package otus.gpb.homework.viewandresources

import android.os.Bundle
import android.view.Menu
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity

class ContactsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        val autoCompleteTextView: AutoCompleteTextView = findViewById(R.id.autoCompleteTextView)

        val phonesType = resources.getStringArray(R.array.phones)
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, phonesType)

        autoCompleteTextView.setAdapter(arrayAdapter)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.contacts_toolbar)

        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.menu_contacts, menu)
        return super.onCreateOptionsMenu(menu)
    }
}