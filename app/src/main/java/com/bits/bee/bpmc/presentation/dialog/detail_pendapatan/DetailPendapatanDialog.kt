package com.bits.bee.bpmc.presentation.dialog.detail_pendapatan

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.DialogDetailPendapatanBinding
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import com.bits.bee.bpmc.utils.CurrencyUtils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.math.BigDecimal

@AndroidEntryPoint
class DetailPendapatanDialog(
    private val mPosses: Posses,
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogDetailPendapatanBinding = DialogDetailPendapatanBinding::inflate
): BaseBottomSheetDialogFragment<DialogDetailPendapatanBinding>() {

    private val viewModel : DetailPendapatanViewModel by viewModels()
    private var bigDecimalZero: BigDecimal = BigDecimal("0")

    override fun initComponents() {
        viewModel.updateState(
            viewModel.state.copy(
                posses = mPosses
            )
        )
    }

    override fun subscribeListeners() {
        binding.apply {
            imageView2.setOnClickListener {
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
                                tvTotalIncome.text = getString(
                                    R.string.mata_uang_nominal,
                                    "Rp", CurrencyUtils.formatCurrency(it.total.add(it.startBal)))
                                tvModal.text = getString(
                                    R.string.mata_uang_nominal,
                                    "Rp", CurrencyUtils.formatCurrency(it.startBal))
                                tvPemasukan.text = getString(
                                    R.string.mata_uang_nominal,
                                    "Rp", CurrencyUtils.formatCurrency(it.totIn ?: BigDecimal.ZERO))
                                tvPengeluaran.text = getString(
                                    R.string.mata_uang_nominal,
                                    "Rp", CurrencyUtils.formatCurrency(it.totOut ?: BigDecimal.ZERO))
                                viewModel.getValueDetail()
                            }

                            it.totalTunai?.let {
                                tvTotalTunai.text = getString(R.string.mata_uang_nominal,
                                    "Rp", CurrencyUtils.formatCurrency(it ?: bigDecimalZero))
                            }
                            it.totalDebit?.let {
                                tvTotalDebit.text = getString(R.string.mata_uang_nominal,
                                    "Rp", CurrencyUtils.formatCurrency(it ?: bigDecimalZero))
                            }
                            it.totalGopay?.let {
                                tvTotalGopay.text = getString(R.string.mata_uang_nominal,
                                    "Rp", CurrencyUtils.formatCurrency(it ?: bigDecimalZero))
                                tvTotalNonTunai.text = getString(R.string.mata_uang_nominal,
                                    "Rp", CurrencyUtils.formatCurrency(viewModel.getTotalNonTunai() ?: bigDecimalZero))
                            }
                        }
                    }
                }
            }
        }
    }

}