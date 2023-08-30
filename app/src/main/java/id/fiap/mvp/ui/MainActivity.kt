package id.fiap.mvp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import id.fiap.core.ui.theme.GreenEatsTheme
import id.fiap.core.ui.theme.StatusBarColor

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreenEatsTheme {
                StatusBarColor(color = MaterialTheme.colors.primary)
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    JetMainScreen()
                }
            }
        }
    }
}