package otus.gpb.homework.viewandresources

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        // Set click listener for the back button
        findViewById<ImageButton>(R.id.btn_back).setOnClickListener({
            // Handle back button click
            onBackPressedDispatcher.onBackPressed() // Example action
        })

        // Set click listener for the close button
        findViewById<ImageButton>(R.id.btn_close).setOnClickListener({
            // Handle back button click
            finish() // Example action
        })

        findViewById<com.google.android.material.button.MaterialButton>(R.id.place_order_button).setOnClickListener({
            // Handle back button click
            finish() // Example action
        })

        val recyclerView: RecyclerView = findViewById(R.id.rv_items) // Replace with your RecyclerView ID

        val divider = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        divider.setDrawable(ContextCompat.getDrawable(this, R.drawable.recycler_view_devider)!!)
        recyclerView.addItemDecoration(divider)

        // Sample data
        val items = listOf(
            CartItem(
                iconResId = R.drawable.ic_cart_item, // Replace with your drawable resource
                title = "Item 1",
                price = "$43.88",
                category = "Category 1",
                note = "This is a note for Item 1"
            ),
            CartItem(
                iconResId = R.drawable.ic_cart_item,
                title = "Item 2",
                price = "$43.88",
                category = "Category 2",
                note = "This is a note for Item 2"
            ),
            CartItem(
                iconResId = R.drawable.ic_cart_item,
                title = "Item 3",
                price = "$43.87",
                category = "Category 3",
                note = "This is a note for Item 3"
            ),
            CartItem(
                iconResId = R.drawable.ic_cart_item,
                title = "Item 4",
                price = "$43.87",
                category = "Category 4",
                note = "This is a note for Item 4"
            )

        )

        // Set up RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = CartAdapter(items)
    }

    data class CartItem(
        val iconResId: Int,      // Resource ID for the image
        val title: String,       // Title of the item
        val price: String,       // Price of the item
        val category: String,    // Category of the item
        val note: String         // Additional note
    )

    class CartAdapter(private val items: List<CartItem>) :
        RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

        // ViewHolder to hold references to views in the item layout
        class CartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val icon: ImageView = itemView.findViewById(R.id.icon)
            val title: TextView = itemView.findViewById(R.id.cart_item_title)
            val price: TextView = itemView.findViewById(R.id.cart_item_price_val)
            val category: TextView = itemView.findViewById(R.id.cart_item_category)
            val note: TextView = itemView.findViewById(R.id.cart_item_note)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.activity_cart_list_item, parent, false) // Replace with your item layout
            return CartViewHolder(view)
        }

        override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
            val item = items[position]
            holder.icon.setImageResource(item.iconResId)
            holder.title.text = item.title
            holder.price.text = item.price
            holder.category.text = item.category
            holder.note.text = item.note
        }

        override fun getItemCount(): Int = items.size
    }

}