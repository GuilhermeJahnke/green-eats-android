package id.fiap.core.domain.repository.product

import id.fiap.core.data.model.Product

interface ProductRepository {
    fun getProductsApiCall(): MutableList<Product>
}