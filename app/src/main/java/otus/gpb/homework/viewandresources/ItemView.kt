package otus.gpb.homework.viewandresources

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class ItemView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : ConstraintLayout(context, attrs) {


    private var image: Drawable?
    private var price: String?
    private var caption: String?
    private var name: String?
    private lateinit var nameView: TextView
    private lateinit var captionView: TextView
    private lateinit var priceView: TextView
    private lateinit var imageView: ImageView

    init {
        initViews()
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.ItemView)
        try {
            name = typedArray.getString(R.styleable.ItemView_name)
            caption = typedArray.getString(R.styleable.ItemView_caption)
            price = typedArray.getString(R.styleable.ItemView_price)
            image = typedArray.getDrawable(R.styleable.ItemView_image)
        } finally {
            typedArray.recycle() // так надо, тк переиспользуется между вьюхами
        }
    }

    private fun initViews() {
        inflate(context, R.layout.view_item, this)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        nameView = findViewById<TextView>(R.id.name)
        captionView = findViewById<TextView>(R.id.caption)
        priceView = findViewById<TextView>(R.id.price)
        imageView = findViewById<ImageView>(R.id.image)

        nameView.text = name
        captionView.text = caption
        priceView.text = price
        imageView.setImageDrawable(image)
    }
}