package otus.gpb.homework.domain.repository

import otus.gpb.homework.domain.models.CartItem

interface CartRepository {

    fun getCartList():List<CartItem>
}