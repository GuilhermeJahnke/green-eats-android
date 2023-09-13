package id.fiap.sample.ui.screen.home


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.fiap.core.data.UiState
import id.fiap.core.data.model.Product
import id.fiap.core.domain.usecase.product.GetProductsUseCase
import id.fiap.sample.ui.screen.cart.CartViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
) : ViewModel() {

    private val _uiStateProduct: MutableStateFlow<UiState<MutableList<Product>>> = MutableStateFlow(UiState.Loading)
    val uiStateProduct: StateFlow<UiState<MutableList<Product>>> = _uiStateProduct

    fun onProductClick(
        product: Product,
        cartViewModel: CartViewModel
    ){
        cartViewModel.addProduct(product)
    }

    fun getProductsApiCall() {
        val productsList: MutableList<Product> = getProductsUseCase.execute(Unit)

        viewModelScope.launch {
            delay(3000)

            _uiStateProduct.value = UiState.Success(productsList)
        }

    }
}