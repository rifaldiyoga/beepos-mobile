package com.bits.bee.bpmc.presentation.ui.pos.invoice_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentInvoiceListBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.DialogBuilderHelper
import com.bits.bee.bpmc.presentation.ui.pos.MainViewModel
import com.bits.bee.bpmc.presentation.ui.pos.invoice.InvoiceFragmentDirections
import com.bits.bee.bpmc.presentation.ui.pos.pos.PosFragmentDirections
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.BeePreferenceManager
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.math.BigDecimal

/**
 * Created by aldi on 03/08/22.
 */

class InvoiceListFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentInvoiceListBinding = FragmentInvoiceListBinding::inflate
) : BaseFragment<FragmentInvoiceListBinding>() {

    private val viewModel : InvoiceListViewModel by viewModels()

    private val mainViewModel : MainViewModel by activityViewModels()

    private lateinit var invoiceAdapter: InvoiceAdapter

    private var page = "invoice"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.let {
            page = it.getString("page") ?: "invoice"
        }
        super.onViewCreated(view, savedInstanceState)
    }

    override fun initComponents() {
        binding.apply {
            invoiceAdapter = InvoiceAdapter(
                onItemClicK = { saled ->
                    val action = if (page == "invoice" && BeePreferenceManager.ORIENTATION == BPMConstants.SCREEN_POTRAIT)
                        InvoiceFragmentDirections.actionInvoiceFragmentToEditItemDialog(saled)
                    else
                        PosFragmentDirections.actionPosFragmentToEditItemDialog2(saled)

                    findNavController().navigate(action)
                },
                onDeleteClick = { saled ->
                    val dialog = DialogBuilderHelper.showDialogChoice(
                        requireContext(),
                        title = getString(R.string.hapus_produk),
                        msg = getString(R.string.msg_hapus_produk),
                        positiveTxt = getString(R.string.ya),
                        positiveListener = {
                            it.dismiss()
                            mainViewModel.onDeleteDetail(saled)
                            if(mainViewModel.state.saledList.isEmpty()) {
                                if(mainViewModel.orientation.value == BPMConstants.SCREEN_POTRAIT && page == "invoice")
                                    findNavController().popBackStack()
                                showSnackbar("Tidak ada data detail!")
                            }
                        },
                        negativeTxt = getString(R.string.batal),
                        negativeListener = {
                            it.dismiss()
                        }
                    )
                    dialog.show(parentFragmentManager, "")
                },
                modePos = mainViewModel.posModeState.value,
                saleAddOnList = mainViewModel.saleTrans.addOnTrans?.getListDetail() ?: mutableListOf()
            )
            rvList.apply {
                adapter = invoiceAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
        }
    }

    override fun subscribeListeners() {
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                mainViewModel.viewStates().collectLatest {
                    it?.let {
                        binding.apply {
                            invoiceAdapter.submitList(it.saledList.filter { !it.isAddOn })
                            invoiceAdapter.submitSaleAddOnDList(mainViewModel.saleTrans.addOnTrans?.getListDetail() ?: mutableListOf())

                        }
                    }
                }
            }
        }
    }
}