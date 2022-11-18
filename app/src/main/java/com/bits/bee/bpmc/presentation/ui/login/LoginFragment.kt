package com.bits.bee.bpmc.presentation.ui.login

import android.content.Intent
import android.net.Uri
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
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
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
        dialog = LoadingDialogHelper(requireContext())
        binding.apply {
            viewLifecycleOwner.lifecycleScope.launch {
                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                    viewModel.event.collectLatest { event ->
                        when(event){
                            LoginViewModel.UIEvent.RequestLogin -> {
                                viewModel.login()
                            }
                            LoginViewModel.UIEvent.NavigateToNamaDevice -> {
                                val value = viewModel.state
                                val action = LoginFragmentDirections.actionLoginFragmentToNamaDeviceFragment(value.email, value.password)
                                findNavController().navigate(action)
                                viewModel.updateState(
                                    LoginViewState()
                                )
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
                viewModel.state.email = etEmail.text.toString().trim()
                viewModel.validateEmail()
            }
            etPassword.addTextChangedListener {
                viewModel.state.password = etPassword.text.toString().trim()
                viewModel.validatePassword()
            }
            btnMasuk.setOnClickListener {
                onClickLogin()
            }
            tvLupaKataSandi.setOnClickListener {
                val uri = Uri.parse("https://app.beecloud.id/resetpassword")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                startActivity(intent)
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    it?.let {
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
    }


    private fun onClickLogin(){
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.login().collect {
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
                                Toast.makeText(requireContext(), "Error : Email dan Password tidak sesuai!", Toast.LENGTH_LONG)
                                    .show()
                            }
                        }
                    }
                    Resource.Status.ERROR -> {
                        dialog.hide()
                        Toast.makeText(requireContext(), "Error : Email dan Password tidak sesuai!", Toast.LENGTH_LONG)
                            .show()
                    }
                }
            }
        }
    }
}