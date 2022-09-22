package com.bits.bee.bpmc.presentation.ui.login_operator

import android.os.Bundle
import android.view.*
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentLoginPinBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.CustomDialogBuilder
import com.bits.bee.bpmc.presentation.dialog.LoadingDialogHelper
import com.bits.bee.bpmc.presentation.dialog.info_akun.InfoAkunDialogBuilder
import com.bits.bee.bpmc.presentation.ui.initial.InitialActivity
import com.bits.bee.bpmc.presentation.ui.nama_device.TAG
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.ConnectionUtils
import com.bits.bee.bpmc.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by aldi on 23/03/22.
 */

@AndroidEntryPoint
class LoginOperatorFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentLoginPinBinding = FragmentLoginPinBinding::inflate
) : BaseFragment<FragmentLoginPinBinding>() {

    private val viewModel : LoginOperatorViewModel by viewModels()
    private var loginUser = false
    private var mLoginUserStatus:Int = 1

    private lateinit var dialog : LoadingDialogHelper


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_login_operator, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_login -> {
                when(mLoginUserStatus){
                    1 -> {
                        BeePreferenceManager.saveToPreferences(requireActivity(), getString(R.string.pref_login_user), true)
                        mLoginUserStatus = 2
                        binding.apply {
                            llModePin.visibility = View.GONE
                            llModeEmail.visibility = View.VISIBLE
                            btnMasuk.visibility = View.VISIBLE
                        }
                        item.title = getString(R.string.login_pin)
                        item.icon = requireContext().getResources().getDrawable(R.drawable.ic_tag_pin);
                    }
                    2 -> {
                        BeePreferenceManager.saveToPreferences(requireActivity(), getString(R.string.pref_login_user), false)
                        mLoginUserStatus = 1
                        binding.apply {
                            llModePin.visibility = View.VISIBLE
                            llModeEmail.visibility = View.GONE
                            btnMasuk.visibility = View.GONE
                        }
                        item.title = getString(R.string.login_email)
                        item.icon = requireContext().getResources().getDrawable(R.drawable.ic_tag_email);
                    }
                }
            }
            R.id.menu_sinkron ->{
                if (ConnectionUtils.checkInternet(requireContext())){
                    viewModel.onClickSync()
                }
            }
            R.id.menu_reset ->{
                viewModel.menuReset()
            }
            R.id.menu_info ->{
                viewModel.menuInfo()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun initComponents() {
        mLoginUserStatus = 1
        dialog = LoadingDialogHelper(requireContext())
        BeePreferenceManager.saveToPreferences(requireActivity(), getString(R.string.pref_last_page), getString(
                    R.string.page_pilih_operator))
        binding.apply {
            numpad.setInputConnection(pinView.onCreateInputConnection(EditorInfo())!!)
            viewLifecycleOwner.lifecycleScope.launch {
                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.event.collect { event ->
                        when(event) {
                            LoginOperatorViewModel.UIEvent.RequestLoginEmail ->{
                                viewModel.loginEmail()
                            }
                            LoginOperatorViewModel.UIEvent.RequestDoSync ->{
                                viewModel.menuSinkron()
                            }
                            LoginOperatorViewModel.UIEvent.RequestConfirmKasir ->{
                                val dialog = CustomDialogBuilder.Builder(requireContext())
                                    .setTitle(getString(R.string.konfirmasi))
                                    .setMessage(getString(R.string.yakin_ganti_kasir))
                                    .setPositiveCallback {
                                        if (ConnectionUtils.checkInternet(requireContext())){
                                            viewModel.deActiveStatusKasir()
                                        }
                                    }.build()
                                dialog.show(parentFragmentManager, TAG)
                            }
                            LoginOperatorViewModel.UIEvent.NavigateToHome ->{
                                val action = LoginOperatorFragmentDirections.actionLoginOperatorFragmentToHomeActivity()
                                findNavController().navigate(action)
                                (activity as InitialActivity).finish()
                            }
                            LoginOperatorViewModel.UIEvent.RequestDialogInfo ->{
                                val dialog = InfoAkunDialogBuilder()
                                dialog.show(parentFragmentManager, TAG)
                            }
                            LoginOperatorViewModel.UIEvent.RequestPilihKasir ->{
                                val action = LoginOperatorFragmentDirections.actionLoginOperatorFragmentToPilihKasirFragment()
                                findNavController().navigate(action)
                            }
                            LoginOperatorViewModel.UIEvent.RequetWarningPass ->{
                                val dialog = CustomDialogBuilder.Builder(requireContext())
                                    .setTitle(getString(R.string.gagal_login))
                                    .setMessage(getString(R.string.silahkan_login_email_sinkron))
                                    .setPositiveCallback {
                                        requireActivity().actionBar?.displayOptions
                                        viewModel.updateState(
                                            viewModel.state.copy(
                                                mTimesWrong = 0
                                            )
                                        )
                                    }.build()
                                dialog.show(parentFragmentManager, TAG)
                            }
                            else -> {}
                        }
                    }
                }
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            pinView.addTextChangedListener {
                pinView.text?.let {
                    if(it.toString().length == 6){
                        viewModel.checkPinUser(it.toString())
                    }
                }
            }
            etEmail.addTextChangedListener {
                viewModel.updateState(
                    viewModel.state.copy(
                        email = etEmail.text.toString().trim()
                    )
                )
                viewModel.validateEmail()
            }
            etPassword.addTextChangedListener {
                viewModel.updateState(
                    viewModel.state.copy(
                        password = etPassword.text.toString().trim()
                    )
                )
                viewModel.validatePassword()
            }
            btnMasuk.setOnClickListener {
                viewModel.onClickLogin()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
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

//        viewLifecycleOwner.lifecycleScope.launch {
//            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
//                viewModel.event.collect { event ->
//                    when(event) {
//                        LoginOperatorViewModel.UIEvent.RequestLoginEmail ->{
//                            viewModel.loginEmail()
//                        }
//                        LoginOperatorViewModel.UIEvent.RequestDoSync ->{
//                            viewModel.menuSinkron()
//                        }
//                        LoginOperatorViewModel.UIEvent.RequestConfirmKasir ->{
//                            val dialog = CustomDialogBuilder.Builder(requireContext())
//                                .setTitle(getString(R.string.konfirmasi))
//                                .setMessage(getString(R.string.yakin_ganti_kasir))
//                                .setPositiveCallback {
//                                    if (ConnectionUtils.checkInternet(requireContext())){
//                                        viewModel.deActiveStatusKasir()
//                                    }
//                                }.build()
//                            dialog.show(parentFragmentManager, TAG)
//                        }
//                        LoginOperatorViewModel.UIEvent.NavigateToHome ->{
//                            val action = LoginOperatorFragmentDirections.actionLoginOperatorFragmentToHomeActivity()
//                            findNavController().navigate(action)
//                            (activity as InitialActivity).finish()
//                        }
//                        LoginOperatorViewModel.UIEvent.RequestDialogInfo ->{
//                            val dialog = InfoAkunDialogBuilder()
//                            dialog.show(parentFragmentManager, TAG)
//                        }
//                        LoginOperatorViewModel.UIEvent.RequestPilihKasir ->{
//                            val action = LoginOperatorFragmentDirections.actionLoginOperatorFragmentToPilihKasirFragment()
//                            findNavController().navigate(action)
//                        }
//                        else -> {}
//                    }
//                }
//            }
//        }

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

        viewModel.observebranchUserResponse().removeObservers(viewLifecycleOwner)
        viewModel.observebranchUserResponse().observe(viewLifecycleOwner){
            it.let {
                when(it.status){
                    Resource.Status.LOADING -> {

                    }
                    Resource.Status.SUCCESS -> {
                        Toast.makeText(requireContext(), "Berhasil Sinkron Data", Toast.LENGTH_SHORT).show()
                    }
                    Resource.Status.ERROR -> {

                    }
                }
            }
        }

        viewModel.observeCashierStatusResponse().removeObservers(viewLifecycleOwner)
        viewModel.observeCashierStatusResponse().observe(viewLifecycleOwner){
            when(it.status){
                Resource.Status.LOADING -> {

                }
                Resource.Status.SUCCESS -> {
                    it.data?.let {
                        if (it.data.status_cashier){
                            viewModel.updateCashier()
                        }else{
                            Toast.makeText(requireContext(), "Gagal Proses Detach", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
                Resource.Status.ERROR -> {
                    Toast.makeText(requireContext(), "${it.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}