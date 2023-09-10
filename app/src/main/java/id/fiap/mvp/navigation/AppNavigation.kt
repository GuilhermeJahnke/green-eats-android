package id.fiap.mvp.navigation

import LoginScreen
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import id.fiap.mvp.ui.MainScreen
import id.fiap.sample.ui.screen.cart.CartScreen
import id.fiap.sample.ui.screen.splashScreen.SplashScreen

@Composable
fun AppNavigation(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = "Splash",
    ) {
        composable("Splash"){
            SplashScreen()
        }
        composable("Login"){
            LoginScreen(navController = navController)
        }
        composable("Home") {
            MainScreen()
        }
        composable("Register"){
            // TODO add register Screen
        }
    }
}