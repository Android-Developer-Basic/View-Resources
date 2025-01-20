package otus.gpb.homework.viewandresources

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val itemTitle: TextView = itemView.findViewById(R.id.cart_item_title)
    val itemImage: ImageView = itemView.findViewById(R.id.cart_item_image)
    val itemCategory: TextView = itemView.findViewById(R.id.cart_item_category)
    val itemDescription: TextView = itemView.findViewById(R.id.cart_item_description)
    val itemPrice: TextView = itemView.findViewById(R.id.cart_item_price)

}