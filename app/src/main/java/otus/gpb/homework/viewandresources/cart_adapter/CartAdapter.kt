package otus.gpb.homework.viewandresources.cart_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import otus.gpb.homework.viewandresources.R

class CartAdapter : ListAdapter<CartItem, CartItemViewHolder>(CartItemCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemViewHolder =
        CartItemViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_cart_items, parent, false))

    override fun onBindViewHolder(holder: CartItemViewHolder, position: Int) =
        holder.bind(getItem(position))
}

class CartItemCallback : DiffUtil.ItemCallback<CartItem>() {
    override fun areItemsTheSame(oldItem: CartItem, newItem: CartItem): Boolean = oldItem.title == newItem.title

    override fun areContentsTheSame(oldItem: CartItem, newItem: CartItem): Boolean = oldItem == newItem
}