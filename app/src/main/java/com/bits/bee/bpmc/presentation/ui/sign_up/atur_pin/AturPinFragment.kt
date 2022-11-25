package com.bits.bee.bpmc.presentation.ui.sign_up.atur_pin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentAturPinBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.LoadingDialogHelper
import com.bits.bee.bpmc.presentation.dialog.NoInternetDialogBuilder
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AturPinFragment constructor(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentAturPinBinding = FragmentAturPinBinding::inflate
): BaseFragment<FragmentAturPinBinding>() {

    private val viewModel : AturPinViewModel by viewModels()


    private lateinit var dialog: LoadingDialogHelper

    override fun initComponents() {
        dialog = LoadingDialogHelper(requireActivity())
        BeePreferenceManager.saveToPreferences(requireActivity(), getString(R.string.pref_last_page), getString(R.string.page_atur_pin))
        binding.apply {

        }
    }

    override fun subscribeListeners() {
        binding.apply {
            pinView.addTextChangedListener {
                viewModel.onPinInput(pinView.text.toString().trim())
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    it?.let {

                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.event.collect {
                when(it){
                    is AturPinViewModel.UIEvent.NavigateToUlangPin -> {
                        val action = AturPinFragmentDirections.actionAturPinFragmentToUlangiPinFragment(it.pin)
                        findNavController().navigate(action)
                    }
                }
            }
        }
    }
}