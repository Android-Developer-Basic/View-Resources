package otus.gpb.homework.viewandresources

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.divider.MaterialDividerItemDecoration
import otus.gpb.homework.viewandresources.databinding.ActivityCartBinding

class CartActivity : AppCompatActivity() {

    private val listItem = mutableListOf<ItemCart>()
    private val binding by lazy {
        ActivityCartBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            finish()
        }

        createListCartItem()
        val adapter = ItemCartAdapter()
        adapter.items = listItem
        binding.counterLabel.text = String.format(
            this.resources.getString(R.string.counterLabel),
            adapter.items.size
        )
        val dividerItemDecoration = MaterialDividerItemDecoration(binding.recyclerViewCartList.context, MaterialDividerItemDecoration.VERTICAL)
        dividerItemDecoration.setDividerColor(ContextCompat.getColor(applicationContext, R.color.outline_variant))
        dividerItemDecoration.dividerThickness = 2
        dividerItemDecoration.isLastItemDecorated = true

        binding.recyclerViewCartList.addItemDecoration(dividerItemDecoration)
        binding.recyclerViewCartList.adapter = adapter

        val pricePair = calculateOrderPrice(listItem)
        binding.taxPrice.text = String.format(this.resources.getString(R.string.price), TAX_PRICE)
        binding.shippingPrice.text = String.format(this.resources.getString(R.string.price), SHIPPING_PRICE)
        binding.subtotalPrice.text = String.format(this.resources.getString(R.string.price), pricePair.second)
        binding.totalPrice.text = String.format(this.resources.getString(R.string.price), pricePair.first)
    }

    private fun createListCartItem() {
        for(i in 1..5){
            val cartItem = ItemCart(i, 35, CATEGORY, DESCRIPTION, IMAGE)
            listItem.add(cartItem)
        }
    }

    private fun calculateOrderPrice(listItem: MutableList<ItemCart>):Pair<Double,Double>{
        var totalPrice = TAX_PRICE + SHIPPING_PRICE
        var subtotalPrice = 0.0
        listItem.forEach { subtotalPrice += it.price }
        totalPrice +=subtotalPrice
        return Pair(totalPrice,subtotalPrice)
    }

    companion object{
        private const val DESCRIPTION = "Supporting line text lorem ipsum dolor sit amet, consectetur."
        private const val CATEGORY = "Category"
        private const val IMAGE = "drawable/food_steak"

        private const val TAX_PRICE = 10.5
        private const val SHIPPING_PRICE = 25.0
    }
}