package otus.gpb.homework.viewandresources

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ContactsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)
        val appBar = findViewById<com.google.android.material.appbar.MaterialToolbar>(R.id.topAppBar)
        appBar.setNavigationOnClickListener {
            this.finish()
        }
    }
}