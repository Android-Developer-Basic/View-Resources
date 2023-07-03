package otus.gpb.homework.viewandresources.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import otus.gpb.homework.viewandresources.RegisterDialog
import otus.gpb.homework.viewandresources.databinding.FragmentMainBinding
import otus.gpb.homework.viewandresources.view_model.MainViewModel


class MainFragment : Fragment() {
    private lateinit var vm: MainViewModel
    private lateinit var binding: FragmentMainBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        binding.apply {
            contactsButton.setOnClickListener { vm.setAction(MainViewModel.OPEN_CONTACTS) }
            cartButton.setOnClickListener {
                vm.setAction(MainViewModel.OPEN_CART)
            }
            signinButton.setOnClickListener {
                RegisterDialog(requireContext()).show()
            }
        }

    }

}