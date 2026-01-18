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

        val rv = findViewById<RecyclerView>(R.id.recyclerView)
        rv.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )
        rv.layoutManager = LinearLayoutManager(this)

        val itemsList = listOf(
            CartItem("SportsCar", "Avto", "car", R.drawable.ic_car_sports, "$500000.00"),
            CartItem("MotoBike", "Avto", "motorcycle", R.drawable.ic_motorbike, "$5000.00"),
            CartItem("Snowmobile", "Avto", "snowmobile", R.drawable.ic_snowmobile, "$10000.00"),
            CartItem("Bicycle", "Avto", "bicycle",R.drawable.ic_bicycle, "$300.00"),
            CartItem("Skateboard", "Avto", "skateboard",R.drawable.ic_skateboard, "$100.00"),
         )

        var amount = 0.0
        for(i in itemsList){
            amount +=i.price.drop(1).toFloat()
        }

        findViewById<TextView>(R.id.text).text = "${itemsList.count()}" + getString(R.string.count_items)
        findViewById<TextView>(R.id.textTaxAmount).text = String.format("$%d.%02d", (amount.toInt() / 100) , amount.toInt() % 100)
        findViewById<TextView>(R.id.textSubtotalAmount).text = "$%.02f".format(amount)

        findViewById<TextView>(R.id.textOrderTotalAmount).text = "$%.02f".format(
                    findViewById<TextView>(R.id.textTaxAmount).text.drop(1).toString().toFloat() +
                                 findViewById<TextView>(R.id.textSubtotalAmount).text.drop(1).toString().toFloat() +
                                    findViewById<TextView>(R.id.textShippingAmount).text.drop(1).toString().toFloat())

        rv.adapter = RecyclerViewItem(itemsList)
    }
}