package com.bits.bee.bpmc.presentation.ui.info_kontak

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.airbnb.paris.R2.attr.background
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentInfoKontakBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.LoadingDialogHelper
import com.bits.bee.bpmc.presentation.ui.login.LoginFragmentDirections
import com.bits.bee.bpmc.presentation.ui.login.LoginViewModel
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class InfoKontakFragment constructor(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentInfoKontakBinding = FragmentInfoKontakBinding::inflate
): BaseFragment<FragmentInfoKontakBinding>() {

    private val viewModel: InfoKontakViewModel by viewModels()
    private lateinit var dialog: LoadingDialogHelper

    override fun initComponents() {
        binding.apply {
            viewLifecycleOwner.lifecycleScope.launch {
                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.event.collect { event ->
                        when(event){
                            InfoKontakViewModel.UIEvent.RequestInfoKontak -> {
                                viewModel.regisInfoKontak()
                            }
                            InfoKontakViewModel.UIEvent.NavigateToOtp -> {
                                val action = InfoKontakFragmentDirections.actionInfoKontakFragmentToOtpFragment(
                                    viewModel.state.nama,
                                    viewModel.state.noWa,
                                    viewModel.state.email,
                                    viewModel.state.password,
                                    viewModel.state.confPassword)
                                findNavController().navigate(action)
                            }
                        }
                    }
                }
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            etNama.addTextChangedListener {
                viewModel.state.nama = etNama.text.toString().trim()
                viewModel.validateInput()
            }
            etNoWa.addTextChangedListener {
                viewModel.state.noWa = etNoWa.text.toString().trim()
                viewModel.validateInput()
            }
            etEmailSu.addTextChangedListener {
                viewModel.state.email = etEmailSu.text.toString().trim()
                viewModel.validateInput()
            }
            etPassword.addTextChangedListener {
                viewModel.state.password = etPassword.text.toString().trim()
                viewModel.validateInput()
            }
            etconfPassword.addTextChangedListener {
                viewModel.state.confPassword = etNama.text.toString().trim()
                viewModel.validateInput()
            }
            btnLanjut.setOnClickListener {
                viewModel.onClickLanjut()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.observeState().collect {
                    it.let {
                        binding.btnLanjut.apply {
                            background = ContextCompat.getDrawable(requireContext(), when(it.isValid){
                                true -> R.drawable.btn_rect_primary
                                false -> R.drawable.btn_rect_disable
                            })
                            isEnabled = it.isValid
                        }

                    }
                }
            }
        }

        viewModel.observeRegisterResponse().removeObservers(viewLifecycleOwner)
        viewModel.observeRegisterResponse().observe(viewLifecycleOwner) {
            when (it.status) {
                Resource.Status.LOADING -> {
                    dialog.show()
                }
                Resource.Status.SUCCESS -> {
                    dialog.hide()
                    it.data?.let {
                        if (it.status == true) {
                            var strRegId: String = it.responses
                            BeePreferenceManager.saveToPreferences(requireActivity(), getString(R.string.pref_regid), strRegId)
                            Toast.makeText(requireContext(), "Berhasil Login", Toast.LENGTH_LONG)
                                .show()
                            viewModel.onSuccesLanjut()
                        } else {
                            Toast.makeText(requireContext(), "Error : ${it.responses}", Toast.LENGTH_LONG)
                                .show()
                        }
                    }
                }
                Resource.Status.ERROR -> {
                    dialog.hide()
                    Toast.makeText(requireContext(), "Error : ${it.message}", Toast.LENGTH_LONG)
                        .show()
                }
                Resource.Status.TIMEOUT -> {
                    dialog.hide()
                }
                Resource.Status.UNAUTHORIZED -> {
                    dialog.hide()
                }
            }
        }
    }
}