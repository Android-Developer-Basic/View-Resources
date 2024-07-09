package otus.gpb.homework.viewandresources

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CartActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerItem
    private lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)

        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val dataList = listOf(
            Item("On the top", "Caption", R.drawable.cake, "$ US,1.50"),
            Item("Forever Friends","Caption", R.drawable.vinil, "$ US,4.50"),
            Item("Prototyping Kit", "Caption", R.drawable.clock, "$ US,8.00"),
            Item("Basket & Coffee","Caption", R.drawable.cactus,"$ US,22.00")
        )

        adapter = RecyclerItem(dataList)
        recyclerView.adapter = adapter
   }
}