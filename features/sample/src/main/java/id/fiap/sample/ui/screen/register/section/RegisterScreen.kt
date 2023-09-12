package id.fiap.sample.ui.screen.register.section

import CustomTextField
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
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
import kotlin.math.absoluteValue

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


    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    val interactionSource = remember { MutableInteractionSource() }

    Scaffold(

        topBar = {

            TopAppBar(
                backgroundColor = md_theme_light_background,
                elevation = 0.dp,
                title = {},
                navigationIcon = {
                    Card(
                        modifier = Modifier
                            .size(48.dp)
                            .padding(8.dp),
                        shape = CircleShape,
                        elevation = 8.dp
                    ) {
                        IconButton(
                            onClick = {
                                navController.popBackStack()
                            },
                            modifier = Modifier
                                .size(48.dp)
                                .background(
                                    shape = CircleShape,
                                    color = MaterialTheme.colors.primary // Cor de fundo do botão
                                )
                        ) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Voltar",
                                tint = Color.White // Cor do ícone
                            )
                        }
                    }
                }
            )
        },
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .clickable(
                    interactionSource = interactionSource,
                    indication = null,
                ) {
                    keyboardController?.hide()
                    focusManager.clearFocus(true)
                }
                .padding(16.dp),

            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painter = painterResource(id.fiap.sample.R.drawable.icon),
                contentDescription = "avatar",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(64.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Cadastre-se",
                style = MaterialTheme.typography.h4
            )

            Spacer(modifier = Modifier.height(50.dp))

            CustomTextField(
                value = fullName,
                onValueChange = {
                   fullName = it
                   viewModel.onFullNameChanged(it)
                },
                label = "Nome completo",
                isError = viewModel.fullNameValid.value == false,
                keyboardType = KeyboardType.Text,
                modifier = Modifier
                    .fillMaxWidth(),
            )

            Spacer(modifier = Modifier.height(30.dp))

            CustomTextField(
                value = email,
                onValueChange = {
                   email = it
                   viewModel.onEmailChanged(it)
                },
                isError = viewModel.emailValid.value == false,
                label = "E-mail",
                keyboardType = KeyboardType.Password,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(30.dp))

            CustomTextField(
                value = document,
                onValueChange = {
                    if(it.length <= 11 ){
                        document = it.filter { it.isDigit() }
                        viewModel.onDocumentChanged(it)
                    }
                },
                label = "CPF",
                isError = viewModel.documentValid.value == false,
                keyboardType = KeyboardType.Number,
                modifier = Modifier
                    .fillMaxWidth(),
                visualTransformation = MaskVisualTransformation("###.###.###-##")
            )

            Spacer(modifier = Modifier.height(30.dp))

            CustomTextField(
                value = phone,
                onValueChange = {
                    if(it.length <= 11) {
                        phone = it
                        viewModel.onPhoneChanged(it)
                    }
                },
                isError = viewModel.phoneValid.value == false,
                label = "Telefone",
                keyboardType = KeyboardType.Phone,
                modifier = Modifier
                    .fillMaxWidth(),
                visualTransformation = MaskVisualTransformation("(##) # ####-####")
            )

            Spacer(modifier = Modifier.height(30.dp))

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

            Spacer(modifier = Modifier.height(30.dp))

            CustomTextField(
                value = confirmPassword,
                onValueChange = {
                   confirmPassword = it
                   viewModel.onConfirmPasswordChanged(password, it)
                },
                isError = viewModel.confirmPasswordValid.value == false,
                visualTransformation =  PasswordVisualTransformation(),
                label = "Confirme sua senha",
                keyboardType = KeyboardType.Password,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(30.dp))

            CustomButton(
                text = "Cadastrar",
                onClick = {
                   viewModel.onRegisterTap(
                       fullName,
                       email,
                       document,
                       phone,
                       password,
                       navController,
                   )
                },
                isEnabled = isButtonEnabled,
                isLoading = viewModel.isLoading.value,
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

            Spacer(modifier = Modifier.height(30.dp))

            Box(modifier = Modifier.padding(it))
        }
    }
}

