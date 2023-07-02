package otus.gpb.homework.viewandresources

import android.annotation.SuppressLint
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import otus.gpb.homework.domain.models.CartItem
import otus.gpb.homework.viewandresources.databinding.CartItemBinding
import java.io.IOException

class CartItemHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    private val binding = CartItemBinding.bind(itemView)

    @SuppressLint("SetTextI18n")
    fun bind(item: CartItem) = with(binding){
        itemName.text = item.title
        itemPrice.text = String.format("%s, %.2f","US",item.price)
        itemCaption.text = "Caption"
        val imageView = itemImage
        val images = item.images
        getImage(images.last(), imageView)

    }

    private fun getImage(image: String, imageView: ImageView ){

        try {
            Glide.with(itemView.context).load(image).centerCrop().into(imageView)
        }
        catch (e:IOException){
            imageView.setImageResource(R.drawable.baseline_image_not_supported_24)
        }
    }

}