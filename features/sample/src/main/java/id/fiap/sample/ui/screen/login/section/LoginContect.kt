package id.fiap.sample.ui.screen.login.section

import CustomTextField
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import id.fiap.core.ui.theme.md_theme_light_background
import id.fiap.core.ui.theme.md_theme_light_primary
import id.fiap.core.ui.theme.md_theme_light_secondary
import id.fiap.sample.R
import id.fiap.sample.ui.component.CustomButton


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginContent(
    onEmailChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    email: String,
    password: String,
    isEmailError: Boolean,
    isPasswordError: Boolean,
    isButtonEnabled: Boolean,
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
){
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable(
                interactionSource = interactionSource,
                indication = null,
            ){
                keyboardController?.hide()
                focusManager.clearFocus(true)
            }
            .background(md_theme_light_background)
            .padding(16.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Image(
            painter = painterResource(R.drawable.icon),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(64.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Login",
            style = MaterialTheme.typography.h4
        )

        Spacer(modifier = Modifier.height(100.dp))

        CustomTextField(
            value = email,
            onValueChange = onEmailChange,
            label = "Email",
            isError = isEmailError,
            keyboardType = KeyboardType.Email,
            modifier = Modifier
                .fillMaxWidth(),
            )

        Spacer(modifier = Modifier.height(30.dp))

        CustomTextField(
            value = password,
            onValueChange = onPasswordChange,
            isError = isPasswordError,
            visualTransformation =  PasswordVisualTransformation(),
            label = "Senha",
            keyboardType = KeyboardType.Password,
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(100.dp))

        CustomButton(
            text = "Entrar",
            onClick = onLoginClick,
            isEnabled = isButtonEnabled,
            isLoading = false,
            colors = if (isButtonEnabled){
                ButtonDefaults.textButtonColors(
                    backgroundColor = md_theme_light_primary,
                )
            } else {
                ButtonDefaults.textButtonColors(
                    backgroundColor = md_theme_light_secondary,
                )
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        CustomButton(
            text= "Cadastrar",
            onClick = onRegisterClick,
            shape = RoundedCornerShape(30.dp),
        )
    }
}