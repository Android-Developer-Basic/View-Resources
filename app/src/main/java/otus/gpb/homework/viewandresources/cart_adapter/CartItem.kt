package otus.gpb.homework.viewandresources.cart_adapter

import otus.gpb.homework.viewandresources.R

data class CartItem(
    val idImage: Int = R.drawable.cake,
    val title: String = "",
    val caption: String = "",
    val price: Double = 0.0,
    var priceString: String = ""
)

fun getCartItems(): MutableList<CartItem> = mutableListOf(
    CartItem(
        R.drawable.cake,
        "On the top",
        "Caption",
        1.5
    ),
    CartItem(
        R.drawable.muse,
        "Forever Friends",
        "Caption",
        4.50
    ),
    CartItem(
        R.drawable.clock,
        "Prototyping Kit",
        "Caption",
        8.00
    ),
    CartItem(
        R.drawable.cake,
        "Basket & Coffee",
        "Caption",
        22.00
    ),
)
