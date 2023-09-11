package id.fiap.core.util

import android.util.Log
import id.fiap.core.BuildConfig
import java.text.NumberFormat
import java.util.Locale

object UtilFunctions {
    private val localeID = Locale("in", "ID")

    fun logE(message: String) {
        if (BuildConfig.DEBUG) Log.e("ERROR_IMO", message)
    }

    fun Long?.fromDollarToReal(): String {
        val localeBR = Locale("pt", "BR")
        val formatter = NumberFormat.getCurrencyInstance(localeBR)
        val currentDollarRate = 5.30

        val realValue = (this ?: 0) * currentDollarRate

        return if (realValue > 0) {
            formatter.format(realValue)
        } else {
            "R$0,00"
        }
    }
}