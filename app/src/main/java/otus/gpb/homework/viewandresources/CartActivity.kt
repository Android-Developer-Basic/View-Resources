package otus.gpb.homework.viewandresources

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import otus.gpb.homework.viewandresources.adapter.CartListAdapter
import otus.gpb.homework.viewandresources.model.CartItem

class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        supportActionBar?.hide()

        val cartItems = listOf(
            CartItem(
                R.drawable.cupcake,
                R.string.on_the_top,
                R.string.caption,
                R.string.us1
            ),
            CartItem(
                R.drawable.forever_friends,
                R.string.forever_friends,
                R.string.caption,
                R.string.us2
            ),
            CartItem(
                R.drawable.prototyping_kit,
                R.string.prototyping_kit,
                R.string.caption,
                R.string.us3
            ),
            CartItem(
                R.drawable.basket_and_coffee,
                R.string.basket_and_coffee,
                R.string.caption,
                R.string.us4
            )
        )

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = CartListAdapter(cartItems)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
