package com.bits.bee.bpmc.presentation.dialog.atur_modal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.DialogAturModalKasirBinding
import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.domain.model.Cashier
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import com.bits.bee.bpmc.presentation.dialog.DialogBuilderHelper
import com.bits.bee.bpmc.presentation.ui.buka_kasir.BukaTutupKasirSharedViewModel
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.CurrencyUtils
import com.bits.bee.bpmc.utils.extension.addNumberFormatChange
import com.bits.bee.bpmc.utils.extension.append
import com.bits.bee.bpmc.utils.extension.removeSymbol
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.math.BigDecimal

/**
 * Created by aldi on 09/06/22.
 */
@AndroidEntryPoint
class AturModalDialogBuilder(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogAturModalKasirBinding = DialogAturModalKasirBinding::inflate
) : BaseBottomSheetDialogFragment<DialogAturModalKasirBinding>(){

    private val viewModel : AturModalViewModel by viewModels()
    private val sharedViewModel : BukaTutupKasirSharedViewModel by activityViewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {
            val cashier : Cashier? = it.getParcelable("cashier")
            val branch : Branch? = it.getParcelable("branch")
            val shift : Int = it.getInt("shift")

            viewModel.updateState(
                viewModel.state.copy(
                    activeCashier = cashier,
                    activeBranch = branch,
                    shift = shift
                )
            )
        }
    }

    override fun initComponents() {
        binding.apply{
            tvInfo.text = ""
            tvInfo.append(getString(R.string.bagaimana_caranya_agar_saya_bisa_mengubah_modal_kasir_pelajari_selengkapnya_disini))
            tvInfo.append(" Pelajari selengkapnya disini", R.color.red)

            etModal.addNumberFormatChange()
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            etModal.addTextChangedListener {
                viewModel.state.modal = etModal.text.toString().removeSymbol()
            }
            btnBukaKasir.setOnClickListener {
                viewModel.onBukaKasirClick()
            }
            llInfo.setOnClickListener {
                viewModel.onInsight()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                sharedViewModel.posPreferences.collect {
                    binding.etModal.hint = CurrencyUtils.formatCurrency(BigDecimal(it.presetBukaKasir))
                    viewModel.state.defaultModal = it.presetBukaKasir
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect {
                    when(it){
                        AturModalViewModel.UIEvent.NavigateToPos -> {
                        }
                        AturModalViewModel.UIEvent.NavigateToDefaultModal -> {
                            val dialog = DialogBuilderHelper.showDialogChoice(requireContext(), getString(
                                R.string.atur_modal_kasir),
                                getString(R.string.msg_default_modal_kasir, getString(R.string.mata_uang_nominal, sharedViewModel.state.crc?.symbol ?: "", CurrencyUtils.formatCurrency(BigDecimal(viewModel.state.defaultModal)))),
                                getString(R.string.ya), {
                                    it.dismiss()
                                    viewModel.updateState(
                                        viewModel.state.copy(
                                            modal = viewModel.state.defaultModal
                                        )
                                    )
                                    viewModel.saveBukaKasir()
                                },
                                getString(R.string.batal), )
                            dialog.show(parentFragmentManager, "")
                        }
                        AturModalViewModel.UIEvent.RequestSave -> {
                            val shift = BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_counter_sesi), 1) as Int
                            sharedViewModel.doBukaKasir(viewModel.state.modal, shift)
                            viewModel.onDoneSave()
                        }
                        AturModalViewModel.UIEvent.NavigateToInsight -> {
                            val action = AturModalDialogBuilderDirections.actionAturModalDialogBuilderToInsightPresetKasirFragment()
                            findNavController().navigate(action)
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            sharedViewModel.event.collect {
                when(it){
                    BukaTutupKasirSharedViewModel.UIEvent.NavigateToPos -> {
                        findNavController().popBackStack()
                        findNavController().navigate(R.id.mainActivity)
                    }
                }
            }
        }
    }


}