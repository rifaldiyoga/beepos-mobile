package com.bits.bee.bpmc.presentation.ui.pos.addon

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.ItemSelectionBinding
import com.bits.bee.bpmc.domain.model.Crc
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.SelectionWithItem

/**
 * Created by aldi on 15/08/22.
 */
class SelectionAdapter(
    private val addOnSelected : LiveData<ArrayList<Item>>,
    private val lifecycleScope: LifecycleOwner,
    private val onItemClick : (Item) -> Unit,
    private val addOnI: AddOnAdapter.AddOnI
) : ListAdapter<SelectionWithItem, RecyclerView.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemSelectionBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        viewHolder.bind(getItem(position))
    }

    inner class ViewHolder(val binding : ItemSelectionBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(model: SelectionWithItem) {
            binding.apply {
                val context = binding.root.context
                tvName.text = model.selection.name
                tvOptional.text = if(model.selection.isMultiSelect) context.getString(R.string.optional) else context.getString(R.string.pilih_1)
                val addOnAdapter = AddOnAdapter(
                    isMultiQty = model.selection.isMultiQty,
                    isMultiSelect = model.selection.isMultiSelect,
                    selectionPosition = absoluteAdapterPosition,
                    addOnSelected = addOnSelected,
                    lifecycleScope = lifecycleScope,
                    addOnI = addOnI
                )
                addOnAdapter.submitList(model.itemList.toMutableList())

                rvList.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(context)
                    adapter = addOnAdapter
                }

                addOnSelected.observe(lifecycleScope){ selectedItem ->
                    val isContains = checkSelected(model.itemList, selectedItem)
                    ivCheck.isVisible = isContains
                }

            }
        }

        fun checkSelected(itemList : List<Item>, selectedList: List<Item>) : Boolean {
            itemList.forEach { item ->
                selectedList.forEach { selectedItem ->
                    if(item.id == selectedItem.id)
                        return true
                }
            }
            return false
        }

    }

    class DiffCallback : DiffUtil.ItemCallback<SelectionWithItem>(){
        override fun areItemsTheSame(oldItem: SelectionWithItem, newItem: SelectionWithItem): Boolean {
            return oldItem.selection.id == newItem.selection.id
        }

        override fun areContentsTheSame(oldItem: SelectionWithItem, newItem: SelectionWithItem): Boolean {
            return oldItem == newItem
        }

    }

}