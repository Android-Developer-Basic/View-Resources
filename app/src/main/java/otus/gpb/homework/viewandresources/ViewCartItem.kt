package otus.gpb.homework.viewandresources

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class ViewCartItem(private val itemsList: List<CartItem>) : RecyclerView.Adapter<ViewCartItem.ViewCartItemHolder>() {

    class ViewCartItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ShapeableImageView = itemView.findViewById(R.id.cart_item_image)
        val title: TextView = itemView.findViewById(R.id.cart_item_title)
        val category: TextView = itemView.findViewById(R.id.cart_item_category)
        val description: TextView = itemView.findViewById(R.id.cart_item_description)
        val price: TextView = itemView.findViewById(R.id.cart_item_price)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewCartItemHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.cart_item, parent, false)
        return ViewCartItemHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: ViewCartItemHolder,
        position: Int
    ) {
        val currentItem = itemsList[position]
        holder.image.setImageResource(currentItem.image)
        holder.title.text = currentItem.title
        holder.category.text = currentItem.category
        holder.description.text = currentItem.description

        val price = holder.itemView.context.getString(R.string.price, currentItem.price)

        holder.price.text = price
    }

    override fun getItemCount(): Int = itemsList.size
}