package com.bits.bee.bpmc.presentation.ui.nama_device

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentNamaDeviceBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.CustomDialogBuilder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by aldi on 21/03/22.
 */

const val TAG = "NamaDeviceFragment"

@AndroidEntryPoint
class NamaDeviceFragment constructor(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentNamaDeviceBinding = FragmentNamaDeviceBinding::inflate
) : BaseFragment<FragmentNamaDeviceBinding>() {

    private val viewModel : NamaDeviceViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            viewModel.onArgumentRecived(it.getString("username", ""), it.getString("password", ""))
        }
    }

    override fun initComponents() {
        binding.apply {

            requireActivity().onBackPressedDispatcher.addCallback(this@NamaDeviceFragment, object : OnBackPressedCallback(true){
                override fun handleOnBackPressed() {
                    val dialog = CustomDialogBuilder.Builder(requireContext())
                        .setTitle(getString(R.string.yakin_akan_keluar))
                        .setPositiveCallback {

                        }
                        .setMessage(getString(R.string.konfirmasi_keluar)).build()

                    dialog.show(parentFragmentManager, TAG)
                }
            })

            viewLifecycleOwner.lifecycleScope.launchWhenStarted {
                viewModel.event.collect { event ->
                    when(event){
                        is NamaDeviceViewModel.UIEvent.NavigateToPilihDb -> {
                            val action = NamaDeviceFragmentDirections.actionNamaDeviceFragmentToPilihDbFragment(event.username, event.password)
                            findNavController().navigate(action)
                        }
                    }
                }
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            btnLanjutkan.setOnClickListener {
                viewModel.onClickLanjutkan(requireContext())
            }
            etNamaDevice.addTextChangedListener {
                viewModel.onInputName(etNamaDevice.text.toString().trim())
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.state.collect {
                    if(it.deviceName.isNotEmpty()) {
                        binding.btnLanjutkan.isEnabled = true
                        binding.btnLanjutkan.background = ContextCompat.getDrawable(requireContext(), R.drawable.btn_rect_primary)
                    } else {
                        binding.btnLanjutkan.isEnabled = false
                        binding.btnLanjutkan.background = ContextCompat.getDrawable(requireContext(), R.drawable.btn_rect_disable)
                    }
                }
            }
        }
    }

}