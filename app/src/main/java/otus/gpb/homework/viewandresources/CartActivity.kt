package otus.gpb.homework.viewandresources
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import otus.gpb.homework.viewandresources.model.CartItem
import otus.gpb.homework.viewandresources.cart.CartAdapter

class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        val root = findViewById<ConstraintLayout>(R.id.rootCartLayout)
        val startPadding = resources.getDimensionPixelSize(R.dimen.contact_screen_padding_start)
        val endPadding = resources.getDimensionPixelSize(R.dimen.contact_screen_padding_end)

        ViewCompat.setOnApplyWindowInsetsListener(root) { view, insets ->
            val statusInsets = insets.getInsets(WindowInsetsCompat.Type.statusBars())
            view.setPaddingRelative(
                startPadding,
                statusInsets.top,
                endPadding,
                view.paddingBottom
            )
            WindowInsetsCompat.CONSUMED
        }
        ViewCompat.requestApplyInsets(root)
        val items = listOf(
            CartItem("List item 1", "Category", "Supporting line lorem ipsum…", "$35", R.drawable.ic_cart_placeholder),
            CartItem("List item 2", "Category", "Supporting line lorem ipsum…", "$35", R.drawable.ic_cart_placeholder),
            CartItem("List item 3", "Category", "Supporting line lorem ipsum…", "$35", R.drawable.ic_cart_placeholder),
            CartItem("List item 4", "Category", "Supporting line lorem ipsum…", "$35", R.drawable.ic_cart_placeholder)
        )

        val recycler = findViewById<RecyclerView>(R.id.recyclerCart)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = CartAdapter(items)

        val itemsCountText = findViewById<TextView>(R.id.textItemsCount)
        itemsCountText.text = getString(R.string.cart_items_count, items.size)
    }
}
