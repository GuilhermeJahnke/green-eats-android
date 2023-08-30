package id.fiap.sample.ui.screen.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.fiap.core.data.UiState
import id.fiap.core.data.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CartViewModel @Inject constructor(

) : ViewModel() {

    private val _uiStateDbProducts: MutableStateFlow<UiState<MutableList<Product>>> = MutableStateFlow(UiState.Loading)
    val uiStateDbProducts: StateFlow<UiState<MutableList<Product>>> = _uiStateDbProducts

    val products: MutableList<Product> = mutableListOf()

    fun deleteProductDb(product: Product) {
        viewModelScope.launch {
            products.remove(product)
        }
    }
}