package otus.gpb.homework.domain.repository

import androidx.lifecycle.LiveData
import otus.gpb.homework.domain.models.CartItem

interface CartRepository {

    fun getCartList():LiveData<List<CartItem>>
}