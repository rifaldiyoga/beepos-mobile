package com.bits.bee.bpmc.presentation.ui.login

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
import com.bits.bee.bpmc.databinding.FragmentLoginBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.LoadingDialogHelper
import com.bits.bee.bpmc.presentation.ui.initial.InitialActivity
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by aldi on 01/03/22.
 */

const val TAG = "Login Fragment"

@AndroidEntryPoint
class LoginFragment constructor (
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentLoginBinding = FragmentLoginBinding::inflate
) : BaseFragment<FragmentLoginBinding>() {

    //View Model
    private val viewModel : LoginViewModel by viewModels()

    private lateinit var dialog : LoadingDialogHelper

    override fun initComponents() {
        directPage()
        dialog = LoadingDialogHelper(requireContext())
        binding.apply {
            viewLifecycleOwner.lifecycleScope.launch {
                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.event.collect { event ->
                        when(event){
                            LoginViewModel.UIEvent.RequestLogin -> {
                                viewModel.login()
                            }
                            LoginViewModel.UIEvent.NavigateToNamaDevice -> {
                                val value = viewModel.state.value
                                val action = LoginFragmentDirections.actionLoginFragmentToNamaDeviceFragment(value.email, value.password)
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
            etEmail.addTextChangedListener {
                viewModel.state.value.email = etEmail.text.toString().trim()
                viewModel.validateEmail()
            }
            etPassword.addTextChangedListener {
                viewModel.state.value.password = etPassword.text.toString().trim()
                viewModel.validatePassword()
            }
            btnMasuk.setOnClickListener {
                viewModel.onClickLogin()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.state.collect {
                    it.let {
                        binding.apply {
                                tilEmail.error = it.messageEmail

                                tilPassword.error = it.messagePassword

                            btnMasuk.apply {
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

        viewModel.observeLoginResponse().removeObservers(viewLifecycleOwner)
        viewModel.observeLoginResponse().observe(viewLifecycleOwner) {
            when (it.status) {
                Resource.Status.LOADING -> {
                    dialog.show()
                }
                Resource.Status.SUCCESS -> {
                    dialog.hide()
                    it.data?.let {
                        if (it.status == "ok") {
                            Toast.makeText(requireContext(), "Berhasil Login", Toast.LENGTH_LONG)
                                .show()
                            viewModel.onSuccessLogin()
                        } else {
                            Toast.makeText(requireContext(), "Error : ${it.msg}", Toast.LENGTH_LONG)
                                .show()
                        }
                    }
                }
                Resource.Status.ERROR -> {
                    dialog.hide()
                    Toast.makeText(requireContext(), "Error : ${it.message}", Toast.LENGTH_LONG)
                        .show()
                }
            }
        }
    }

    /**
     * check last page from prefences then direct to last page
     */
    private fun directPage(){
        when(BeePreferenceManager.getDataFromPreferences(requireActivity(), getString(R.string.pref_last_page), "")){
            getString(R.string.page_pilih_cabang) -> {
                val action = LoginFragmentDirections.actionLoginFragmentToPilihCabangFragment()
                findNavController().navigate(action)
            }
            getString(R.string.page_pilih_kasir) -> {
                val action = LoginFragmentDirections.actionLoginFragmentToPilihKasirFragment()
                findNavController().navigate(action)
            }
            getString(R.string.page_pilih_operator) -> {
                val action = LoginFragmentDirections.actionLoginFragmentToLoginOperatorFragment()
                findNavController().navigate(action)
            }
            getString(R.string.page_mode_tampilan) -> {
                val action = LoginFragmentDirections.actionLoginFragmentToModeTampilanFragment()
                findNavController().navigate(action)
            }
            getString(R.string.page_home) -> {
                val action = LoginFragmentDirections.actionLoginFragmentToHomeActivity()
                findNavController().navigate(action)
                (activity as InitialActivity).finish()
            }
            else -> null
        }
    }

}