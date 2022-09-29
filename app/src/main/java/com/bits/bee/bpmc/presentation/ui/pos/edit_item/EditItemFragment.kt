package com.bits.bee.bpmc.presentation.ui.pos.edit_item

import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
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
import com.bits.bee.bpmc.presentation.ui.pos.MainViewModel
import com.bits.bee.bpmc.presentation.ui.pos.PosModeState
import com.bits.bee.bpmc.utils.CurrencyUtils
import com.bits.bee.bpmc.utils.extension.addNumberFormatChange
import com.bits.bee.bpmc.utils.extension.gone
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        arguments?.let { bundle ->
            val saled = bundle.getParcelable<Saled>("saled")
            saled?.let {
                val state = viewModel.state
                state.listPrice = it.listPrice
                state.diskon = it.discExp
                state.qty = it.qty
                state.note = it.dNotes
                state.discAmt = it.discAmt
                viewModel.state.saled = saled
                viewModel.loadUnit(it.itemId)
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
                val state = viewModel.state
                state.listPrice = it.price
                state.diskon = ""
                state.qty = BigDecimal.ONE
                state.note = ""
                viewModel.state.item = it
                viewModel.loadUnit(it.id)
            }
        }

        super.onViewCreated(view, savedInstanceState)
    }

    override fun initComponents() {
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
                    val saledList = addOnTrans.getListDetail().filter { saled == it.upSaled }.map { it.saled!!.item }
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

            etHarga.addNumberFormatChange()
            etQty.addNumberFormatChange()
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            etDiskon.addTextChangedListener {
                viewModel.onDiscChange(etDiskon.text.toString().trim())
            }
            etHarga.addTextChangedListener {
                viewModel.onPriceChange(etHarga.text.toString().trim().removeSymbol())
            }
            etQty.addTextChangedListener {
                viewModel.onQtyChange(etQty.text.trim().toString().removeSymbol())
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
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.error.collect{
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
                viewModel.event.collect {
                    when(it){
                        is EditItemViewModel.UIEvent.RequestSubmit -> {

                            mViewModel.saleTrans.addOnTrans?.let { addOnTrans ->
                                val saledAddOnList : MutableList<Saled?> = mutableListOf()
                                for (saleAddOnD in addOnTrans.getListDetail()){
                                    if(saleAddOnD.upSaled == it.saled)
                                        saledAddOnList.add(saleAddOnD.saled)
                                }

                                for(saled in saledAddOnList){
                                    saled?.let { saled ->
                                        mViewModel.onDeleteAddOnData(it.saled, saled)
                                    }
                                }

                                mViewModel.onItemAddOn(viewModel.state.addOnList, it.saled)
                            }

                            mViewModel.onEditDetail(it.saled)
                            findNavController().popBackStack(R.id.invoiceFragment, false)
                        }
                        is EditItemViewModel.UIEvent.RequestAdd -> {
                            mViewModel.onAddDetail(it.itemWithUnit, true)
                            findNavController().popBackStack(R.id.posFragment, false)
                        }
                        is EditItemViewModel.UIEvent.NavigateToAddOn -> {
                            val bundle = bundleOf(
                                "addOnList" to (viewModel.state.addOnList as ArrayList<out Parcelable>),
                                "item" to it.item,
                                "bp" to mViewModel.state.bp!!,
                                "saled" to it.saled
                            )
//                            val action = EditItemFragmentDirections.actionEditItemDialogToAddOnFragment(it.item, mViewModel.state.bp!!, saled = it.saled)
                            findNavController().navigate(R.id.action_editItemDialog_to_addOnFragment, bundle)
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
                                    state.unit?.let {
                                        tvQty.text = getString(R.string._1_PCS, CurrencyUtils.formatCurrency(state.qty), it.unit)
//                                        spSatuan.setText(it.unit)
                                    } ?: run {
                                        tvQty.text = getString(R.string._1_produk, CurrencyUtils.formatCurrency(state.qty))
                                    }
                                    val code = state.item?.code ?: state.saled?.itemCode ?: ""
                                    val name = state.item?.name1 ?: state.saled?.name ?: ""
                                    tvNamaItem.text = "$code - $name"
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

    fun getTotalAddOn() : BigDecimal {
        var subtotal = BigDecimal.ZERO
        viewModel.state.addOnList.forEach {
            it?.let {
                subtotal += it.price * it.qty
            }
        }
        return subtotal
    }
}