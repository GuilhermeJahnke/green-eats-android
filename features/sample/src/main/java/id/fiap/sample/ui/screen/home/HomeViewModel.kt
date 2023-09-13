package id.fiap.sample.ui.screen.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import id.fiap.core.data.UiState
import id.fiap.core.data.model.Product
import id.fiap.core.data.model.ProductResponse
import id.fiap.core.domain.usecase.product.GetProductsUseCase
import id.fiap.core.domain.usecase.product.SearchProductUseCase
import id.fiap.sample.ui.screen.cart.CartViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
) : ViewModel() {

    private val _uiStateProduct: MutableStateFlow<UiState<ProductResponse>> = MutableStateFlow(UiState.Loading)
    val uiStateProduct: StateFlow<UiState<ProductResponse>> = _uiStateProduct

    fun onProductClick(
        product: Product,
        cartViewModel: CartViewModel
    ){
        cartViewModel.addProduct(product)
    }

    fun getProductsApiCall() { // this is sample not using `suspend`
        getProductsUseCase.execute(Unit).onEach { product ->
            _uiStateProduct.value = UiState.Success(product)
        }.catch { e ->
            _uiStateProduct.value = UiState.Error(e.message.toString())
        }.launchIn(viewModelScope)
    }
}