package otus.gpb.homework.viewandresources

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.withStyledAttributes
import otus.gpb.homework.viewandresources.databinding.CartItemBinding

enum class CartItemType { ITEM, TOTAL, SUBTOTAL }

class CartItem @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val binding: CartItemBinding

    var itemType: CartItemType = CartItemType.ITEM

    var name: String = ""
        set(value) {
            field = value
            binding.name.text = value
        }
    var caption: String = ""
        set(value) {
            field = value
            binding.caption.text = value
        }

    var price: Float = 0F
        set(value) {
            field = value
            val s = "${if (itemType == CartItemType.ITEM) "\$US, " else ""}${"%.2f".format(value)}"
            binding.price.text = s
        }

    var imageRes: Int = 0
        set(value) {
            field = value
            binding.image.setImageResource(value)
        }

    init {
        binding = CartItemBinding.inflate(LayoutInflater.from(context), this)
        initView(attrs, defStyleAttr)
    }

    private fun initView(attrs: AttributeSet?, defStyleAttr: Int) {
        val attrsRetrieve = intArrayOf(
            android.R.attr.layout_width,
            android.R.attr.layout_height
        ).apply { sort() }

        context.withStyledAttributes(attrs, attrsRetrieve, defStyleAttr) {
            layoutParams = LayoutParams(
                getInt(attrsRetrieve.indexOf(android.R.attr.layout_width), LayoutParams.WRAP_CONTENT),
                getInt(attrsRetrieve.indexOf(android.R.attr.layout_height), LayoutParams.WRAP_CONTENT),
            )
        }

        context.withStyledAttributes(attrs, R.styleable.CartItem, defStyleAttr) {
            itemType = CartItemType.values()[getInt(R.styleable.CartItem_cart_item_type, 0)]
            name = getString(R.styleable.CartItem_cart_item_name) ?: ""
            price = getFloat(R.styleable.CartItem_cart_item_price, 0F)

            if (itemType == CartItemType.ITEM) {
                caption = getString(R.styleable.CartItem_cart_item_caption) ?: ""
                imageRes = getResourceId(R.styleable.CartItem_cart_item_image, 0)
            } else {
                binding.image.visibility = GONE
                binding.caption.visibility = GONE
                binding.close.visibility = GONE
            }

            if (itemType == CartItemType.TOTAL)
                binding.name.setTextAppearance(R.style.MyLabel_Head)

        }
    }
}