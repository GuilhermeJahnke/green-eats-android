package id.fiap.sample.ui.component

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import id.fiap.core.ui.theme.*

@Composable
fun CustomButton(
    text: String,
    textColor: Color = md_theme_light_white,
    onClick: () -> Unit,
    isEnabled: Boolean = true,
    isLoading: Boolean = false,
    shape: Shape = RoundedCornerShape(30.dp),
    colors: ButtonColors = ButtonDefaults.outlinedButtonColors(
        backgroundColor = md_theme_light_primary,
    ),
    buttonModifier: Modifier = Modifier
        .fillMaxWidth()
        .height(60.dp)
        .padding(4.dp),
    loadingModifier: Modifier = Modifier
        .fillMaxHeight()
        .aspectRatio(1f)
){
    Button(
        onClick = onClick,
        enabled = isEnabled,
        modifier = buttonModifier,
        shape = shape,
        colors =colors,
    ) {
        if(isLoading){
            CircularProgressIndicator(
                modifier = loadingModifier,
            )
        } else {
            Text(
                text = text,
                color = textColor,
            )
        }
    }
}