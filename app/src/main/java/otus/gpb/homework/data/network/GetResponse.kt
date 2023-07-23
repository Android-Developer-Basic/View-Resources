package otus.gpb.homework.data.network

import otus.gpb.homework.domain.models.CartItem
import retrofit2.http.GET


interface GetResponse {
    @GET("/products")
    suspend fun getListFromVercel(): List<CartItem>

}

