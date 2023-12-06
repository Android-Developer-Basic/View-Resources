package otus.gpb.homework.viewandresources

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textview.MaterialTextView

class CartViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView) {

    fun bind(cart: CartData, clickListener: (CartData, View) -> Unit) {
        // заполним строку корзины данными
        itemView.findViewById<MaterialTextView>(R.id.tv_cart_item_name).text=cart.itemName
        itemView.findViewById<MaterialTextView>(R.id.tv_cart_item_description).text=cart.itemDescription

        itemView.findViewById<MaterialTextView>(R.id.tv_cart_item_price).text=
            "\$US,${"%.2f".format(cart.itemPrice)}"
        itemView.findViewById<AppCompatImageView>(R.id.tv_cart_item_img).setImageResource(cart.itemImg)

        // отдаем обработку действий обратно
        val btn = itemView.findViewById<AppCompatImageView>(R.id.tv_cart_item_delete)
        btn.setOnClickListener{
            clickListener(cart, btn) // удаление
        }
        itemView.setOnClickListener {
            clickListener(cart, itemView)
        }
    }
}