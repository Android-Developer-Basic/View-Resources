package otus.gpb.homework.viewandresources

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import otus.gpb.homework.viewandresources.databinding.ItemCartBinding

class CartAdapter : RecyclerView.Adapter<CartAdapter.CartHolder>() {

    val list = CartList.list


    inner class CartHolder(item: View): RecyclerView.ViewHolder(item) {
        private val binding = ItemCartBinding.bind(item)


        @SuppressLint("NotifyDataSetChanged")
        fun bind(cart: Cart
        ) = with(binding) {
            var i: Int
            when (cart.id){
                1 -> i = R.drawable.pencil
                2 -> i = R.drawable.pencil
                3 -> i = R.drawable.pencil
                4 -> i = R.drawable.pencil
                else -> i = R.drawable.account
            }
            Glide.with(imageView)
                .load(R.drawable.pencil)
                .placeholder(android.R.drawable.ic_popup_sync)
                .error(android.R.drawable.stat_notify_error)
                .into(imageView)

            textView6.text = cart.name
            textView6.text = cart.name
        }


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent, false)
        return CartHolder(view)
    }

    override fun onBindViewHolder(holder: CartHolder, position: Int) {
            holder.bind(list[position])

    }

    override fun getItemCount(): Int {
        return list.size
    }



}