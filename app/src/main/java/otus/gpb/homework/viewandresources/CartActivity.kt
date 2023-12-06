package otus.gpb.homework.viewandresources


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        //actionbar
        val actionbar = supportActionBar!!
        actionbar.setHomeAsUpIndicator(R.drawable.top_back)
        actionbar.setDisplayHomeAsUpEnabled(true)

        // заполним корзину демо данными
        var itemsList = createTestData()

        val rvCarts = findViewById<RecyclerView>(R.id.rv_carts)
        rvCarts.layoutManager = LinearLayoutManager(this)
        rvCarts.setHasFixedSize(true)
        rvCarts.adapter = CartAdapter(itemsList) { cartItem: CartData, iView: View ->
            cartItemClicked( cartItem, iView )
        }

        // demo total
        findViewById<TextView>(R.id.cartTotalSum).text = "41.24"
        findViewById<TextView>(R.id.cartTotalSub).text = "36.00"
        findViewById<TextView>(R.id.cartTotalShip).text = "2.00"
        findViewById<TextView>(R.id.cartTotalTax).text = "3.50"

        findViewById<Button>(R.id.buttonCartPay).setOnClickListener {
            finish()
        }
    }

    // обработка кликов в строках корзины
    private fun cartItemClicked(cart: CartData, iView: View) {
        when(iView.id) {
            R.id.tv_cart_item_delete -> Toast.makeText(this, "DELETE: ${cart.itemName}", Toast.LENGTH_LONG).show()
            else -> Toast.makeText(this, "Clicked: ${cart.itemName}", Toast.LENGTH_LONG).show()
        }
    }

    private fun createTestData() : List<CartData> {
        var itemsList = ArrayList<CartData>()
        itemsList.add(CartData(1001, "Пироженное сет №1", "Самое вкусное пироженное1", 120.0, R.drawable.demo1))
        itemsList.add(CartData(1002, "Вкусный сет №2", "Самое вкусное пироженное2", 106.50, R.drawable.demo2))
        itemsList.add(CartData(1003, "Сладкий сет №3", "Самое вкусное пироженное3", 200.10, R.drawable.demo3))
        itemsList.add(CartData(1004, "Новый сет №4", "Самое вкусное пироженное4", 202.11, R.drawable.demo4))
        itemsList.add(CartData(1005, "Романтичный сет №5", "Самое вкусное пироженное5", 40.15, R.drawable.demo5))
        itemsList.add(CartData(1006, "Вечерний сет №6", "Самое вкусное пироженное6", 240.30, R.drawable.demo6))
        return itemsList
    }

    // actionbar кнопка назад
    override fun onSupportNavigateUp(): Boolean {
        //onBackPressed() // deprecate
        finish()
        return true
    }

    // actionbar кнопки справа
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_carts, menu)
        return super.onCreateOptionsMenu(menu)
    }

}

