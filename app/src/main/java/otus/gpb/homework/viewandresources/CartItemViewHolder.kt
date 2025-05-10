package otus.gpb.homework.viewandresources

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CartItemViewHolder(view: View): RecyclerView.ViewHolder(view){

        private val categoryText:TextView by lazy { view.findViewById(R.id.categoryText) }
        private val supportingText:TextView by lazy { view.findViewById(R.id.supportingText) }
        private val priceText:TextView by lazy { view.findViewById(R.id.priceText) }
        private val nameItemText:TextView by lazy { view.findViewById(R.id.nameItemText) }
        private val itemImage:ImageView by lazy { view.findViewById(R.id.itemImage) }

        private val maxLength = 32

        fun bind(itemCart: ItemCart){
                nameItemText.text = String.format(itemView.context.resources.getString(R.string.nameItemText), itemCart.id)
                categoryText.text = String.format(itemView.context.resources.getString(R.string.categoryText), itemCart.category)
                supportingText.text =
                        if (itemCart.supportingText.length > maxLength) {
                                itemCart.supportingText.substring(0, maxLength) + "..."
                        }else{
                                itemCart.supportingText
                        }
                priceText.text = String.format(itemView.context.resources.getString(R.string.priceText), itemCart.price)
        }

    
}