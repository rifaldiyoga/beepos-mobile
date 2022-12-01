package com.bits.bee.bpmc.presentation.ui.sign_up.otp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentOtpBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.LoadingDialogHelper
import com.bits.bee.bpmc.presentation.dialog.NoInternetDialogBuilder
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class OtpFragment constructor(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentOtpBinding = FragmentOtpBinding::inflate
): BaseFragment<FragmentOtpBinding>() {

    private val viewModel : OtpViewModel by viewModels()
    private lateinit var dialog: LoadingDialogHelper

    override fun initComponents() {
        dialog = LoadingDialogHelper(requireContext())
        BeePreferenceManager.saveToPreferences(requireActivity(), getString(R.string.pref_last_page), getString(R.string.page_otp))
        binding.apply {
            arguments?.let {
                val noWa = BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_wa), "") as String
                val regId = BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_regid), "") as String

                viewModel.state.regId = regId.toInt()

                pinView.requestFocus()

                tvDesc.text = getString(R.string.kami_telah_mengirimkan, noWa.toList().mapIndexed { i, char -> if(i in 4..7) '*' else char }.joinToString(separator = ""))
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            pinView.addTextChangedListener {
                viewModel.onInputPin(pinView.text.toString().trim())
            }
            tvKirimUlang.setOnClickListener {
                viewModel.postSendOtp()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    it?.let {
                        binding.apply {
                            if(!it.isSendOtp) {
                                tvKirimUlang.text = "Kirim ulang kode (${it.countDown / 1000})"
                                tvKirimUlang.setTextColor(ContextCompat.getColor(requireActivity(), R.color.dark_gray))
                            } else {
                                tvKirimUlang.text = "Kirim ulang kode"
                                tvKirimUlang.setTextColor(ContextCompat.getColor(requireActivity(), R.color.red))
                            }
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.event.collect {
                when(it){
                    OtpViewModel.UIEvent.NavigateToAturPin -> {
                        val action = OtpFragmentDirections.actionOtpFragmentToCekDbFragment()
                        findNavController().navigate(action)
                    }
                }
            }
        }
        viewModel.observeVerifSmsResponse().observe(viewLifecycleOwner){
            when(it.status){
                Resource.Status.LOADING -> {
                    dialog.show()
                }
                Resource.Status.SUCCESS -> {
                    dialog.hide()
                    it.data?.let {
                        BeePreferenceManager.saveToPreferences(requireActivity(), getString(R.string.pref_serial_number), it.userData.serialNumber)
                        BeePreferenceManager.saveToPreferences(requireActivity(), getString(R.string.pref_auth_key), it.userData.myauthkey ?: "")
                        viewModel.onSuccess()
                    }
                }
                Resource.Status.ERROR -> {
                    showSnackbar("Kode Salah!")
                    dialog.hide()
                }
                Resource.Status.NOINTERNET -> {
                    dialog.hide()
                    val dialog = NoInternetDialogBuilder({
                        viewModel.onInputPin(viewModel.state.pin)
                    })
                    dialog.show(parentFragmentManager, "")
                }
            }
        }
        viewModel.observeSendOtpResponse().observe(viewLifecycleOwner){
            when(it.status){
                Resource.Status.LOADING -> {

                }
                Resource.Status.SUCCESS -> {
                    it.data?.let {
                        BeePreferenceManager.saveToPreferences(requireActivity(), getString(R.string.pref_regid), it.regId)
                    }
                }
                Resource.Status.ERROR -> {

                }
                Resource.Status.NOINTERNET -> {
                    val dialog = NoInternetDialogBuilder({
                        viewModel.onInputPin(viewModel.state.pin)
                    })
                    dialog.show(parentFragmentManager, "")
                }
            }
        }
    }
}