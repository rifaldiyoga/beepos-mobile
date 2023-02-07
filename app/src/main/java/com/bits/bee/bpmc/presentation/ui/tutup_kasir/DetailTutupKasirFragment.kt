package com.bits.bee.bpmc.presentation.ui.tutup_kasir

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentDetailTutupKasirBinding
import com.bits.bee.bpmc.domain.printer.helper.PrinterHelper
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.DialogBuilderHelper
import com.bits.bee.bpmc.presentation.ui.buka_kasir.BukaTutupKasirSharedViewModel
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.CurrencyUtils
import com.bits.bee.bpmc.utils.DateFormatUtils
import com.bits.bee.bpmc.utils.replaceNumberWithStars
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import java.math.BigDecimal
import java.sql.Date
import javax.inject.Inject

/**
 * Created by aldi on 13/04/22.
 */
@AndroidEntryPoint
class DetailTutupKasirFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailTutupKasirBinding = FragmentDetailTutupKasirBinding::inflate
) : BaseFragment<FragmentDetailTutupKasirBinding>() {

    private val viewModel : DetailTutupKasirViewModel by viewModels()
    private val sharedViewModel : BukaTutupKasirSharedViewModel by activityViewModels()
    private var mCounter: Int = 0

    @Inject
    lateinit var printerHelper: PrinterHelper

    override fun initComponents() {
//        setHasOptionsMenu(true)
        binding.apply {

        }
    }

    override fun subscribeListeners() {
        binding.apply {
            btnTutupKasir.setOnClickListener {
                val dialog = DialogBuilderHelper.showDialogYesNo(requireContext(),
                    getString(R.string.tutup_kasir), getString(R.string.msg_validasi_tutup_kasir), {
                        it.dismiss()
                        viewModel.onTutupKasir()
                    })
                dialog.show(parentFragmentManager, "DetailTutupKasirFragment")
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect { event  ->
                    when(event){
                        DetailTutupKasirViewModel.UIEvent.RequestSave -> {
                            mCounter = BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_counter_sesi), 1) as Int
                            mCounter++
                            BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_counter_sesi), mCounter)
                            sharedViewModel.doTutupKasir()
                            printerHelper.printClosingCashier(sharedViewModel.state.activePosses!!)
                            sharedViewModel.resetActivePosses()
                            findNavController().popBackStack()
                        }
                        DetailTutupKasirViewModel.UIEvent.RequestRekapSesi ->{
                            val action = DetailTutupKasirFragmentDirections.actionDetailTutupKasirFragmentToRekapSesiFragment()
                            findNavController().navigate(action)
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                sharedViewModel.viewStates().collect {
                    binding.apply {
                        it?.let {
                            it.activeBranch?.let { branch ->
                                tvCabang.text = branch.name
                            }
                            it.activeCashier?.let { cashier ->
                                tvKasir.text = cashier.cashierName
                            }
                            it.activePosses?.let {
                                var modal = CurrencyUtils.formatCurrency(it.startBal)
                                var pemasukan = CurrencyUtils.formatCurrency(it.totIn)
                                var pengeluaran = CurrencyUtils.formatCurrency(it.totOut)
                                var saldoAkhir = CurrencyUtils.formatCurrency(it.startBal + (it.totIn ?: BigDecimal.ZERO) - (it.totOut ?: BigDecimal.ZERO))
                                sharedViewModel.possesActualCashReg.first()?.let {
                                    if(it.value == "1") {
                                        modal = modal.replaceNumberWithStars()
                                        pemasukan = pemasukan.replaceNumberWithStars()
                                        pengeluaran = pengeluaran.replaceNumberWithStars()
                                        saldoAkhir = saldoAkhir.replaceNumberWithStars()
                                    }
                                }
                                tvModal.text = modal
                                tvPemasukan.text = pemasukan
                                tvPengeluaran.text = pengeluaran
                                tvSaldoAkhir.text = saldoAkhir
                                tvShift.text = it.shift.toString()

                                val startTime = Date(it.startTime.time)
                                tvMulaiOperasional.text = DateFormatUtils.formatDateToString(
                                    BPMConstants.DEFAULT_DATE_FORMAT, startTime)
                                sharedViewModel.getUser()
                            }
                            it.user?.let {
                                tvUserKasir.text = it.name
                            }
                        }
                    }
                }
            }
        }
    }

//    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
//        super.onCreateOptionsMenu(menu, inflater)
//        inflater.inflate(R.menu.menu_analisa_sesi, menu)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when(item.itemId){
//            R.id.menu_list -> viewModel.onCLickMenu()
//        }
//        return super.onOptionsItemSelected(item)
//    }

}