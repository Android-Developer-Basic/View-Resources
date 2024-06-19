package otus.gpb.homework.viewandresources

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerCard(private val dataList: List<Item>) : RecyclerView.Adapter<RecyclerCard.RecyclerCardHolder>() {

    class RecyclerCardHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val textView: TextView = itemView.findViewById(R.id.textView)
        val priceView: TextView = itemView.findViewById(R.id.priceView)
        val deleteIcon: ImageView = itemView.findViewById(R.id.deleteIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerCardHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return RecyclerCardHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerCardHolder, position: Int) {
        val currentItem = dataList[position]
        holder.imageView.setImageResource(currentItem.imageResId)
        holder.textView.text = currentItem.text
        holder.priceView.text = currentItem.price
        holder.deleteIcon.setOnClickListener {
        }
    }

    override fun getItemCount() = dataList.size
}