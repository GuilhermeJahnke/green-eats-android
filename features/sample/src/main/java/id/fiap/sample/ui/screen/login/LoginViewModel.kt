package id.fiap.sample.ui.screen.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import id.fiap.core.util.UtilFunctions.isValidEmail
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class LoginViewModel() : ViewModel(){
    private val _emailValid = mutableStateOf<Boolean?>(null)
    val emailValid: State<Boolean?> = _emailValid

    private val _passwordValid = mutableStateOf<Boolean?>(null)
    val passwordValid: State<Boolean?> = _passwordValid

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    fun onLoginTap(email: String, password: String, navController: NavController) {
        _isLoading.value = true

        viewModelScope.launch {
            delay(2000)

            // Remove this mock when Integration is finished
            navController.navigate("Home"){
                popUpTo(navController.graph.id)
            }

            _isLoading.value = false
        }
    }

    fun onRegisterTap(navController: NavController){
        navController.navigate("Register")
    }

    fun onEmailChanged(email: String){
        _emailValid.value = isValidEmail(email.trim());
    }

    fun onPasswordChanged(password: String){
        _passwordValid.value = password.trim().length >= 6
    }

}