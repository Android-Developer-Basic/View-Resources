package otus.gpb.homework.data



import otus.gpb.homework.data.network.NetworkData
import otus.gpb.homework.domain.models.CartItem
import otus.gpb.homework.domain.repository.CartRepository



object CartRepositoryImpl:CartRepository {

    override suspend fun getCartList(): List<CartItem> {
        return NetworkData().getDataFromNet()

    }
}