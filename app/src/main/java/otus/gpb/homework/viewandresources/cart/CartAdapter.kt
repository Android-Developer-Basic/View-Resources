package otus.gpb.homework.viewandresources.cart
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import otus.gpb.homework.viewandresources.databinding.ItemCartBinding
import otus.gpb.homework.viewandresources.model.CartItem

data class CartItem(
    val title: String,
    val category: String,
    val subtitle: String,
    val price: String,
    val imageResId: Int
)

class CartAdapter(
    private val items: List<CartItem>
) : RecyclerView.Adapter<CartAdapter.VH>() {

    class VH(val binding: ItemCartBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemCartBinding.inflate(inflater, parent, false)
        return VH(binding)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = items[position]
        with(holder.binding) {
            cartTitle.text = item.title
            cartCategory.text = item.category
            cartSubtitle.text = item.subtitle
            cartPrice.text = item.price
            cartImage.setImageResource(item.imageResId)
        }
    }

    override fun getItemCount(): Int = items.size
}
