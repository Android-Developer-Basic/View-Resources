package otus.gpb.homework.viewandresources

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import otus.gpb.homework.viewandresources.databinding.ActivityCartBinding
import otus.gpb.homework.viewandresources.dto.Product
import java.util.UUID

class CartActivity : AppCompatActivity(), ItemListener {

    private val products by lazy { generateTestData() }
    private val adapter by lazy { CartAdapter(products, this) }

    lateinit var activityCartBinding: ActivityCartBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityCartBinding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(activityCartBinding.root)
        val cartListView = activityCartBinding.cartListView
        cartListView.addItemDecoration(DividerItemDecoration(this, LinearLayout.VERTICAL))
        cartListView.adapter = adapter
//        adapter.notifyDataSetChanged()
        activityCartBinding.orderTotalValue.text =
            products.sumOf { it.price.replace("$", "").toInt() }.toString()
    }

    fun generateTestData() = Array(22) {
        Product(
            UUID.randomUUID(),
            R.drawable.cart_item_icon,
            "Product $it",
            "Category $it",
            "lorem ipsum dolor sit amet, consectetur adipiscing elit",
            "$$it"
        )
    }.toMutableList()

    override fun onItemClick(id: UUID) {
        Toast.makeText(this, "Clicked on item with id $id", Toast.LENGTH_SHORT).show()
    }

}