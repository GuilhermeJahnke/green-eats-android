package id.rivaldy.core.util

import id.rivaldy.core.data.model.Product
import id.rivaldy.core.data.model.ProductResponse

object UtilTests {
    val dummyProduct = Product("Product", "Product 1")
    val dummyProductResponse = ProductResponse(0, mutableListOf(dummyProduct))
}