package com.bits.bee.bpmc.presentation.ui.buka_kasir

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentDetailBukaKasirBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.DialogBuilderUtils
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.CurrencyUtils
import com.bits.bee.bpmc.utils.DateFormatUtils
import com.bits.bee.bpmc.utils.extension.removeSymbol
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.math.BigDecimal
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by aldi on 13/04/22.
 */
@AndroidEntryPoint
class DetailBukaKasirFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailBukaKasirBinding = FragmentDetailBukaKasirBinding::inflate
) : BaseFragment<FragmentDetailBukaKasirBinding>() {

    private val viewModel : DetailBukaKasirViewModel by viewModels()

    private val sharedViewModel : BukaTutupKasirSharedViewModel by activityViewModels()

    override fun initComponents() {
        binding.apply {
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            etModal.addTextChangedListener {
                viewModel.state.modal = etModal.text.toString().trim().removeSymbol()
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
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            sharedViewModel.error.collect{
                showSnackbar(it)
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                sharedViewModel.posPreferences.collect{
                    binding.etModal.hint = CurrencyUtils.formatCurrency(BigDecimal(it.presetBukaKasir))
                    viewModel.state.defaultModal = it.presetBukaKasir
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect {
                    when(it){
                        DetailBukaKasirViewModel.UIEvent.NavigateToDefaultModal -> {
                            val dialog = DialogBuilderUtils.showDialogChoice(requireContext(), getString(
                                R.string.atur_modal_kasir), getString(R.string.msg_default_modal_kasir),
                                getString(R.string.ya), {
                                    viewModel.updateState(
                                        viewModel.state.copy(
                                            modal = viewModel.state.defaultModal
                                        )
                                    )
                                    viewModel.saveBukaKasir()
                                    it.dismiss()
                                },
                                getString(R.string.batal), )
                            dialog.show(parentFragmentManager, "")
                        }
                        DetailBukaKasirViewModel.UIEvent.NavigateToPos -> {
//                            val action = DetailBukaKasirFragmentDirections.actionDetailBukaKasirFragmentToMainActivity()

                        }
                        DetailBukaKasirViewModel.UIEvent.RequestSave -> {
                            sharedViewModel.doBukaKasir(viewModel.state.modal,
                                BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_counter_sesi), 0) as Int
                            )
                        }
                        DetailBukaKasirViewModel.UIEvent.NavigateToInsight -> {
                            val action = DetailBukaKasirFragmentDirections.actionDetailBukaKasirFragmentToInsightPresetKasirFragment()
                            findNavController().navigate(action)
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                sharedViewModel.viewStates().collect {
                    it?.let {
                        binding.apply {
                            it.activeBranch?.let { branch ->
                                tvCabang.text = branch.name
                            }
                            it.activeCashier?.let { cashier ->
                                tvKasir.text = cashier.cashierName
                            }
//                            it.shift?.let {
//                                tvShift.text = it.toString()
//                            }
                            it.listCasha?.let {
                                if (it.isNotEmpty()){
                                    val trxDate = DateFormatUtils.formatStringToDate(BPMConstants.DATE_TIME_FROMAT, it[0].trxDate)
                                    if (SimpleDateFormat("MMdd").format(Date())compareTo(SimpleDateFormat("MMdd").format(trxDate)) > 0){
                                        BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_counter_sesi), 1)
                                    }else{

                                    }
                                }else{
                                    BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_counter_sesi), 1)
                                }
                                tvShift.text = (BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_counter_sesi), 0) as Int).toString()
                            }
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