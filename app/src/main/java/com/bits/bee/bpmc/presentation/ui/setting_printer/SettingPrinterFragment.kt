package com.bits.bee.bpmc.presentation.ui.setting_printer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bits.bee.bpmc.databinding.FragmentSettingPrinterBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.data.data_source.local.model.Printer
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.ProcessBuilder.Redirect.to

@AndroidEntryPoint
class SettingPrinterFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> com.bits.bee.bpmc.databinding.FragmentSettingPrinterBinding = FragmentSettingPrinterBinding::inflate
): BaseFragment<FragmentSettingPrinterBinding>() {

    private val viewModel : SettingPrinterViewModel by viewModels()
    private lateinit var printerAdapter: PrinterAdapter

    override fun initComponents() {
//        printerAdapter = PrinterAdapter()
//        binding.apply {
//            rvListPrinter.layoutManager = LinearLayoutManager(requireContext())
//            rvListPrinter.adapter = printerAdapter
//        }
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
                            val action = SettingPrinterFragmentDirections.actionSettingPrinterFragmentToAddPrinterFragment(true, Gson().toJson(null))
                            findNavController().navigate(action)
                        }
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.loadPrinter.collect {
                    it.data?.let { data ->
                        viewModel.loadFromState(data)
                        initAdapter(viewModel.get())
                        validateAdapter()
                    }
//                    when(it.status){
//                        Resource.Status.SUCCESS ->{
//                        }
//                        Resource.Status.ERROR -> {
//                            val error = ""
//                        }
//                    }
                }
            }
        }
    }

    private fun validateAdapter(){
        binding.apply {
            if (viewModel.get().isEmpty()){
                lLBtnEmptyPrinter.visibility = View.VISIBLE
                floatBtnTambah.visibility = View.GONE
            }else{
                lLBtnEmptyPrinter.visibility = View.GONE
                floatBtnTambah.visibility = View.VISIBLE
            }
        }

    }

    private fun initAdapter(data: List<Printer>) {
        printerAdapter = PrinterAdapter(data, mListener = object : PrinterAdapter.PilihPrinterI{
            override fun onItemClick(printer: Printer) {
                val action = SettingPrinterFragmentDirections.actionSettingPrinterFragmentToAddPrinterFragment(false, Gson().toJson(printer))
                findNavController().navigate(action)
            }

        })
        binding.apply {
            rvListPrinter.layoutManager = LinearLayoutManager(requireContext())
            rvListPrinter.adapter = printerAdapter
        }
    }

//    override fun onResume() {
//        super.onResume()
//        validateAdapter()
////        printerAdapter.setPrinterList(viewModel.get())
//    }


}