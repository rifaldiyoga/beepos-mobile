package com.bits.bee.bpmc.presentation.ui.hak_akses

import android.os.Bundle
import android.view.*
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentHakAksesBinding
import com.bits.bee.bpmc.presentation.base.BaseDialogFragment
import com.bits.bee.bpmc.presentation.dialog.DialogBuilderHelper
import com.bits.bee.bpmc.presentation.dialog.LoadingDialogHelper
import com.bits.bee.bpmc.presentation.dialog.NoInternetDialogBuilder
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.Resource
import com.bits.bee.bpmc.utils.extension.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * Created by aldi on 01/11/22
 */
@AndroidEntryPoint
class HakAksesFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHakAksesBinding = FragmentHakAksesBinding::inflate
) : BaseDialogFragment<FragmentHakAksesBinding>() {

    private val viewModel : HakAksesViewModel by viewModels()

    private var mLoginUserStatus:Int = 2

    private lateinit var dialog : LoadingDialogHelper

    override fun getTheme(): Int = R.style.DialogTheme

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_hak_akses, menu)
        val menuLogin = menu.findItem(R.id.menu_login)
        loadMenu(menuLogin)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_login -> {
                when(mLoginUserStatus){
                    1 -> {
                        mLoginUserStatus = 2
                    }
                    2 -> {
                        mLoginUserStatus = 1
                    }
                }
                loadMenu(item)
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
        arguments?.let {
            val acs = it.getString("acsType")
            viewModel.updateState(
                viewModel.state.copy(
                    acsType = acs ?: ""
                )
            )
        }
        dialog = LoadingDialogHelper(requireContext())
        binding.apply {
            toolbar.inflateMenu(R.menu.menu_hak_akses)
            toolbar.setNavigationOnClickListener {
                findNavController().popBackStack()
            }
            toolbar.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.menu_login -> {
                        when(mLoginUserStatus){
                            1 -> {
                                BeePreferenceManager.saveToPreferences(requireActivity(), getString(R.string.pref_login_user), true)
                                mLoginUserStatus = 2
                            }
                            2 -> {
                                BeePreferenceManager.saveToPreferences(requireActivity(), getString(R.string.pref_login_user), false)
                                mLoginUserStatus = 1
                            }
                        }
                        loadMenu(it)
                    }
                }
                false
            }
            numpad.setInputConnection(pinView.onCreateInputConnection(EditorInfo())!!)
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
                viewModel.loginEmail()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collectLatest {
                    when(it){
                        HakAksesViewModel.UIEvent.ClearPin -> {
                            binding.pinView.setText("")
                            binding.tvPinSalah.visible()
                        }
                        HakAksesViewModel.UIEvent.RequetWarningPass -> {
                            val dialog = DialogBuilderHelper.showDialogInfo(
                                requireActivity(),
                                getString(R.string.gagal_login),
                                getString(R.string.silahkan_login_email_sinkron)
                            ) {
                                it.dismiss()
                                requireActivity().actionBar?.displayOptions
                                viewModel.updateState(
                                    viewModel.state.copy(
                                        mTimesWrong = 0
                                    )
                                )
                            }
                            dialog.show(parentFragmentManager, "")
                        }
                        HakAksesViewModel.UIEvent.SuccessValididation -> {
                            findNavController().previousBackStackEntry?.savedStateHandle?.set(viewModel.state.acsType, true)
                            findNavController().popBackStack()
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.msg.collect {
                showSnackbar(it)
            }
        }
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
                            viewModel.onSuccessValidate()
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
                Resource.Status.NOINTERNET -> {
                    dialog.hide()
                    val dialog = NoInternetDialogBuilder({
                        viewModel.loginEmail()
                    })
                    dialog.show(parentFragmentManager, "")
                }
            }
        }
    }

    private fun loadMenu(menuLogin : MenuItem) {
        when(mLoginUserStatus){
            1 -> {
                binding.apply {
                    llModePin.visibility = View.GONE
                    llModeEmail.visibility = View.VISIBLE
                    btnMasuk.visibility = View.VISIBLE
                }
                menuLogin.title = getString(R.string.login_pin)
                menuLogin.icon = ContextCompat.getDrawable(requireActivity(), R.drawable.ic_tag_pin);
            }
            2 -> {
                binding.apply {
                    llModePin.visibility = View.VISIBLE
                    llModeEmail.visibility = View.GONE
                    btnMasuk.visibility = View.GONE
                }
                menuLogin.title = getString(R.string.login_email)
                menuLogin.icon =  ContextCompat.getDrawable(requireActivity(), R.drawable.ic_tag_email);
            }
        }
    }

}