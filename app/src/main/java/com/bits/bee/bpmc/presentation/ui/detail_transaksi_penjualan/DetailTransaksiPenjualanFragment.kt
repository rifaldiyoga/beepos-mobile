package com.bits.bee.bpmc.presentation.ui.detail_transaksi_penjualan

import android.view.*
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentDetailTransaksiPenjualanBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.ui.pos.invoice_list.InvoiceAdapter
import com.bits.bee.bpmc.presentation.ui.transaksi_penjualan.TransaksiPenjualanViewModel
import com.bits.bee.bpmc.utils.CurrencyUtils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by aldi on 23/06/22.
 */
@AndroidEntryPoint
class DetailTransaksiPenjualanFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailTransaksiPenjualanBinding = FragmentDetailTransaksiPenjualanBinding::inflate
) : BaseFragment<FragmentDetailTransaksiPenjualanBinding>() {

    private val viewModel : DetailTransaksiPenjualanViewModel by viewModels()

    private val parentViewModel : TransaksiPenjualanViewModel by viewModels({requireParentFragment()})

    private lateinit var detailAdapter : InvoiceAdapter
    private val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_void, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_void -> {
                viewModel.onClickVoid()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun initComponents() {
        setHasOptionsMenu(true)
        detailAdapter = InvoiceAdapter(
            onItemClicK = {},
            onDeleteClick = {},
            isDelete = false,
        )
        binding.apply {
            rvList.apply {
                adapter = detailAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
        }
    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    it?.let {
                        it.sale?.let { sale ->
                            binding.apply {
                                setToolbarTitle(sale.trxNo)
                                tvTotal.text = CurrencyUtils.formatCurrency(sale.total)
                                tvKasir.text = sale.cashiername
                                tvMember.text = sale.bpName
                                tvPajak.text = CurrencyUtils.formatCurrency(sale.taxAmt)
                                tvDiskon.text = CurrencyUtils.formatCurrency(sale.discAmt)
                                tvPembulatan.text = CurrencyUtils.formatCurrency(sale.rounding)
                                tvSubtotal.text = CurrencyUtils.formatCurrency(sale.subtotal)
                                tvTanggal.text = dateFormat.format(sale.trxDate)

                                btnCetak.isEnabled = sale.isVoid
                                if(sale.isVoid) {
                                    btnCetak.background = ContextCompat.getDrawable(requireActivity(), R.drawable.btn_rect_disable)
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
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){

            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                parentViewModel.activeSale.collect{
                    binding.group.isVisible = it != null
                    viewModel.updateState(
                        viewModel.state.copy(sale = it)
                    )
                    viewModel.getSaledList()
                }
            }
        }
    }
}