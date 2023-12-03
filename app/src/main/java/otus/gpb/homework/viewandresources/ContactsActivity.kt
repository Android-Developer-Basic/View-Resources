package otus.gpb.homework.viewandresources


import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import java.text.SimpleDateFormat

import java.util.Calendar
import java.util.Locale

class ContactsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        //actionbar
        val actionbar = supportActionBar!!
        actionbar.setHomeAsUpIndicator(R.drawable.top_back)
        actionbar.setDisplayHomeAsUpEnabled(true)

        // dropdown select
        val items = resources.getStringArray(R.array.select_list)
        val adapter = ArrayAdapter(this, R.layout.dropdown_select, items)
        val menuSelect = findViewById<AutoCompleteTextView>(R.id.autoCompleteSelect)
        menuSelect.setAdapter(adapter)

        // dropdown state
        val itemsState = arrayOf("MO", "LO", "--")
        val adapterState = ArrayAdapter(this, R.layout.dropdown_select, itemsState)
        val menuState = findViewById<AutoCompleteTextView>(R.id.autoCompleteState)
        menuState.setAdapter(adapterState)

        // birthday picker
        val pickDate = findViewById<TextInputEditText>(R.id.editTextBirthday)
        pickDate.setText(SimpleDateFormat("dd.MM.yyyy").format(System.currentTimeMillis()))
        var cal = Calendar.getInstance()
        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
            cal.set(Calendar.YEAR, year)
            cal.set(Calendar.MONTH, monthOfYear)
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val myFormat = "dd.MM.yyyy" // mention the format you need
            val sdf = SimpleDateFormat(myFormat, Locale.US)
            pickDate.setText(sdf.format(cal.time))
        }
        pickDate.setOnClickListener {
            DatePickerDialog(this@ContactsActivity, R.style.datepicker , dateSetListener,
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH))

                .show()
        }

        // button Register
        findViewById<Button>(R.id.buttonContactRegister)
            .setOnClickListener {
            finish()
        }
    }

    // actionbar кнопка назад
    override fun onSupportNavigateUp(): Boolean {
        //onBackPressed() // deprecate
        finish()
        return true
    }

    // actionbar кнопки справа (поиск и меню)
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_contacts, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // пункты в меню
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.menu_search -> Toast.makeText(this, "Search clicked", Toast.LENGTH_LONG).show()
            R.id.menu_item1 -> Toast.makeText(this, "First item clicked", Toast.LENGTH_LONG).show()
            R.id.menu_item2 -> Toast.makeText(this, "Second item clicked", Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }
}