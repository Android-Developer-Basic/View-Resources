package otus.gpb.homework.viewandresources
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.constraintlayout.widget.ConstraintLayout

class ContactsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        val root = findViewById<ConstraintLayout>(R.id.rootLayout)

        val startPadding = resources.getDimensionPixelSize(
            R.dimen.contact_screen_padding_start
        )
        val endPadding = resources.getDimensionPixelSize(
            R.dimen.contact_screen_padding_end
        )

        ViewCompat.setOnApplyWindowInsetsListener(root) { view, insets ->
            val statusInsets = insets.getInsets(WindowInsetsCompat.Type.statusBars())

            view.setPaddingRelative(
                startPadding, statusInsets.top, endPadding, view.paddingBottom
            )

            WindowInsetsCompat.CONSUMED
        }

        ViewCompat.requestApplyInsets(root)
    }
}
