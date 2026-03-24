package otus.gpb.homework.viewandresources

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val textCount = findViewById<TextView>(R.id.text)
        val textTax = findViewById<TextView>(R.id.textTaxAmount)
        val textSubtotal = findViewById<TextView>(R.id.textSubtotalAmount)
        val textShipping = findViewById<TextView>(R.id.textShippingAmount)
        val textTotal = findViewById<TextView>(R.id.textOrderTotalAmount)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )

        val itemsList = listOf(
            CartItem("SportsCar", "Auto", "car", R.drawable.ic_car_sports, "$500000.00"),
            CartItem("MotoBike", "Auto", "motorcycle", R.drawable.ic_motorbike, "$5000.00"),
            CartItem("Snowmobile", "Auto", "snowmobile", R.drawable.ic_snowmobile, "$10000.00"),
            CartItem("Bicycle", "Auto", "bicycle", R.drawable.ic_bicycle, "$300.00"),
            CartItem("Skateboard", "Auto", "skateboard", R.drawable.ic_skateboard, "$100.00"),
        )

        recyclerView.adapter = RecyclerViewItem(itemsList)

        var subtotal = 0.0
        for (item in itemsList) {
            subtotal += item.price.drop(1).toDouble()
        }

        val tax = subtotal * 0.01
        val shipping = textShipping.text.drop(1).toString().toDouble()
        val total = subtotal + tax + shipping

        textCount.text = "${itemsList.count()}" + getString(R.string.count_items)
        textSubtotal.text = "$%.2f".format(subtotal)
        textTax.text = "$%.2f".format(tax)
        textTotal.text = "$%.2f".format(total)
    }
}