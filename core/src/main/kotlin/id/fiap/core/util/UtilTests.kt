package id.fiap.core.util

import id.fiap.core.data.model.Product
import id.fiap.core.data.model.ProductResponse

object UtilTests {
    val dummyProduct = Product("Product", "Product 1")
    val dummyProductResponse = ProductResponse(0, mutableListOf(dummyProduct))
}