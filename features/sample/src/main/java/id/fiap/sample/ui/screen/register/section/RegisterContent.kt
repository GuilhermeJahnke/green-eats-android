package id.fiap.sample.ui.screen.register.section

import CustomTextField
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import id.fiap.core.ui.theme.md_theme_light_background
import id.fiap.core.ui.theme.md_theme_light_primary
import id.fiap.core.ui.theme.md_theme_light_secondary
import id.fiap.core.util.MaskVisualTransformation
import id.fiap.sample.R
import id.fiap.sample.ui.component.CustomButton

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun RegisterContent(
    navController: NavHostController = rememberNavController(),
    onFullNameChange: (String) -> Unit,
    onEmailChange: (String) -> Unit,
    onDocumentChange: (String) -> Unit,
    onPhoneChange: (String) -> Unit,
    onPasswordChange: (String) -> Unit,
    onConfirmPasswordChange: (String) -> Unit,
    onRegisterTap: () -> Unit,
    fullName: String,
    email: String,
    document: String,
    phone: String,
    password: String,
    confirmPassword: String,
    isFullNameError: Boolean,
    isEmailError: Boolean,
    isDocumentError: Boolean,
    isPhoneError: Boolean,
    isPasswordError: Boolean,
    isConfirmPasswordError: Boolean,
    isButtonEnabled: Boolean,
    isButtonLoading: Boolean,
) {

    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current
    val interactionSource = remember { MutableInteractionSource() }

    Scaffold(

//        topBar = {
//
//            TopAppBar(
//                backgroundColor = md_theme_light_background,
//                elevation = 0.dp,
//                title = {},
//                navigationIcon = {
//                    Card(
//                        modifier = Modifier
//                            .size(48.dp)
//                            .padding(8.dp),
//                        shape = CircleShape,
//                        elevation = 8.dp
//                    ) {
//                        IconButton(
//                            onClick = {
//                                navController.popBackStack()
//                            },
//                            modifier = Modifier
//                                .size(48.dp)
//                                .background(
//                                    shape = CircleShape,
//                                    color = MaterialTheme.colors.primary // Cor de fundo do botão
//                                )
//                        ) {
//                            Icon(
//                                imageVector = Icons.Default.ArrowBack,
//                                contentDescription = "Voltar",
//                                tint = Color.White // Cor do ícone
//                            )
//                        }
//                    }
//                }
//            )
//        },
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
            Row(
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                Card(
                    modifier = Modifier
                        .size(48.dp)
                        .padding(8.dp)
                        .fillMaxWidth(),
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
                text = "Cadastre-se",
                style = MaterialTheme.typography.h4
            )

            Spacer(modifier = Modifier.height(50.dp))

            CustomTextField(
                value = fullName,
                onValueChange = onFullNameChange,
                label = "Nome completo",
                isError = isFullNameError,
                keyboardType = KeyboardType.Text,
                modifier = Modifier
                    .fillMaxWidth(),
            )

            Spacer(modifier = Modifier.height(30.dp))

            CustomTextField(
                value = email,
                onValueChange = onEmailChange,
                isError = isEmailError,
                label = "E-mail",
                keyboardType = KeyboardType.Password,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(30.dp))

            CustomTextField(
                value = document,
                onValueChange = onDocumentChange,
                label = "CPF",
                isError = isDocumentError,
                keyboardType = KeyboardType.Number,
                modifier = Modifier
                    .fillMaxWidth(),
                visualTransformation = MaskVisualTransformation("###.###.###-##")
            )

            Spacer(modifier = Modifier.height(30.dp))

            CustomTextField(
                value = phone,
                onValueChange = onPhoneChange,
                isError = isPhoneError,
                label = "Telefone",
                keyboardType = KeyboardType.Phone,
                modifier = Modifier
                    .fillMaxWidth(),
                visualTransformation = MaskVisualTransformation("(##) # ####-####")
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

            Spacer(modifier = Modifier.height(30.dp))

            CustomTextField(
                value = confirmPassword,
                onValueChange = onConfirmPasswordChange,
                isError = isConfirmPasswordError,
                visualTransformation =  PasswordVisualTransformation(),
                label = "Confirme sua senha",
                keyboardType = KeyboardType.Password,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(30.dp))

            CustomButton(
                text = "Cadastrar",
                onClick = onRegisterTap,
                isEnabled = isButtonEnabled,
                isLoading = isButtonLoading,
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