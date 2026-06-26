package otus.gpb.homework.viewandresources

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        listOf(
            R.id.cart_item_1 to 1,
            R.id.cart_item_2 to 2,
            R.id.cart_item_3 to 3,
            R.id.cart_item_4 to 4,
        ).forEach { (itemId, number) ->
            findViewById<View>(itemId)
                .findViewById<TextView>(R.id.item_title)
                .text = getString(R.string.cart_item_title, number)
        }
    }
}
