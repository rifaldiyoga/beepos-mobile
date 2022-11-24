package com.bits.bee.bpmc.presentation.ui.sign_up.ulangi_pin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.data.data_source.remote.RetrofitClient
import com.bits.bee.bpmc.databinding.FragmentUlangiPinBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.LoadingDialogHelper
import com.bits.bee.bpmc.presentation.dialog.NoInternetDialogBuilder
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UlangiPinFragment constructor(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentUlangiPinBinding = FragmentUlangiPinBinding::inflate
): BaseFragment<FragmentUlangiPinBinding>() {

    private val viewModel : UlangiPinViewModel by viewModels()

    private lateinit var dialog: LoadingDialogHelper

    override fun initComponents() {
        dialog = LoadingDialogHelper(requireActivity())
        val pass = BeePreferenceManager.getDataFromPreferences(requireActivity(), getString(R.string.pref_password), "") as String
        val auth = BeePreferenceManager.getDataFromPreferences(requireActivity(), getString(R.string.pref_auth_key), "") as String
        viewModel.updateState(
            viewModel.state.copy(
                password = pass,
                authKey = auth
            )
        )
        binding.apply {
            arguments?.let {
                val pin = it.getString("pin")
                viewModel.state.pinBefore = pin ?: ""
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            pinView.addTextChangedListener {
                viewModel.onPinInput(pinView.text.toString().trim())
            }
            btnSimpanPin.setOnClickListener {

            }
        }
    }

    override fun subscribeObservers() {
        viewModel.observeSetupPasswordResponse().removeObservers(viewLifecycleOwner)
        viewModel.observeSetupPasswordResponse().observe(viewLifecycleOwner){
            when(it.status){
                Resource.Status.LOADING -> {
                    dialog.show()
                }
                Resource.Status.SUCCESS -> {
                    dialog.hide()
                    it.data?.let {
                        if(it.status)
                            viewModel.onSuccess()
                        else
                            showSnackbar(it.responses)
                    }

                }
                Resource.Status.ERROR -> {
                    dialog.hide()
                }
                Resource.Status.NOINTERNET -> {
                    dialog.hide()
                    val dialog = NoInternetDialogBuilder({
                        viewModel.onPinFilled()
                    })
                    dialog.show(parentFragmentManager, "")
                }
            }
        }

        viewModel.observeLoginResponse().observe(viewLifecycleOwner){
            when(it.status){
                Resource.Status.LOADING -> {
                    dialog.show(message = "Validasi data login..")
                }
                Resource.Status.SUCCESS -> {
                    dialog.hide()
                    it.data?.let { data ->
                        if(data.status == "success"){
                            if(data.db != null && data.db!!.isNotEmpty()) {
                                viewModel.postDb(data.db!!.first().dbName)
                            }
                        }
                    }
                }
                Resource.Status.ERROR -> {
                    dialog.hide()
                }
                Resource.Status.NOINTERNET -> {
                    dialog.hide()
                    val dialog = NoInternetDialogBuilder({
                        viewModel.onPinFilled()
                    })
                    dialog.show(parentFragmentManager, "")
                }
            }
        }

        viewModel.observeDbResponse().observe(viewLifecycleOwner){
            when(it.status){
                Resource.Status.LOADING -> {
                    dialog.show("Validasi database yang sudah dibuat..")
                }
                Resource.Status.SUCCESS -> {
                    dialog.hide()
                    it.data?.let { data ->
                        if(data.status == "success"){
                            if(data.dataDb.isNotEmpty()) {
                                val apiKey = data.dataDb.firstOrNull()?.auth_key ?: ""
                                BeePreferenceManager.saveToPreferences(requireActivity(), getString(R.string.api_key), apiKey)
                                RetrofitClient.API_KEY = apiKey
                                viewModel.onSuccess()
                            }
                        }
                    }
                }
                Resource.Status.ERROR -> {
                    dialog.hide()
                }
                Resource.Status.NOINTERNET -> {
                    dialog.hide()
                    val dialog = NoInternetDialogBuilder({
                        viewModel.onPinFilled()
                    })
                    dialog.show(parentFragmentManager, "")
                }
            }
        }


        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {

                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect {
                    when(it){
                        UlangiPinViewModel.UIEvent.NavigateToAturProduk -> {
                            BeePreferenceManager.saveToPreferences(requireActivity(), getString(R.string.pref_pin), viewModel.state.pin)
                            val action = UlangiPinFragmentDirections.actionUlangiPinFragmentToModeTampilanFragment(type = "signup")
                            findNavController().navigate(action)
                        }
                        UlangiPinViewModel.UIEvent.PinNotSame -> {
                            binding.pinView.text!!.clear()
                            showSnackbar("Pin yang anda masukkan tidak sama!")
                        }
                    }
                }
            }
        }
    }
}