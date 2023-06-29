package otus.gpb.homework.data.network

import otus.gpb.homework.domain.models.CartItem
import retrofit2.http.GET
import retrofit2.http.Path

interface GetResponse {
    @GET("/products/{id}")
    suspend fun getItemById(@Path("id") id: Int): CartItem

}