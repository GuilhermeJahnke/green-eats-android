package id.fiap.sample.ui.screen.splashScreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class SplashScreenViewModel : ViewModel() {
    private val _backgroundWorkFinished = mutableStateOf(false)
    val backgroundWorkFinished: State<Boolean> = _backgroundWorkFinished

    fun performBackgroundWork() {
        viewModelScope.launch {

            delay(2000)

            _backgroundWorkFinished.value = true
        }
    }
}