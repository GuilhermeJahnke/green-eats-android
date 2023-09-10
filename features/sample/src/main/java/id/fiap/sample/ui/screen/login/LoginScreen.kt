import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
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
import androidx.lifecycle.viewmodel.compose.viewModel
import id.fiap.core.ui.theme.*
import id.fiap.sample.R
import id.fiap.sample.ui.component.CustomButton
import id.fiap.sample.ui.screen.login.LoginViewModel

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val viewModel: LoginViewModel = viewModel()
    val isButtonEnabled: Boolean = viewModel.emailValid.value == true && viewModel.passwordValid.value == true


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

        // Campo de email
        CustomTextField(
            value = email,
            onValueChange = {
                email = it
                viewModel.onEmailChanged(it)
            },
            label = "Email",
            isError = viewModel.emailValid.value == false,
            keyboardType = KeyboardType.Email,
            modifier = Modifier
                .fillMaxWidth(),

        )

        Spacer(modifier = Modifier.height(30.dp))

        // Campo de senha
        CustomTextField(
            value = password,
            onValueChange = {
                password = it
                viewModel.onPasswordChanged(it)
            },
            isError = viewModel.passwordValid.value == false,
            visualTransformation =  PasswordVisualTransformation(),
            label = "Senha",
            keyboardType = KeyboardType.Password,
            modifier = Modifier
                .fillMaxWidth()

        )

        Spacer(modifier = Modifier.height(100.dp))

        // Botões
        CustomButton(
            text = "Entrar",
            onClick = {
                viewModel.onLoginTap(email, password)
            },
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
            onClick = {
                viewModel.onRegisterTap()
            },
            shape = RoundedCornerShape(30.dp),
        )
    }
}

fun isValidEmail(email: String): Boolean {
    // Implemente sua validação de email aqui
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}
