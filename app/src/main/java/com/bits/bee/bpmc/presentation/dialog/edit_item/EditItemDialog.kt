package com.bits.bee.bpmc.presentation.dialog.edit_item

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bits.bee.bpmc.databinding.DialogEditItemBinding
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by aldi on 25/05/22.
 */
@AndroidEntryPoint
class EditItemDialog(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogEditItemBinding = DialogEditItemBinding::inflate
) : BaseBottomSheetDialogFragment<DialogEditItemBinding>() {

    private val viewModel : EditItemViewModel by viewModels()

    override fun initComponents() {

    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {

    }

}