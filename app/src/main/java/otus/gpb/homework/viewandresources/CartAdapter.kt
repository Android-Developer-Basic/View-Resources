package otus.gpb.homework.viewandresources

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CartAdapter() : RecyclerView.Adapter<CartViewHolder>() {

    private var list = emptyList<CartItem>()

    fun setList(list: List<CartItem>) {
        this.list = list.toList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cart_item, parent, false)

        return CartViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(viewHolder: CartViewHolder, position: Int) {
        val item = list[position]
        viewHolder.bind(item)
    }

}