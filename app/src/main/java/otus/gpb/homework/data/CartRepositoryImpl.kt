package otus.gpb.homework.data

import otus.gpb.homework.data.network.NetworkData
import otus.gpb.homework.domain.models.CartItem
import otus.gpb.homework.domain.repository.CartRepository

class CartRepositoryImpl:CartRepository {
    override fun getCartList(): List<CartItem> {
        val networkData = NetworkData()
        return  networkData.getDataFromNet(1, 10)

    }
}