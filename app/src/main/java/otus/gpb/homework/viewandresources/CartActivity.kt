package otus.gpb.homework.viewandresources

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

data class CartItem (
    val name:String,
    val caption: String,
    val price: Double,
    val icon: String
)

class CustomAdapter(private val dataSet: Array<String>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {
            // Define click listener for the ViewHolder's View
            textView = view.findViewById(R.id.textView)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.text_row_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textView.text = dataSet[position]
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}



class CartListAdapter(private val dataSet: Array<String>) :
    RecyclerView.Adapter<CartListAdapter.ViewHolder>() {
    private val tag = "CartListAdapter"

        init {
            Log.d(tag,"Init")
        }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {
            // Define click listener for the ViewHolder's View
            textView = view.findViewById(R.id.cart_item_caption)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.cart_item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.textView.text = dataSet[position]
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return 3
    }

}


class CartActivity : ActivityHelper() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

    //    setSupportActionBar(findViewById(R.id.toolbar))

        /*val actionBar = supportActionBar
        requireNotNull(actionBar==null)
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayUseLogoEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)

        findViewById<TextView>(R.id.cart_count).text = resources.getQuantityString(R.plurals.cart_items_count,getNumberOfItems(),getNumberOfItems())
        findViewById<TextView>(R.id.cart_order_total_sum).text= String.format("%.2f",getTotal())
        findViewById<TextView>(R.id.cart_order_subtotal_sum).text= String.format("%.2f",getSubtotal())
        findViewById<TextView>(R.id.cart_order_tax_sum).text= String.format("%.2f",getTax())
        findViewById<TextView>(R.id.cart_order_shipping_sum).text= String.format("%.2f",getDeliveryPrice())*/

        val dataset = arrayOf("January", "February", "March")
       // findViewById<RecyclerView>(R.id.cart_list).adapter=CartListAdapter(dataset)

/*        val customAdapter = CartListAdapter(dataset)

        val recyclerView: RecyclerView = findViewById(R.id.cart_list)
        recyclerView.adapter = customAdapter*/

        val customAdapter = CustomAdapter(dataset)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = customAdapter

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