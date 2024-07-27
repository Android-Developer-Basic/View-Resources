package otus.gpb.homework.viewandresources

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.contacts_button).setOnClickListener {
            startActivity(Intent(this, ContactsActivity::class.java))
        }

        findViewById<Button>(R.id.cart_button).setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }

        findViewById<Button>(R.id.signin_button).setOnClickListener {
            val contentView = LayoutInflater.from(this)
                .inflate(R.layout.dialog_signin, null, false)

            AlertDialog.Builder(this, R.style.Dialog).setView(contentView).show()
        }
    }
}