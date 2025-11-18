package otus.gpb.homework.viewandresources

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i("Salnikov", "Start activity")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val topAppBar = findViewById<MaterialToolbar>(R.id.cart_toolbar)
        topAppBar.setNavigationOnClickListener { finish() }

        topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.close -> {
                    finish()
                    true
                }

                else -> false
            }
        }

        val rv = findViewById<RecyclerView>(R.id.cart_items)
        rv.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )
        rv.layoutManager = LinearLayoutManager(this)

        val itemsList = listOf(
            CartItem(image = R.drawable.cart_item_sample, title = "Title 1", category = "category", description = "description 1", price = 32),
            CartItem(image = R.drawable.cart_item_sample, title = "Title 2", category = "category", description = "description 2", price = 32),
            CartItem(image = R.drawable.cart_item_sample, title = "Title 3", category = "category", description = "description 3", price = 32),
            CartItem(image = R.drawable.cart_item_sample, title = "Title 4", category = "category", description = "description 4", price = 32),
            CartItem(image = R.drawable.cart_item_sample, title = "Title 1", category = "category", description = "description 1", price = 32),
            CartItem(image = R.drawable.cart_item_sample, title = "Title 2", category = "category", description = "description 2", price = 32),
            CartItem(image = R.drawable.cart_item_sample, title = "Title 3", category = "category", description = "description 3", price = 32),
            CartItem(image = R.drawable.cart_item_sample, title = "Title 4", category = "category", description = "description 4", price = 32),
            CartItem(image = R.drawable.cart_item_sample, title = "Title 1", category = "category", description = "description 1", price = 32),
            CartItem(image = R.drawable.cart_item_sample, title = "Title 2", category = "category", description = "description 2", price = 32),
            CartItem(image = R.drawable.cart_item_sample, title = "Title 3", category = "category", description = "description 3", price = 32),
            CartItem(image = R.drawable.cart_item_sample, title = "Title 4", category = "category", description = "description 4", price = 32),
            CartItem(image = R.drawable.cart_item_sample, title = "Title 1", category = "category", description = "description 1", price = 32),
            CartItem(image = R.drawable.cart_item_sample, title = "Title 2", category = "category", description = "description 2", price = 32),
            CartItem(image = R.drawable.cart_item_sample, title = "Title 3", category = "category", description = "description 3", price = 32),
            CartItem(image = R.drawable.cart_item_sample, title = "Title 4", category = "category", description = "description 4", price = 32),
            CartItem(image = R.drawable.cart_item_sample, title = "Title 1", category = "category", description = "description 1", price = 32),
            CartItem(image = R.drawable.cart_item_sample, title = "Title 2", category = "category", description = "description 2", price = 32),
            CartItem(image = R.drawable.cart_item_sample, title = "Title 3", category = "category", description = "description 3", price = 32),
            CartItem(image = R.drawable.cart_item_sample, title = "Title 4", category = "category", description = "description 4", price = 32),
        )

        rv.adapter = ViewCartItem(itemsList)

    }
}