package com.bits.bee.bpmc.presentation.dialog.detail_pendapatan

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bits.bee.bpmc.databinding.DialogDetailMemberBinding
import com.bits.bee.bpmc.databinding.DialogDetailPendapatanBinding
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import com.bits.bee.bpmc.presentation.dialog.detail_member.DetailMemberViewModel
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.sql.Date
import java.text.SimpleDateFormat

@AndroidEntryPoint
class DetailPendapatanDialog(
    private val mPosses: Posses,
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogDetailPendapatanBinding = DialogDetailPendapatanBinding::inflate
): BaseBottomSheetDialogFragment<DialogDetailPendapatanBinding>() {

    private val viewModel : DetailPendapatanViewModel by viewModels()

    override fun initComponents() {
        viewModel.updateState(
            viewModel.state.copy(
                posses = mPosses
            )
        )
    }

    override fun subscribeListeners() {
        binding.apply {
            imgViewClose.setOnClickListener {
                dismiss()
            }
            buttonClosed.setOnClickListener {
                dismiss()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    binding.apply {
                        it?.let {
                            it.posses?.let {
                                tvTotalIncome.text = it.total.toString()
                                tvModal.text = it.startBal.toString()
                                tvPemasukan.text = it.totIn.toString()
                                tvPengeluaran.text = it.totOut.toString()
                            }
                        }
                    }
                }
            }
        }
    }

}