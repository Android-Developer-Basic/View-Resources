package otus.gpb.homework.viewandresources

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText

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


        val builder = MaterialAlertDialogBuilder(this)
        val view = layoutInflater.inflate(R.layout.dialog_signin, null)
        builder.setView(view)
        val dialog = builder.create()

        view.findViewById<Button>(R.id.password_reset).setOnClickListener {
            view.findViewById<TextInputEditText>(R.id.password_field).setText("")
        }

        view.findViewById<Button>(R.id.cancel_btn).setOnClickListener {
            dialog.dismiss()
        }

        findViewById<Button>(R.id.signin_button).setOnClickListener {
            dialog.show()
        }

    }
}