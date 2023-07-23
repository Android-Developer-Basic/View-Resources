package otus.gpb.homework.viewandresources.fragments

import android.os.Bundle
import android.text.InputType
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.ViewModelProvider
import otus.gpb.homework.viewandresources.R
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
        setConnectionType()
        val onBackClick = object: OnBackPressedCallback(true){
            override fun handleOnBackPressed() {
                vm.setAction(MainViewModel.OPEN_MAIN_FRAGMENT)
            }
        }
        activity.onBackPressedDispatcher.addCallback(viewLifecycleOwner, onBackClick)

    }

    private fun setConnectionType() {
        binding.apply {
            selectorTV.setOnItemClickListener { _, _, pos, _ ->
                when (pos) {
                    0 ->{
                        connectionET.setText("")
                        connectionET.inputType = InputType.TYPE_CLASS_PHONE
                        connectionL.setEndIconDrawable(R.drawable.baseline_phone_24)
                        connectionL.hint = getString(R.string.phone_number)
                    }

                    1 ->{
                        connectionET.setText("")
                        connectionET.inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
                        connectionL.setEndIconDrawable(R.drawable.baseline_email_24)
                        connectionL.hint = getString(R.string.mail)
                    }

                    else -> return@setOnItemClickListener

                }

            }
        }
    }


}