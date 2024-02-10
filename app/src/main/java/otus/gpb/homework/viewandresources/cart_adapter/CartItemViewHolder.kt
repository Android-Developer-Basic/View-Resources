package otus.gpb.homework.viewandresources.cart_adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import otus.gpb.homework.viewandresources.R

class CartItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val imageViewCartItem: ImageView by lazy { itemView.findViewById(R.id.imageViewCartItem) }
    private val textViewCartItemTitle: TextView by lazy { itemView.findViewById(R.id.textViewCartItemTitle) }
    private val textViewCartItemPrice: TextView by lazy { itemView.findViewById(R.id.textViewCartItemPrice) }
    private val textViewCartItemCaption: TextView by lazy { itemView.findViewById(R.id.textViewCartItemCaption) }

    fun bind(item: CartItem) {
        imageViewCartItem.setImageResource(item.idImage)

        textViewCartItemTitle.text = item.title
        textViewCartItemCaption.text = item.caption
        textViewCartItemPrice.text = item.priceString
    }
}