package id.fiap.sample.ui.component

import android.content.Context
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.platform.LocalContext
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun GreetingByTime() {
    val context = LocalContext.current

    val horaAtual = rememberUpdatedState(obterHoraAtual(context))

    val saudacao = when (horaAtual.value) {
        in 6..11 -> "Bom dia,"
        in 12..17 -> "Boa tarde,"
        else -> "Boa noite,"
    }
    
    Text(text = saudacao)
}

private fun obterHoraAtual(context: Context): Int {
    val horaFormat = SimpleDateFormat("HH", Locale.getDefault())
    val horaAtual = horaFormat.format(Calendar.getInstance().time)
    return horaAtual.toIntOrNull() ?: 0
}