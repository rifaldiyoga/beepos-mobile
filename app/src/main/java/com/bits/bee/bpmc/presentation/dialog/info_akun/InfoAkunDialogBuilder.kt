package com.bits.bee.bpmc.presentation.dialog.info_akun

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bits.bee.bpmc.databinding.DialogInfoAkunBinding
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class InfoAkunDialogBuilder(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogInfoAkunBinding = DialogInfoAkunBinding::inflate
): BaseBottomSheetDialogFragment<DialogInfoAkunBinding>() {

    private val viewModel : InfoAkunViewModel by viewModels()

    override fun initComponents() {
        viewModel.getCmp()
    }

    override fun subscribeListeners() {
        binding.apply {
            imagClose.setOnClickListener {
                dismiss()
            }
            btnClose.setOnClickListener {
                dismiss()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.viewStates().collect {
                    binding.apply {
                        it?.let {
                            it.perusahaan?.let {
                                tvNamaCompany.text = it
                            }
                            it.email?.let {
                                tvEmail.text = it
                            }
                        }
                    }
                }
            }
        }
    }
}