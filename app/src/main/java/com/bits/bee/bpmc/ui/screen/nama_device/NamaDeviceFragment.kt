package com.bits.bee.bpmc.ui.screen.nama_device

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentNamaDeviceBinding
import com.bits.bee.bpmc.ui.base.BaseFragment
import com.bits.bee.bpmc.ui.dialog.CustomDialogBuilder
import com.bits.bee.bpmc.utils.PreferenceUtils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

/**
 * Created by aldi on 21/03/22.
 */

const val TAG = "NamaDeviceFragment"

@AndroidEntryPoint
class NamaDeviceFragment constructor(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentNamaDeviceBinding = FragmentNamaDeviceBinding::inflate
) : BaseFragment<FragmentNamaDeviceBinding>() {

    private val viewModel : NamaDeviceViewModel by viewModels()

    @Inject lateinit var preferenceUtils: PreferenceUtils

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            viewModel.email = it.getString("username", "")
            viewModel.password = it.getString("password", "")
        }
    }

    override fun initComponents() {
        binding.apply {

            requireActivity().onBackPressedDispatcher.addCallback(this@NamaDeviceFragment, object : OnBackPressedCallback(true){
                override fun handleOnBackPressed() {
                    val dialog = CustomDialogBuilder.Builder(requireContext())
                        .setTitle(getString(R.string.yakin_akan_keluar))
                        .setMessage(getString(R.string.konfirmasi_keluar)).build()

                    dialog.show(parentFragmentManager, TAG)
                }
            })

            viewLifecycleOwner.lifecycleScope.launchWhenStarted {
                viewModel.event.collect { event ->
                    when(event){
                        NamaDeviceViewModel.UIEvent.NavigateToPilihDb -> {
                            preferenceUtils.putDeviceName(viewModel.deviceName)
                            val action = NamaDeviceFragmentDirections.actionNamaDeviceFragmentToPilihDbFragment(viewModel.email, viewModel.password)
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
                viewModel.onClickLanjutkan()
            }
            etNamaDevice.addTextChangedListener {
                viewModel.deviceName = etNamaDevice.text.toString().trim()
                btnLanjutkan.isEnabled = viewModel.deviceName.isNotEmpty()
                if(viewModel.deviceName.isNotEmpty()) {
                    btnLanjutkan.background = ContextCompat.getDrawable(requireContext(), R.drawable.btn_rect_primary)
                } else {
                    btnLanjutkan.background = ContextCompat.getDrawable(requireContext(), R.drawable.btn_rect_disable)
                }
            }
        }
    }

    override fun subscribeObservers() {

    }

}