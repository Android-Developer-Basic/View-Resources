package otus.gpb.homework.viewandresources

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RcViewItem(private val itemsList: List<CartItem>) : RecyclerView.Adapter<RcViewItem.RecyclerItemHolder>() {

    class RecyclerItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textViewTitle: TextView = itemView.findViewById(R.id.title)
        val textView: TextView = itemView.findViewById(R.id.description)
        val priceView: TextView = itemView.findViewById(R.id.price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerItemHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cart, parent, false)
        return RecyclerItemHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerItemHolder, position: Int) {
        val currentItem = itemsList[position]
        holder.imageView.setImageResource(currentItem.image)
        holder.textViewTitle.text = currentItem.title
        holder.textView.text = currentItem.description
        holder.priceView.text = currentItem.price
    }

    override fun getItemCount() = itemsList.size
}
