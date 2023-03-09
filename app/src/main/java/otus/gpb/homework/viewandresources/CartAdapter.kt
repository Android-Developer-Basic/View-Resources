package otus.gpb.homework.viewandresources

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class CartAdapter(private val context: Activity,private val arrayList : ArrayList<CartItem>) : ArrayAdapter<CartItem>(context,
    R.layout.cart_item,arrayList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater : LayoutInflater = LayoutInflater.from(context)
        val view : View = inflater.inflate(R.layout.cart_item,null)

        val productImage : ImageView = view.findViewById(R.id.image)
        val nameProduct : TextView = view.findViewById(R.id.name)
        val sectionProduct : TextView = view.findViewById(R.id.section)
        val costProduct : TextView = view.findViewById(R.id.cost)
        val deleteImage : ImageView = view.findViewById(R.id.delete)

        productImage.setImageResource(arrayList[position].productImage)
        nameProduct.text = arrayList[position].productName
        sectionProduct.text = arrayList[position].productSection
        costProduct.text = arrayList[position].productPrice
        deleteImage.setImageResource(arrayList[position].deleteImage)

        return view
    }
}