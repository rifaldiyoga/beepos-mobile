package com.bits.bee.bpmc.presentation.dialog

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bits.bee.bpmc.databinding.DialogCloudDapurBinding
import com.bits.bee.bpmc.databinding.DialogRadioListBinding
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import com.bits.bee.bpmc.utils.extension.gone

class CloudDapurDialogBuilder(
    val title: String,
    val onSaveClick : (Any) -> Unit,
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogCloudDapurBinding = DialogCloudDapurBinding::inflate
) : BaseBottomSheetDialogFragment<DialogCloudDapurBinding>() {
    override fun initComponents() {
        binding.apply {
            tvTitle.text = title
            btnTontonVideo.gone()
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            btnTutup.setOnClickListener {
                dismiss()
            }
            imageView2.setOnClickListener {
                dismiss()
            }
            btnTontonVideo.setOnClickListener {
                //
            }
        }
    }

    override fun subscribeObservers() {

    }
}