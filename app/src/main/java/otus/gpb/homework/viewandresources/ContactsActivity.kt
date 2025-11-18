package otus.gpb.homework.viewandresources

import android.icu.text.SimpleDateFormat
import android.icu.util.TimeZone
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputEditText
import java.util.Date
import java.util.Locale

class ContactsActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        findViewById<MaterialToolbar>(R.id.contacts_toolbar).setNavigationOnClickListener { finish() }

        val bookingDateEditText = findViewById<TextInputEditText>(R.id.booking_date_edit_text)


        val datePickerBuilder = MaterialDatePicker.Builder.datePicker()
        datePickerBuilder.setTitleText("Select Date")
        if (bookingDateEditText.text.toString().isNotEmpty()) {
            try {
                val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                dateFormat.timeZone = TimeZone.getTimeZone("UTC")
                val parsedDate = dateFormat.parse(bookingDateEditText.text.toString())
                parsedDate?.let {
                    datePickerBuilder.setSelection(it.time)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        val datePicker = datePickerBuilder.build()
        datePicker.addOnPositiveButtonClickListener { selection ->
            val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            dateFormat.timeZone = TimeZone.getTimeZone("UTC")
            val formattedDate = dateFormat.format(Date(selection))
            bookingDateEditText.setText(formattedDate)
        }
        datePicker.addOnNegativeButtonClickListener {
            bookingDateEditText.clearFocus()
        }
        datePicker.addOnDismissListener {
            bookingDateEditText.clearFocus()
        }

        bookingDateEditText.setOnClickListener {
            datePicker.show(supportFragmentManager, "date_picker_tag")
        }

    }
}