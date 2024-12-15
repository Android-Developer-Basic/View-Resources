package otus.gpb.homework.viewandresources

import android.net.Uri
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class ContactsActivity : AppCompatActivity() {
    // Define the ActivityResultLauncher
    private lateinit var filePickerLauncher: ActivityResultLauncher<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        // Set click listener for the back button
        findViewById<ImageButton>(R.id.btn_back).setOnClickListener({
            // Handle back button click
            onBackPressedDispatcher.onBackPressed() // Example action
        })

        // Set click listener for the attach file icon
        findViewById<ImageButton>(R.id.btn_attach).setOnClickListener({
            // Handle attach file click
            openFilePicker() // Example action
        })

        // Set click listener for the save button
        findViewById<com.google.android.material.button.MaterialButton>(R.id.save_button).setOnClickListener({
            finish() // Example action
        })

        // Initialize the ActivityResultLauncher
        filePickerLauncher =
            registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
                if (uri != null) {
                    handleFileSelection(uri)
                } else {
                    Toast.makeText(this, "No file selected", Toast.LENGTH_SHORT).show()
                }
            }
    }


    private fun openFilePicker() {
        filePickerLauncher.launch("*/*")
    }

    // Handle the selected file URI
    private fun handleFileSelection(uri: Uri) {
        Toast.makeText(this, "File selected: $uri", Toast.LENGTH_SHORT).show()
        // Implement your logic to use the selected file
    }
}