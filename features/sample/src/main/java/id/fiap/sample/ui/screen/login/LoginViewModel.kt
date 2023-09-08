package id.fiap.sample.ui.screen.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import isValidEmail

class LoginViewModel() : ViewModel(){
    private val _emailValid = mutableStateOf(true)
    val emailValid: State<Boolean> = _emailValid

    private val _passwordValid = mutableStateOf(true)
    val passwordValid: State<Boolean> = _passwordValid

    fun login(email: String, password: String) {

    }

    fun onEmailChanged(email: String){
        _emailValid.value = isValidEmail(email.trim());
    }

    fun onPasswordChanged(password: String){
        _passwordValid.value = password.trim().length >= 6
    }
}