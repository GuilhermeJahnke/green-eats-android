package id.fiap.core.data.model


import com.google.gson.annotations.SerializedName

data class Product(
    val brand: String? = null,
    val category: String? = null,
    val description: String? = null,
    val discountPercentage: Double? = null,
    val id: Int? = null,
    val images: List<String?>? = null,
    val price: Long? = null,
    val rating: Double? = null,
    val stock: Int? = null,
    val thumbnail: String? = null,
    val title: String? = null,
    val size: Int? = null
)