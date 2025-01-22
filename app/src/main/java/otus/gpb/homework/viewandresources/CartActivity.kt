package otus.gpb.homework.viewandresources

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.button.MaterialButton

class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setTheme(R.style.Theme_MyTheme)             // это работает

        setContentView(R.layout.activity_cart)

        findViewById<MaterialButton>(R.id.btnClose).setOnClickListener {
            Toast.makeText(this, "btnClose", Toast.LENGTH_SHORT).show()
        }

        findViewById<MaterialButton>(R.id.buttonPlaceOrder).setOnClickListener {
            Toast.makeText(this, "buttonPlaceOrder", Toast.LENGTH_SHORT).show()
        }

        findViewById<MaterialToolbar>(R.id.topAppBar).setNavigationOnClickListener {
            finish()
        }


        val listView: ListView = findViewById(R.id.listItems)

        val items = ArrayList<ItemData?>()
        for(i in 1..4) {
            items.add(ItemData("Item $i", "Category", "Supporting line text lorem ipsum...", "$i$", R.drawable.ic_shape_outline))
        }

        val listAdapter = ListAdapter(this, items)
        listView.adapter = listAdapter
    }
}

class ItemData(
    var name: String,
    var category: String,
    var description: String,
    var price: String,
    var image: Int
)

class ListAdapter(context: Context, dataArrayList: ArrayList<ItemData?>?) :
    ArrayAdapter<ItemData?>(context, R.layout.list_item, dataArrayList!!) {

        override fun getView(position: Int, view: View?, parent: ViewGroup): View {
            var view = view
            val listData = getItem(position)
            if (view == null) {
                view = LayoutInflater.from(context).inflate(R.layout.layout_list_item, parent, false)
            }
            val listImage = view!!.findViewById<ImageView>(R.id.imageView)
            val listName = view.findViewById<TextView>(R.id.textViewName)
            val listCategory = view.findViewById<TextView>(R.id.textViewCategory)
            val listDescription = view.findViewById<TextView>(R.id.textViewDescription)
            val listPrice = view.findViewById<TextView>(R.id.textViewPrice)

            listImage.setImageResource(listData!!.image)
            listName.text = listData.name
            listCategory.text = listData.category
            listDescription.text = listData.description
            listPrice.text = listData.price

            return view
        }
}