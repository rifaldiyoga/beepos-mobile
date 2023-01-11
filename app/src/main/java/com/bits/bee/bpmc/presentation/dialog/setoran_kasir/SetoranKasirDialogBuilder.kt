package com.bits.bee.bpmc.presentation.dialog.setoran_kasir

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.DialogSetoranKasirBinding
import com.bits.bee.bpmc.domain.printer.helper.PrinterHelper
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import com.bits.bee.bpmc.presentation.dialog.DialogBuilderHelper
import com.bits.bee.bpmc.presentation.ui.buka_kasir.BukaTutupKasirSharedViewModel
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.extension.addNumberFormatChange
import com.bits.bee.bpmc.utils.extension.removeSymbol
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by aldi on 09/06/22.
 */
@AndroidEntryPoint
class SetoranKasirDialogBuilder(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogSetoranKasirBinding = DialogSetoranKasirBinding::inflate,
) : BaseBottomSheetDialogFragment<DialogSetoranKasirBinding>(){

    private val viewModel : SetoranKasirViewModel by viewModels()
    private val sharedViewModel : BukaTutupKasirSharedViewModel by activityViewModels()
    private var mCounter: Int = 0

    @Inject
    lateinit var printerHelper : PrinterHelper

    override fun initComponents() {
        binding.apply{
            etModal.addNumberFormatChange()
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            etModal.addTextChangedListener {
                viewModel.state.setoran = etModal.text.toString().removeSymbol()
            }
            btnBukaKasir.setOnClickListener {
                viewModel.onBukaKasirClick()
            }
            imageView2.setOnClickListener {
                dismiss()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect {
                    when(it){
                        SetoranKasirViewModel.UIEvent.NavigateToPos -> {
                        }
                        SetoranKasirViewModel.UIEvent.NavigateToDefaultModal -> {

                        }
                        SetoranKasirViewModel.UIEvent.RequestSave -> {
                            if(viewModel.state.setoran.isNotEmpty()) {
                                viewLifecycleOwner.lifecycleScope.launchWhenStarted {
                                    mCounter = BeePreferenceManager.getDataFromPreferences(
                                        requireContext(),
                                        getString(R.string.pref_counter_sesi),
                                        1
                                    ) as Int
                                    mCounter++
                                    BeePreferenceManager.saveToPreferences(
                                        requireContext(),
                                        getString(R.string.pref_counter_sesi),
                                        mCounter
                                    )
                                    sharedViewModel.doTutupKasir(
                                        viewModel.state.setoran.removeSymbol()
                                            .toBigDecimal()
                                    )
                                    printerHelper.printClosingCashier(
                                        sharedViewModel.state.activePosses!!,
                                        BPMConstants.BPM_FONT_REGULAR,
                                        BPMConstants.BPM_ALIGN_LEFT
                                    )
                                    sharedViewModel.resetActivePosses()
                                    findNavController().popBackStack()
                                }
                            } else {
                                Toast.makeText(requireContext(), "Nominal setoran tidak boleh kosong!", Toast.LENGTH_LONG).show()
                            }
                        }
                        SetoranKasirViewModel.UIEvent.NavigateToInsight -> {

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