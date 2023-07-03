package otus.gpb.homework.domain.use_cases


import otus.gpb.homework.domain.models.CartItem
import otus.gpb.homework.domain.repository.CartRepository

class GetCartListUseCase(private val cartRepository: CartRepository) {
    suspend fun getCartList(): List<CartItem>{
        return cartRepository.getCartList()
    }
}