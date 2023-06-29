package otus.gpb.homework.viewandresources.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModelProvider
import otus.gpb.homework.viewandresources.databinding.FragmentCartBinding
import otus.gpb.homework.viewandresources.view_model.MainViewModel


class Cart : Fragment() {
    private lateinit var binding: FragmentCartBinding
    private lateinit var mainVM:MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCartBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()
        mainVM = ViewModelProvider(activity)[MainViewModel::class.java]
        val onBackClick = object : OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                 mainVM.setAction(MainViewModel.OPEN_MAIN_FRAGMENT)
            }
        }
        activity.onBackPressedDispatcher.addCallback(viewLifecycleOwner, onBackClick)
    }

}