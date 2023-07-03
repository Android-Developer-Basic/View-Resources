package otus.gpb.homework.data


import android.util.Log
import otus.gpb.homework.data.network.NetworkData
import otus.gpb.homework.domain.models.CartItem
import otus.gpb.homework.domain.repository.CartRepository
import kotlin.random.Random


object CartRepositoryImpl:CartRepository {

    override suspend fun getCartList(): List<CartItem> {
        val rangeList = listOf(Random.nextInt(1, 100),Random.nextInt(1, 100)).sorted()
        Log.d("RangeList", rangeList.toString())
        return NetworkData().getDataFromNet(rangeList[0], rangeList[1])

    }
}