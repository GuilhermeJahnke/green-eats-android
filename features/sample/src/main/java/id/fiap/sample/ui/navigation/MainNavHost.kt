package id.fiap.sample.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import id.fiap.sample.ui.navigation.model.BottomBarScreen
import id.fiap.sample.ui.screen.cart.CartScreen
import id.fiap.sample.ui.screen.cart.CartViewModel
import id.fiap.sample.ui.screen.home.HomeScreen


@Composable
fun MainNavHost(
    navController: NavHostController,
    innerPadding: PaddingValues,
    cartViewModel: CartViewModel = viewModel()
) {
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route,
        modifier = Modifier.padding(innerPadding)
    ) {
        composable(BottomBarScreen.Home.route) {
            HomeScreen(
                cartViewModel = cartViewModel
            )
        }
        composable(BottomBarScreen.Cart.route) {
            CartScreen(
                viewModel = cartViewModel
            )
        }
    }
}