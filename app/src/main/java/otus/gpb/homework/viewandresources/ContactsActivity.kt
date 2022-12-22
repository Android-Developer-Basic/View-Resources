package otus.gpb.homework.viewandresources

import android.app.AlertDialog
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import java.util.*


class ContactsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)
        findViewById<Button>(R.id.register).setOnClickListener()
        {
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)

            val customLayout = getLayoutInflater().inflate(R.layout.dialog_signin, null);
            builder.setView(customLayout)
            val dialog = builder.create()
            dialog.show()
        }
        findViewById<MaterialToolbar>(R.id.topAppBar).setNavigationOnClickListener()
        {
            this.finish()
        }
        val prefix = arrayOf("+7(905)", "+7(960)", "+7(917)")
        val states = arrayOf("Saratov", "Samara", "Volgograd")

        val adapter_prefix = ArrayAdapter<String>(
            this, android.R.layout.simple_dropdown_item_1line, prefix
        )

        val adapter_state = ArrayAdapter<String>(
            this, android.R.layout.simple_dropdown_item_1line, states
        )

        val autoCompleteTextView_prefix = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView_prefix)
        autoCompleteTextView_prefix.setAdapter(adapter_prefix)
        autoCompleteTextView_prefix.threshold = 2

        val autoCompleteTextView_state = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView_state)
        autoCompleteTextView_state.setAdapter(adapter_state)
        autoCompleteTextView_state.threshold = 2
    }
}