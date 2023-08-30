package id.fiap.core.domain.usecase.product

import id.fiap.core.data.model.ProductResponse
import id.fiap.core.domain.repository.product.ProductRepository
import id.fiap.core.domain.usecase.BaseUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val productRepository: ProductRepository
) : BaseUseCase<Unit, Flow<ProductResponse>>() {
    override fun execute(params: Unit): Flow<ProductResponse> {
        return productRepository.getProductsApiCall()
    }
}