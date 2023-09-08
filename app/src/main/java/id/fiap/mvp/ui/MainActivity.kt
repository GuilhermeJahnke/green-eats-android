package id.fiap.mvp.ui

import LoginScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import id.fiap.core.ui.theme.GreenEatsTheme
import id.fiap.sample.ui.screen.splashScreen.SplashScreen
import id.fiap.sample.ui.screen.splashScreen.SplashScreenViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: SplashScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GreenEatsTheme {
                val backgroundWorkFinished = viewModel.backgroundWorkFinished.value

                if (backgroundWorkFinished) {
                    LoginScreen()
                } else {
                    SplashScreen()
                }
            }
        }

        viewModel.performBackgroundWork()
    }
}