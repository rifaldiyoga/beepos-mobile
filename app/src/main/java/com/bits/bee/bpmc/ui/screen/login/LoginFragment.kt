package com.bits.bee.bpmc.ui.screen.login

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.databinding.FragmentLoginBinding
import com.bits.bee.bpmc.ui.dialog.LoadingDialogHelper
import com.bits.bee.bpmc.ui.base.BaseFragment
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

/**
 * Created by aldi on 01/03/22.
 */

@AndroidEntryPoint
class LoginFragment constructor(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentLoginBinding = FragmentLoginBinding::inflate
) : BaseFragment<FragmentLoginBinding>() {

    //View Model
    private val viewModel : LoginViewModel by viewModels()

    private lateinit var dialog : LoadingDialogHelper
    private lateinit var state: LoginState

    override fun initComponents() {
        state = viewModel.observeState().value!!
        dialog = LoadingDialogHelper(requireContext())
        binding.apply {

            viewLifecycleOwner.lifecycleScope.launchWhenStarted {
                viewModel.event.collect { event ->
                    when(event){
                        LoginViewModel.UIEvent.RequestLogin -> {
                            viewModel.login()
                        }
                        LoginViewModel.UIEvent.NavigateToNamaDevice -> {
                            val action = LoginFragmentDirections.actionLoginFragmentToNamaDeviceFragment(viewModel.state.email, viewModel.state.password)
                            findNavController().navigate(action)
                        }
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun subscribeListeners() {
        binding.apply {
            etEmail.addTextChangedListener {
                state.email = etEmail.text.toString().trim()
            }
            etPassword.addTextChangedListener {
                state.password = etPassword.text.toString().trim()
               viewModel.setState()
            }
            btnMasuk.setOnClickListener {
                viewModel.onClickLogin()
            }
        }
    }

    override fun subscribeObservers() {

        viewModel.observeState().observe(viewLifecycleOwner, {
            it?.let {
//                it.isValid = !it.email.isEmpty() && !it.password.isEmpty()

//                if(it.isValid)
//                    Paris.styleBuilder(binding.btnMasuk).add(R.style.ButtonPrimary).apply()
//                else
//                    Paris.styleBuilder(binding.btnMasuk).add(R.style.ButtonDisable).apply()
            }
        })

        viewModel.observeLoginResponse().removeObservers(viewLifecycleOwner)
        viewModel.observeLoginResponse().observe(viewLifecycleOwner, {
            when(it.status){
                Resource.Status.LOADING -> {
                    dialog.show()
                }
                Resource.Status.SUCCESS -> {
                    dialog.hide()
                    it.data?.let {
                        if(it.status == "ok") {
                            Toast.makeText(requireContext(), "Berhasil Login", Toast.LENGTH_LONG)
                                .show()
                            viewModel.onSuccessLogin()
                        }  else {
                            Toast.makeText(requireContext(), "Error : ${it.msg}", Toast.LENGTH_LONG).show()
                        }
                    }
                }
                Resource.Status.ERROR -> {
                    dialog.hide()
                    Toast.makeText(requireContext(), "Error : ${it.message}", Toast.LENGTH_LONG).show()
                }
                Resource.Status.TIMEOUT -> {
                    dialog.hide()
                }
                Resource.Status.UNAUTHORIZED -> {
                    dialog.hide()
                }
            }
        })
    }

}