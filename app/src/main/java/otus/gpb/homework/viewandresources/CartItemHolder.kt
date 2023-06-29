package otus.gpb.homework.viewandresources

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import otus.gpb.homework.domain.models.CartItem
import otus.gpb.homework.domain.use_cases.GetImageFromUrlUseCase
import otus.gpb.homework.viewandresources.databinding.CartItemBinding

class CartItemHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val binding = CartItemBinding.bind(itemView)

    @SuppressLint("SetTextI18n")
    fun bind(item: CartItem){
        itemView.findViewById<TextView>(R.id.itemName).text = item.title
        itemView.findViewById<TextView>(R.id.itemPrice).text = "\$US,${item.price}"
        itemView.findViewById<TextView>(R.id.itemCaption).text = "Caption"
        //getImage(item.images, itemView.findViewById(R.id.itemImage))

    }

    private fun getImage(images: List<String>, imageView: ImageView ){
        images.forEach {
            val img = GetImageFromUrlUseCase(it).getBitmap()
            img?.let{
                imageView.setImageBitmap(img)
                return@forEach
            }
        }
    }


}