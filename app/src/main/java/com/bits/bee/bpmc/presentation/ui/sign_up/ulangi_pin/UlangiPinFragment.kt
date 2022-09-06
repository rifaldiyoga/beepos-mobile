package com.bits.bee.bpmc.presentation.ui.sign_up.ulangi_pin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.databinding.FragmentUlangiPinBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class UlangiPinFragment constructor(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentUlangiPinBinding = FragmentUlangiPinBinding::inflate
): BaseFragment<FragmentUlangiPinBinding>() {

    private val viewModel : UlangiPinViewModel by viewModels()

    override fun initComponents() {
        binding.apply {
            arguments?.let {
                val pin = it.getString("pin")
                viewModel.state.pinBefore = pin ?: ""
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            pinView.addTextChangedListener {
                viewModel.onPinInput(pinView.text.toString().trim())
            }
            btnSimpanPin.setOnClickListener {

            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {

                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect {
                    when(it){
                        UlangiPinViewModel.UIEvent.NavigateToAturProduk -> {
                            val action = UlangiPinFragmentDirections.actionUlangiPinFragmentToModeTampilanFragment(type = "signup")
                            findNavController().navigate(action)
                        }
                        UlangiPinViewModel.UIEvent.PinNotSame -> {
                            binding.pinView.text!!.clear()
                            showSnackbar("Pin yang anda masukkan tidak sama!")
                        }
                    }
                }
            }
        }
    }
}