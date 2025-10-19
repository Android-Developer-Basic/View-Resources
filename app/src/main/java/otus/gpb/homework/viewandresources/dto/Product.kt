package otus.gpb.homework.viewandresources.dto

import java.util.UUID

data class Product(
    val id: UUID,
    val imageResId: Int,
    val productName: String,
    val category: String,
    val description: String,
    val price: String
)