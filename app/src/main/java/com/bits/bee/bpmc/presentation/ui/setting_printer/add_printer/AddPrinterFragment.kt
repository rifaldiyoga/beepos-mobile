package com.bits.bee.bpmc.presentation.ui.setting_printer.add_printer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentSettingAddPrinterBinding
import com.bits.bee.bpmc.domain.model.Kitchen
import com.bits.bee.bpmc.domain.model.Printer
import com.bits.bee.bpmc.domain.model.PrinterKitchen
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.tipe_printer.TipePrinterDialog
import com.bits.bee.bpmc.presentation.ui.setting_printer.list_printer_search.PrinterDevice
import com.bits.bee.bpmc.presentation.ui.setting_printer.printer_kitchen.SectionKitchenAdapter
import com.bits.bee.bpmc.utils.BeePreferenceManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

const val TAG = "Tambah Printer"

@AndroidEntryPoint
class AddPrinterFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSettingAddPrinterBinding = FragmentSettingAddPrinterBinding::inflate
): BaseFragment<FragmentSettingAddPrinterBinding>() {

    private val viewModel : AddPrinterViewModel by viewModels()

    var isNew: Boolean = false
    var tipe: Int = 0
    private var data_kitchen = false
    private lateinit var sectionKitchenAdapter: SectionKitchenAdapter

    override fun initComponents() {
        arguments?.let {
            val printer = it.getParcelable<Printer>("printer")
            printer?.let {
                viewModel.updateState(
                    viewModel.state.copy(
                        mPrinter = printer
                    )
                )
            }
        }
        binding.apply {
            data_kitchen = BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_switch_dapur), false) as Boolean
            viewModel.updateState(
                viewModel.state.copy(data_kitchen = data_kitchen)
            )
            sectionKitchenAdapter = SectionKitchenAdapter(requireContext())
            rvKitchenPrinter.layoutManager = LinearLayoutManager(requireContext())
            rvKitchenPrinter.adapter = sectionKitchenAdapter
        }
        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<PrinterDevice>("printer")?.observe(viewLifecycleOwner) {
            val printer = viewModel.state.mPrinter ?: Printer()
            viewModel.updateState(
                viewModel.state.copy(
                    mPrinter = printer.copy(
                        printerName = it.nama,
                        address = it.address
                    )
                )
            )
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            etTipePrinter.setOnClickListener {
                viewModel.onClickShowPrinter()
            }
            swcPrinterKasir.setOnClickListener {
                viewModel.onClickPrinterKasir()
            }
            swcPrinterSetoran.setOnClickListener {
                viewModel.onClickPrinterSetoran()
            }
            btnSimpanEdit.setOnClickListener {
                viewModel.doSave()
            }
            swcPrinterKitchen.setOnCheckedChangeListener { _, b ->
                if (b){
                    viewKitchen(swcPrinterKitchen.isChecked)
                }else{
                    viewKitchen(swcPrinterKitchen.isChecked)
                }
            }
            addPrinterKitIvPlus.setOnClickListener {
                addPrinterKitchen()
            }
            addPrinterKitIvMinus.setOnClickListener {
                sectionKitchenAdapter.delePrinterKitchen()
                if(sectionKitchenAdapter.itemCount == 0)
                    doIsKitchen()
                else
                    reloadQtyPrinterKitchen()
            }
        }
    }

    private fun doIsKitchen(){
        binding.apply {
            swcPrinterKitchen.isChecked = !swcPrinterKitchen.isChecked
            viewKitchen(swcPrinterKitchen.isChecked)
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.event.collect { event ->
                    when(event){
                        AddPrinterViewModel.UIEvent.RequestTipePrinter -> {
                            val dialog = TipePrinterDialog(onSaveClick = { data ->
                                    Toast.makeText(requireContext(), data, Toast.LENGTH_LONG).show()
                                    val printer = viewModel.state.mPrinter ?: Printer()
                                    viewModel.updateState(
                                        viewModel.state.copy(
                                            tipePrinter = data,
                                            mPrinter = printer.copy(
                                                tipe = getTipePrinter(data)
                                            )
                                        )
                                    )

                                    if (data == resources.getString(R.string.bluetooth_printer)){
                                        val action = AddPrinterFragmentDirections.actionAddPrinterFragmentToListPrinterFragment()
                                        findNavController().navigate(action)
                                        return@TipePrinterDialog
                                    } else{
                                        return@TipePrinterDialog
                                    }
                                }, requireContext())
                            dialog.show(parentFragmentManager, TAG)
                        }
                        AddPrinterViewModel.UIEvent.RequestSimpan ->{
                            val action = AddPrinterFragmentDirections.actionAddPrinterFragmentToSettingPrinterFragment()
                            findNavController().navigate(action)
                        }
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.viewStates().collect { state ->
                    state?.let {
                        binding.apply {
                            it.mPrinter?.let {
                                etNamaPrinter.setText(it.printerName)
                                etMacAddress.setText(it.address)
                                etTipePrinter.setText(state.tipePrinter)

                                rbSize1.isChecked = it.size == getString(R.string.kertas58)
                                rbSize2.isChecked = it.size == getString(R.string.kertas80)
                                swcPrinterKasir.isChecked =  it.isReceipt
                                swcPrinterKitchen.isChecked =  it.isKitchen
                                swcPrinterSetoran.isChecked =  it.isReport
                            }
                            btnSimpanEdit.background =
                                if(state.mPrinter != null)
                                    ContextCompat.getDrawable(requireActivity(), R.drawable.btn_rect_primary)
                                else
                                    ContextCompat.getDrawable(requireActivity(), R.drawable.btn_rect_disable)

                            btnTesPrint.isVisible = state.mPrinter != null && state.mPrinter!!.printerName.isNotEmpty() && state.mPrinter!!.address.isNotEmpty()
                        }
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (viewModel.state.mPrinter == null)
            viewModel.onClickShowPrinter()
    }

    private fun loadSectionKitchenFlow(isKitchen: Boolean) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.viewStates().collect {
                    binding.apply {
                        it?.let {
                            if (isKitchen){
                                clQtyDapur.visibility = View.VISIBLE
                                rvKitchenPrinter.visibility = View.VISIBLE
                                it.listKitchen.let { data ->
                                    sectionKitchenAdapter.setKitchenList(data)
                                }
                                if(!isNew){
                                    it.listPrinterKitchen.let { dataPrinter ->
                                        var listkit: MutableList<Kitchen> = mutableListOf()
                                        listkit.add(Kitchen(id=2, code=null, name="OTG", branchId=0, createdBy=0, createdAt=0, updatedBy=0, updatedAt=0, isUsed=false))
                                        it.listhashMap?.let { dataMap ->
                                            dataMap[0] = listkit
                                            dataMap[1] = listkit
                                            sectionKitchenAdapter.initList(dataPrinter, dataMap)
                                        }
                                    }
                                }

                                if (!isNew){
                                    it.listhashMap.let {
                                        if (sectionKitchenAdapter.itemCount == 0){
                                            addPrinterKitchen()
                                        }
                                    }
                                } else {
                                    it.listKitchen?.let {
                                        if (sectionKitchenAdapter.itemCount == 0){
                                            addPrinterKitchen()
                                        }
                                    }
                                }

                            }else{
                                clQtyDapur.visibility = View.GONE
                                rvKitchenPrinter.visibility = View.GONE
                            }
                        }
                    }
                }
            }
        }
    }

    private fun getTipePrinter(tipe : String): Int =
        when(tipe){
            getString(R.string.bluetooth_printer) -> 0
            getString(R.string.network_printer) -> 1
            else -> -1
        }

    private fun getNamaPrinter(): String{
        return binding.etNamaPrinter.text.toString()
    }

    private fun getMacAddress(): String{
        return binding.etMacAddress.text.toString()
    }

    private fun validateInput(): Boolean{
        var isValidate = true
        if (getNamaPrinter().isEmpty() && getMacAddress().isEmpty())
            return false
        return isValidate
    }

    private fun viewKitchen(isKitchen: Boolean){
        loadSectionKitchenFlow(isKitchen)
        if (isKitchen){
            binding.apply {
//                clQtyDapur.visibility = View.VISIBLE
//                rvKitchenPrinter.visibility = View.VISIBLE
            }
            if (!isNew){
//                viewModel.setPrinterKitchen(mPrinter)
//                sectionKitchenAdapter.initList(viewModel.state.listPrinterKitchen!!, viewModel.state.listKitchen!!)
            }else{
//                viewModel.loadKategoriPrinterKit()
//                sectionKitchenAdapter.setKitchenList(viewModel.state.listKitchen!!)
//                viewModel.getMutable()
            }
//            if (sectionKitchenAdapter.itemCount == 0){
//                addPrinterKitchen()
//            }
        }else{
            binding.apply {
                clQtyDapur.visibility = View.GONE
                rvKitchenPrinter.visibility = View.GONE
            }
        }
    }

    private fun reloadQtyPrinterKitchen(){
        binding.tvQty.text = sectionKitchenAdapter.itemCount.toString()
    }

    private fun addPrinterKitchen(){
        val pritnterKitchen = PrinterKitchen(kitchenName = "Makanan")
        sectionKitchenAdapter.addPrinterKitchen(pritnterKitchen)

        reloadQtyPrinterKitchen()

    }

}