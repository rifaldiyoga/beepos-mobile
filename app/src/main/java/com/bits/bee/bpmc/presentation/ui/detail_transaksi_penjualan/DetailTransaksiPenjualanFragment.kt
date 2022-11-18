package com.bits.bee.bpmc.presentation.ui.detail_transaksi_penjualan

import android.view.*
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentDetailTransaksiPenjualanBinding
import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.printer.helper.PrinterHelper
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.DialogBuilderHelper
import com.bits.bee.bpmc.presentation.ui.home.HomeViewModel
import com.bits.bee.bpmc.presentation.ui.pos.PosModeState
import com.bits.bee.bpmc.presentation.ui.pos.invoice_list.InvoiceAdapter
import com.bits.bee.bpmc.presentation.ui.transaksi_penjualan.TransaksiPenjualanFragmentDirections
import com.bits.bee.bpmc.presentation.ui.transaksi_penjualan.TransaksiPenjualanViewModel
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.CurrencyUtils
import com.bits.bee.bpmc.utils.Utils
import com.bits.bee.bpmc.utils.extension.gone
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

/**
 * Created by aldi on 23/06/22.
 */
@AndroidEntryPoint
class DetailTransaksiPenjualanFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailTransaksiPenjualanBinding = FragmentDetailTransaksiPenjualanBinding::inflate
) : BaseFragment<FragmentDetailTransaksiPenjualanBinding>() {

    private val viewModel : DetailTransaksiPenjualanViewModel by viewModels()

    private val parentViewModel : TransaksiPenjualanViewModel by viewModels({requireParentFragment()})

    private val activityViewModel : HomeViewModel by activityViewModels()

    private lateinit var detailAdapter : InvoiceAdapter

    private val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())

    @Inject
    lateinit var printerHelper: PrinterHelper

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_void, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_void -> {
                if(!viewModel.state.sale!!.isVoid) {
                    viewModel.onClickVoid()
                } else {
                    val dialog = DialogBuilderHelper.showDialogInfo(requireActivity(), getString(R.string.informasi), "Transaksi sudah dibatalkan!", positiveListener = {it.dismiss()})
                    dialog.show(parentFragmentManager, "")
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun initComponents() {
        arguments?.let {
            val sale = it.getParcelable<Sale>("sale")
            viewModel.updateState(
                viewModel.state.copy(
                    sale = sale
                )
            )
            viewModel.getSaledList()
        }
        setHasOptionsMenu(true)
        detailAdapter = InvoiceAdapter(
            onItemClicK = {},
            onDeleteClick = {},
            isDelete = false,
            modePos = activityViewModel.posModeState.value
        )
        binding.apply {
            if(activityViewModel.posModeState.value is PosModeState.FnBState)
                groupSalesman.gone()

            rvList.apply {
                adapter = detailAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }

            findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<Sale>("sale")?.observe(viewLifecycleOwner) { sale ->
                viewModel.updateState(
                    viewModel.state.copy(sale = sale)
                )
                binding.apply {
                    setToolbarTitle(sale.trxNo)
                    tvTotal.text = getString(R.string.mata_uang_nominal, viewModel.state.crc?.symbol, CurrencyUtils.formatCurrency(sale.total))
                    tvKasir.text = sale.cashiername
                    tvMember.text = sale.bpName
                    tvPajak.text = getString(R.string.mata_uang_nominal, viewModel.state.crc?.symbol, CurrencyUtils.formatCurrency(sale.taxAmt))
                    tvDiskon.text =  getString(R.string.mata_uang_nominal, viewModel.state.crc?.symbol, CurrencyUtils.formatCurrency(sale.discAmt))
                    tvPembulatan.text = getString(R.string.mata_uang_nominal, viewModel.state.crc?.symbol, CurrencyUtils.formatCurrency(sale.rounding))
                    tvSubtotal.text = getString(R.string.mata_uang_nominal, viewModel.state.crc?.symbol, CurrencyUtils.formatCurrency(sale.subtotal))
                    tvTanggal.text = dateFormat.format(sale.trxDate)
                    tvJenisPembayaran.text = Utils.getTermType(requireActivity(), sale.termType)
                    tvChannel.text = sale.channel
                    tvSalesman.text = sale.salesman

                    btnCetak.isEnabled = sale.isVoid
                    if(sale.isVoid) {
                        btnCetak.background = ContextCompat.getDrawable(requireActivity(), R.drawable.btn_rect_disable)
                    } else {
                        btnCetak.background = ContextCompat.getDrawable(requireActivity(), R.drawable.btn_rect_primary)
                    }
                    groupSurc.isVisible = sale.termType != BPMConstants.BPM_DEFAULT_TYPE_TUNAI
                    if (sale.termType != BPMConstants.BPM_DEFAULT_TYPE_TUNAI) {
                        var totalSurc: BigDecimal = BigDecimal.ZERO
                        viewModel.state.saleCrcvList.forEach {
                            totalSurc += BigDecimal(it.surcAmt)
                        }
                        tvSurcharge.text = getString(
                            R.string.mata_uang_nominal,
                            viewModel.state.crc?.symbol,
                            CurrencyUtils.formatCurrency(totalSurc)
                        )
                    }
                }
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            btnCetak.setOnClickListener {
                viewModel.onClickPrint()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect { state ->
                    state?.let {
                        it.sale?.let { sale ->
                            binding.apply {
                                setToolbarTitle(sale.trxNo)
                                tvTotal.text = getString(R.string.mata_uang_nominal, viewModel.state.crc?.symbol, CurrencyUtils.formatCurrency(sale.total))
                                tvKasir.text = sale.cashiername
                                tvMember.text = sale.bpName
                                tvPajak.text = getString(R.string.mata_uang_nominal, viewModel.state.crc?.symbol, CurrencyUtils.formatCurrency(sale.taxAmt))
                                tvDiskon.text =  getString(R.string.mata_uang_nominal, viewModel.state.crc?.symbol, CurrencyUtils.formatCurrency(sale.discAmt))
                                tvPembulatan.text = getString(R.string.mata_uang_nominal, viewModel.state.crc?.symbol, CurrencyUtils.formatCurrency(sale.rounding))
                                tvSubtotal.text = getString(R.string.mata_uang_nominal, viewModel.state.crc?.symbol, CurrencyUtils.formatCurrency(sale.subtotal))
                                tvTanggal.text = dateFormat.format(sale.trxDate)
                                tvJenisPembayaran.text = Utils.getTermType(requireActivity(), sale.termType)
                                tvChannel.text = sale.channel
                                tvSalesman.text = sale.salesman

                                btnCetak.isEnabled = !sale.isVoid
                                if(sale.isVoid) {
                                    btnCetak.background = ContextCompat.getDrawable(requireActivity(), R.drawable.btn_rect_disable)
                                } else {
                                    btnCetak.background = ContextCompat.getDrawable(requireActivity(), R.drawable.btn_rect_primary)
                                }
                                groupSurc.isVisible = sale.termType != BPMConstants.BPM_DEFAULT_TYPE_TUNAI
                                if (sale.termType != BPMConstants.BPM_DEFAULT_TYPE_TUNAI) {
                                    var totalSurc: BigDecimal = BigDecimal.ZERO
                                    state.saleCrcvList.forEach {
                                        totalSurc += BigDecimal(it.surcAmt)
                                    }
                                    tvSurcharge.text = getString(
                                        R.string.mata_uang_nominal,
                                        viewModel.state.crc?.symbol,
                                        CurrencyUtils.formatCurrency(totalSurc)
                                    )
                                }
                            }
                        }
                        detailAdapter.submitList(it.saledList)
                        if(it.saleAddOnDList.isNotEmpty())
                            detailAdapter.submitSaleAddOnDList(it.saleAddOnDList)
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.event.collect{
                when(it){
                    DetailTransaksiPenjualanViewModel.UIEvent.SuccessVoid -> {
                        viewModel.state.sale?.let {
//                            parentViewModel.updateActiveSale(it.copy(isVoid = true))
                        }
                    }
                    DetailTransaksiPenjualanViewModel.UIEvent.NavigateToHapusTransaksi -> {
//                        val dialog = HapusTransaksiDialog(onFinish = {
//                            viewModel.updateState(
//                                viewModel.state.copy(sale = it)
//                            )
//                        })
//                        dialog.show(parentFragmentManager, "")
                        val action = if(BeePreferenceManager.ORIENTATION == BPMConstants.SCREEN_LANDSCAPE)
                            TransaksiPenjualanFragmentDirections.actionTransaksiPenjualanFragmentToHapusTransaksiDialog(viewModel.state.sale!!)
                        else DetailTransaksiPenjualanFragmentDirections.actionDetailTransaksiPenjualanFragmentToHapusTransaksiDialog(viewModel.state.sale!!)
                        findNavController().navigate(action)
                    }
                    DetailTransaksiPenjualanViewModel.UIEvent.ReqPrint -> {
                        printerHelper.printInvoiceDuplicate(requireActivity(), viewModel.state.sale!!)
                    }
                }
            }
        }
        if (BeePreferenceManager.ORIENTATION == BPMConstants.SCREEN_LANDSCAPE) {
            viewLifecycleOwner.lifecycleScope.launch {
                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    parentViewModel.activeSale.collect { sale ->
                        binding.group.isVisible = sale != null
                        viewModel.updateState(
                            viewModel.state.copy(sale = sale)
                        )
                        viewModel.getSaledList()
                    }
                }
            }
        }
    }
}