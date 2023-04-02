package otus.gpb.homework.viewandresources

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.appbar.MaterialToolbar

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        findViewById<MaterialToolbar>(R.id.id_cart_mtoolbar).apply {
            setNavigationOnClickListener { finish() }
        }

    }
}