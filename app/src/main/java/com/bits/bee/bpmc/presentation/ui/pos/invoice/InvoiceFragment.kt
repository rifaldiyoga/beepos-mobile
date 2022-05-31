package com.bits.bee.bpmc.presentation.ui.pos.invoice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.databinding.FragmentInvoiceBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.ui.pos.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

/**
 * Created by aldi on 22/04/22.
 */
@AndroidEntryPoint
class InvoiceFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentInvoiceBinding = FragmentInvoiceBinding::inflate
) : BaseFragment<FragmentInvoiceBinding>() {

    private val viewModel : InvoiceViewModel by viewModels()

    private val mainViewModel : MainViewModel by activityViewModels()

    private lateinit var invoiceAdapter: InvoiceAdapter

    override fun initComponents() {
        invoiceAdapter = InvoiceAdapter(
            onItemClicK = { saled ->
                val action = InvoiceFragmentDirections.actionInvoiceFragmentToEditItemDialog(saled)
                findNavController().navigate(action)
            },
            onDeleteClick = {saled ->
                mainViewModel.onDeleteDetail(saled)
            }
        )
        binding.apply {
            rvList.apply {
                adapter = invoiceAdapter
                layoutManager = LinearLayoutManager(requireContext())
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            btnBayar.setOnClickListener {
                viewModel.onClickBayar()
            }
            btnBatal.setOnClickListener {
                viewModel.onClickBatal()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                mainViewModel.viewStates().collect {
                    it?.let {
                        invoiceAdapter.submitList(it.saledList)
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch{
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect {
                    when(it){
                        InvoiceViewModel.UIEvent.RequestBatal -> {
                            findNavController().popBackStack()
                        }
                        InvoiceViewModel.UIEvent.RequestPembayaran -> {
                            val action = InvoiceFragmentDirections.actionInvoiceFragmentToPembayaranFragment()
                            findNavController().navigate(action)
                        }
                    }
                }
            }
        }
    }


}