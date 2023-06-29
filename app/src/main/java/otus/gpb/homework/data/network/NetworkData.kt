package otus.gpb.homework.data.network

import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import otus.gpb.homework.domain.models.CartItem
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkData {

    fun getDataFromNet(startIndex: Int, endIndex: Int): List<CartItem>{
        val list = mutableListOf<CartItem>()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(GetResponse::class.java)

        runBlocking {
            val res = async {
                for (i in startIndex..endIndex) {

                    list.add(api.getItemById(i))
                    Log.d("GetRes", list.toString())
                }
            }
            res.await()

        }
        return list

    }

    companion object{
        const val BASE_URL = "https://dummyjson.com"
    }

}