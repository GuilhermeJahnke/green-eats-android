package id.fiap.sample.ui.screen.cart

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import id.fiap.core.data.model.Product
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch



class CartViewModel : ViewModel() {

    private val _products = mutableListOf<Product>()
    val products: MutableList<Product> = _products;

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading


    fun addProduct(product: Product) {
        if(
            _products.none {
                it.id == product.id
            }
        ){
            _products.add(product)
        }
    }

    fun deleteProduct(product: Product) {
        _isLoading.value = true

        viewModelScope.launch {
            delay(2000)

            _products.remove(product)

            _isLoading.value = false
        }
    }
}