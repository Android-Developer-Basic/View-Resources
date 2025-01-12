package otus.gpb.homework.viewandresources.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import otus.gpb.homework.viewandresources.R

class CartAdapter : RecyclerView.Adapter<CartViewHolder>() {
    private var carts = listOf<CartData>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CartViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cart_item, parent, false)

        return CartViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: CartViewHolder,
        position: Int
    ) {
        val item = carts.getOrNull(position)
        item?.let {
            holder.bind(it)
        }
    }

    override fun getItemCount(): Int {
        return carts.size
    }

    fun createCarts(newCarts: List<CartData>) {
        carts = newCarts
    }
}
