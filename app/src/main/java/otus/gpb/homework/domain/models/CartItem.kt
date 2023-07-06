package otus.gpb.homework.domain.models

data class CartItem(
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val images: List<String>
)
