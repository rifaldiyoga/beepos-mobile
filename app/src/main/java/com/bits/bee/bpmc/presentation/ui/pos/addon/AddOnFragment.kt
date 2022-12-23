package com.bits.bee.bpmc.presentation.ui.pos.addon

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentAddonBinding
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.ui.pos.MainViewModel
import com.bits.bee.bpmc.utils.CurrencyUtils
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.math.BigDecimal

/**
 * Created by aldi on 15/08/22.
 */
@AndroidEntryPoint
class AddOnFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentAddonBinding = FragmentAddonBinding::inflate
) : BaseFragment<FragmentAddonBinding>(), AddOnAdapter.AddOnI {

    private val viewModel : AddOnViewModel by viewModels()

    private val mainViewModel : MainViewModel by activityViewModels()

    private lateinit var selectionAdapter : SelectionAdapter

    private lateinit var variantAdapter : AddOnAdapter

    override fun initComponents() {
        binding.apply {
            arguments?.let {
                val item = it.getParcelable<Item>("item")
                item?.let { item1 ->
                    setToolbarTitle(item1.name1)
                    layoutVariant.apply {
                        root.isVisible = item1.isVariant
                        tvName.text = item.name1
                        tvOptional.isVisible = false
                    }
                    rvListAddOn.isVisible = !item1.isVariant
                }
                val bp = it.getParcelable<Bp>("bp")
                val saled = it.getParcelable<Saled>("saled")
                val addOnList = it.getParcelableArrayList<Item>("addOnList")
                val priceLvlId = it.getInt("priceLvlId")

                viewModel.updateState(
                    viewModel.state.copy(
                        item = item,
                        bp = bp,
                        priceLvlId = priceLvlId,
                        saled = saled,
                        qty = saled?.qty ?: BigDecimal.ONE
                    )
                )
                addOnList?.let {
                    val selectedItem = it.map {
                        val item = it
                        item.qty = (it.qty / saled?.qty!!)
                        item
                    }
                    viewModel.updateState(
                        viewModel.state.copy(
                            itemList = selectedItem
                        )
                    )
                    viewModel.setItemSelectedList(selectedItem as ArrayList<Item>)
                    layoutVariant.root.gone()
                    rvListAddOn.visible()
                }
            }

            selectionAdapter = SelectionAdapter(
                addOnSelected = viewModel.selectedAddOn,
                lifecycleScope = viewLifecycleOwner,
                onItemClick = { viewModel.addItemSelectedList(it) },
                this@AddOnFragment
            )
            variantAdapter = AddOnAdapter(
                addOnSelected = viewModel.selectedAddOn,
                lifecycleScope = viewLifecycleOwner,
//                onItemClick = { viewModel.addItemSelectedList(it) },
                addOnI = this@AddOnFragment
            )
            layoutVariant.rvList.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = variantAdapter
            }
            rvListAddOn.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = selectionAdapter
            }
            etQty.setText(CurrencyUtils.formatCurrency(BigDecimal.ONE))
        }

        viewModel.loadData()

    }

    override fun subscribeListeners() {
        binding.apply {
            ivMinus.setOnClickListener {
                if(viewModel.state.qty > BigDecimal.ONE) {
                    viewModel.updateState(
                        viewModel.state.copy(
                            qty = viewModel.state.qty - BigDecimal.ONE
                        )
                    )
                }
            }
            ivPlus.setOnClickListener {
                viewModel.updateState(
                    viewModel.state.copy(
                        qty = viewModel.state.qty + BigDecimal.ONE
                    )
                )
            }
            llNext.setOnClickListener {
                viewModel.onClickNext()
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
            viewModel.viewStates().collect {
                it?.let {
                    selectionAdapter.submitList(it.selectionList.toMutableList())

                    it.variantWithItem?.let {
                        variantAdapter.submitList(it.itemList.toMutableList())
                    }
                    binding.apply {
                        etQty.setText(CurrencyUtils.formatCurrency(it.qty))
                        tvQty.text = getString(R.string._1_produk, CurrencyUtils.formatCurrency(it.qty))

                        recalcSubtotal()
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.event.collect{
                when(it){
                    is AddOnViewModel.UIEvent.ShowLoadingSelection -> {
                        binding.apply {
                            progressBarSelection.isVisible = it.isLoading
                        }
                    }
                    is AddOnViewModel.UIEvent.RequestSave -> {
                        if (viewModel.state.saled == null) {
                            mainViewModel.onAddAddOn(it.qty, it.item, it.selectedAddOnList)
                        } else {
                            val list = it.selectedAddOnList.map { itemW ->
                                val item = itemW.item
                                item.qty = item.qty * viewModel.state.saled!!.qty
                                item.copy()
                            }
                            findNavController().previousBackStackEntry?.savedStateHandle?.set("addon", list)
                        }
                        findNavController().popBackStack()
                    }
                }
            }
        }
        viewModel.selectedAddOn.observe(viewLifecycleOwner) {
            recalcSubtotal()
        }
    }

    private fun recalcSubtotal() {
        var subtotal : BigDecimal = BigDecimal.ZERO
        val state = viewModel.state
        state.item?.let {
            if(!it.isVariant)
                subtotal = it.price
        }
        state.saled?.let {
            subtotal = it.listPrice
        }
        viewModel.getSelectedAddOn().map {
            subtotal = (it.price * it.qty) + subtotal
        }
        subtotal *= viewModel.state.qty
        binding.tvSubtotal.text = getString(R.string.mata_uang_nominal, mainViewModel.state.crc?.symbol ?: "", CurrencyUtils.formatCurrency(subtotal))
    }

    override fun onItemClick(item: Item) {
        if(item.isVariant && !item.isAddOn){
            binding.rvListAddOn.visible()
            binding.progressBarSelection.visible()
            viewModel.clearSelectedAddOn()
            item.qty = BigDecimal(binding.etQty.text.toString())
            viewModel.addItemSelectedList(item)
            selectionAdapter.notifyDataSetChanged()
            viewModel.getSelection(item)
        }
    }

    override fun onMin(item: Item) {
        viewModel.minItemSelected(item)
    }

    override fun onDeselect(item: Item) {
        if(item.isVariant && !item.isAddOn){
            binding.rvListAddOn.gone()
            binding.progressBarSelection.gone()
            viewModel.clearSelectedAddOn()
        }
//        else {
//            viewModel.addItemSelectedList(item)
//        }
    }

    override fun addOrRemoveItem(item: Item) {
        viewModel.addItemSelectedList(item)
    }

}