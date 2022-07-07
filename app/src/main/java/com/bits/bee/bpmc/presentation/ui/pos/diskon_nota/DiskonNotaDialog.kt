package com.bits.bee.bpmc.presentation.ui.pos.diskon_nota

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bits.bee.bpmc.databinding.DialogDiskonNotaBinding
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import com.bits.bee.bpmc.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by aldi on 27/06/22.
 */
@AndroidEntryPoint
class DiskonNotaDialog(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogDiskonNotaBinding = DialogDiskonNotaBinding::inflate
) : BaseBottomSheetDialogFragment<DialogDiskonNotaBinding>() {

    private val viewModel : DiskonNotaViewModel by viewModels()

    override fun initComponents() {
        binding.apply {

        }
    }

    override fun subscribeListeners() {
        binding.apply {
            btnBatal.setOnClickListener {
                dismiss()
            }
            btnTambah.setOnClickListener {
                dismiss()
            }
        }
    }

    override fun subscribeObservers() {

    }

}