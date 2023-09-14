package id.fiap.core.util

import android.content.Context
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

object UtilFunctions {

    fun Long?.fromDollarToReal(): String {
        val localeBR = Locale("pt", "BR")
        val formatter = NumberFormat.getCurrencyInstance(localeBR)

        val realValue = this ?: 0

        return if (realValue > 0) {
            formatter.format(realValue)
        } else {
            "R$0,00"
        }
    }

    fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isCPFValid(cpf: String): Boolean {
        val cleanedCPF = cpf.replace("[^\\d]".toRegex(), "")

        if (cleanedCPF.length != 11) {
            return false
        }

        if (cleanedCPF.toSet().size == 1) {
            return false
        }

        val firstDigit = calculateCPFValidatorDigit(cleanedCPF.substring(0, 9))
        if (cleanedCPF[9] != firstDigit) {
            return false
        }

        val secondDigit = calculateCPFValidatorDigit(cleanedCPF.substring(0, 10))
        return cleanedCPF[10] == secondDigit
    }

    fun calculateCPFValidatorDigit(partialCPF: String): Char {
        val digits = partialCPF.map { it.toString().toInt() }.toMutableList()
        var weight = digits.size + 1
        val total = digits.sumBy { it * weight-- }
        val remainder = total % 11
        val result = if (remainder < 2) 0 else 11 - remainder
        return result.toString()[0]
    }

    fun getCurrentTime(context: Context): Int {
        val horaFormat = SimpleDateFormat("HH", Locale.getDefault())
        val currentHour = horaFormat.format(Calendar.getInstance().time)
        return currentHour.toIntOrNull() ?: 0
    }

}