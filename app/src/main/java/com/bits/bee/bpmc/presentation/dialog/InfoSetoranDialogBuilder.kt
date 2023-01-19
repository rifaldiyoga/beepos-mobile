package com.bits.bee.bpmc.presentation.dialog

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bits.bee.bpmc.databinding.DialogInfoSetoranKasirBinding
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment

class InfoSetoranDialogBuilder(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogInfoSetoranKasirBinding = DialogInfoSetoranKasirBinding::inflate
) : BaseBottomSheetDialogFragment<DialogInfoSetoranKasirBinding>() {
    override fun initComponents() {
        binding.apply {

        }
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

    }
}