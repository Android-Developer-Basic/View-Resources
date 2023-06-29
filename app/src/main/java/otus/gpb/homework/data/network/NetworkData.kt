package otus.gpb.homework.data.network

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import otus.gpb.homework.domain.models.CartItem
import retrofit2.Retrofit

class NetworkData {

    fun getDataFromNet(startIndex: Int, endIndex: Int): List<CartItem>{
        val list = mutableListOf<CartItem>()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .build()

        val api = retrofit.create(GetResponse::class.java)

        CoroutineScope(Dispatchers.IO).launch{
            for( i in startIndex..endIndex){
                list.add(api.getItemById(i))
        }

        }
        return list.toList()
    }

    companion object{
        const val BASE_URL = "https://dummyjson.com"
    }

}