package otus.gpb.homework.viewandresources

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import otus.gpb.homework.viewandresources.databinding.CartItemBinding
import otus.gpb.homework.viewandresources.dto.Product

/**
 * Cвязывает данные [Product] с представлениями [CartViewHolder]
 * */
class CartAdapter(
    private val dataSet: MutableList<Product>,
    private val itemListener: ItemListener,
) : RecyclerView.Adapter<CartViewHolder>() {


    fun removeItem(index: Int) {
        dataSet.removeAt(index)
        notifyItemRemoved(index)
    }

    /**
     * [RecyclerView] вызывает этот метод всякий раз,
     * когда ему необходимо создать новый ViewHolder .
     * Метод создаёт и инициализирует ViewHolder и связанный с ним View ,
     * но не заполняет содержимое представления,
     * так как ViewHolder ещё не привязан к определённым данным.
     * */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val cartItemBinding: CartItemBinding =
            CartItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        return CartViewHolder(cartItemBinding, itemListener)
    }

    /**
     * [RecyclerView] вызывает этот метод, чтобы связать ViewHolder с данными.
     * Метод извлекает соответствующие данные и использует их для заполнения макета держателя представления.
     * Например, если RecyclerView отображает список имён,
     * метод может найти нужное имя в списке и заполнить виджет TextView держателя представления.
     * */
    override fun onBindViewHolder(holder: CartViewHolder, position: Int) =
        holder.bind(dataSet[position])

    override fun getItemCount() = dataSet.size


}

