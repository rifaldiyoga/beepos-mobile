package com.bits.bee.bpmc.presentation.ui.pos.edit_item

import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentEditItemBinding
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.domain.model.Stock
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.DialogBuilderHelper
import com.bits.bee.bpmc.presentation.dialog.TidakAdaAksesDialog
import com.bits.bee.bpmc.presentation.ui.pos.MainViewModel
import com.bits.bee.bpmc.presentation.ui.pos.PosModeState
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.CurrencyUtils
import com.bits.bee.bpmc.utils.extension.addNumberFormatChange
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.hideKeyboard
import com.bits.bee.bpmc.utils.extension.removeSymbol
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import java.math.BigDecimal

/**
 * Created by aldi on 25/05/22.
 */
@AndroidEntryPoint
class EditItemFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentEditItemBinding = FragmentEditItemBinding::inflate
) : BaseFragment<FragmentEditItemBinding>() {

    private val viewModel : EditItemViewModel by viewModels()

    private val mViewModel : MainViewModel by activityViewModels()

    override fun initComponents() {
        arguments?.let { bundle ->
            val saled = bundle.getParcelable<Saled>("saled")
            saled?.let {
                viewModel.updateState(
                    viewModel.state.copy(
                        saled = saled,
                        listPrice = it.listPrice,
                        diskon = it.discExp,
                        qty = it.qty,
                        note = it.dNotes,
                        discAmt = it.discAmt,
                        pid = it.stock
                    )
                )
                viewModel.loadData()
                viewModel.loadUnit(it.itemId, it.unitId)
                setToolbarTitle(it.name)
            }
            val stock = bundle.getParcelable<Stock>("pid")
            stock?.let {
                val state = viewModel.state
                viewModel.updateState(state.copy(
                    pid = it
                ))
            }
            val item = bundle.getParcelable<Item>("item")
            item?.let {
                viewModel.updateState(
                    viewModel.state.copy(
                        item = item,
                        listPrice = it.price,
                        diskon = "",
                        qty = BigDecimal.ONE,
                        note = "",
                    )
                )
                viewModel.loadUnit(it.id)
            }
        }
        binding.apply {
            val state = viewModel.state
            etHarga.setText(CurrencyUtils.formatCurrency(state.listPrice))
            etDiskon.setText(state.diskon)
            etCatatan.setText(state.note)

            mViewModel.saleTrans.addOnTrans?.let { addOnTrans ->
                state.saled?.let { saled ->

                    val addOnAdapter = EditItemAddOnAdapter(saled.qty)
                    rvAddon.apply {
                        layoutManager = LinearLayoutManager(requireActivity())
                        adapter = addOnAdapter
                    }
                    val saledList = addOnTrans.getListDetail().filter { saled == it.upSaled }.map {
                        val item = it.saled!!.item!!
                        item.qty = it.saled!!.qty
                        item
                    }
                    state.addOnList = saledList
                    groupAddon.isVisible = saledList.isNotEmpty()
                    addOnAdapter.submitList(saledList)

                    findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<List<Item>>("addon")?.observe(viewLifecycleOwner) {
                        addOnAdapter.submitList(it)
                        viewModel.updateState(
                            state.copy(
                                addOnList = it
                            )
                        )
                    }
                }
            }
            findNavController().currentBackStackEntry?.savedStateHandle?.apply {
                getLiveData<Boolean>(BPMConstants.ACS_PRICE_EDIT).observe(viewLifecycleOwner) {
                    viewModel.state.isEditPrice = it
                    etHarga.requestFocus()
                }
                getLiveData<Boolean>(BPMConstants.ACS_DISC).observe(viewLifecycleOwner) {
                    viewModel.state.isEditDisc = it
                    etDiskon.requestFocus()
                }
            }

            etHarga.addNumberFormatChange()
            etQty.addNumberFormatChange()
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            etHarga.setOnFocusChangeListener { _, b ->
                if(b)
                    viewModel.onPriceFocus()
            }
            etDiskon.setOnFocusChangeListener { _, b ->
                if(b)
                    viewModel.onDiscFocus()
            }
            etDiskon.addTextChangedListener {
                viewModel.onDiscChange(etDiskon.text.toString().trim())
            }
            etHarga.addTextChangedListener {
                val harga = etHarga.text.toString().trim().removeSymbol()
                viewModel.onPriceChange(harga)
                if(harga.isEmpty()){
                    etHarga.setText("0")
                    etHarga.selectAll()
                }
            }
            etQty.addTextChangedListener {
                val qty = etQty.text.trim().toString().removeSymbol()
                viewModel.onQtyChange(qty)
                if(qty.isEmpty()){
                    etQty.setText("0")
                    etQty.selectAll()
                }
            }
            etQty.setOnFocusChangeListener { _, b ->
                if(!b){
                    viewModel.onQtyChange(etQty.text.toString())
                }
            }
            etCatatan.addTextChangedListener{
                viewModel.state.note = etCatatan.text.toString().trim()
            }
            ivPlus.setOnClickListener {
                viewModel.onClickPlus()
            }
            ivMinus.setOnClickListener {
                viewModel.onClickMinus()
            }
            llNext.setOnClickListener {
                viewModel.onClickSubmit()
            }
            tvUbah.setOnClickListener {
                viewModel.onClickAddOn()
            }
            spSatuan.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    viewModel.onUnitChange(p2)
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }

            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.msg.collect{
                    showSnackbar(it)
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            mViewModel.posModeState.collect {
                viewModel.state.modePos = it
                when(it){
                    PosModeState.FnBState -> {
                        binding.apply {
                            tvNamaItem.gone()
                            groupPid.gone()
                            groupSatuan.gone()
                        }
                    }
                    PosModeState.RetailState -> {
                        binding.apply {
                            groupAddon.gone()
                            groupCatatan.gone()
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect { event ->
                    when(event){
                        is EditItemViewModel.UIEvent.RequestSubmit -> {
                            mViewModel.onEditDetail(event.saled, event.selectedAddOnList)
                            findNavController().popBackStack()
                        }
                        is EditItemViewModel.UIEvent.RequestAdd -> {
                            mViewModel.onAddDetail(event.itemWithUnit, true)
                            findNavController().popBackStack(R.id.posFragment, false)
                        }
                        is EditItemViewModel.UIEvent.NavigateToAddOn -> {
                            val bundle = bundleOf(
                                "addOnList" to (viewModel.state.addOnList as ArrayList<out Parcelable>),
                                "item" to event.item,
                                "bp" to mViewModel.state.bp!!,
                                "saled" to event.saled
                            )
//                            val action = EditItemFragmentDirections.actionEditItemDialogToAddOnFragment(it.item, mViewModel.state.bp!!, saled = it.saled)
                            findNavController().navigate(R.id.action_editItemDialog_to_addOnFragment, bundle)
                        }
                        EditItemViewModel.UIEvent.ValidateDelete -> {
                            val dialog = DialogBuilderHelper.showDialogChoice(
                                requireContext(),
                                title = getString(R.string.hapus_produk),
                                msg = getString(R.string.msg_hapus_produk),
                                positiveTxt = getString(R.string.ya),
                                positiveListener = {
                                    it.dismiss()
                                    viewModel.state.saled?.let {
                                        mViewModel.onDeleteDetail(it)
                                    }
                                    findNavController().popBackStack()
                                },
                                negativeTxt = getString(R.string.batal),
                                negativeListener = {
                                    it.dismiss()
                                }
                            )
                            dialog.show(parentFragmentManager, "")
                        }
                        is EditItemViewModel.UIEvent.NavigateToHakAkses -> {
                            hideKeyboard()
                            binding.etDiskon.clearFocus()
                            binding.etHarga.clearFocus()
                            val dialog = TidakAdaAksesDialog {
                                it.dismiss()
                                val action = EditItemFragmentDirections.actionEditItemDialogToHakAksesFragment(event.accType)
                                findNavController().navigate(action)
                            }

                            dialog.show(parentFragmentManager, "")
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collectLatest { state ->
                    state?.let {
                        binding.apply {
                            etQty.setText(CurrencyUtils.formatCurrency(state.qty))
                            val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, state.unitList.map { it.unit })
                            spSatuan.adapter = adapter
                            when(state.modePos){
                                PosModeState.FnBState -> {
                                    tvQty.text = getString(R.string._1_produk, CurrencyUtils.formatCurrency(state.qty))
                                }
                                PosModeState.RetailState -> {
                                    state.unit?.let { unit ->
                                        tvQty.text = getString(R.string._1_PCS, CurrencyUtils.formatCurrency(state.qty), unit.unit)
                                        spSatuan.setSelection(state.unitList.indexOfFirst { it.id == unit.id })
                                    } ?: run {
                                        tvQty.text = getString(R.string._1_produk, CurrencyUtils.formatCurrency(state.qty))
                                    }
                                    val code = state.item?.code ?: state.saled?.itemCode ?: ""
                                    val name = state.item?.name1 ?: state.saled?.name ?: ""
                                    tvNamaItem.text = "$code - $name"
                                }
                            }
                            state.saled?.let { saled ->
                                ivPlus.isEnabled = !saled.isBonus
                                ivMinus.isEnabled = !saled.isBonus
                                etQty.isEnabled = !saled.isBonus
                                etDiskon.isEnabled = !saled.isBonus
                                etHarga.isEnabled = !saled.isBonus
                                if(saled.isBonus) {
                                    ivPlus.setImageDrawable(
                                        ContextCompat.getDrawable(
                                            requireActivity(),
                                            R.drawable.ic_circle_plus_disable
                                        )
                                    )
                                    ivMinus.setImageDrawable(
                                        ContextCompat.getDrawable(
                                            requireActivity(),
                                            R.drawable.ic_circle_minus_disable
                                        )
                                    )
                                }
                            }

                            state.item?.let {
                                groupPid.isVisible = it.usePid
                            }
                            state.pid?.let {
                                tvPid.text = it.pid
                            }
                            groupPid.isVisible = state.pid != null
                            val subtotal = ((state.listPrice + getTotalAddOn()) - state.discAmt) * state.qty
                            tvSubtotal.text = getString(R.string.mata_uang_nominal ,mViewModel.state.crc?.symbol ?: "",CurrencyUtils.formatCurrency(subtotal))
                        }
                    }
                }
            }
        }
    }

    private fun getTotalAddOn() : BigDecimal {
        var subtotal = BigDecimal.ZERO
        viewModel.state.addOnList.forEach {
            it?.let {
                subtotal += it.price * it.qty
            }
        }
        return subtotal
    }
}