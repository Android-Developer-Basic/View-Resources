package otus.gpb.homework.viewandresources

import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class CartViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val title: TextView by lazy { view.findViewById(R.id.name) }
    private val category: TextView by lazy { view.findViewById(R.id.category) }
    private val description: TextView by lazy { view.findViewById(R.id.description) }
    private val price: TextView by lazy { view.findViewById(R.id.price) }
    private val photo: ImageView by lazy { view.findViewById(R.id.image) }
    fun bind(item: CartItem) {
        title.text = item.title
        price.text = buildString {
            append("$")
            append(item.price.toString())
        }
        category.text = item.category
        description.text = item.description
        photo.setImageResource(item.image)
    }
}