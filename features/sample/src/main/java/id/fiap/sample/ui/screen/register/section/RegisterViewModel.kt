package id.fiap.sample.ui.screen.register.section

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import id.fiap.core.util.UtilFunctions
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class RegisterViewModel() : ViewModel() {
    private val _fullNameValid = mutableStateOf<Boolean?>(null)
    private val _emailValid = mutableStateOf<Boolean?>(null)
    private val _documentValid = mutableStateOf<Boolean?>(null)
    private val _phoneValid = mutableStateOf<Boolean?>(null)
    private val _passwordValid = mutableStateOf<Boolean?>(null)
    private val _confirmPasswordValid = mutableStateOf<Boolean?>(null)

    private val _isLoading = mutableStateOf<Boolean>(false)

    val fullNameValid: State<Boolean?> = _fullNameValid
    val emailValid: State<Boolean?> = _emailValid
    val documentValid: State<Boolean?> = _documentValid
    val phoneValid: State<Boolean?> = _phoneValid
    val passwordValid: State<Boolean?> = _passwordValid
    val confirmPasswordValid: State<Boolean?> = _confirmPasswordValid

    val isLoading: State<Boolean> = _isLoading

    fun onFullNameChanged(fullName: String) {
        _fullNameValid.value = fullName.trim().isNotEmpty()
    }

    fun onEmailChanged(email: String){
        _emailValid.value = UtilFunctions.isValidEmail(email.trim());
    }

    fun onDocumentChanged(document: String){
        _documentValid.value = UtilFunctions.isCPFValid(document)
    }

    fun onPhoneChanged(phone: String){
        _phoneValid.value = phone.trim().length > 10
    }

    fun onPasswordChanged(password: String){
        _passwordValid.value = password.trim().length > 5
    }

    fun onConfirmPasswordChanged(password: String, confirmPassword: String){
        _confirmPasswordValid.value = password == confirmPassword
    }

    fun onRegisterTap(
        fullName: String,
        email: String,
        document: String,
        phone: String,
        password: String,
        navController: NavController
    ){
        _isLoading.value = true

        viewModelScope.launch {
            delay(2000)

            // Remove this mock when Integration is finished
            navController.popBackStack()

            _isLoading.value = false
        }
    }

}