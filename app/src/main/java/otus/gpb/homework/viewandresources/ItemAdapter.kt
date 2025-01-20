package otus.gpb.homework.viewandresources

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val dataItem: List<Item>) : RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cart_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount() = dataItem.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataItem[position]
        holder.itemTitle.text = item.title
        holder.itemDescription.text = item.description
        holder.itemCategory.text = item.category
        holder.itemPrice.text = "\$${item.price}"
    }
}