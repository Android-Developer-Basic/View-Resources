package otus.gpb.homework.viewandresources

data class Item(
    val id: Long,
    val title: String,
    val category: String,
    val price: Double,
    val description: String,
    val photo: String
)