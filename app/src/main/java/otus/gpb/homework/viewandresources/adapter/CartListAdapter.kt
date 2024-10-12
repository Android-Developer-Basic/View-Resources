package otus.gpb.homework.viewandresources.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import otus.gpb.homework.viewandresources.R
import otus.gpb.homework.viewandresources.model.CartItem

class CartListAdapter(
    private val listItems: List<CartItem>,
) : RecyclerView.Adapter<CartListAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.mainImage)
        val nameTextView: TextView = itemView.findViewById(R.id.mainText)
        val descriptionTextView: TextView = itemView.findViewById(R.id.mainDescription)
        val priceTextView: TextView = itemView.findViewById(R.id.mainPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.cart_item, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listItems[position]

        holder.apply {
            imageView.setImageResource(item.image)
            nameTextView.setText(item.name)
            descriptionTextView.setText(item.description)
            priceTextView.setText(item.price)
        }
    }

    override fun getItemCount() = listItems.size
}
