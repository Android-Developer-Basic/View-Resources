package otus.gpb.homework.viewandresources.view_model


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import otus.gpb.homework.data.CartRepositoryImpl
import otus.gpb.homework.domain.models.CartItem
import otus.gpb.homework.domain.use_cases.GetCartListUseCase

class CartViewModel: ViewModel() {

    private val cartRepository = CartRepositoryImpl
    private val mutableData = MutableLiveData<List<CartItem>>()
    val data get() = mutableData
    private val scope = CoroutineScope(Dispatchers.Main)

    init {

        getData()
    }

    private fun getData(){
        scope.launch {
            mutableData.value = GetCartListUseCase(cartRepository).getCartList()
        }
    }

    override fun onCleared() {
        super.onCleared()
        scope.cancel()
    }

}