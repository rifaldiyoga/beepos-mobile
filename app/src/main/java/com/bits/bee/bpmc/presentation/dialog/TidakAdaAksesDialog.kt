package com.bits.bee.bpmc.presentation.dialog

import android.app.Dialog
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bits.bee.bpmc.databinding.DialogTidakAdaAksesBinding
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment

/**
 * Created by aldi on 28/03/22.
 */
class TidakAdaAksesDialog(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogTidakAdaAksesBinding = DialogTidakAdaAksesBinding::inflate,
    private val onClick : (Dialog) -> Unit
) : BaseBottomSheetDialogFragment<DialogTidakAdaAksesBinding>() {

    override fun initComponents() {

    }

    override fun subscribeListeners() {
        binding.apply {
            imagClose.setOnClickListener {
                dismiss()
            }
            btnClose.setOnClickListener {
                onClick(dialog!!)
            }
        }
    }

    override fun subscribeObservers() {

    }


}