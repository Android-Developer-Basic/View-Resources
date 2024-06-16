package otus.gpb.homework.viewandresources


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContentProviderCompat.requireContext


class ContactsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val items = resources.getStringArray(R.array.array_for_dropdown1)
        val adapter = ArrayAdapter(
            this,
            R.layout.list_popup_window_item, items
        )
        val autoComplete2 = findViewById<AutoCompleteTextView>(R.id.autoComplete2)
        autoComplete2.setAdapter(adapter)

        val items2 = resources.getStringArray(R.array.array_for_dropdown2)
        val adapter2 = ArrayAdapter(
            this,
            R.layout.list_popup_window_item, items2
        )
        val autoComplete3 = findViewById<AutoCompleteTextView>(R.id.autoComplete3)
        autoComplete3.setAdapter(adapter2)




//        val COUNTRIES = arrayOf(
//            "Belgium", "France", "Italy", "Germany", "Spain"
//        )
//        val adapter = ArrayAdapter(
//            this,
//            android.R.layout.simple_dropdown_item_1line, COUNTRIES
//        )
//        val textView = findViewById<AutoCompleteTextView>(R.id.autocomplete1)
//        textView.setAdapter(adapter)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return true


    }
}