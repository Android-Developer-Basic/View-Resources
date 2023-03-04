package otus.gpb.homework.viewandresources

import android.graphics.drawable.Icon
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.core.graphics.drawable.IconCompat

class ContactsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        findViewById<Toolbar>(R.id.toolBar).setNavigationOnClickListener {
            finish()
        }
    }
}