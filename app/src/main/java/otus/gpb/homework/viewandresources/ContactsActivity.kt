package otus.gpb.homework.viewandresources

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.google.android.material.appbar.MaterialToolbar

class ContactsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        findViewById<MaterialToolbar>(R.id.id_contacts_mtoolbar).apply {
            setNavigationOnClickListener { finish() }
        }

        val pt = ArrayAdapter.createFromResource(this, android.R.array.phoneTypes, R.layout.my_spinner)
        findViewById<Spinner>(R.id.id_phone_type).apply {
            adapter = pt
        }

        val st = ArrayAdapter.createFromResource(this, R.array.States, R.layout.my_spinner)
        findViewById<Spinner>(R.id.id_state).apply {
            adapter = st
        }
        /*
        val pt = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, resources.getStringArray(android.R.array.phoneTypes))
        findViewById<AutoCompleteTextView>(R.id.autoCompletePhoneType).apply {
            setAdapter(pt)
        }
         */

    }
}