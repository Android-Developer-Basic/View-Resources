package otus.gpb.homework.viewandresources.view_model


import androidx.lifecycle.ViewModel
import otus.gpb.homework.data.CartRepositoryImpl
import otus.gpb.homework.domain.repository.CartRepository
import otus.gpb.homework.domain.use_cases.GetCartListUseCase
import javax.inject.Inject

class CartViewModel: ViewModel() {
//    @Inject
//    lateinit var cartRepository: CartRepository
    private val cartRepository = CartRepositoryImpl


    val data = GetCartListUseCase(cartRepository).getCartList()

}