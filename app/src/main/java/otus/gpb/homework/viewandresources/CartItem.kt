package otus.gpb.homework.viewandresources

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class CartItem @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {
    private val imageView: ImageView
    private val titleView: TextView
    private val captionView: TextView
    private val priceView: TextView

    var image: Drawable? = null
        set(value) {
            field = value
            imageView.setImageDrawable(value)
        }
    var title: String = ""
        set(value) {
            field = value
            titleView.text = value
        }
    var caption: String = ""
        set(value) {
            field = value
            captionView.text = value
        }
    var price: String = ""
        set(value) {
            field = value
            priceView.text = value
        }


    init {
        inflate(context, R.layout.cart_item, this)

        imageView = findViewById(R.id.image)
        titleView = findViewById(R.id.title)
        captionView = findViewById(R.id.caption)
        priceView = findViewById(R.id.price)

        val a = context.obtainStyledAttributes(
            attrs, R.styleable.CartItem, defStyleAttr, defStyleRes
        )

        image = a.getDrawable(
            R.styleable.CartItem_image
        )
        title = a.getString(
            R.styleable.CartItem_title
        ) ?: ""
        caption = a.getString(
            R.styleable.CartItem_caption
        ) ?: ""
        price = a.getString(
            R.styleable.CartItem_price
        ) ?: ""

        a.recycle()
    }
}