package otus.gpb.homework.viewandresources

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.appbar.MaterialToolbar
import otus.gpb.homework.viewandresources.databinding.ActivityContactsBinding

lateinit var topAppBarContacts : MaterialToolbar
private lateinit var binding: ActivityContactsBinding

class ContactsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        topAppBarContacts = binding.topAppBarContacts

        topAppBarContacts.setNavigationOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        topAppBarContacts.setOnMenuItemClickListener { menuItem ->
            when(menuItem.itemId){
                R.id.search -> {
                    Toast.makeText(this,"Search action Clicked", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.more_contacts -> {
                    Toast.makeText(this,"More over flow menu Clicked", Toast.LENGTH_SHORT).show()
                    true
                }

                else -> {
                    false
                }
            }
        }
    }
}