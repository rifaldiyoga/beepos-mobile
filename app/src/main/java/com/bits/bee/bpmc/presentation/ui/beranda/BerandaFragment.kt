package com.bits.bee.bpmc.presentation.ui.beranda

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentBerandaBinding
import com.bits.bee.bpmc.domain.printer.helper.PrinterHelper
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.DialogBuilderHelper
import com.bits.bee.bpmc.presentation.ui.buka_kasir.BukaTutupKasirSharedViewModel
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.CurrencyUtils
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.math.BigDecimal
import javax.inject.Inject

/**
 * Created by aldi on 13/04/22.
 */
const val TAG = "BerandaFragment"
@AndroidEntryPoint
class BerandaFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentBerandaBinding = FragmentBerandaBinding::inflate
) : BaseFragment<FragmentBerandaBinding>() {

    private val viewModel : BerandaViewModel by viewModels()
    private val sharedViewModel : BukaTutupKasirSharedViewModel by activityViewModels()
    private var mCounter: Int = 0

    @Inject
    lateinit var printerHelper : PrinterHelper

    override fun onResume() {
        super.onResume()
        sharedViewModel.getActivePosses()
    }

    override fun initComponents() {
        val isFirstRun = BeePreferenceManager.getDataFromPreferences(requireActivity(), getString(R.string.is_first_run), true) as Boolean

        if(isFirstRun){
            val action = BerandaFragmentDirections.actionBerandaFragmentToDownloadDialogBuilder()
            findNavController().navigate(action)
            BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.is_first_run), false)
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            tvDetail.setOnClickListener {
                if(sharedViewModel.state.activePosses == null) {
                    viewModel.onDetailBukaKasirClick()
                } else {
                    viewModel.onDetailTutupKasirClick()
                }
            }
            btnBukaKasir.setOnClickListener {
                if(sharedViewModel.state.activePosses == null) {
                    viewModel.onBukaKasirClick()
                } else {
                    val dialog = DialogBuilderHelper.showDialogYesNo(requireContext(),
                        getString(R.string.tutup_kasir), getString(R.string.msg_validasi_tutup_kasir), {
                            it.dismiss()
                            viewModel.onTutupKasirClick()
                        })
                    dialog.show(parentFragmentManager, "DetailTutupKasirFragment")
                }
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                sharedViewModel.viewStates().collect {
                    it?.let {
                        it.activeCashier?.let {
                            binding.tvGreeting.text = getString(R.string.halo_kasir_2, it.cashierName)
                        }
                        it.activeBranch?.let {
                            binding.tvKota.text = getString(R.string.di_surabaya, it.name)
                        }

                        viewModel.state.isBukaKasir = it.activePosses != null
                        if(it.activePosses != null){
                            binding.apply {
                                groupPendapatan.visible()
                                tvInfoKasir.text = getString(R.string.klik_tutup_kasir_untuk_mengakhiri_shift_3_ya, it.activePosses!!.shift)
                                btnBukaKasir.text = getString(R.string.tutup_kasir)
                                tvTotalPendapatan.text = CurrencyUtils.formatCurrency(it.activePosses!!.totIn ?: BigDecimal.ZERO)
                            }
                        } else {
                            binding.apply {
                                val shift = BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_counter_sesi), 1) as Int
                                groupPendapatan.gone()
                                tvInfoKasir.text = getString(R.string.klik_buka_kasir_untuk_memulai_shift_3_ya, shift)
                                btnBukaKasir.text = getString(R.string.buka_kasir)
                            }
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect {
                    when(it){
                        BerandaViewModel.UIEvent.NavigateToBukaKasir -> {
                            val action = BerandaFragmentDirections.actionBerandaFragmentToDetailBukaKasirFragment()
                            findNavController().navigate(action)
                        }
                        BerandaViewModel.UIEvent.NavigateToTutupKasir -> {
                            val action = BerandaFragmentDirections.actionBerandaFragmentToDetailTutupKasirFragment()
                            findNavController().navigate(action)
                        }
                        BerandaViewModel.UIEvent.NavigateToDialogBukaKasir -> {
                            val state = sharedViewModel.state

                            val shift = BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_counter_sesi), 1) as Int
                            val dialog = BerandaFragmentDirections.actionBerandaFragmentToAturModalDialogBuilder(state.activeCashier!!, state.activeBranch!!, shift )
                            findNavController().navigate(dialog)
//                            dialog.show(parentFragmentManager, TAG)
                        }
                        BerandaViewModel.UIEvent.ReqTutupKasir -> {
                            mCounter = BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_counter_sesi), 1) as Int
                            mCounter++
                            BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_counter_sesi), mCounter)
                            sharedViewModel.doTutupKasir()
                            printerHelper.printClosingCashier(sharedViewModel.state.activePosses!!, BPMConstants.BPM_FONT_REGULAR, BPMConstants.BPM_ALIGN_LEFT)
                            sharedViewModel.resetActivePosses()
                        }
                    }
                }
            }
        }
    }

}