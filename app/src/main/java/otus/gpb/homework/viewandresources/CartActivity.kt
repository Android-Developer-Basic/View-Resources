package otus.gpb.homework.viewandresources

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CartActivity : AppCompatActivity() {
    private val adapter: AdapterCart by lazy { AdapterCart() }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = adapter
        adapter.setData(generate())
        findViewById<TextView>(R.id.filledTextCounter).text =
            buildString {
                append(adapter.itemCount.toString())
                append(" items in your cart")
            }
        findViewById<View>(R.id.close).setOnClickListener { finish() }


    }

    fun generate() = run {
        val list = mutableListOf<Item>()
        repeat(
            4
        ) {
            val item = Item(

                title = "Name ${it.inc()}",
                price = 35,
                category = "Category",
                description = "Supporting line text lorem ipsum dolor sit amet, consectetur.",
                photo = R.drawable.ic_launcher_background
            )
            list.add(item)

        }
        list.toList()
    }
}