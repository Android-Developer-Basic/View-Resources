package otus.gpb.homework.viewandresources

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CartItemViewAdapter(private var cartItem: List<CartItem>) :
    RecyclerView.Adapter<CartItemViewAdapter.CartItemViewHolder>() {

    class CartItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.cart_item_title_tv)
        val category: TextView = itemView.findViewById(R.id.cart_item_category_tv)
        val description: TextView = itemView.findViewById(R.id.cart_item_description_tv)
        val price: TextView = itemView.findViewById(R.id.cart_item_price_tv)
        val itemImage: ImageView = itemView.findViewById(R.id.cart_item_iv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.cart_list_item, parent, false)
        return CartItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cartItem.size
    }

    override fun onBindViewHolder(holder: CartItemViewHolder, position: Int) {
        val item = cartItem[position]
        holder.itemImage.setImageResource(R.drawable.ic_cart_item)
        holder.name.text = item.name
        holder.category.text = item.category
        holder.description.text = item.description
        holder.price.text = item.price
    }
}
