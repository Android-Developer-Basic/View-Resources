package otus.gpb.homework.viewandresources.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import otus.gpb.homework.viewandresources.R
import otus.gpb.homework.viewandresources.fragments.Cart
import otus.gpb.homework.viewandresources.fragments.Contacts
import otus.gpb.homework.viewandresources.fragments.MainFragment
import otus.gpb.homework.viewandresources.view_model.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var vm:MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vm = ViewModelProvider(this)[MainViewModel::class.java]
        vm.data.observe(this){
            when(it){
                MainViewModel.OPEN_MAIN_FRAGMENT -> openMainFragment(MainFragment())
                MainViewModel.OPEN_CONTACTS -> openMainFragment(Contacts())
                MainViewModel.OPEN_CART -> openMainFragment(Cart())
            }
        }

    }

    private fun openMainFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.mainContainer, fragment)
            .commit()
    }
}