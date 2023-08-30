package id.fiap.mvp.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import id.fiap.sample.ui.navigation.BottomNav
import id.fiap.core.ui.theme.JetShopeeTheme

@Composable
fun JetMainScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    BottomNav(modifier, navController)
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun DefaultPreview() {
    JetShopeeTheme {
        JetMainScreen()
    }
}