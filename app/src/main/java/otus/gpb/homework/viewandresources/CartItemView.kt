package otus.gpb.homework.viewandresources

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.withStyledAttributes

class CartItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private var cost = 0f
    private var description = ""
    private var imgsrc = -1

    init {
        inflate(context, R.layout.cart_item, this)
        context.withStyledAttributes(attrs, R.styleable.CartItem) {
            description = this.getString(R.styleable.CartItem_name).toString()
            cost = this.getFloat(R.styleable.CartItem_cost, 0f)
            imgsrc = this.getResourceId(R.styleable.CartItem_img_src, -1)
        }
    }

    override fun onFinishInflate() {
        super.onFinishInflate()

        findViewById<ImageView>(R.id.id_item_img).apply {
            if (imgsrc != -1) this.setImageDrawable(AppCompatResources.getDrawable(context, imgsrc))
        }

        findViewById<TextView>(R.id.id_item_name).apply {
            text = if (description == "") "<No item name>" else description.replace("{ampersand}", "&")
        }

        findViewById<TextView>(R.id.id_item_cost).apply {
            text = "\$US, " + "%.2f".format(cost).replace(",", ".")
        }

    }

}
