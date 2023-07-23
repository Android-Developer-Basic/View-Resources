package otus.gpb.homework.data.network


import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import otus.gpb.homework.domain.models.CartItem
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory




class NetworkData {

    suspend fun getDataFromNet(): List<CartItem>{
        val list = mutableListOf<CartItem>()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        val api = retrofit.create(GetResponse::class.java)
        val scope = CoroutineScope(Dispatchers.IO)

        scope.async {

            val apiList = api.getListFromVercel()
            apiList.map { list.add(it) }

        }.await()
        scope.cancel()
        return list
    }


    companion object{
        const val BASE_URL = "https://testing-server-indol.vercel.app"
    }

}