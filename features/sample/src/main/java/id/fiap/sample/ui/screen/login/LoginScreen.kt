import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import id.fiap.sample.ui.screen.login.LoginViewModel
import id.fiap.sample.ui.screen.login.section.LoginContent

@Composable
fun LoginScreen(
    navController: NavHostController = rememberNavController()
) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val viewModel: LoginViewModel = viewModel()
    val isButtonEnabled: Boolean = viewModel.emailValid.value == true && viewModel.passwordValid.value == true

    LoginContent(
        onEmailChange = {
            email = it
            viewModel.onEmailChanged(it)
        },
        onPasswordChange = {
            password = it
            viewModel.onPasswordChanged(it)
        },
        email = email,
        password = password,
        isEmailError = viewModel.emailValid.value == false,
        isPasswordError = viewModel.passwordValid.value == false,
        isButtonEnabled = isButtonEnabled,
        isButtonLoading = viewModel.isLoading.value,
        onLoginClick = {
            viewModel.onLoginTap(
                email,
                password,
                navController,
            )
        },
        onRegisterClick= {
            viewModel.onRegisterTap(navController)
        },
    )
}
