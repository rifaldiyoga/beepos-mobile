package com.bits.bee.bpmc.presentation.dialog.hapus_transaksi

import android.view.LayoutInflater
import android.view.ViewGroup
import com.bits.bee.bpmc.databinding.DialogHapusTransaksiBinding
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by aldi on 03/11/22
 */
@AndroidEntryPoint
class HapusTransaksiDialog(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogHapusTransaksiBinding = DialogHapusTransaksiBinding::inflate
) : BaseBottomSheetDialogFragment<DialogHapusTransaksiBinding>() {

    override fun initComponents() {
        binding.apply {

        }
    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {

    }


}