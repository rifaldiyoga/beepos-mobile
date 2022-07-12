package com.bits.bee.bpmc.presentation.ui.setting_printer.add_printer

import android.bluetooth.BluetoothAdapter
import android.net.wifi.WifiManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentSettingAddPrinterBinding
import com.bits.bee.bpmc.domain.model.Kitchen
import com.bits.bee.bpmc.domain.model.Printer
import com.bits.bee.bpmc.domain.model.PrinterKitchen
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.tipe_printer.TipePrinterDialog
import com.bits.bee.bpmc.presentation.ui.setting_printer.list_printer_search.ListPrinterFragmentDirections
import com.bits.bee.bpmc.presentation.ui.setting_printer.printer_kitchen.SectionKitchenAdapter
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

const val TAG = "Tambah Printer"

@AndroidEntryPoint
class AddPrinterFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSettingAddPrinterBinding = FragmentSettingAddPrinterBinding::inflate
): BaseFragment<FragmentSettingAddPrinterBinding>() {

    private val viewModel : AddPrinterViewModel by viewModels()
    private var mPrinter: Printer? = null
    var isNew: Boolean = false
    var isScan: Boolean = false
    var tipe: Int = 0
    var data_kitchen = false
    private lateinit var sectionKitchenAdapter: SectionKitchenAdapter
    lateinit var mBluetoothAdapter: BluetoothAdapter
    lateinit var mWifiManager: WifiManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            isNew = it.getBoolean("isNew")
            if (!it.getString("printer").equals("null") && it.getString("printer")?.isNotEmpty() == true){
                mPrinter = Gson().fromJson(it.getString("printer"), Printer::class.java)
            }
            data_kitchen = BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_switch_dapur), false) as Boolean
            viewModel.updateState(
                viewModel.state.copy(data_kitchen = data_kitchen)
            )
        }
        viewModel.loadKategoriPrinterKit()
        if (!isNew){
            viewModel.setPrinterKitchen(mPrinter)
        }

    }

    override fun initComponents() {
        isScan = BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_is_scan), false) as Boolean
        if (!isScan){
            var sharedPreferences = PreferenceManager.getDefaultSharedPreferences(requireContext()).edit()
            sharedPreferences.remove(getString(R.string.pref_name_printer))
            sharedPreferences.remove(getString(R.string.pref_address_printer))
            sharedPreferences.commit()
        }
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
                                    viewModel.updateState(
                                        viewModel.state.copy(
                                            tipePrinter = data.toString()
                                        )
                                    )
                                    if (data.equals(resources.getString(R.string.bluetooth_printer))){
                                        val action = AddPrinterFragmentDirections.actionAddPrinterFragmentToListPrinterFragment()
                                        findNavController().navigate(action)
                                    }else{
                                        return@TipePrinterDialog
                                    }
                                },
                                requireContext())
                            dialog.show(parentFragmentManager, TAG)
//                            val action = AddPrinterFragmentDirections.actionAddPrinterFragmentToListPrinterFragment()
//                            findNavController().navigate(action)
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
                        it?.let {
//                            if (isKitchen){
//                                if (isNew){
//                                    it.listKitchen?.let { data ->
//                                        sectionKitchenAdapter.setKitchenList(data)
//                                    }
//                                    btnLanjut.visibility = View.VISIBLE
//                                    btnSimpanEdit.visibility = View.GONE
//                                    btnTesPrint.visibility = View.GONE
//                                }else{
//                                    it.listKitchen?.let { data ->
//                                        data.add(Kitchen(id=2, code=null, name="OTG", branchId=0, createdBy=0, createdAt=0, updatedBy=0, updatedAt=0, isUsed=false))
//                                        data.add(Kitchen(id=5, code=null, name="Keyboard", branchId=0, createdBy=0, createdAt=0, updatedBy=0, updatedAt=0, isUsed=false))
//                                        sectionKitchenAdapter.setKitchenList(data)
//                                    }
//                                    it.listPrinterKitchen?.let { data ->
//                                        sectionKitchenAdapter.setPrinterKitchenList(data)
//                                    }
//                                    btnLanjut.visibility = View.GONE
//                                    btnSimpanEdit.visibility = View.VISIBLE
//                                    btnTesPrint.visibility = View.VISIBLE
//                                }
////                                clQtyDapur.visibility = View.VISIBLE
////                                rvKitchenPrinter.visibility = View.VISIBLE
//                                if (sectionKitchenAdapter.itemCount == 0){
//                                    addPrinterKitchen()
//                                }
//                            }else{
////                                clQtyDapur.visibility = View.GONE
////                                rvKitchenPrinter.visibility = View.GONE
//                            }
                            etNamaPrinter.setText(if(!isNew && mPrinter != null) mPrinter!!.printerName else BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_name_printer), "") as String)
                            etMacAddress.setText(if(!isNew && mPrinter != null) mPrinter!!.address else BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_address_printer), "") as String)
                            if (mPrinter != null && mPrinter!!.size.equals(getString(R.string.kertas58)))
                                rbSize1.isChecked = if (!isNew) true else false
                            else if (mPrinter != null && mPrinter!!.size.equals(getString(R.string.kertas80)))
                                rbSize2.isChecked = if (!isNew) true else false
                            else {
                                rbSize1.isChecked = false
                                rbSize2.isChecked = false
                            }
                            swcPrinterKasir.isChecked = if(!isNew && mPrinter != null) mPrinter!!.isReceipt else false
                            swcPrinterKitchen.isChecked = if(!isNew && mPrinter != null) mPrinter!!.isKitchen else false
                            swcPrinterSetoran.isChecked = if(!isNew && mPrinter != null) mPrinter!!.isReport else false
                            etTipePrinter.setText(BeePreferenceManager.getDataFromPreferences(requireContext(), getString(
                                R.string.pref_tipe_printer), "" ) as String)

                            btnLanjut.visibility = if (isNew) View.VISIBLE else View.GONE
                            btnSimpanEdit.visibility = if (isNew) View.GONE else View.VISIBLE
                            btnTesPrint.visibility = if (isNew) View.GONE else View.VISIBLE
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
//                viewModel.loadKitchen.collect {
//                    it.data?.let { data ->
//                        viewModel.updateState(
//                            viewModel.state.copy(listKitchen = data)
//                        )
//                    }
//                }
//                viewModel.getItemgrpKitchen.collect {
//                    it.data?.let { data ->
//                        viewModel.updateState(
//                            viewModel.state.copy(listItemgrp = data)
//                        )
//                    }
//                }
//                viewModel.kitchenList.collect {
//                    it.data?.let { data ->
//                        viewModel.updateState(
//                            viewModel.state.copy(listKitchen = data)
//                        )
//                    }
//                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (mPrinter == null)
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
                                it.listKitchen?.let { data ->
                                    sectionKitchenAdapter.setKitchenList(data)
                                }
                                if(!isNew){
                                    it.listPrinterKitchen?.let { dataPrinter ->
                                        var listkit: MutableList<Kitchen> = mutableListOf()
                                        listkit.add(Kitchen(id=2, code=null, name="OTG", branchId=0, createdBy=0, createdAt=0, updatedBy=0, updatedAt=0, isUsed=false))
                                        it.listhashMap?.let { dataMap ->
                                            dataMap.put(0, listkit)
                                            dataMap.put(1, listkit)
                                            sectionKitchenAdapter.initList(dataPrinter, dataMap)
                                        }
                                    }
                                }

                                if (!isNew){
                                    it.listhashMap?.let {
                                        if (sectionKitchenAdapter.itemCount == 0){
                                            addPrinterKitchen()
                                        }
                                    }
                                }else{
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

    private fun doSave(){
//        if (isNew){
//            mPrinter = Printer()
//        }
        binding.apply {
            val radio: RadioButton = requireView().findViewById(radioGroup.checkedRadioButtonId)
            val sizeStr = radio.text.toString()
            mPrinter = Printer(
                printerName = getNamaPrinter(),
                address = getMacAddress(),
                tipe = tipePrinter(),
                size = sizeStr,
                isReceipt = swcPrinterKasir.isChecked,
                isKitchen = swcPrinterKitchen.isChecked,
                isReport = swcPrinterSetoran.isChecked
            )
        }
        if (validateInput()){
            var printerKitchenList: List<PrinterKitchen> = mutableListOf()
            var listKitchen: MutableList<Kitchen> = mutableListOf()
            if (sectionKitchenAdapter != null){
//                viewModel.getDataList()
                printerKitchenList = sectionKitchenAdapter.getPrinterKitchenList()
                listKitchen = sectionKitchenAdapter.getPrinterKitchenListmap()
            }
            viewModel.save(mPrinter, printerKitchenList, listKitchen)
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