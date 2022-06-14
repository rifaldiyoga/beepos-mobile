package com.bits.bee.bpmc.presentation.ui.tutup_kasir

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentDetailTutupKasirBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.DialogBuilderUtils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.math.BigDecimal

/**
 * Created by aldi on 13/04/22.
 */
@AndroidEntryPoint
class DetailTutupKasirFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailTutupKasirBinding = FragmentDetailTutupKasirBinding::inflate
) : BaseFragment<FragmentDetailTutupKasirBinding>() {

    private val viewModel : DetailTutupKasirViewModel by viewModels()

    override fun initComponents() {
        binding.apply {
            viewModel.state.defaultModal = BigDecimal(100000)
        }
    }

    override fun subscribeListeners() {
        binding.apply {
//            etModal.addTextChangedListener {
//                viewModel.state.modal = BigDecimal(etModal.text.toString().trim())
//            }
//            btnBukaKasir.setOnClickListener {
//                viewModel.onBukaKasir()
//            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect {
                    when(it){
                        DetailTutupKasirViewModel.UIEvent.NavigateToDefaultModal -> {
                            val dialog = DialogBuilderUtils.showDialogChoice(requireContext(), getString(
                                R.string.atur_modal_kasir), getString(R.string.msg_default_modal_kasir),
                                getString(R.string.ya), {
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
                        DetailTutupKasirViewModel.UIEvent.NavigateToPos -> {
//                            val action = DetailBukaKasirFragmentDirections.actionDetailBukaKasirFragmentToMainActivity()
//                            findNavController().navigate(action)
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    it?.let {
                        it.branch?.let { branch ->
                            binding.tvCabang.text = branch.name
                        }
                        it.cashier?.let { cashier ->
                            binding.tvKasir.text = cashier.cashierName
                        }
                        binding.tvShift.text = it.shift.toString()
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.getActiveBranch.collect {
                    it?.let {
                        viewModel.updateState(
                            viewModel.state.copy(
                                branch = it
                            )
                        )
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.getActiveCashier.collect {
                    it?.let {
                        viewModel.updateState(
                            viewModel.state.copy(
                                cashier = it
                            )
                        )
                    }
                }
            }
        }
    }


}