package otus.gpb.homework.viewandresources

import android.os.Bundle
import android.view.Menu
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import otus.gpb.homework.viewandresources.ItemRepository.Companion.listItem

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.cart_toolbar)

        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val itemAdapter = ItemAdapter(listItem)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = itemAdapter
        recyclerView.addItemDecoration(RecyclerViewItemDecoration(this, R.drawable.divider))

        var cartCount = findViewById<TextView>(R.id.cart_count)
        cartCount.text = "${itemAdapter.itemCount} items in your cart"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.menu_cart, menu)
        return super.onCreateOptionsMenu(menu)
    }
}