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
import com.bits.bee.bpmc.presentation.ui.setting_printer.printer_kitchen.SectionKitchenAdapter
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.google.gson.Gson
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

private const val TAG = "Tambah Printer"

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
//            viewModel.onReceiveArgument(it.getBoolean("isNew",false), it.getParcelable<Printer>("fdfdf"))
            mPrinter = Gson().fromJson(it.getString("printerP"), Printer::class.java)
            isNew = it.getBoolean("isNew")
//            viewModel.onReceiveData(mPrinter, isNew)
        }
    }

    override fun initComponents() {
        viewModel.setValuePrinter(mPrinter)
        viewModel.setDataKitchen(BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_switch_dapur), false) as Boolean)
        binding.apply {
            if (!swcPrinterKitchen.isChecked){

            }
            rvKitchenPrinter.layoutManager = LinearLayoutManager(requireContext())

        }
        var newPrinter = Printer
//        Printer(0, "")

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
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.viewStates().collect {
                    binding.apply {
                        etNamaPrinter.setText(BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_name_printer), "") as String)
                        etMacAddress.setText(BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_address_printer), "") as String)
                        swcPrinterKasir.isChecked = false
                        swcPrinterKitchen.isChecked = false
                        swcPrinterSetoran.isChecked = false
                        etTipePrinter.setText(BeePreferenceManager.getDataFromPreferences(requireContext(), getString(
                            R.string.pref_tipe_printer), "" ) as String)

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
        if (isNew){
//            mPrinter = Printer()
        }
//        radioAdapter.getSelectedPosition()
        binding.apply {
            mPrinter = Printer(
                id = -1,
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
        if (isKitchen){
            sectionKitchenAdapter = SectionKitchenAdapter(requireContext())
            binding.apply {
                rvKitchenPrinter.visibility = View.VISIBLE
                binding.rvKitchenPrinter.adapter = sectionKitchenAdapter
            }
            if (!isNew){
                viewModel.setPrinterKitchen()
            }
            if (sectionKitchenAdapter.itemCount == 0){

            }
        }else{
            binding.rvKitchenPrinter.visibility = View.GONE
        }
    }

}