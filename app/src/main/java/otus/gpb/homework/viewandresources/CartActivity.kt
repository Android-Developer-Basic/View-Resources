package otus.gpb.homework.viewandresources

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar

class CartActivity : AppCompatActivity() {

    private lateinit var toolbar: MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        toolbar = findViewById<MaterialToolbar>(R.id.topAppBar)
        setSupportActionBar(toolbar)
        toolbar.title = "Cart"
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewItems)
        recyclerView.layoutManager = LinearLayoutManager(this)


        recyclerView.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        val listItems = getItemList()
        recyclerView.adapter = CustomRecyclerAdapter(listItems)

    }

    private fun getItemList(): List<Item>{
        val res = mutableListOf<Item>()
        repeat(200) {
            val item = Item(). apply {
                title = "Title $it"
                category = "Category $it"
                price = (10..100).random()
            }
            res.add(item)
        }
        return res
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.top_app_bar_cart, menu)
        return super.onCreateOptionsMenu(menu)
    }
}