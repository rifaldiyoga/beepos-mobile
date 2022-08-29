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
import com.bits.bee.bpmc.domain.model.ItemWithUnit
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.ui.pos.MainViewModel
import com.bits.bee.bpmc.utils.CurrencyUtils
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
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
                item?.let {
                    setTitle(it.name1)
                    layoutVariant.apply {
                        root.isVisible = it.isVariant
                        tvName.text = item.name1
                        tvOptional.isVisible = false
                    }
                    rvListAddOn.isVisible = !it.isVariant
                }
                val bp = it.getParcelable<Bp>("bp")
                val saled = it.getParcelable<Saled>("saled")
                saled?.let {
                    layoutVariant.root.gone()
                    rvListAddOn.visible()
                }
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
        viewModel.state.saled?.let {
            mainViewModel.saleTrans.getSaledByUpSaledList(it).map { it?.item }.forEach {
                it?.let {
                    viewModel.addItemSelectedList(it)
                }
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            ivMinus.setOnClickListener {
                viewModel.updateState(
                    viewModel.state.copy(
                        qty = viewModel.state.qty - BigDecimal.ONE
                    )
                )
            }
            ivPlus.setOnClickListener {
                viewModel.updateState(
                    viewModel.state.copy(
                        qty = viewModel.state.qty + BigDecimal.ONE
                    )
                )
            }
            llNext.setOnClickListener {
                val selectedList = viewModel.getSelectedAddOn()
                val variant = selectedList.firstOrNull{ it.isVariant && !it.isAddOn }
                val addOnList = selectedList.filter { it.isAddOn }
                for (i in 1..viewModel.state.qty.toInt()){
                    mainViewModel.onAddAddOn(if(variant!= null) ItemWithUnit(variant) else null , addOnList.map { ItemWithUnit(it) })
                }
                findNavController().popBackStack()
            }
        }
    }

    override fun subscribeObservers() {
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
        viewModel.getSelectedAddOn().map {
            subtotal = (it.price * it.qty) + subtotal
        }
        subtotal *= viewModel.state.qty
        binding.tvSubtotal.text = getString(R.string.mata_uang_nominal, mainViewModel.state.crc?.symbol ?: "", CurrencyUtils.formatCurrency(subtotal))
    }

    override fun onItemClick(item: Item) {
        if(item.isVariant && !item.isAddOn){
            binding.rvListAddOn.visible()
            viewModel.clearSelectedAddOn()
            selectionAdapter.notifyDataSetChanged()
            viewModel.getSelection(item, )
        }
    }

    override fun onDeselect(item: Item) {
        if(item.isVariant && !item.isAddOn){
            binding.rvListAddOn.gone()
            viewModel.clearSelectedAddOn()
        }
    }

    override fun addOrRemoveItem(item: Item) {
        viewModel.addItemSelectedList(item)
    }

}