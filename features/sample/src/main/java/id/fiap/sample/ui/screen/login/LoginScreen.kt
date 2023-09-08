import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import id.fiap.core.ui.theme.md_theme_light_background
import id.fiap.core.ui.theme.md_theme_light_secondary
import id.fiap.sample.ui.screen.login.LoginViewModel

@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val viewModel: LoginViewModel = viewModel()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(md_theme_light_background)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Ícone e título
//        Icon(
//            painter = painterResource(id = ),
//            contentDescription = null,
//            modifier = Modifier.size(120.dp)
//        )
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
            isError = !viewModel.emailValid.value,
            modifier = Modifier
                .fillMaxWidth()

        )

        Spacer(modifier = Modifier.height(30.dp))

        // Campo de senha
        CustomTextField(
            value = password,
            onValueChange = {
                password = it
                viewModel.onPasswordChanged(it)
            },
            isError = !viewModel.passwordValid.value,
            visualTransformation =  PasswordVisualTransformation(),
            label = "Senha",
            modifier = Modifier
                .fillMaxWidth()

        )

        Spacer(modifier = Modifier.height(100.dp))

        // Botões
        Button(
            onClick = {
                viewModel.login(email, password)
            },
            enabled = viewModel.emailValid.value && viewModel.passwordValid.value,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(4.dp),
            shape = RoundedCornerShape(30.dp)
        ) {
            Text(text = "Entrar")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                // Navegar para a tela de cadastro
                // navController.navigate("tela_de_cadastro")
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .padding(4.dp),
            shape = RoundedCornerShape(30.dp),
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = md_theme_light_secondary,
            )
        ) {
            Text(text = "Cadastrar", color= Color.White )
        }
    }
}

fun isValidEmail(email: String): Boolean {
    // Implemente sua validação de email aqui
    return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
}
