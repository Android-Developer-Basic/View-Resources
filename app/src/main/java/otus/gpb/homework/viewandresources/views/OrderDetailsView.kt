package otus.gpb.homework.viewandresources.views

import android.content.Context
import android.graphics.Color.red
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import otus.gpb.homework.viewandresources.R

class OrderDetailsView
@JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
): ConstraintLayout(context, attributeSet) {
    private lateinit var picture: ImageView
    private lateinit var title: TextView
    private lateinit var price: TextView
    private lateinit var icon: ImageView

    init {
        inflate(context, R.layout.order_details_view, this)
        init()

        val typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.OrderDetailsView)
        val pictureResource = typedArray.getDrawable(R.styleable.OrderDetailsView_picture)
        val titleTxt = typedArray.getString(R.styleable.OrderDetailsView_title)
        val priceTxt = typedArray.getString(R.styleable.OrderDetailsView_price)
        val iconColor = typedArray.getResourceId(R.styleable.OrderDetailsView_iconColor, R.color.red)

        picture.setImageDrawable(pictureResource)
        title.text = titleTxt
        price.text = priceTxt
        icon.setColorFilter(ContextCompat.getColor(context, iconColor))

        typedArray.recycle()
    }

    private fun init() {
        picture = findViewById(R.id.img)
        title = findViewById(R.id.title)
        price = findViewById(R.id.price)
        icon = findViewById(R.id.iconButton)
    }
}