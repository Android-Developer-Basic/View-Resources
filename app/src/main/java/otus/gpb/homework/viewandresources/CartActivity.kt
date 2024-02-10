package otus.gpb.homework.viewandresources

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import otus.gpb.homework.viewandresources.cart_adapter.CartAdapter
import otus.gpb.homework.viewandresources.cart_adapter.getCartItems

class CartActivity : AppCompatActivity(R.layout.activity_cart) {

    private val listView: RecyclerView by lazy { findViewById(R.id.recyclerView) }
    private val cartItems = getCartItems()
    private val adapter: CartAdapter = CartAdapter()

    private val textViewCounting: TextView by lazy { findViewById(R.id.textViewCounting) }
    private val textViewSubTotalPrice: TextView by lazy { findViewById(R.id.textViewSubTotalPrice) }
    private val textViewOrderTotalPrice: TextView by lazy { findViewById(R.id.textViewOrderTotalPrice) }
    private val textViewShippingPrice: TextView by lazy { findViewById(R.id.textViewShippingPrice) }
    private val textViewTaxPrice: TextView by lazy { findViewById(R.id.textViewTaxPrice) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        listView.recycledViewPool.setMaxRecycledViews(0, 15)
        listView.adapter = adapter
        adapter.submitList(cartItems.onEach {
            it.priceString = resources.getString(R.string.cart_item_price, it.price)
        })

        cartItems.apply {
            textViewCounting.text = resources.getString(R.string.cart_items_counting, count())
            var subTotalPrice = 0.0
            forEach {
                subTotalPrice += it.price
            }

            textViewSubTotalPrice.text = resources.getString(R.string.cart_item_price, subTotalPrice)
            val totalPrice = resources.getString(R.string.cart_shipping_price).toDouble() + resources.getString(R.string.cart_tax_price).toDouble() + subTotalPrice
            textViewOrderTotalPrice.text = resources.getString(R.string.cart_item_price, totalPrice)
        }

        textViewShippingPrice.text = resources.getString(R.string.cart_item_price, resources.getString(R.string.cart_shipping_price).toDouble())
        textViewTaxPrice.text = resources.getString(R.string.cart_item_price, resources.getString(R.string.cart_tax_price).toDouble())
    }
}