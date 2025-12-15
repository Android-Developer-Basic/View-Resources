package otus.gpb.homework.viewandresources

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CartActivity : AppCompatActivity() {

    private val cartItems = mutableListOf<CartItem>()

    private val cartAdapter by lazy { CartAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart_recycler_view)

        // Генерируем тестовые данные
        generateTestData()

        val rv = findViewById<RecyclerView>(R.id.recyclerView)
        rv.adapter = cartAdapter

        cartAdapter.setList(cartItems)
    }

    private fun generateTestData() {
        cartItems.clear()
        for (i in 1..100) {
            cartItems.add(
                CartItem(
                    image = R.drawable.cart_item,
                    title = getString(R.string.cart_item_headline, i),
                    category = getString(R.string.cart_item_category),
                    description = getString(R.string.cart_item_description),
                    price = i * 10
                )
            )
        }

        val cartCounter = findViewById<TextView>(R.id.cartCounter)
        cartCounter.text = getString(R.string.cart_items, 100)
    }
}