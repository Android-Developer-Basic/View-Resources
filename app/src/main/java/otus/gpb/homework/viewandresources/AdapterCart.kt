package otus.gpb.homework.viewandresources


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class AdapterCart : RecyclerView.Adapter<ViewHolder>() {
    private var list = listOf<Item>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.text_row_item, parent, false)



        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list.getOrNull(position)
        item?.let {
            holder.bind(item)

        }

    }

    override fun getItemCount(): Int = list.size
    fun setData(newList: List<Item>) {
        list = newList

    }

}