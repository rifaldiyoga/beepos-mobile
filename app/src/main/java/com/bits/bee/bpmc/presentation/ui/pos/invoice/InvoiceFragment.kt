package com.bits.bee.bpmc.presentation.ui.pos.invoice

import android.view.*
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentInvoiceBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.DialogBuilderUtils
import com.bits.bee.bpmc.presentation.ui.pos.MainViewModel
import com.bits.bee.bpmc.utils.CurrencyUtils
import com.bits.bee.bpmc.utils.extension.gone
import dagger.hilt.android.AndroidEntryPoint
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
                viewModel.onClickDraft()
            }
            clPromo.setOnClickListener {
                viewModel.onClickPromo()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                mainViewModel.viewStates().collect {
                    it?.let {
                        binding.apply {

                            clPromo.isVisible = mainViewModel.listPromoBonus.size > 0
                            tvPromo.text = getString(R.string.anda_mendapatkan_promo, mainViewModel.listPromoBonus.size)

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
                            val dialog = DialogBuilderUtils.showDialogChoice (
                                requireContext(),
                                title = getString(R.string.batalkan_transaksi),
                                msg = getString(R.string.msg_batalkan_transaksi),
                                positiveTxt = getString(R.string.lanjut_bayar),
                                positiveListener = {
                                    it.dismiss()
                                },
                                negativeTxt = getString(R.string.batalkan),
                                negativeListener = {
                                    it.dismiss()
                                    findNavController().popBackStack()
                                    mainViewModel.resetState()
                                }
                            )
                            dialog.show(parentFragmentManager, "")
                        }
                        InvoiceViewModel.UIEvent.RequestPembayaran -> {
                            val action = InvoiceFragmentDirections.actionInvoiceFragmentToPembayaranFragment()
                            findNavController().navigate(action)
                        }
                        InvoiceViewModel.UIEvent.RequestDraft -> {
                            val dialog = DialogBuilderUtils.showDialogChoice(
                                requireContext(),
                                title = getString(R.string.simpan_sebagai_draft),
                                msg = getString(R.string.msg_draft),
                                positiveTxt = getString(R.string.simpan),
                                positiveListener = {
                                    it.dismiss()
                                    mainViewModel.submitDraft(requireActivity())
                                    findNavController().popBackStack()
                                    mainViewModel.resetState()
                                },
                                negativeTxt = getString(R.string.batal),
                                negativeListener = {
                                    it.dismiss()
                                }
                            )
                            dialog.show(parentFragmentManager, "")
                        }
                        InvoiceViewModel.UIEvent.NavigatePos -> {
                            findNavController().popBackStack()
                        }
                        InvoiceViewModel.UIEvent.NavigateKlaimPromo -> {
                            val action = InvoiceFragmentDirections.actionInvoiceFragmentToKlaimPromoFragment()
                            findNavController().navigate(action)
                        }
                    }
                }
            }
        }
    }
}