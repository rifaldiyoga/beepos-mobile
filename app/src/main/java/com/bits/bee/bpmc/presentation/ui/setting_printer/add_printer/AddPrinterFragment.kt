package com.bits.bee.bpmc.presentation.ui.setting_printer.add_printer

import android.view.*
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentSettingAddPrinterBinding
import com.bits.bee.bpmc.domain.model.Printer
import com.bits.bee.bpmc.domain.model.PrinterKitchen
import com.bits.bee.bpmc.domain.printer.helper.PrinterHelper
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.tipe_printer.TipePrinterDialog
import com.bits.bee.bpmc.presentation.ui.pos.PosModeState
import com.bits.bee.bpmc.presentation.ui.setting_printer.list_printer_search.PrinterDevice
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

const val TAG = "Tambah Printer"

@AndroidEntryPoint
class AddPrinterFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSettingAddPrinterBinding = FragmentSettingAddPrinterBinding::inflate
): BaseFragment<FragmentSettingAddPrinterBinding>() {

    private val viewModel : AddPrinterViewModel by viewModels()
    private lateinit var sectionKitchenAdapter: SectionKitchenAdapter

    @Inject
    lateinit var printerHelper: PrinterHelper

    var isKitchen = false
    private lateinit var menuDelete : MenuItem

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_delete, menu)
        menu.findItem(R.id.menu_delete).isVisible = viewModel.state.mPrinter?.id != null
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_delete -> {
                viewModel.onClickDelete()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun initComponents() {
        setHasOptionsMenu(true)
        arguments?.let {
            val printer = it.getParcelable<Printer>("printer")
            printer?.let {
                viewModel.updateState(
                    viewModel.state.copy(
                        mPrinter = printer
                    )
                )
                viewModel.setPrinterKitchen(it)
            }
        }
        binding.apply {
            sectionKitchenAdapter = SectionKitchenAdapter {
                val action = AddPrinterFragmentDirections.actionAddPrinterFragmentToKitchenFragment(viewModel.state.printerKitchenList[it])
                findNavController().navigate(action)
            }
            rvKitchenPrinter.layoutManager = LinearLayoutManager(requireContext())
            rvKitchenPrinter.adapter = sectionKitchenAdapter
        }
        findNavController().currentBackStackEntry?.savedStateHandle?.apply {
            getLiveData<PrinterDevice>("printer").observe(viewLifecycleOwner) {
                val printer = viewModel.state.mPrinter ?: Printer()
                viewModel.updateState(
                    viewModel.state.copy(
                        mPrinter = printer.copy(
                            printerName = it.nama,
                            address = it.address
                        )
                    )
                )
                viewModel.bluetoothConnectService.onEventConnectPrinter(viewModel.state.mPrinter!!, 0)
            }
            getLiveData<PrinterKitchen>("printerKitchen").observe(viewLifecycleOwner) {
                viewModel.onClickAddKitchen(it)
                sectionKitchenAdapter.notifyDataSetChanged()
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            etNamaPrinter.addTextChangedListener {
                val nama = etNamaPrinter.text.toString().trim()
                viewModel.state.mPrinter?.printerName = nama
                if(nama.isNotEmpty())
                    tilNama.isErrorEnabled = false
            }
            etMacAddress.addTextChangedListener {
                val address = etMacAddress.text.toString().trim()
                viewModel.state.mPrinter?.address = address
                if(address.isNotEmpty())
                    tilAddress.isErrorEnabled = false
            }

            etTipePrinter.setOnClickListener {
                viewModel.onClickShowPrinter()
            }
            clPrinterKasir.setOnClickListener {
                swcPrinterKasir.isChecked = !swcPrinterKasir.isChecked
            }
            swcPrinterKasir.setOnCheckedChangeListener { _, b ->
                viewModel.onClickPrinterKasir(b)
            }

            clPrinterSetoran.setOnClickListener {
                swcPrinterSetoran.isChecked = !swcPrinterSetoran.isChecked
            }
            swcPrinterSetoran.setOnCheckedChangeListener { _, b ->
                viewModel.onClickPrinterSetoran(b)
            }

            clPrinterKitchen.setOnClickListener {
                swcPrinterKitchen.isChecked = !swcPrinterKitchen.isChecked
            }
            swcPrinterKitchen.setOnCheckedChangeListener { _, b ->
                viewModel.onClickPrinterKitchen(b)
            }

            btnSimpanEdit.setOnClickListener {
                viewModel.doSave()
            }

            btnKitchenPlus.setOnClickListener {
                viewModel.onClickAddPrinterKitchen()
            }
            btnKitchenMinus.setOnClickListener {
                viewModel.onClickMinuPrintersKitchen()
            }

            btnTesPrint.setOnClickListener {
                viewModel.onClickTesPrint()
            }
            rbSize1.setOnCheckedChangeListener { _, b ->
                if(b)
                    viewModel.onClickRadio(getString(R.string.kertas58))
            }
            rbSize2.setOnCheckedChangeListener { _, b ->
                if(b)
                    viewModel.onClickRadio(getString(R.string.kertas80))
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.msg.collect {
                showSnackbar(it)
            }
        }
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
                        AddPrinterViewModel.UIEvent.NavigateBack ->{
                            findNavController().popBackStack()
                        }
                        AddPrinterViewModel.UIEvent.RequestTesPrint -> {
                            val printer = viewModel.state.mPrinter
                            if(printer != null && printer.address.isNotEmpty())
                                printerHelper.testPrint(requireActivity(), printer)
                            else
                                showSnackbar("Harap pilih printer terlebih dahulu")
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
                            val mode = viewModel.modePreferences.first()
                            (mode != PosModeState.RetailState).also {
                                clPrinterKitchen.isVisible = it
                                rvKitchenPrinter.isVisible = it
                                llQtyKitchen.isVisible = it
                            }
                            tilNama.error = it.errorName
                            tilAddress.error = it.errorAddress
                            it.mPrinter?.let {
                                etNamaPrinter.setText(it.printerName)
                                etMacAddress.setText(it.address)
                                etMacAddress.isEnabled = it.tipe != 0
                                val tipe = when(it.tipe){
                                    0 -> getString(R.string.bluetooth_printer)
                                    else -> getString(R.string.network_printer)
                                }
                                etTipePrinter.setText(tipe)

                                rbSize1.isChecked = it.size == getString(R.string.kertas58)
                                rbSize2.isChecked = it.size == getString(R.string.kertas80)
                                swcPrinterKasir.isChecked =  it.isReceipt
                                swcPrinterKitchen.isChecked =  it.isKitchen
                                swcPrinterSetoran.isChecked =  it.isReport
                            }
                            btnSimpanEdit.background = ContextCompat.getDrawable(
                                requireActivity(),
                                if(state.mPrinter != null)
                                    R.drawable.btn_rect_primary
                                else
                                    R.drawable.btn_rect_disable
                            )

                            btnTesPrint.isVisible = state.mPrinter != null && state.mPrinter!!.printerName.isNotEmpty() && state.mPrinter!!.address.isNotEmpty()

                            rvKitchenPrinter.isVisible = state.printerKitchenList.isNotEmpty()
                            llQtyKitchen.isVisible = state.printerKitchenList.isNotEmpty()

                            tvQty.text = state.printerKitchenList.size.toString()

                            sectionKitchenAdapter.submitList(state.printerKitchenList)
                        }
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        if (viewModel.state.mPrinter == null || viewModel.state.mPrinter?.address.isNullOrEmpty())
            viewModel.onClickShowPrinter()
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

}