package otus.gpb.homework.viewandresources

import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.FlowPreview

class MainComposerActivity : ActivityHelper() {

    private fun showContacts() {
    }

    private fun showCart() {
    }

    private fun showDialog() {
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ActivityButtons()
        }
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onRestart() {
        super.onRestart()
        switchCurrentScreen(Screens.NONE)
    }
    @Composable
    @Preview
    fun ActivityButtons( ) {
        Text("Hello world!")
    }
}



