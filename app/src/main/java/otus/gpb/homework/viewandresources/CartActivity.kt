package otus.gpb.homework.viewandresources

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val recyclerView: RecyclerView = findViewById(R.id.cart_rv)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        val cartItemsList = listOf(
            CartItem("List item 1","Category", getString(R.string.card_description), "$35"),
            CartItem("List item 2","Category", getString(R.string.card_description), "$35"),
            CartItem("List item 3","Category", getString(R.string.card_description), "$35"),
            CartItem("List item 4","Category", getString(R.string.card_description), "$35"),
        )

        recyclerView.adapter = CartItemViewAdapter(cartItemsList)
    }
}
