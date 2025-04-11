package otus.gpb.homework.viewandresources

import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import otus.gpb.homework.viewandresources.databinding.ActivityCartBinding


class CartActivity : AppCompatActivity() {

    private var orderTotal = 0.0
    private var subtotal = 0
    private var shipping = 25.0
    private var tax = 10.50
    private val listItem = mutableListOf<CartItem>()
    private val binding by lazy {
        ActivityCartBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setSupportActionBar(binding.myToolbar)
        getSupportActionBar()?.setDisplayHomeAsUpEnabled(true)
        getSupportActionBar()?.setDisplayShowHomeEnabled(true)
        binding.myToolbar.setNavigationOnClickListener() {
            val intent = MainActivity.newIntent(this)
            startActivity(intent)
        }
        createListCartItem()
        val adapter = ListAdapter()
        adapter.list = listItem
        binding.textViewCountItems.setText(String.format(
            this.resources.getString(R.string.count_items),
            adapter.list.size
        ))
        binding.recyclerViewCartList.adapter = adapter
        calculateSubtotal()
        calculateOrderTotal()
        setResults()
    }

    private fun calculateSubtotal(){
        var sum = 0
        for(cartItem in listItem){
            sum += cartItem.price
        }
        subtotal = sum
    }

    private fun calculateOrderTotal(){
        orderTotal = tax + shipping + subtotal
    }
    private fun setResults(){
        binding.textViewShipping.setText(shipping.toString())
        binding.textViewSubtotal.setText(subtotal.toString())
        binding.textViewOrderTotal.setText(orderTotal.toString())
        binding.textViewTax.setText(tax.toString())
    }

    private fun createListCartItem() {
        for(i in 1..4){
            val cartItem = CartItem(i, 35, CATEGORY, DESCRIPTION, IMAGE)
            listItem.add(cartItem)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_cart, menu)
        return true
    }

    companion object{
        private const val DESCRIPTION = "Supporting line text lorem ipsum..."
        private const val CATEGORY = "Category"
        private const val IMAGE = "drawable/food_steak"
    }
}