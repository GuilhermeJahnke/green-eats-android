package id.fiap.core.ui.theme


import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColors(
    primary = md_theme_light_primary,
    onPrimary = md_theme_light_onPrimary,
    primaryVariant = md_theme_light_primaryContainer,
    secondary = md_theme_light_secondary,
    secondaryVariant = md_theme_light_secondaryContainer,
    background = md_theme_light_background,
    surface = md_theme_light_surface,
    error = md_theme_light_error,
    onSecondary = md_theme_light_onSecondary,
    onError = md_theme_light_onError,
)

@Composable
fun GreenEatsTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = LightColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}