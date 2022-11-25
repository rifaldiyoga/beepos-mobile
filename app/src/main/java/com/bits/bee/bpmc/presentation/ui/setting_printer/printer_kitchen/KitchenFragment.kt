package com.bits.bee.bpmc.presentation.ui.setting_printer.printer_kitchen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentKitchenListBinding
import com.bits.bee.bpmc.domain.model.PrinterKitchen
import com.bits.bee.bpmc.presentation.base.BaseDialogFragment
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by aldi on 14/11/22
 */
@AndroidEntryPoint
class KitchenFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentKitchenListBinding = FragmentKitchenListBinding::inflate
) : BaseDialogFragment<FragmentKitchenListBinding>() {

    private val viewModel : KitchenViewModel by viewModels()

    private lateinit var kitchenAdapter: KitchenAdapter
    var printerKitchen : PrinterKitchen? = null

    override fun getTheme(): Int = R.style.DialogTheme

    override fun initComponents() {
        arguments?.let {
            printerKitchen = it.getParcelable("printerKitchen")
            viewModel.updateState(
                viewModel.state.copy(
                    printerKitchen = printerKitchen
                )
            )
        }
        viewModel.loadData()
        binding.apply {
            toolbar.setNavigationOnClickListener {
                findNavController().popBackStack()
            }
            kitchenAdapter = KitchenAdapter {
                viewModel.onItemClick(it)
            }
            rvListPrinter.apply {
                layoutManager = LinearLayoutManager(requireActivity())
                adapter = kitchenAdapter
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            btnSimpan.setOnClickListener {
                printerKitchen?.let {
                    it.kitchenList = viewModel.state.kitchenList.filter { it.isUsed }.toMutableList()
                    findNavController().previousBackStackEntry?.savedStateHandle?.set("printerKitchen", printerKitchen)
                    findNavController().popBackStack()
                }
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.viewStates().collect {
                it?.let { state ->
                    kitchenAdapter.submitList(state.kitchenList)
                }
            }
        }
    }
}