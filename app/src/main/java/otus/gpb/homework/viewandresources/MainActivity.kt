package otus.gpb.homework.viewandresources

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlin.math.min

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
            val dialog = MaterialAlertDialogBuilder(this)
                .setView(R.layout.dialog_signin)
                .show()
            dialog.window?.apply {
                setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                val horizontalInset = (48 * resources.displayMetrics.density).toInt()
                val dialogWidth = min(
                    resources.getDimensionPixelSize(R.dimen.signin_dialog_width),
                    resources.displayMetrics.widthPixels - horizontalInset,
                )
                setLayout(dialogWidth, ViewGroup.LayoutParams.WRAP_CONTENT)
            }
            dialog.findViewById<TextView>(R.id.reset_password)?.setOnClickListener {
                Toast.makeText(this, R.string.reset_password_clicked, Toast.LENGTH_SHORT).show()
            }
            dialog.findViewById<Button>(R.id.login_button)?.setOnClickListener {
                Toast.makeText(this, R.string.login_clicked, Toast.LENGTH_SHORT).show()
            }
            dialog.findViewById<Button>(R.id.cancel_button)?.setOnClickListener {
                dialog.dismiss()
            }
        }
    }
}
