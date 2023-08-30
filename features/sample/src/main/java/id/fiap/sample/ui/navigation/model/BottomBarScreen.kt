package id.fiap.sample.ui.navigation.model

import id.fiap.core.R


sealed class BottomBarScreen(val route: String) {
    object Home : BottomBar(
        route = "home",
        titleResId = R.string.home,
        icon = R.drawable.home,
        iconFocused = R.drawable.home
    )

    object Cart : BottomBar(
        route = "cart",
        titleResId = R.string.cart,
        icon = R.drawable.cart,
        iconFocused = R.drawable.cart
    )
}