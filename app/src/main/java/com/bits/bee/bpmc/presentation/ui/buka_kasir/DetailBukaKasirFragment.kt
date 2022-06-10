package com.bits.bee.bpmc.presentation.ui.buka_kasir

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bits.bee.bpmc.databinding.FragmentDetailBukaKasirBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.CustomDialogBuilder
import com.bits.bee.bpmc.presentation.dialog.DialogBuilderUtils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.math.BigDecimal

/**
 * Created by aldi on 13/04/22.
 */
@AndroidEntryPoint
class DetailBukaKasirFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentDetailBukaKasirBinding = FragmentDetailBukaKasirBinding::inflate
) : BaseFragment<FragmentDetailBukaKasirBinding>() {

    private val viewModel : DetailBukaKasirViewModel by viewModels()

    override fun initComponents() {
        binding.apply {

        }
    }

    override fun subscribeListeners() {
        binding.apply {
            etModal.addTextChangedListener {
                viewModel.state.modal = BigDecimal(etModal.text.toString().trim())
            }
            btnBukaKasir.setOnClickListener {
                viewModel.onBukaKasir()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect {
                    when(it){
                        DetailBukaKasirViewModel.UIEvent.NavigateToDefaultModal -> {
                            DialogBuilderUtils.showDialogChoice(requireContext(), "", "", "", {}, "", {})
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