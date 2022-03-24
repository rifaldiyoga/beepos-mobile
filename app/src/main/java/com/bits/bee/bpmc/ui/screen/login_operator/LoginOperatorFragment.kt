package com.bits.bee.bpmc.ui.screen.login_operator

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import com.bits.bee.bpmc.databinding.FragmentLoginPinBinding
import com.bits.bee.bpmc.ui.base.BaseFragment
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