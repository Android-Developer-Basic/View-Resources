package otus.gpb.homework.viewandresources

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromJsonElement

@Serializable
data class CartItem (
    val title:String,
    val caption: String,
    val price: Double,
    val icon: String
)

@Serializable
data class CartList (
    val items: List<CartItem>
)

class CartListAdapter(private val dataSet: CartList) :
    RecyclerView.Adapter<CartListAdapter.ViewHolder>() {
    private val tag = "CartListAdapter"

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemTitle: TextView=view.findViewById(R.id.cart_item_title)
        val itemCaption: TextView=view.findViewById(R.id.cart_item_caption)
        val itemPrice: TextView=view.findViewById(R.id.cart_item_price)
        val itemIcon: ImageView=view.findViewById(R.id.cart_item_image)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cart_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemTitle.text = dataSet.items[position].title
        viewHolder.itemCaption.text = dataSet.items[position].caption
        viewHolder.itemPrice.text = "\$US, "+dataSet.items[position].price.toString()
        with (viewHolder.itemView.context) {
            val id=this.resources.getIdentifier(dataSet.items[position].icon.substringBeforeLast("."),"drawable", this.packageName)
            viewHolder.itemIcon.setImageResource(id)
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount()=dataSet.items.size

}


class CartActivity : ActivityHelper() {
    private lateinit var jsonCart:CartList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        setSupportActionBar(findViewById(R.id.toolbar))

        val actionBar = supportActionBar
        requireNotNull(actionBar==null)
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayUseLogoEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)

        jsonCart = try {
            Json.decodeFromString<CartList>(
                resources.openRawResource(R.raw.cart).bufferedReader().use{it.readText()}
            )
        } catch (e: Exception) {
            Toast.makeText(this,"Unable to read car list", Toast.LENGTH_SHORT).show()
            CartList(emptyList())
        }

        findViewById<TextView>(R.id.cart_count).text = resources.getQuantityString(R.plurals.cart_items_count,getNumberOfItems(),getNumberOfItems())
        findViewById<TextView>(R.id.cart_order_total_sum).text= String.format("%.2f",getTotal())
        findViewById<TextView>(R.id.cart_order_subtotal_sum).text= String.format("%.2f",getSubtotal())
        findViewById<TextView>(R.id.cart_order_tax_sum).text= String.format("%.2f",getTax())
        findViewById<TextView>(R.id.cart_order_shipping_sum).text= String.format("%.2f",getDeliveryPrice())

        findViewById<RecyclerView>(R.id.cart_list).adapter=CartListAdapter(jsonCart)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.cart, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.search -> Toast.makeText(this, "Search Clicked", Toast.LENGTH_SHORT).show()
            android.R.id.home -> finish()
            else -> Toast.makeText(this, "Else Clicked", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getNumberOfItems()=jsonCart.items.size

    private fun getSubtotal(): Double {
        var t=0.0
        jsonCart.items.forEach() {
            t+=it.price
        }
        return t
    }

    private fun getTaxRate()=10.3

    private fun getDeliveryPrice()=2.5

    private fun getTax()=(getSubtotal()*getTaxRate())/100

    private fun getTotal()=getSubtotal()+getTax()+getDeliveryPrice()
}