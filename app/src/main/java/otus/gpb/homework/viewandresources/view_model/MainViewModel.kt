package otus.gpb.homework.viewandresources.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {
    private val mutableData = MutableLiveData<Int>()
    val data get() = mutableData
    init {
        mutableData.value = OPEN_MAIN_FRAGMENT
    }
    fun setAction(value: Int){
        mutableData.value = value
    }

    companion object {
        const val OPEN_MAIN_FRAGMENT = 1
        const val OPEN_CONTACTS = 2
        const val OPEN_CART = 3
    }


}