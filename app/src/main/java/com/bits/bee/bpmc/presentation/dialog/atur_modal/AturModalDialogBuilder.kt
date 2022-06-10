package com.bits.bee.bpmc.presentation.dialog.atur_modal

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bits.bee.bpmc.databinding.DialogAturModalKasirBinding
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by aldi on 09/06/22.
 */
@AndroidEntryPoint
class AturModalDialogBuilder(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogAturModalKasirBinding = DialogAturModalKasirBinding::inflate
) : BaseBottomSheetDialogFragment<DialogAturModalKasirBinding>(){

    override fun initComponents() {

    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {

    }


}