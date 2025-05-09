package otus.gpb.homework.viewandresources

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView

class CustomRecyclerAdapter(private val items: List<Item>):
    RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<MaterialTextView>(R.id.textViewTitle)
        val category = itemView.findViewById<MaterialTextView>(R.id.textViewCategory)
        val priceItem = itemView.findViewById<MaterialTextView>(R.id.textViewPriceItem)
        val imageItem = itemView.findViewById<ImageView>(R.id.imageView)
        val description = itemView.findViewById<MaterialTextView>(R.id.textViewDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = items[position]
        holder.title.text = item.title
        holder.category.text = item.category
        holder.priceItem.text = item.price.toString()
        holder.description.text = item.description
        holder.imageItem.setImageResource(R.drawable.cat)
    }
    fun <T> myList(vararg i: T) = arrayListOf(*i)
    val list = myList(1, 5, 3, 2, 4)
}

interface My1