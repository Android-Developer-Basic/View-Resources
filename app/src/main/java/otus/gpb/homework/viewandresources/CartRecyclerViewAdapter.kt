package otus.gpb.homework.viewandresources

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView

class CartRecyclerViewAdapter(private val list: List<CartItem>) :
    RecyclerView.Adapter<CartRecyclerViewAdapter.CartViewHolder>() {

    inner class CartViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        private val image: ImageView = view.findViewById(R.id.image)
        private val title: TextView = view.findViewById(R.id.title)
        private val price: TextView = view.findViewById(R.id.price)
        private val category: TextView = view.findViewById(R.id.category)
        private val description: TextView = view.findViewById(R.id.description)

        fun bind(item: CartItem) {
            val drawableImage = ResourcesCompat
                .getDrawable(view.resources, item.image, null)
            image.setImageDrawable(drawableImage)

            title.text = item.title
            price.text = item.price
            category.text = item.category
            description.text = item.description
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent, false)
        return CartViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: CartViewHolder,
        position: Int
    ) {
        val item: CartItem = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = list.size
}

data class CartItem(
    val id: Int,
    val image: Int,
    val title: String,
    val price: String,
    val category: String,
    val description: String,
)