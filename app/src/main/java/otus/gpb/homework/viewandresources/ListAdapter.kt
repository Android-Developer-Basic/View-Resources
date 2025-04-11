package otus.gpb.homework.viewandresources

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import otus.gpb.homework.viewandresources.databinding.ActivityCartBinding
import otus.gpb.homework.viewandresources.databinding.CartItemBinding

class ListAdapter: Adapter<CartItemViewHolder>() {

    var list = listOf<CartItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart_item, parent, false)
        return CartItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartItemViewHolder, position: Int) {
        val cartItem = list[position]
        holder.textViewNumber.setText(String.format(
            holder.itemView.context.resources.getString(R.string.number_of_list),
            cartItem.index
        ))
        holder.textViewPrice.setText(String.format(
            holder.itemView.context.resources.getString(R.string.price),
            cartItem.price
        ))
        holder.textViewDescription.setText(cartItem.description)
        holder.textViewCategory.setText(cartItem.category)
        val resourceId = holder.itemView.context.resources.getIdentifier(cartItem.image, "drawable", holder.itemView.context.packageName)
        holder.imageView.setImageResource(resourceId)

    }

    override fun getItemCount(): Int {
        return list.size
    }
}