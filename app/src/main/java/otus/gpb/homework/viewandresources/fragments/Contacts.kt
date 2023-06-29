package otus.gpb.homework.viewandresources.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModelProvider
import otus.gpb.homework.viewandresources.databinding.FragmentContactsBinding
import otus.gpb.homework.viewandresources.view_model.MainViewModel


class Contacts : Fragment() {
    private lateinit var binding:FragmentContactsBinding
    private lateinit var vm:MainViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentContactsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()
        vm = ViewModelProvider(activity)[MainViewModel::class.java]
        val onBackClick = object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                vm.setAction(MainViewModel.OPEN_MAIN_FRAGMENT)
            }
        }
        activity.onBackPressedDispatcher.addCallback(viewLifecycleOwner, onBackClick)

    }


}