package otus.gpb.homework.viewandresources

// класс для хранения записей товаров в корзине
data class CartData(val id: Long,
                    val itemName: String,
                    val itemDescription: String,
                    val itemPrice: Double,
                    val itemImg: Int )