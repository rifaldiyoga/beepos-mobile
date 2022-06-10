package com.bits.bee.bpmc.presentation.ui.setting_printer.add_printer

import android.bluetooth.BluetoothAdapter
import android.net.wifi.WifiManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.data.data_source.local.model.Kitchen
import com.bits.bee.bpmc.data.data_source.local.model.Printer
import com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchen
import com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchenD
import com.bits.bee.bpmc.databinding.FragmentSettingAddPrinterBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.tipe_printer.TipePrinterDialog
import com.bits.bee.bpmc.presentation.dialog.radio_list.RadioListAdapter
import com.bits.bee.bpmc.presentation.ui.setting_printer.list_printer_search.ListPrinter
import com.bits.bee.bpmc.presentation.ui.setting_printer.printer_kitchen.SectionKitchenAdapter
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

private const val TAG = "Tambah Printer"

@AndroidEntryPoint
class AddPrinterFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSettingAddPrinterBinding = FragmentSettingAddPrinterBinding::inflate
): BaseFragment<FragmentSettingAddPrinterBinding>() {

    private val viewModel : AddPrinterViewModel by viewModels()
    private lateinit var ukuranKertasList: List<String>
    private lateinit var radioAdapter: RadioListAdapter
    private var mPrinter: Printer? = null
    var isNew: Boolean = false
    var tipe: Int = 0
    val data_kitchen = false
    private lateinit var sectionKitchenAdapter: SectionKitchenAdapter
    lateinit var mBluetoothAdapter: BluetoothAdapter
    lateinit var mWifiManager: WifiManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            isNew = it.getBoolean("isNew")
            if (!it.getString("printer").equals("null") && it.getString("printer")?.isNotEmpty() == true){
                mPrinter = Gson().fromJson(it.getString("printer"), Printer::class.java)
            }
        }
    }

    override fun initComponents() {
        viewModel.setDataKitchen(BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_switch_dapur), false) as Boolean)
        sectionKitchenAdapter = SectionKitchenAdapter(requireContext())
        binding.apply {
//            if (!swcPrinterKitchen.isChecked){
//
//            }
            rvKitchenPrinter.layoutManager = LinearLayoutManager(requireContext())
            rvKitchenPrinter.adapter = sectionKitchenAdapter
        }
//        loadData()
    }

    override fun subscribeListeners() {
        binding.apply {
            etTipePrinter.setOnClickListener {
                viewModel.onClickShowPrinter()
            }
            btnLanjut.setOnClickListener {
                doSave()
            }
            swcPrinterKitchen.setOnCheckedChangeListener { compoundButton, b ->
                if (b){
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
            if (swcPrinterKitchen.isChecked)
                swcPrinterKitchen.isChecked = false
            else
                swcPrinterKitchen.isChecked = true
            viewKitchen(swcPrinterKitchen.isChecked)
        }

    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.event.collect { event ->
                    when(event){
                        AddPrinterViewModel.UIEvent.RequestTipePrinter -> {
                            val dialog = TipePrinterDialog(
                                { data ->
                                    Toast.makeText(requireContext(), data.toString(), Toast.LENGTH_LONG)
                                        .show()
                                    BeePreferenceManager.saveToPreferences(
                                        requireActivity(), getString(
                                            R.string.pref_tipe_printer
                                        ), data.toString()
                                    )
                                    viewModel.update(
                                        viewModel.state.copy(
                                            tipePrinter = data.toString()
                                        )
                                    )
                                    if (data.equals(resources.getString(R.string.bluetooth_printer))){
                                        val action = AddPrinterFragmentDirections.actionAddPrinterFragmentToListPrinterFragment()
                                        findNavController().navigate(action)
                                        return@TipePrinterDialog
                                    }else{
                                        return@TipePrinterDialog
                                    }
                                },
                                requireContext())
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
                viewModel.viewStates().collect {
                    binding.apply {
                        etNamaPrinter.setText(if(!isNew && mPrinter != null) mPrinter!!.printerName else BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_name_printer), "") as String)
                        etMacAddress.setText(if(!isNew && mPrinter != null) mPrinter!!.address else BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_address_printer), "") as String)
                        swcPrinterKasir.isChecked = if(!isNew && mPrinter != null) mPrinter!!.isReceipt else false
                        swcPrinterKitchen.isChecked = if(!isNew && mPrinter != null) mPrinter!!.isKitchen else false
                        swcPrinterSetoran.isChecked = if(!isNew && mPrinter != null) mPrinter!!.isReport else false
                        etTipePrinter.setText(BeePreferenceManager.getDataFromPreferences(requireContext(), getString(
                            R.string.pref_tipe_printer), "" ) as String)

                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.getPrinterFromPrinterKitchen.collect {
                    it.data?.let { data ->
//                        viewModel.setPrinterKitchenList(data)
                        viewModel.update(
                            viewModel.state.copy(listPrinterKitchen = data)
                        )
                    }
                }
                viewModel.getPrinterKitchenFromDetail.collect {
                    it.data?.let { data ->
//                        viewModel.setPrinterKitchenDList(data)
                        viewModel.update(
                            viewModel.state.copy(listPrinterKitchenD = data)
                        )
                    }
                }
                viewModel.getKitchenId.collect {
                    it.data?.let { data ->
//                        viewModel.setKitchen(data)
                        viewModel.update(
                            viewModel.state.copy(kititchen = data)
                        )
                    }
                }
                viewModel.getItmgrpId.collect {
                    it.data?.let { data ->
//                        viewModel.setItemgrp(data)
                        viewModel.update(
                            viewModel.state.copy(itmgrp = data)
                        )
                    }
                }
                viewModel.printerAddressList.collect {
                    it.data?.let { data ->
                        viewModel.update(
                            viewModel.state.copy(listPrinter = data)
                        )
                    }
                }
                viewModel.getLastIdVal.collect {
                    it.data?.let { data ->
                        viewModel.update(
                            viewModel.state.copy(mPrinter = data)
                        )
                    }
                }
                viewModel.getLastIdPrinterKit.collect {
                    it.data?.let { data ->
                        viewModel.update(
                            viewModel.state.copy(mPrinterKitchen = data)
                        )
                    }
                }
                viewModel.getByPrinter.collect {
                    it.data?.let { data ->
                        viewModel.update(
                            viewModel.state.copy(listPrinterKitchen = data)
                        )
                    }
                }
                viewModel.loadKitchen.collect {
                    it.data?.let { data ->
                        viewModel.update(
                            viewModel.state.copy(listKitchen = data)
                        )
                    }
                }
                viewModel.getItemgrpKitchen.collect {
                    it.data?.let { data ->
                        viewModel.update(
                            viewModel.state.copy(listItemgrp = data)
                        )
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (mPrinter == null)
            viewModel.onClickShowPrinter()
    }

    private fun loadData(){
        binding.apply {
            etNamaPrinter.setText(mPrinter!!.printerName)
            etMacAddress.setText(mPrinter!!.address)
            etTipePrinter.setText(if(mPrinter!!.tipe == 0) R.string.bluetooth_printer else R.string.network_printer)
            swcPrinterKitchen.isChecked = mPrinter!!.isKitchen
            swcPrinterKasir.isChecked = mPrinter!!.isReceipt
            swcPrinterSetoran.isChecked = mPrinter!!.isReport
        }
    }

    private fun tipePrinter(): Int{
        if (binding.etTipePrinter.text.toString().equals(getString(R.string.bluetooth_printer))){
            tipe = 0
        }else if (binding.etTipePrinter.text.toString().equals(getString(R.string.network_printer))){
            tipe = 1
        }
        return tipe
    }

    private fun getNamaPrinter(): String{
        return binding.etNamaPrinter.text.toString()
    }

    private fun getMacAddress(): String{
        return binding.etMacAddress.text.toString()
    }

    fun doSave(){
//        if (isNew){
//            mPrinter = Printer()
//        }
//        radioAdapter.getSelectedPosition()
        binding.apply {
            mPrinter = Printer(
                printerName = getNamaPrinter(),
                address = getMacAddress(),
                tipe = tipePrinter(),
                size = addPrinterRgSize.checkedRadioButtonId.toString(),
                isReceipt = swcPrinterKasir.isChecked,
                isKitchen = swcPrinterKitchen.isChecked,
                isReport = swcPrinterSetoran.isChecked
            )
        }
        if (validateInput()){
            var printerKitchenList: List<PrinterKitchen> = mutableListOf()
            var mListMap: HashMap<Int, MutableList<Kitchen>> = HashMap()
            if (sectionKitchenAdapter != null){
//                viewModel.getDataList()
                printerKitchenList = sectionKitchenAdapter.getPrinterKitchenList()
                mListMap = sectionKitchenAdapter.getPrinterKitchenListmap()
            }
            viewModel.valueIsNewPrinter(mPrinter)
            viewModel.save(mPrinter, printerKitchenList, mListMap)
            Toast.makeText(requireContext(), "Berhasil simpan print", Toast.LENGTH_LONG)
        }else{
            Toast.makeText(requireContext(), "Lengkapi data terlebih dahulu", Toast.LENGTH_LONG)
        }

    }

    private fun validateInput(): Boolean{
        var isValidate = true
        if (getNamaPrinter().isEmpty() && getMacAddress().isEmpty())
            return false
        return isValidate
    }

    private fun viewKitchen(isKitchen: Boolean){
        viewModel.setSectionKitAdapter(sectionKitchenAdapter)
        if (isKitchen){
            binding.apply {
                clQtyDapur.visibility = View.VISIBLE
                rvKitchenPrinter.visibility = View.VISIBLE
            }
            if (!isNew){
                viewModel.setValuePrinter(mPrinter)
                viewModel.setPrinterKitchen()
            }else{
                viewModel.loadKategoriPrinterKit()
            }
            if (sectionKitchenAdapter.itemCount == 0){
                addPrinterKitchen()
            }
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