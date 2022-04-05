package com.bits.bee.bpmc.presentation.ui.login_operator

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentLoginPinBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.utils.BeePreferenceManager
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by aldi on 23/03/22.
 */

@AndroidEntryPoint
class LoginOperatorFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentLoginPinBinding = FragmentLoginPinBinding::inflate
) : BaseFragment<FragmentLoginPinBinding>() {

    private val viewModel : LoginOperatorViewModel by viewModels()

    override fun initComponents() {
        BeePreferenceManager.saveToPreferences(requireActivity(), getString(R.string.pref_last_page), getString(
                    R.string.page_pilih_operator))
        binding.apply {
            numpad.setInputConnection(pinView.onCreateInputConnection(EditorInfo())!!)
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            pinView.addTextChangedListener {  }
        }
    }

    override fun subscribeObservers() {
    }

}