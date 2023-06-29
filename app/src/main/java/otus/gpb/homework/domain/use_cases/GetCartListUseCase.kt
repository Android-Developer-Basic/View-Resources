package otus.gpb.homework.domain.use_cases

import otus.gpb.homework.domain.repository.CartRepository

class GetCartListUseCase(private val cartRepository: CartRepository) {
    fun getCartList(){
        cartRepository.getCartList()
    }
}