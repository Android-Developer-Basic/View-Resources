package otus.gpb.homework.viewandresources.cart

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import otus.gpb.homework.viewandresources.R

class CartViewHolder(
    private val viewCartItem: View,
) : RecyclerView.ViewHolder(viewCartItem) {

    private val image: ImageView by lazy { viewCartItem.findViewById(R.id.imageView) }
    private val headerTitle: TextView by lazy { viewCartItem.findViewById(R.id.header_title) }
    private val category: TextView by lazy { viewCartItem.findViewById(R.id.category) }
    private val supporting: TextView by lazy { viewCartItem.findViewById(R.id.supporting) }
    private val price: TextView by lazy { viewCartItem.findViewById(R.id.price) }

    fun bind(items: CartData) {
        image.setImageResource(items.image)
        headerTitle.text = items.headerTitle
        category.text = items.category
        supporting.text = items.supporting
        price.text = items.price
    }
}