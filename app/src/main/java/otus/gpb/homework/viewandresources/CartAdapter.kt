package otus.gpb.homework.viewandresources

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import otus.gpb.homework.domain.models.CartItem

class CartAdapter:RecyclerView.Adapter<CartItemHolder>() {
    val list = mutableListOf<CartItem>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CartItemHolder, position: Int) {
        TODO("Not yet implemented")
    }
}