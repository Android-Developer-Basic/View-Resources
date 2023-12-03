package otus.gpb.homework.viewandresources

import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
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
                .setPositiveButton(R.string.signin_button){ dialog,_ ->
                    dialog.cancel()
                }
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

        // center button SING IN
        val positive = dialog.getButton(AlertDialog.BUTTON_POSITIVE)
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        //  layoutParams.weight = 1f
        val metrics = resources.displayMetrics
        // dp convert to pixel
        val marginLR = (8 * (metrics.densityDpi.toFloat() / DisplayMetrics.DENSITY_DEFAULT)).toInt()
        layoutParams.leftMargin = marginLR
        layoutParams.rightMargin = marginLR
        layoutParams.bottomMargin = marginLR

        layoutParams.gravity = Gravity.CENTER
        positive.layoutParams = layoutParams

        return dialog
    }

}