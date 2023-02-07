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
                viewModel.viewStates().collect { state ->
                    binding.apply {
                        state?.let {
                            it.posses?.let {

                                viewModel.getValueDetail()
                                var totalIncome = CurrencyUtils.formatCurrency(it.total.add(it.startBal))
                                var startBal = CurrencyUtils.formatCurrency(it.startBal)
                                var pemasukan = CurrencyUtils.formatCurrency(it.totIn ?: BigDecimal.ZERO)
                                var pengeluaran = CurrencyUtils.formatCurrency(it.totOut ?: BigDecimal.ZERO)
                                var totalTunai = CurrencyUtils.formatCurrency(state.totalTunai)
                                var totalDebit = CurrencyUtils.formatCurrency(state.totalDebit)
                                var totalGopay = CurrencyUtils.formatCurrency(state.totalGopay)
                                var totalNonTunai = CurrencyUtils.formatCurrency(viewModel.getTotalNonTunai())
//                                if(viewModel.possesActualCashReg.first()?.value == "1"){
//                                    totalIncome = totalIncome.replaceNumberWithStars()
//                                    startBal = startBal.replaceNumberWithStars()
//                                    pemasukan = pemasukan.replaceNumberWithStars()
//                                    pengeluaran = pengeluaran.replaceNumberWithStars()
//                                    totalTunai = totalTunai.replaceNumberWithStars()
//                                    totalDebit = totalDebit.replaceNumberWithStars()
//                                    totalGopay = totalGopay.replaceNumberWithStars()
//                                    totalNonTunai = totalNonTunai.replaceNumberWithStars()
//
//                                }

                                tvTotalIncome.text = getString(R.string.mata_uang_nominal, "Rp", totalIncome)
                                tvModal.text = getString(R.string.mata_uang_nominal, "Rp", startBal)
                                tvPemasukan.text = getString(R.string.mata_uang_nominal, "Rp", pemasukan)
                                tvPengeluaran.text = getString(R.string.mata_uang_nominal, "Rp", pengeluaran)
                                tvTotalTunai.text = getString(R.string.mata_uang_nominal, "Rp", totalTunai)
                                tvTotalDebit.text = getString(R.string.mata_uang_nominal, "Rp", totalDebit)
                                tvTotalGopay.text = getString(R.string.mata_uang_nominal, "Rp", totalGopay)
                                tvTotalNonTunai.text = getString(R.string.mata_uang_nominal, "Rp", totalNonTunai)
                            }

                        }
                    }
                }
            }
        }
    }
}