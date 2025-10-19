package otus.gpb.homework.viewandresources

import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import otus.gpb.homework.viewandresources.databinding.CartItemBinding
import otus.gpb.homework.viewandresources.dto.Product

/**
 * Обёртка вокруг View, и этим представлением управляет RecyclerView .
 * */
class CartViewHolder(
    private val cartItemBinding: CartItemBinding,
    private val itemListener: ItemListener
) : RecyclerView.ViewHolder(cartItemBinding.root) {

    init {
        println("init CartViewHolder")
    }

    val productImageView: ImageView = cartItemBinding.productImage
    val productNameView: TextView = cartItemBinding.productName
    val categoryView: TextView = cartItemBinding.category
    val descriptionView: TextView = cartItemBinding.description
    val priceView: TextView = cartItemBinding.price


    fun bind(product: Product) {
        with(product) {
            println("bind CartViewHolder with id $id.}")
            //todo разобраться, почему без этой строки не отображается
            productImageView.setImageResource(imageResId)
            productNameView.text = productName
            categoryView.text = category
            descriptionView.text = description
            priceView.text = price
        }
        cartItemBinding.root.setOnClickListener { it ->
            itemListener.onItemClick(product.id)
        }


    }

}