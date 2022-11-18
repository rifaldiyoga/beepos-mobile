package com.bits.bee.bpmc.presentation.ui.setting_printer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.databinding.FragmentSettingPrinterBinding
import com.bits.bee.bpmc.domain.model.Printer
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.service.BluetoothConnectService
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class SettingPrinterFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSettingPrinterBinding = FragmentSettingPrinterBinding::inflate
): BaseFragment<FragmentSettingPrinterBinding>() {

    private val viewModel : SettingPrinterViewModel by viewModels()
    private lateinit var printerAdapter: PrinterAdapter
    @Inject
    lateinit var bluetoothConnectService: BluetoothConnectService

    override fun initComponents() {
        binding.apply {
            printerAdapter = PrinterAdapter(mListener = object : PrinterAdapter.PilihPrinterI{
                override fun onItemClick(printer: Printer) {
                    val action = SettingPrinterFragmentDirections.actionSettingPrinterFragmentToAddPrinterFragment(printer)
                    findNavController().navigate(action)
                }

            }, bluetoothConnectService)
            binding.apply {
                rvListPrinter.layoutManager = LinearLayoutManager(requireContext())
                rvListPrinter.adapter = printerAdapter
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            btnTambah.setOnClickListener {
                viewModel.onClickAddPrinter()
            }
            floatBtnTambah.setOnClickListener {
                viewModel.onClickAddPrinter()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect { event ->
                    when(event){
                        SettingPrinterViewModel.UIEvent.RequestAddPrinter -> {
                            val action = SettingPrinterFragmentDirections.actionSettingPrinterFragmentToAddPrinterFragment(null)
                            findNavController().navigate(action)
                        }
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.loadPrinter.collect {
                    printerAdapter.submitList(it)
                    validateAdapter(it.isEmpty())
                }
            }
        }
    }

    private fun validateAdapter(isEmpty : Boolean){
        binding.apply {
            if (isEmpty){
                lLBtnEmptyPrinter.visibility = View.VISIBLE
                floatBtnTambah.visibility = View.GONE
            }else{
                lLBtnEmptyPrinter.visibility = View.GONE
                floatBtnTambah.visibility = View.VISIBLE
            }
        }

    }

    private fun initAdapter(data: List<Printer>) {

    }

}