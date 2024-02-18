package otus.gpb.homework.viewandresources

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class MainXMLActivity : ActivityHelper() {

    private fun showContacts() {
        switchCurrentScreen(Screens.CONTACTS)
        startActivity(Intent(this, ContactsActivity::class.java))
    }

    private fun showCart() {
        switchCurrentScreen(Screens.CART)
        startActivity(Intent(this, CartActivity::class.java))
    }

    private fun showDialog() {
        switchCurrentScreen(Screens.DIALOG)
        val theme=when (currentTheme()) {
            Themes.LIGHT -> R.style.Theme_ThemeSwitcher_Dialogue_Light
            Themes.DARK -> R.style.Theme_ThemeSwitcher_Dialogue_Dark
            else -> {0}
        }
        MaterialAlertDialogBuilder(this,theme)
            .setView(R.layout.dialog_signin)
            .show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_xml)
        setSupportActionBar(findViewById(R.id.toolbar))

        val actionBar = supportActionBar
        requireNotNull(actionBar==null)
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar.setDisplayShowHomeEnabled(true)

        when (currentScreen()) {
            Screens.CONTACTS -> showContacts()
            Screens.CART -> showCart()
            Screens.DIALOG -> showDialog()
            else -> {}
        }
        findViewById<Button>(R.id.contacts_button).setOnClickListener {
            showContacts()
        }

        findViewById<Button>(R.id.cart_button).setOnClickListener {
            showCart()
        }

        findViewById<Button>(R.id.signin_button).setOnClickListener {
            showDialog()
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
}