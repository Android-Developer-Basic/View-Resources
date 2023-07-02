package otus.gpb.homework.viewandresources

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import otus.gpb.homework.domain.models.CartItem

class CartAdapter:RecyclerView.Adapter<CartItemHolder>() {
    private val cartList = mutableListOf<CartItem>()
    private  var order = 0.0
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.cart_item, parent, false)
        return CartItemHolder(itemView)
    }

    override fun getItemCount(): Int {
        return cartList.size
    }

    override fun onBindViewHolder(holder: CartItemHolder, position: Int) {
        val item = cartList[position]
        holder.bind(item)
    }

    fun setCartList(list:List<CartItem>){
        cartList.clear()
        for(i in list.indices){
            cartList.add(list[i])
        }
        calculatePrice()
    }

    fun getOrder(callback:(Double)->Unit){
        callback.invoke(order)
    }


    private fun calculatePrice(){
        cartList.forEach {
            order += it.price
        }

    }
}