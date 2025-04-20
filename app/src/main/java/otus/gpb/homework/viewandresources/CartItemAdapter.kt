package otus.gpb.homework.viewandresources

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import otus.gpb.homework.viewandresources.databinding.ItemCartBinding


class CartItemAdapter : RecyclerView.Adapter<CartItemAdapter.CartItemViewHolder>() {

    var data: List<CartItem> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    class CartItemViewHolder(val binding: ItemCartBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int = data.size // Количество элементов в списке данных

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCartBinding.inflate(inflater, parent, false)

        return CartItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartItemViewHolder, position: Int) {
        val item = data[position] // Получение записи списка данных по позиции

        with(holder.binding) {
            cartItemTitle.text = item.name
            cartItemPrice.text = item.price
            cartItemCategoryDesc.text = item.desc
            cartItemImageView.scaleType=ImageView.ScaleType.CENTER_INSIDE
            cartItemImageView.setImageResource(R.drawable.cat)

        }
    }
}