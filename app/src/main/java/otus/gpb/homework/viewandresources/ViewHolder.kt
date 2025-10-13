package otus.gpb.homework.viewandresources

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val title: TextView by lazy { view.findViewById(R.id.textViewTitle) }
    private val category: TextView by lazy { view.findViewById(R.id.textViewCategory) }
    private val description: TextView by lazy { view.findViewById(R.id.textViewDescription) }
    private val price: TextView by lazy { view.findViewById(R.id.textViewPrice) }
    private val photo: ImageView by lazy { view.findViewById(R.id.photo) }
    fun bind(item: Item) {
        title.text = item.title
        price.text = buildString {
            append("$")
            append(item.price.toString())
        }
        category.text = item.category
        description.text = item.description
        photo.setImageResource(item.photo)
    }
}