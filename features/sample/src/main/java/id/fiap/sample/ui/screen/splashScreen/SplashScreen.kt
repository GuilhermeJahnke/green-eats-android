package id.fiap.sample.ui.screen.splashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import id.fiap.core.ui.theme.GreenEatsTheme
import id.fiap.core.ui.theme.StatusBarColor
import id.fiap.core.ui.theme.md_theme_light_primary
import id.fiap.sample.ui.screen.mainScreen.MainScreen
import id.fiap.sample.R

@Composable
fun SplashScreen() {
    val viewModel: SplashScreenViewModel = viewModel()

    StatusBarColor(color = MaterialTheme.colors.primary)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(md_theme_light_primary),
        contentAlignment = Alignment.Center
    ) {
        if (viewModel.backgroundWorkFinished.value) {
           MainScreen()
        } else {
            Image(
                painter = painterResource(id = R.drawable.splash),
                contentDescription = null,
                contentScale = ContentScale.FillHeight,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SplashScreenPreview() {
    GreenEatsTheme {
        SplashScreen()
    }
}