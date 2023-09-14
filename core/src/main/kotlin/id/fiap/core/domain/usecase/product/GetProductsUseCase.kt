package id.fiap.core.domain.usecase.product

import id.fiap.core.data.model.Product
import id.fiap.core.domain.repository.product.ProductRepository
import id.fiap.core.domain.usecase.BaseUseCase
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val productRepository: ProductRepository
) : BaseUseCase<Unit, MutableList<Product>>() {
    override fun execute(params: Unit): MutableList<Product> {
        return productRepository.getProductsApiCall()
    }
}