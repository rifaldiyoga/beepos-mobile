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
import com.bits.bee.bpmc.utils.DateFormatUtils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
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
            viewModel.state.defaultModal = BigDecimal(100000)
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            etModal.addTextChangedListener {
                viewModel.state.modal = BigDecimal(etModal.text.toString().trim())
            }
            btnBukaKasir.setOnClickListener {
                viewModel.onBukaKasirClick()
            }
        }
    }

    override fun subscribeObservers() {
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
                            val action = DetailBukaKasirFragmentDirections.actionDetailBukaKasirFragmentToMainActivity()
                            findNavController().popBackStack()
                            findNavController().navigate(R.id.mainActivity)
                        }
                        DetailBukaKasirViewModel.UIEvent.RequestSave -> {
                            sharedViewModel.doBukaKasir(viewModel.state.modal!!, BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_counter_sesi), 0) as Int)
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
                                if (it.size > 0){
                                    val trxDate = DateFormatUtils.formatStringToDate(BPMConstants.DEFAULT_DATE_FORMAT, it.get(0).trxDate)
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
    }


}