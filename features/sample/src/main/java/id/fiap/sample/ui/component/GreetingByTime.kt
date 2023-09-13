package id.fiap.sample.ui.component

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.platform.LocalContext
import id.fiap.core.util.UtilFunctions.getCurrentTime

@Composable
fun GreetingByTime() {
    val context = LocalContext.current

    val currentHour = rememberUpdatedState(getCurrentTime(context))

    val respectiveText = when (currentHour.value) {
        in 6..11 -> "Bom dia"
        in 12..17 -> "Boa tarde"
        else -> "Boa noite"
    }
    
    Text(
        text = respectiveText,
        style = MaterialTheme.typography.body1
    )
}

