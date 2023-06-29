package otus.gpb.homework.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import otus.gpb.homework.data.network.NetworkData
import otus.gpb.homework.domain.models.CartItem
import otus.gpb.homework.domain.repository.CartRepository

object CartRepositoryImpl:CartRepository {
    private val data = MutableLiveData<List<CartItem>>()
    override fun getCartList(): LiveData<List<CartItem>> {
        val networkData = NetworkData()
        data.value = networkData.getDataFromNet(1, 10)
        Log.d("GetResInRepo", data.value.toString())
        return data

    }
}