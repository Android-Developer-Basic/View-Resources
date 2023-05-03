package otus.gpb.homework.viewandresources

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.*
import com.google.android.material.textfield.TextInputLayout

class ContactsActivity : AppCompatActivity() {
    private lateinit var connectionET: EditText
    private lateinit var connectionL: TextInputLayout
    private lateinit var typeConnectionSelectorView: AutoCompleteTextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)
        connectionET = findViewById(R.id.connectionET)
        connectionL = findViewById(R.id.connectionL)
        typeConnectionSelectorView = findViewById(R.id.selectorTV)
        typeConnectionSelectorView.setOnItemClickListener { parent, view, position, id ->

            when(position){
                0 -> {
                    connectionET.setText("")
                    connectionET.inputType = InputType.TYPE_CLASS_PHONE
                    connectionL.setEndIconDrawable(R.drawable.baseline_phone_24)
                    connectionL.hint = getString(R.string.phone_number)
                }
                1 -> {
                    connectionET.setText("")
                    connectionET.inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
                    connectionL.setEndIconDrawable(R.drawable.baseline_email_24)
                    connectionL.hint = getString(R.string.mail)
                }

            }
        }

    }
}