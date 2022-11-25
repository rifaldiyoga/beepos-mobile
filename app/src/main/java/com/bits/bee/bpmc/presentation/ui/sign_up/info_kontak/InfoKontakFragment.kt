package com.bits.bee.bpmc.presentation.ui.sign_up.info_kontak

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
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentInfoKontakBinding
import com.bits.bee.bpmc.domain.model.SignUp
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.LoadingDialogHelper
import com.bits.bee.bpmc.presentation.dialog.NoInternetDialogBuilder
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class InfoKontakFragment constructor(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentInfoKontakBinding = FragmentInfoKontakBinding::inflate
): BaseFragment<FragmentInfoKontakBinding>() {

    private val viewModel: InfoKontakViewModel by viewModels()
    private lateinit var dialog: LoadingDialogHelper

    override fun initComponents() {
        dialog = LoadingDialogHelper(requireContext())
        binding.apply {
            viewLifecycleOwner.lifecycleScope.launch {
                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.event.collect { event ->
                        when(event){
                            InfoKontakViewModel.UIEvent.NavigateToOtp -> {
                                val signUp = SignUp(viewModel.state.nama,
                                    viewModel.state.noWa,
                                    viewModel.state.email,
                                    viewModel.state.password,
                                    viewModel.state.confPassword,
                                    regId = viewModel.state.regId.toInt())

                                val action = InfoKontakFragmentDirections.actionInfoKontakFragmentToInfoBisnisFragment(signUp)
                                findNavController().navigate(action)
                            }
                            InfoKontakViewModel.UIEvent.RequestInfoKontak -> {

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
            etEmail.addTextChangedListener {
                viewModel.state.email = etEmail.text.toString().trim()
                viewModel.validateInput()
            }
            etPassword.addTextChangedListener {
                viewModel.state.password = etPassword.text.toString().trim()
                viewModel.validateInput()
            }
            etconfPassword.addTextChangedListener {
                viewModel.state.confPassword = etconfPassword.text.toString().trim()
                viewModel.validateInput()
            }
            btnLanjut.setOnClickListener {
                onClickSignUp()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    it?.let {
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
    }

    private fun onClickSignUp() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.postSignUp().collect{
                when (it.status) {
                    Resource.Status.LOADING -> {
                        dialog.show()
                    }
                    Resource.Status.SUCCESS -> {
                        dialog.hide()
                        it.data?.let { data ->
                            if (data.status) {
                                val strRegId = data.responses
                                viewModel.state.regId = strRegId
                                strRegId.let {
                                    BeePreferenceManager.saveToPreferences(requireActivity(), getString(R.string.pref_regid), strRegId)
                                    BeePreferenceManager.saveToPreferences(requireActivity(), getString(R.string.pref_wa), viewModel.state.noWa)
                                    viewModel.onSuccesLanjut()
                                }
                            } else if(data.errorData.isNotEmpty()){
                                for (data in data.errorData){
                                    data.email?.let {
                                        binding.tilEmail.apply {
                                            isErrorEnabled = true
                                            error = it.firstOrNull()
                                        }
                                    }
                                    data.mobile?.let {
                                        binding.tilNoWa.apply {
                                            isErrorEnabled = true
                                            error = it.firstOrNull()
                                        }
                                    }
                                    data.username?.let {
                                        binding.tilNama.apply {
                                            isErrorEnabled = true
                                            error = it.firstOrNull()
                                        }
                                    }
                                }
                            } else {

                            }
                        }
                    }
                    Resource.Status.ERROR -> {
                        dialog.hide()
                        Toast.makeText(requireContext(), "Error : ${it.message}", Toast.LENGTH_LONG)
                            .show()
                    }
                    Resource.Status.NOINTERNET -> {
                        dialog.hide()
                        val dialog = NoInternetDialogBuilder({
                            onClickSignUp()
                        })
                        dialog.show(parentFragmentManager, "")
                    }
                }
            }
        }
    }
}