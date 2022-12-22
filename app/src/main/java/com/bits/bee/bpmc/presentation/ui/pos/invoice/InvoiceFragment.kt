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
import com.bits.bee.bpmc.presentation.dialog.DialogBuilderHelper
import com.bits.bee.bpmc.presentation.ui.pos.MainViewModel
import com.bits.bee.bpmc.presentation.ui.pos.pos.PosFragmentDirections
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.CurrencyUtils
import com.bits.bee.bpmc.utils.extension.gone
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.math.BigDecimal

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
        menu.clear()
        inflater.inflate(R.menu.menu_pos, menu)
        if(BeePreferenceManager.ORIENTATION == BPMConstants.SCREEN_POTRAIT) {
            menu.findItem(R.id.menu_draft).isVisible = false
            menu.findItem(R.id.menu_search).isVisible = false
        }
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

                        if(it.saledList.isEmpty() && BeePreferenceManager.ORIENTATION == BPMConstants.SCREEN_POTRAIT) {
                            viewModel.onDetailEmpty()
                        }
                        if(it.sale.total < BigDecimal.ZERO){
                            val dialog = DialogBuilderHelper.showDialogInfo(requireActivity(), "Informasi", "Subtotal tidak boleh minus, transaksi akan langsung direset!", positiveListener = {
                                mainViewModel.resetState()
                                it.dismiss()
                            })
                            dialog.show(parentFragmentManager, "")
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch{
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect {
                    when(it){
                        InvoiceViewModel.UIEvent.RequestBatal -> {
                            val dialog = DialogBuilderHelper.showDialogChoice (
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
                                    mainViewModel.resetState()
                                    mainViewModel.sendMessage(getString(R.string.berhasil_batal_transaksi))
                                    if(mainViewModel.orientation.value == BPMConstants.SCREEN_POTRAIT)
                                        findNavController().popBackStack()
                                }
                            )
                            dialog.show(parentFragmentManager, "")
                        }
                        InvoiceViewModel.UIEvent.RequestPembayaran -> {
                            if (mainViewModel.state.saledList.isEmpty()) {
                                showSnackbar("Detail Kosong!")
                            } else {
                                val action = when (BeePreferenceManager.ORIENTATION) {
                                    BPMConstants.SCREEN_POTRAIT -> InvoiceFragmentDirections.actionInvoiceFragmentToPembayaranFragment()
                                    else -> PosFragmentDirections.actionPosFragmentToPembayaranFragment()
                                }
                                findNavController().navigate(action)
                            }
                        }
                        InvoiceViewModel.UIEvent.RequestDraft -> {
                            val dialog = DialogBuilderHelper.showDialogChoice(
                                requireContext(),
                                title = getString(R.string.simpan_sebagai_draft),
                                msg = getString(R.string.msg_draft),
                                positiveTxt = getString(R.string.simpan),
                                positiveListener = {
                                    it.dismiss()
                                    if (mainViewModel.state.saledList.isEmpty()) {
                                        showSnackbar("Detail Kosong!")
                                    } else {
                                        mainViewModel.submitDraft(requireActivity())
                                        if (mainViewModel.orientation.value == BPMConstants.SCREEN_POTRAIT)
                                            findNavController().popBackStack()
                                    }
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
                            val action = when (BeePreferenceManager.ORIENTATION) {
                                BPMConstants.SCREEN_POTRAIT -> InvoiceFragmentDirections.actionInvoiceFragmentToKlaimPromoFragment()
                                else -> PosFragmentDirections.actionPosFragmentToKlaimPromoFragment()
                            }
                            findNavController().navigate(action)
                        }
                    }
                }
            }
        }
    }
}