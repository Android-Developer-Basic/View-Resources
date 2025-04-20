package otus.gpb.homework.viewandresources

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import otus.gpb.homework.viewandresources.databinding.ActivityCartBinding

class CartActivity : AppCompatActivity() {

    private val cartItems = listOf(
        CartItem("List Item 1",
            "Supporting line text 1",
            "image/cat",
            "$35"),

        CartItem("List Item 2",
            "Supporting line text 2",
            "image/cat",
            "$35"),

        CartItem("List Item 3",
            "Supporting line text 3",
            "image/cat",
            "$35"),

        CartItem("List Item 4",
            "Supporting line text 4",
            "image/cat",
            "$35"),
    )

    private lateinit var binding: ActivityCartBinding
    private lateinit var adapter: CartItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val manager = LinearLayoutManager(this) // LayoutManager
        adapter = CartItemAdapter() // Создание объекта
        adapter.data = cartItems
        binding.recyclerView.layoutManager = manager // Назначение LayoutManager для RecyclerView
        binding.recyclerView.adapter = adapter // Назначение адаптера для RecyclerView
    }
}