package otus.gpb.homework.data.network

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import otus.gpb.homework.domain.models.CartItem
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException



class NetworkData {

    fun getDataFromNet(startIndex: Int, endIndex: Int): List<CartItem>{
        val list = mutableListOf<CartItem>()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(GetResponse::class.java)

        runBlocking(Dispatchers.IO){
            val res = async{
                for (i in startIndex..endIndex) {

                    try{list.add(api.getItemById(i))}
                    catch (e:IOException){
                        return@async
                    }
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