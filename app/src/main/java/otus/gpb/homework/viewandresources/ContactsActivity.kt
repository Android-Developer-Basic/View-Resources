package otus.gpb.homework.viewandresources

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity


class ContactsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.contacts_menu, menu)
        return true
    }
}