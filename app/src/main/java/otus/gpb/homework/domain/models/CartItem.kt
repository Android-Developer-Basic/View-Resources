package otus.gpb.homework.domain.models

data class CartItem(
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val discount: Double,
    val rating: Double,
    val stock: Int,
    val brand: String,
    val category: String,
    val thumbnail: String,
    val images: List<String>
)
