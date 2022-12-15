package com.bits.bee.bpmc.presentation.ui.pos.addon

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.view.isVisible
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.ItemAddonBinding
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.utils.CurrencyUtils
import java.math.BigDecimal

/**
 * Created by aldi on 15/08/22.
 */
class AddOnAdapter(
    private var lastPosition : Int = -1,
    private var selectedPosition : Int = -1,
    private var selectionPosition : Int = 0,
    private val isMultiSelect : Boolean = false,
    private val isMultiQty : Boolean = false,
    private val addOnI : AddOnI,
    private val lifecycleScope : LifecycleOwner,
    private val addOnSelected : LiveData<ArrayList<Item>>,
) : ListAdapter<Item, RecyclerView.ViewHolder>(DiffCallback()) {

    override fun submitList(list: MutableList<Item>?) {
        if(!isMultiSelect){
            list!!.forEachIndexed{ index, item ->
                if(item.qty > BigDecimal.ZERO) {
                    selectedPosition = index
                    lastPosition = -1
                }
            }
        }
        super.submitList(list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemAddonBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        viewHolder.bind(getItem(position))
    }

    inner class ViewHolder(val binding : ItemAddonBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(model : Item){
            binding.apply {
                val qty = model.qty

                root.setOnClickListener {
                    doClick(model)
                }
                rbItem.setOnClickListener {
                    doClick(model)
                }
                cbItem.setOnClickListener {
                    if(cbItem.isChecked)
                        addItem(model)
                    else
                        deleteItem(model)
                }
                ivPlus.setOnClickListener {
                    addItem(model)
                }
                ivMinus.setOnClickListener {
                    minItem(model)
                }

                val context = binding.root.context
                tvItem.text = model.name1
                tvQty.text = CurrencyUtils.formatCurrency(qty)

                tvPrice.isVisible = model.price > BigDecimal.ZERO
                tvPrice.text = context.getString(R.string.mata_uang_nominal, model.crcSymbol, CurrencyUtils.formatCurrency(model.price))

                rbItem.isVisible = !isMultiSelect
                cbItem.isVisible = isMultiSelect

                setSelected(absoluteAdapterPosition, model)

                bindView(model.qty)

                addOnSelected.observe(lifecycleScope) { items ->
                    if(items.isNotEmpty()){
                        val itemIdList = items.map { it.id }
                        if(itemIdList.contains(model.id)){
                            items.lastOrNull{ it.id == model.id }?.let {
                                cbItem.isChecked = it.qty > BigDecimal.ZERO
                                rbItem.isSelected = it.qty > BigDecimal.ZERO
                                model.qty = it.qty
                                tvQty.text = CurrencyUtils.formatCurrency(it.qty)
                                bindView(model.qty)
                            }
                        } else {
                            cbItem.isChecked = false
                            rbItem.isSelected = false

                            bindView(BigDecimal.ZERO)
                        }
                    } else {
                        cbItem.isChecked = false
                        rbItem.isSelected = false

                        bindView(BigDecimal.ZERO)
                    }
                }
            }
        }

        private fun bindView(qty : BigDecimal){
            binding.apply {
                cbItem.isChecked = qty > BigDecimal.ZERO
                rbItem.isSelected = qty > BigDecimal.ZERO

                if(isMultiQty){
                    llQty.isVisible = qty > BigDecimal.ZERO
                } else {
                    llQty.isVisible = false
                    val constraintLayout: ConstraintLayout = clContent
                    val constraintSet = ConstraintSet()
                    constraintSet.clone(constraintLayout)
                    constraintSet.clear(R.id.tvPrice, ConstraintSet.START)
                    constraintSet.clear(R.id.tvPrice, ConstraintSet.TOP)
                    constraintSet.connect(R.id.tvPrice, ConstraintSet.RIGHT, constraintLayout.id, ConstraintSet.RIGHT, 10)
                    constraintSet.connect(R.id.tvPrice, ConstraintSet.TOP, constraintLayout.id, ConstraintSet.TOP)
                    constraintSet.clear(R.id.tvItem, ConstraintSet.BOTTOM)
                    constraintSet.setMargin(R.id.tvItem, ConstraintSet.BOTTOM, 0)
                    constraintSet.setMargin(R.id.tvItem, ConstraintSet.TOP, 0)
                    constraintSet.setMargin(R.id.tvPrice, ConstraintSet.TOP, 0)
                    constraintSet.setMargin(R.id.tvPrice, ConstraintSet.BOTTOM, 0)
                    constraintSet.connect(R.id.tvItem, ConstraintSet.BOTTOM, R.id.view, ConstraintSet.TOP)
                    constraintSet.applyTo(constraintLayout)
                }
            }
        }

        private fun doClick(item: Item) {
            binding.apply {
                if (rbItem.isVisible) {
                    selectedPosition = absoluteAdapterPosition
                    if(item.isVariant && !item.isAddOn)
                        addOnI.onItemClick(item)
                    else {
                        if (!rbItem.isSelected) {
                            item.qty = BigDecimal.ONE
                            addItem(item)
                        } else {
                            deleteItem(item)
                        }
                    }
                    notifyDataSetChanged()
                } else if (cbItem.isVisible) {
                    cbItem.isChecked = !cbItem.isChecked
                    if (cbItem.isChecked) {
                        addItem(item)
                    } else {
                        deleteItem(item)
                    }
                }
            }
        }

        private fun setSelected(position: Int, item: Item) {
            binding.apply {
                if (selectedPosition == position) {
                    if (lastPosition != position) {
                        rbItem.isChecked = true
                        item.qty = BigDecimal.ONE
                        lastPosition = position
                    } else {
                        item.qty = BigDecimal.ZERO
                        rbItem.isChecked = false
                        lastPosition = -1
                        addOnI.onDeselect(item)
                    }
                } else {
                    item.qty = BigDecimal.ZERO
                    rbItem.isChecked = false
                    if(!isMultiSelect)
                        addOnI.onMin(item)
                }
            }
        }

        private fun addItem(item: Item) {
            item.qty = item.qty + BigDecimal.ONE
            addOnI.addOrRemoveItem(item)
        }


        private fun minItem( item: Item) {
            if (item.qty > BigDecimal.ONE) {
                item.qty = item.qty - BigDecimal.ONE
            } else {
                item.qty = BigDecimal.ZERO
            }
            addOnI.addOrRemoveItem(item)
        }

        private fun deleteItem(item: Item) {
            item.qty = BigDecimal.ZERO
            addOnI.addOrRemoveItem(item)
        }
    }


    class DiffCallback : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }
    }

    interface AddOnI {
        fun onItemClick(item: Item)
        fun onMin(item : Item)
        fun onDeselect(item: Item)
        fun addOrRemoveItem(item : Item)
    }

}