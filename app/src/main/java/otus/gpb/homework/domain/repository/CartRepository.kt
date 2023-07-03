package otus.gpb.homework.domain.repository

import otus.gpb.homework.domain.models.CartItem

interface CartRepository {

    suspend fun getCartList():List<CartItem>
}