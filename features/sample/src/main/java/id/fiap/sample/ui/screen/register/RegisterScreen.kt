package id.fiap.sample.ui.screen.register


import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import id.fiap.sample.ui.screen.register.section.RegisterContent

@Composable
fun RegisterScreen(
    navController: NavHostController = rememberNavController()
){
    var fullName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var document by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }


    val viewModel: RegisterViewModel = viewModel()

    val isButtonEnabled: Boolean =
        viewModel.emailValid.value == true &&
                viewModel.passwordValid.value == true &&
                viewModel.phoneValid.value == true &&
                viewModel.documentValid.value == true &&
                viewModel.confirmPasswordValid.value == true &&
                viewModel.fullNameValid.value == true

    RegisterContent(
        onFullNameChange = {
            fullName = it
            viewModel.onFullNameChanged(it)
        },
        onEmailChange = {
            email = it
            viewModel.onEmailChanged(it)
        },
        onDocumentChange = {
            if(it.length <= 11 ){
                document = it.filter { it.isDigit() }
                viewModel.onDocumentChanged(it)
            }
        },
        onPhoneChange = {
            if(it.length <= 11) {
                phone = it
                viewModel.onPhoneChanged(it)
            }
        },
        onPasswordChange = {
            password = it
            viewModel.onPasswordChanged(it)
        },
        onConfirmPasswordChange = {
            confirmPassword = it
            viewModel.onConfirmPasswordChanged(password, it)
        },
        onRegisterTap = {
            viewModel.onRegisterTap(
                fullName,
                email,
                document,
                phone,
                password,
                navController,
            )
        },
        fullName = fullName,
        email = email,
        document = document,
        phone = phone,
        password = password,
        confirmPassword = confirmPassword,
        isFullNameError = viewModel.fullNameValid.value == false ,
        isEmailError = viewModel.emailValid.value == false ,
        isDocumentError = viewModel.documentValid.value == false,
        isPhoneError = viewModel.phoneValid.value == false,
        isPasswordError = viewModel.passwordValid.value == false,
        isConfirmPasswordError = viewModel.confirmPasswordValid.value == false,
        isButtonEnabled = isButtonEnabled,
        isButtonLoading = viewModel.isLoading.value,
        navController = navController
    )
}

