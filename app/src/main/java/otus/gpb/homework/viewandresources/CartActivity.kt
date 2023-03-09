package otus.gpb.homework.viewandresources

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.MaterialToolbar
import otus.gpb.homework.viewandresources.databinding.ActivityCartBinding
import otus.gpb.homework.viewandresources.databinding.ActivityContactsBinding

class CartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCartBinding
    private lateinit var cartArrayList : ArrayList<CartItem>
    lateinit var topAppBarCart : MaterialToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        topAppBarCart = binding.topAppBarCart

        topAppBarCart.setNavigationOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        topAppBarCart.setOnMenuItemClickListener { menuItem ->
            when(menuItem.itemId){
                R.id.loyalty -> {
                    Toast.makeText(this,"Loyalty action Clicked", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.more_cart -> {
                    Toast.makeText(this,"More over flow menu Clicked", Toast.LENGTH_SHORT).show()
                    true
                }

                else -> {
                    false
                }
            }
        }


        val imageId = intArrayOf(
            R.drawable.fen,
            R.drawable.miband,
            R.drawable.robot,
            R.drawable.clock
        )

        val nameProduct = arrayOf (
            "Dyson",
            "Mi Band",
            "Robot UI",
            "Michael Kors"
        )

        val sectionProduct = arrayOf(
            "фены и сушильные машины",
            "электроника",
            "игрушки для детей",
            "наручные часы"
        )

        val costProduct = arrayOf(
            "$-US,1.50",
            "$-US,4.50",
            "$-US,8.00",
            "$-US,22.00"
        )

        val deleteImage = arrayOf(
            R.drawable.ic_baseline_delete_24,
            R.drawable.ic_baseline_delete_24,
            R.drawable.ic_baseline_delete_24,
            R.drawable.ic_baseline_delete_24
        )

        cartArrayList = ArrayList()

        for (i in nameProduct.indices){

            val product = CartItem(
                productName = nameProduct[i],
                productSection = sectionProduct[i],
                productPrice = costProduct[i],
                productImage = imageId[i],
                deleteImage = deleteImage[i]
            )
            cartArrayList.add(product)
        }

        binding.listview.adapter = CartAdapter(this,cartArrayList)
    }
}