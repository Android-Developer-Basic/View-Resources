package otus.gpb.homework.viewandresources

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ContactsActivity : AppCompatActivity() {
    private val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        val contactTypes = resources.getStringArray(R.array.contact_type_options)
        findViewById<MaterialAutoCompleteTextView>(R.id.contact_type_dropdown).apply {
            setAdapter(
                ArrayAdapter(
                    this@ContactsActivity,
                    android.R.layout.simple_list_item_1,
                    contactTypes,
                ),
            )
            setText(getString(R.string.contact_type), false)
            setOnClickListener { showDropDown() }
        }

        val dateInput = findViewById<TextInputEditText>(R.id.date_input)
        val dateLayout = findViewById<TextInputLayout>(R.id.date_layout)
        val showDatePicker = {
            val picker = MaterialDatePicker.Builder.datePicker()
                .setTitleText(getString(R.string.field_date))
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build()

            picker.addOnPositiveButtonClickListener { selection ->
                dateInput.setText(dateFormat.format(Date(selection)))
            }
            picker.show(supportFragmentManager, "contact_date_picker")
        }

        dateInput.setOnClickListener { showDatePicker() }
        dateLayout.setEndIconOnClickListener { showDatePicker() }
    }
}
