package otus.gpb.homework.viewandresources

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class CartActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerCard
    private lateinit var layoutManager: RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)

        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val dataList = listOf(
            Item("On the top\nCaption", R.drawable.pie, "$ US,1.50"),
            Item("Forever Friends\nCaption", R.drawable.disk, "$ US,4.50"),
            Item("Prototyping Kit\nCaption", R.drawable.clock, "$ US,8.00"),
            Item("Basket & Coffee\nCaption", R.drawable.cactus,"$ US,22.00")
        )

        adapter = RecyclerCard(dataList)
        recyclerView.adapter = adapter
    }
}