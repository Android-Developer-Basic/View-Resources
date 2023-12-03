package otus.gpb.homework.viewandresources

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import otus.gpb.homework.viewandresources.databinding.ActivityCartBinding

class CartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            cartItems.text = resources.getQuantityString(R.plurals.cart_items, 4, 4)
            cartItem1Price.text = resources.getString(R.string.cart_item_price, 1.5)
            cartItem2Price.text = resources.getString(R.string.cart_item_price, 4.5)
            cartItem3Price.text = resources.getString(R.string.cart_item_price, 8.0)
            cartItem4Price.text = resources.getString(R.string.cart_item_price, 22.0)
            cartTotalOrderNumber.text = resources.getString(R.string.cart_order_price, 41.24)
            cartSubtotalNumber.text = resources.getString(R.string.cart_order_price, 36.0)
            cartShippingNumber.text = resources.getString(R.string.cart_order_price, 2.0)
            cartTaxNumber.text = resources.getString(R.string.cart_order_price, 3.5)
        }
    }
}