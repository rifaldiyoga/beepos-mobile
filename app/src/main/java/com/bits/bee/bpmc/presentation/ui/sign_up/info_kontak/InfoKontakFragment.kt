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
import com.bits.bee.bpmc.utils.extension.isContainsNumber
import com.bits.bee.bpmc.utils.extension.isContainsUpperCase
import com.bits.bee.bpmc.utils.extension.isValidEmail
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
            }
            etNoWa.addTextChangedListener {
                val nowa = etNoWa.text.toString().trim()
                viewModel.state.noWa = nowa
                viewModel.validateInput()
                if(nowa.isNotEmpty() && nowa.length <= 11) {
                    tilNoWa.isErrorEnabled = true
                    tilNoWa.error = "No. Whatsapp harus lebih dari 11 karakter"
                }else {
                    tilNoWa.isErrorEnabled = false
                }
            }
            etEmail.addTextChangedListener {
                val email =  etEmail.text.toString().trim()
                viewModel.state.email = email
                viewModel.validateInput()
                if(email.isNotEmpty() && !email.isValidEmail()) {
                    tilEmail.isErrorEnabled = true
                    tilEmail.error = "Email tidak valid"
                }else {
                    tilEmail.isErrorEnabled = false
                }
            }
            etPassword.addTextChangedListener {
                viewModel.onPasswordChange(etPassword.text.toString().trim())
                viewModel.validateInput()
            }
            etconfPassword.addTextChangedListener {
                val pass = etconfPassword.text.toString().trim()
                viewModel.state.confPassword = pass
                viewModel.validateInput()
                if(pass.isNotEmpty() && pass != viewModel.state.password) {
                    tilconfPassword.isErrorEnabled = true
                    tilconfPassword.error = "Konfirmasi password tidak sama"
                }else {
                    tilconfPassword.isErrorEnabled = false
                }
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
                        binding.apply {
                            val icError = ContextCompat.getDrawable(requireActivity(), R.drawable.ic_close_red)
                            val icSuccess = ContextCompat.getDrawable(requireActivity(), R.drawable.ic_baseline_check)

                            val errorKarakter = if(it.password.length > 7) icSuccess else icError
                            val errorCase = if(it.password.isContainsUpperCase()) icSuccess else icError
                            val errorNumber = if(it.password.isContainsNumber()) icSuccess else icError

                            tvErrorKarakter.setCompoundDrawablesWithIntrinsicBounds(errorKarakter, null, null, null)
                            tvErrorCase.setCompoundDrawablesWithIntrinsicBounds(errorCase, null, null, null)
                            tvErrorNumber.setCompoundDrawablesWithIntrinsicBounds(errorNumber, null, null, null)

                            btnLanjut.apply {
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