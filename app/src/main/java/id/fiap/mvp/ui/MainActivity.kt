package id.fiap.mvp.ui

import LoginScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import id.fiap.core.ui.theme.GreenEatsTheme
import id.fiap.mvp.navigation.AppNavigation
import id.fiap.sample.ui.screen.splashScreen.SplashScreen
import id.fiap.sample.ui.screen.splashScreen.SplashScreenViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: SplashScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            GreenEatsTheme {
                val navController = rememberNavController()
                val backgroundWorkFinished = viewModel.backgroundWorkFinished.value

                AppNavigation(navController = navController)

                if (backgroundWorkFinished) {
                    navController.navigate("Login")
                } else {
                    navController.navigate("Splash")
                }
            }
        }

        viewModel.performBackgroundWork()
    }
}