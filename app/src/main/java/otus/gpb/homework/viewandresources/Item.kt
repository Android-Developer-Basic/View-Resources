package otus.gpb.homework.viewandresources

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.withStyledAttributes
import otus.gpb.homework.viewandresources.databinding.ItemBinding

class Item @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : LinearLayout(context, attrs, defStyleAttr) {
    private val binding: ItemBinding = ItemBinding.inflate(LayoutInflater.from(context), this)

    init {
        initParams(attrs, defStyleAttr)
    }

    private fun initParams(attrs: AttributeSet?, defStyleAttr: Int) = with(binding) {
        context.withStyledAttributes(attrs, R.styleable.Item, defStyleAttr) {
            val imageResId = getResourceId(R.styleable.Item_itemImage, 0)
            if (imageResId != 0) {
                itemImage.setImageResource(imageResId)
            }

            val name = getString(R.styleable.Item_itemName) ?: "Name"
            itemName.text = name

            val description = getString(R.styleable.Item_itemDescription) ?: "Description"
            itemDescription.text = description

            val price = getString(R.styleable.Item_itemPrice) ?: "Price"
            itemPrice.text = price
        }
    }
}