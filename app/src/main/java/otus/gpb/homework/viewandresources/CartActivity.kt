package otus.gpb.homework.viewandresources

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val rv = findViewById<RecyclerView>(R.id.recyclerView)
        rv.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )
        rv.layoutManager = LinearLayoutManager(this)

        val itemsList = listOf(
            CartItem("Baguette", "Food", R.drawable.baguette, "$0.50"),
            CartItem("Wine", "Food", R.drawable.bottle_wine, "$7.30"),
            CartItem("Cheese", "Food", R.drawable.cheese, "$10.00"),
            CartItem("Metallica CD", "Music", R.drawable.album, "$15.00")
        )

        rv.adapter = RcViewItem(itemsList)
    }
}