package otus.gpb.homework.viewandresources

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import androidx.core.view.MenuProvider

class ContactsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = resources.getString(R.string.name_example)
        setSupportActionBar(toolbar)

        addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(
                menu: Menu,
                menuInflater: MenuInflater
            ) {
                menuInflater.inflate(R.menu.options_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                TODO("Not yet implemented")
            }
        })
    }
}