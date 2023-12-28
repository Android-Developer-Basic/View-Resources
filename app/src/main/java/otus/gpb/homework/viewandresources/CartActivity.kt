package otus.gpb.homework.viewandresources

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.cart_menu, menu)
        return true
    }
}