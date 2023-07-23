package otus.gpb.homework.viewandresources.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import otus.gpb.homework.viewandresources.CartAdapter
import otus.gpb.homework.viewandresources.R
import otus.gpb.homework.viewandresources.databinding.FragmentCartBinding
import otus.gpb.homework.viewandresources.view_model.CartViewModel
import otus.gpb.homework.viewandresources.view_model.MainViewModel


class Cart : Fragment() {
    private lateinit var binding: FragmentCartBinding
    private lateinit var mainVM:MainViewModel
    private lateinit var vm:CartViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCartBinding.inflate(inflater)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()
        vm = ViewModelProvider(this)[CartViewModel::class.java]
        binding.cartProgressBar.isVisible = true
        val cartAdapter = CartAdapter()
        binding.cartRV.adapter = cartAdapter
        vm.data.observe(viewLifecycleOwner){
            if(it.isEmpty()) Toast.makeText(requireContext(), "Check your internet connection!", Toast.LENGTH_LONG).show()
            Log.d("GetResInCartFrag", it.toString())
            cartAdapter.setCartList(it)
            val str = resources.getString(R.string.items_count_text)
            binding.apply {
                itemsCountTV.text = "${it.size} $str"

            }
            cartAdapter.getOrder {order-> calculateTotalOrder(order) }
            cartAdapter.notifyDataSetChanged()
        }



        mainVM = ViewModelProvider(activity)[MainViewModel::class.java]
        val onBackClick = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                 mainVM.setAction(MainViewModel.OPEN_MAIN_FRAGMENT)
            }
        }
        activity.onBackPressedDispatcher.addCallback(viewLifecycleOwner, onBackClick)
    }

    private fun calculateTotalOrder(price:Double){
        val tax = price * NDS
        val total = tax + price + SHIPPING

        binding.apply {
            totalPriceTV.text = String.format("%.2f", total)
            subtotalTV.text = String.format("%.2f", price)
            shippingTV.text = String.format("%.2f", SHIPPING)
            taxTV.text = String.format("%.2f", tax)
            cartProgressBar.isVisible = false
        }
    }

    companion object{
        const val NDS = 0.12
        const val SHIPPING = 2.0
    }



}