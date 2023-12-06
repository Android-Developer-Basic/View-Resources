package otus.gpb.homework.viewandresources

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputLayout

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
            MaterialAlertDialogBuilder(this)
                .showSigninForm(R.layout.dialog_signin)
        }
    }


    fun MaterialAlertDialogBuilder.showSigninForm(
        layoutForm: Int
        ): Dialog {
        this.setView(layoutForm)
        val dialog = this.show()
        val tilEmail = dialog.findViewById<TextInputLayout>(R.id.dialog_signin_email_layout)
        tilEmail?.let {
            tilEmail.hint = context.getString(R.string.signin_email_field)
        }

        val registerBtn = dialog.findViewById<Button>(R.id.btn_signin_register)
        registerBtn?.setOnClickListener{
            Toast.makeText(dialog.context, "Register OK", Toast.LENGTH_LONG).show()
        }

        val resetBtn = dialog.findViewById<Button>(R.id.btn_reset)
        resetBtn?.setOnClickListener{
            Toast.makeText(dialog.context, "Reset OK", Toast.LENGTH_LONG).show()
        }

        val signinBtn = dialog.findViewById<Button>(R.id.btn_signin)
        signinBtn?.setOnClickListener{
            dialog.cancel()
        }

        // размер окна
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val displayWidth = displayMetrics.widthPixels
        //val displayHeight = displayMetrics.heightPixels
        val layoutParams = WindowManager.LayoutParams()
        layoutParams.copyFrom(dialog?.window?.attributes)
        val dialogWindowWidth = (displayWidth * 0.8f).toInt()
        //val dialogWindowHeight = (displayHeight * 0.8f).toInt()
        layoutParams.width = dialogWindowWidth
        //layoutParams.height = dialogWindowHeight
        dialog?.window?.attributes = layoutParams

        return dialog
    }

}