package otus.gpb.homework.domain.use_cases

import androidx.lifecycle.LiveData
import otus.gpb.homework.domain.models.CartItem
import otus.gpb.homework.domain.repository.CartRepository

class GetCartListUseCase(private val cartRepository: CartRepository) {
    fun getCartList(): LiveData<List<CartItem>>{
        return cartRepository.getCartList()
    }
}