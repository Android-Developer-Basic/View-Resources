package otus.gpb.homework.viewandresources

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ItemCartAdapter: RecyclerView.Adapter<CartItemViewHolder>() {

    var items = listOf<ItemCart>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout_cart, parent, false)
        return CartItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartItemViewHolder, position: Int) {
        val cartItem: ItemCart = items[position]
        holder.bind(cartItem)
    }

    override fun getItemCount(): Int {
        return items.size
    }

}