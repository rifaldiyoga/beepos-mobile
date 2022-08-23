package com.bits.bee.bpmc.presentation.ui.pos.invoice

import android.view.*
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentInvoiceBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.ui.pos.MainViewModel
import com.bits.bee.bpmc.utils.CurrencyUtils
import com.bits.bee.bpmc.utils.extension.gone
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_pos, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_draft -> {
                mainViewModel.onClickDraft()
            }
            R.id.menu_diskon -> {
                mainViewModel.onClickDiskonNota()
            }
            R.id.menu_search -> {
                mainViewModel.onClickSearch()
            }
            R.id.menu_promo -> {
                mainViewModel.onClickPromo()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun initComponents() {
        setHasOptionsMenu(true)
        binding.apply {
            clPromo.gone()

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
            btnDraft.setOnClickListener {
                viewModel.onClickDraft(mainViewModel.state.sale, mainViewModel.state.saledList)
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                mainViewModel.viewStates().collect {
                    it?.let {
                        binding.apply {
                            tvDiskon.text = getString(R.string.mata_uang_nominal, it.crc?.symbol ?: "",CurrencyUtils.formatCurrency(it.sale.discAmt))
                            tvPajak.text = getString(R.string.mata_uang_nominal, it.crc?.symbol ?: "",CurrencyUtils.formatCurrency(it.sale.taxAmt))
                            tvSubtotal.text = getString(R.string.mata_uang_nominal, it.crc?.symbol ?: "",CurrencyUtils.formatCurrency(it.sale.subtotal))
                            tvRounding.text = getString(R.string.mata_uang_nominal, it.crc?.symbol ?: "",CurrencyUtils.formatCurrency(it.sale.rounding))
                            tvTotal.text = getString(R.string.mata_uang_nominal, it.crc?.symbol ?: "",CurrencyUtils.formatCurrency(it.sale.total))
                        }
                        if(it.saledList.size == 0){
                            viewModel.onDetailEmpty()
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.error.collect {
                    showSnackbar(it)
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch{
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect {
                    when(it){
                        InvoiceViewModel.UIEvent.RequestBatal -> {
                            findNavController().popBackStack()
                            mainViewModel.resetState()
                        }
                        InvoiceViewModel.UIEvent.RequestPembayaran -> {
                            val action = InvoiceFragmentDirections.actionInvoiceFragmentToPembayaranFragment()
                            findNavController().navigate(action)
                        }
                        InvoiceViewModel.UIEvent.RequestDraft -> {
                            findNavController().popBackStack()
                        }
                        InvoiceViewModel.UIEvent.NavigatePos -> {
                            findNavController().popBackStack()
                        }
                    }
                }
            }
        }
    }
}