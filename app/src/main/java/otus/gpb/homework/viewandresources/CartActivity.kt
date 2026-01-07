package otus.gpb.homework.viewandresources

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class CartActivity : AppCompatActivity()/*, CartItemListener*/ {
    private lateinit var textCartItemCount :TextView
    private lateinit var textCartOrderTotalAmount :TextView
    private lateinit var textCartSubtotalAmount :TextView
    private lateinit var textCartShippingAmount :TextView
    private lateinit var textCartTaxAmount :TextView
    private lateinit var textCartOrderTotal :TextView
    private lateinit var textCartSubtotal :TextView
    private lateinit var textCartShipping :TextView
    private lateinit var textCartTax :TextView

    private lateinit var cartItemInc: View
    private lateinit var textCartName :TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        textCartOrderTotal = findViewById<TextView>(R.id.textCartOrderTotal)
        textCartSubtotal = findViewById<TextView>(R.id.textCartSubtotal)
        textCartShipping = findViewById<TextView>(R.id.textCartShipping)
        textCartTax = findViewById<TextView>(R.id.textCartTax)
        textCartItemCount = findViewById<TextView>(R.id.textCartItemCount)
        textCartOrderTotalAmount = findViewById<TextView>(R.id.textCartOrderTotalAmount)
        textCartSubtotalAmount = findViewById<TextView>(R.id.textCartSubtotalAmount)
        textCartShippingAmount = findViewById<TextView>(R.id.textCartShippingAmount)
        textCartTaxAmount = findViewById<TextView>(R.id.textCartTaxAmount)

        cartItemInc = findViewById<View>(R.id.сart_item_inc_1)
        textCartName = cartItemInc.findViewById<TextView>(R.id.cart_item_caption)
        textCartName.text = getString(R.string.cart_item_name_1)

        cartItemInc = findViewById<View>(R.id.сart_item_inc_2)
        textCartName = cartItemInc.findViewById<TextView>(R.id.cart_item_caption)
        textCartName.text = getString(R.string.cart_item_name_2)

        cartItemInc = findViewById<View>(R.id.сart_item_inc_3)
        textCartName = cartItemInc.findViewById<TextView>(R.id.cart_item_caption)
        textCartName.text = getString(R.string.cart_item_name_3)

        cartItemInc = findViewById<View>(R.id.сart_item_inc_4)
        textCartName = cartItemInc.findViewById<TextView>(R.id.cart_item_caption)
        textCartName.text = getString(R.string.cart_item_name_4)

        textCartOrderTotal.text = getString(R.string.order_total)
        textCartSubtotal.text = getString(R.string.subtotal)
        textCartShipping.text = getString(R.string.shipping)
        textCartTax.text = getString(R.string.tax)
    }
}