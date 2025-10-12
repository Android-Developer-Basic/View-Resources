package otus.gpb.homework.viewandresources


import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.color.DynamicColors
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import otus.gpb.homework.viewandresources.databinding.ActivityContactsBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone


class ContactsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityContactsBinding
    private val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).apply {
        timeZone = TimeZone.getTimeZone("UTC")
    }
    private val dataPickerTitle by lazy { getString(R.string.data_picker_title) }
    private val phoneTypes by lazy { resources.getStringArray(R.array.phone_type) }

    override fun onCreate(savedInstanceState: Bundle?) {
        DynamicColors.applyToActivityIfAvailable(this)
        super.onCreate(savedInstanceState)
        binding = ActivityContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter: ArrayAdapter<String?> =
            ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, phoneTypes)


        with(binding) {
            textFieldPhoneType
                .editText
                ?.asClass<MaterialAutoCompleteTextView>()
                ?.setAdapter(adapter)

            val datePickerBuilder = MaterialDatePicker
                .Builder
                .datePicker()
                .setTitleText(dataPickerTitle)


            if (editData.text.toString().isNotEmpty()) {
                try {
                    dateFormat
                        .parse(editData.text.toString())
                        ?.let {
                            datePickerBuilder.setSelection(it.time)
                        }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            val datePicker = datePickerBuilder.build()
            editData.setOnFocusChangeListener { v, hasFocus ->
                if (hasFocus) {
                    datePicker.addOnPositiveButtonClickListener { selection: Long ->
                        editData.setText(dateFormat.format(Date(selection)))
                    }
                    datePicker.addOnNegativeButtonClickListener {
                        editData.clearFocus()
                    }
                    datePicker.addOnDismissListener {
                        editData.clearFocus()
                    }
                    datePicker.show(supportFragmentManager, "birthday_date")

                } else {
                    //
                }
            }


        }


    }
}

fun <T> Any.asClass(): T? = if (this as? T == null) null else this