package otus.gpb.homework.viewandresources

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import androidx.appcompat.app.AlertDialog
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private val login_Dialog by lazy { createMaterialDialog() }

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
            login_Dialog.show()
        }
    }

    private fun createMaterialDialog(): AlertDialog {
        val builder = MaterialAlertDialogBuilder(this)
        val view = layoutInflater.inflate(R.layout.dialog_signin, null)
        builder.setView(view)
        val dialog = builder.create()

        view.findViewById<Button>(R.id.button_reset).setOnClickListener {
            view.findViewById<TextInputEditText>(R.id.password_field).setText("")
        }
        view.findViewById<MaterialButton>(R.id.button_login).setOnClickListener{
            Toast.makeText(this, "Login!!!", Toast.LENGTH_SHORT).show()
            login_Dialog.dismiss()
        }
        view.findViewById<MaterialButton>(R.id.button_cancel).setOnClickListener{
            Toast.makeText(this, "Cancel!!!", Toast.LENGTH_SHORT).show()
            login_Dialog.dismiss()
        }

        return dialog
    }
}