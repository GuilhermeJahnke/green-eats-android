package id.rivaldy.sample.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import id.rivaldy.sample.ui.navigation.model.BottomBarScreen
import id.rivaldy.sample.ui.screen.cart.CartScreen
import id.rivaldy.sample.ui.screen.home.HomeScreen


@Composable
fun MainNavHost(
    navController: NavHostController,
    innerPadding: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route,
        modifier = Modifier.padding(innerPadding)
    ) {
        composable(BottomBarScreen.Home.route) {
            HomeScreen()
        }
        composable(BottomBarScreen.Cart.route) {
            CartScreen()
        }
    }
}