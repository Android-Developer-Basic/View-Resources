package otus.gpb.homework.domain.models

data class CartItem(
    val id: Int,
    val title: String,
    val description: String,
    val price: Float,
    val discount: Float,
    val rating: Float,
    val stock: Int,
    val brand: String,
    val category: String,
    val thumbnail: String,
    val images: List<String>
)
