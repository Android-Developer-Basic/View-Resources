package otus.gpb.homework.viewandresources

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import otus.gpb.homework.viewandresources.databinding.ActivityContactsBinding

class ContactsActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityContactsBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.backBtn.setOnClickListener {
            finish()
        }
    }
}