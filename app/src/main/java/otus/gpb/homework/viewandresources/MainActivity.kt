package otus.gpb.homework.viewandresources

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.dialog.MaterialDialogs
import com.google.android.material.textview.MaterialTextView
import otus.gpb.homework.viewandresources.databinding.ActivityContactsBinding
import otus.gpb.homework.viewandresources.databinding.DialogSigninBinding

private lateinit var binding: DialogSigninBinding
lateinit var buttonSignIn : Button
lateinit var registerAction : Button
lateinit var resetPasswordAction : Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.getDefaultNightMode())

        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.contacts_button).setOnClickListener {
            startActivity(Intent(this, ContactsActivity::class.java))
        }

        findViewById<Button>(R.id.cart_button).setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }

        findViewById<Button>(R.id.signin_button).setOnClickListener {
            MaterialAlertDialogBuilder(this)
                .setView(R.layout.dialog_signin)
                .show()

            binding = DialogSigninBinding.inflate(layoutInflater)

            buttonSignIn = binding.buttonSignIn
            registerAction = binding.registerAction
            resetPasswordAction = binding.resetPassword

            buttonSignIn.setOnClickListener {
                Toast.makeText(this,"SignIn button Clicked", Toast.LENGTH_SHORT).show()
            }

            registerAction.setOnClickListener {
                Toast.makeText(this,"Register action Clicked", Toast.LENGTH_SHORT).show()
            }

            resetPasswordAction.setOnClickListener {
                Toast.makeText(this,"Reset action Clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }
}