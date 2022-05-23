package com.bits.bee.bpmc.presentation.ui.setting_printer.add_printer

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothAssignedNumbers
import android.net.wifi.WifiManager
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.data.data_source.local.model.Printer
import com.bits.bee.bpmc.databinding.FragmentSettingAddPrinterBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.tipe_printer.TipePrinterDialog
import com.bits.bee.bpmc.presentation.dialog.radio_list.RadioListAdapter
import com.bits.bee.bpmc.presentation.ui.pilih_db.PilihDbFragmentDirections
import com.bits.bee.bpmc.utils.BeePreferenceManager
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

private const val TAG = "Tambah Printer"

class AddPrinterFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSettingAddPrinterBinding = FragmentSettingAddPrinterBinding::inflate
): BaseFragment<FragmentSettingAddPrinterBinding>() {

    private val viewModel : AddPrinterViewModel by viewModels()
    private lateinit var ukuranKertasList: List<String>
    private lateinit var radioAdapter: RadioListAdapter
    private lateinit var mPrinter: Printer
    lateinit var mBluetoothAdapter: BluetoothAdapter
    lateinit var mWifiManager: WifiManager

    override fun initComponents() {
//        if (mPrinter == null){
            viewModel.onClickShowPrinter()
//        }
        ukuranKertasList = requireActivity().resources.getStringArray(R.array.list_ukuran_kertas).toList()
        binding.apply {
            radioAdapter = RadioListAdapter(ukuranKertasList, 0)
            recVKertas.layoutManager = LinearLayoutManager(requireContext())
            recVKertas.adapter = radioAdapter
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            etTipePrinter.setOnClickListener {
                viewModel.onClickShowPrinter()
            }
            btnLanjut.setOnClickListener {

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
                        etNamaPrinter.setText("")
                        etMacAddress.setText("")
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

}