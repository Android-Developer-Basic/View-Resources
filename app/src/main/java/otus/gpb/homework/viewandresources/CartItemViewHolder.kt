package otus.gpb.homework.viewandresources

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class CartItemViewHolder(view: View): ViewHolder(view){

    val textViewCategory = view.findViewById<TextView>(R.id.textViewCategory)
    val textViewDescription = view.findViewById<TextView>(R.id.textViewDescription)
    val textViewPrice = view.findViewById<TextView>(R.id.textViewPrice)
    val textViewNumber = view.findViewById<TextView>(R.id.textViewNumber)
    val imageView = view.findViewById<ImageView>(R.id.imageView)
}