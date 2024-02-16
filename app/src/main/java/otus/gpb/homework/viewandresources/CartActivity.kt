package otus.gpb.homework.viewandresources

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import java.net.URI
import kotlin.math.floor

data class CartItem (
    val name:String,
    val caption: String,
    val price: Double,
    val icon: String
)


class CartActivity : ActivityHelper() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        setSupportActionBar(findViewById(R.id.toolbar))

        val actionBar = supportActionBar
        requireNotNull(actionBar==null)
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayUseLogoEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)

        findViewById<TextView>(R.id.cart_count).text = resources.getQuantityString(R.plurals.cart_items_count,getNumberOfItems(),getNumberOfItems())
        findViewById<TextView>(R.id.cart_order_total_sum).text= String.format("%.2f",getTotal())
        findViewById<TextView>(R.id.cart_order_subtotal_sum).text= String.format("%.2f",getSubtotal())
        findViewById<TextView>(R.id.cart_order_tax_sum).text= String.format("%.2f",getTax())
        findViewById<TextView>(R.id.cart_order_shipping_sum).text= String.format("%.2f",getDeliveryPrice())

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.cart, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // methods to control the operations that will
    // happen when user clicks on the action buttons
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.search -> Toast.makeText(this, "Search Clicked", Toast.LENGTH_SHORT).show()
            android.R.id.home -> finish()
            else -> Toast.makeText(this, "Else Clicked", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getNumberOfItems()=4

    private fun getSubtotal()=36.0

    private fun getTaxRate()=10.3

    private fun getDeliveryPrice()=2.5

    private fun getTax()=(getSubtotal()*getTaxRate())/100

    private fun getTotal()=getSubtotal()+getTax()+getDeliveryPrice()
}