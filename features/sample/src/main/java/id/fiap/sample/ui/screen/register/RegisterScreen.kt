package id.fiap.sample.ui.screen.register

import CustomTextField
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import id.fiap.core.ui.theme.md_theme_light_background
import id.fiap.core.ui.theme.md_theme_light_primary
import id.fiap.core.ui.theme.md_theme_light_secondary
import id.fiap.core.util.MaskVisualTransformation
import id.fiap.sample.ui.component.CustomButton
import id.fiap.sample.ui.screen.register.section.RegisterContent

@OptIn(ExperimentalComposeUiApi::class)
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
    )
}

