package com.bits.bee.bpmc.presentation.dialog

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bits.bee.bpmc.databinding.DialogNoIntenetBuilderBinding
import com.bits.bee.bpmc.presentation.base.BaseDialogFragment

class NoInternetDialogBuilder(
    private val onPositive : () -> Unit,
    private val onNegative : (() -> Unit)? = null,
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogNoIntenetBuilderBinding = DialogNoIntenetBuilderBinding::inflate
): BaseDialogFragment<DialogNoIntenetBuilderBinding>() {

    override fun initComponents(){

    }

    override fun subscribeListeners() {
        binding.apply {
            btnCobaLagi.setOnClickListener {
                onPositive()
                dismiss()
            }
            btnClose.setOnClickListener {
                onNegative?.let {
                    it()
                }
                dismiss()
            }
        }
    }

    override fun subscribeObservers() {

    }

}