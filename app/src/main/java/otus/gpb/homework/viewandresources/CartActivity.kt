package otus.gpb.homework.viewandresources

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import otus.gpb.homework.viewandresources.cart.CartAdapter
import otus.gpb.homework.viewandresources.cart.CartData

class CartActivity : AppCompatActivity() {

    private val cartAdapter: CartAdapter by lazy { CartAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        var toolbar = findViewById<Toolbar>(R.id.topAppBar)
        setSupportActionBar(toolbar)

        val recyclerView = findViewById<RecyclerView>(R.id.cartRW)
        recyclerView.adapter = cartAdapter
        cartAdapter.createCarts(createCarts())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu_card, menu)
        return true
    }

    private fun createCarts(): List<CartData> {

        val carts = (1..15).map {
            CartData(
                headerTitle = "List item $it",
                image = R.drawable.cart_image,
                category = "category",
                supporting = "Supporting line text lorem ipsum dolor sit amet, consectetur.",
                price = "$35",
            )
        }.toList()
        return carts
    }
}
