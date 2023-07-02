package otus.gpb.homework.viewandresources.view_model


import androidx.lifecycle.ViewModel
import otus.gpb.homework.data.CartRepositoryImpl
import otus.gpb.homework.domain.use_cases.GetCartListUseCase

class CartViewModel: ViewModel() {

    private val cartRepository = CartRepositoryImpl


    val data = GetCartListUseCase(cartRepository).getCartList()

}