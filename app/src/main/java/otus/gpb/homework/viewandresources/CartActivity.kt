package otus.gpb.homework.viewandresources

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.core.view.MenuProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CartActivity : AppCompatActivity() {

    private val cartItemsList = mutableListOf<CartItem>()

    private lateinit var recycleView: RecyclerView
    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var adapter: CartRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        for (i in 1..4) {
            val item = CartItem(
                id = i,
                image = R.drawable.cart_item_image,
                title = getString(R.string.item_title, i),
                price = getString(R.string.item_price_example),
                category = getString(R.string.item_category_example),
                description = getString(R.string.item_description_example)
            )
            cartItemsList.add(item)
        }

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = resources.getString(R.string.cart)
        setSupportActionBar(toolbar)

        addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(
                menu: Menu,
                menuInflater: MenuInflater
            ) {
                menuInflater.inflate(R.menu.cart_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                TODO("Not yet implemented")
            }
        })

        recycleView = findViewById(R.id.rvItems)
        layoutManager = LinearLayoutManager(this)

        adapter = CartRecyclerViewAdapter(cartItemsList)

        recycleView.layoutManager = layoutManager
        recycleView.adapter = adapter
        recycleView
            .addItemDecoration(
                DividerItemDecoration(
                    this,
                    DividerItemDecoration.VERTICAL
                )
            )
    }
}