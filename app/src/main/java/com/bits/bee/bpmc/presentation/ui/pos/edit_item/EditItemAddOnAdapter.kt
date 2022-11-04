package com.bits.bee.bpmc.presentation.ui.pos.edit_item

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemEditItemAddonBinding
import com.bits.bee.bpmc.domain.model.Item
import java.math.BigDecimal

/**
 * Created by aldi on 26/08/22.
 */
class EditItemAddOnAdapter(private val qty : BigDecimal) : ListAdapter<Item, RecyclerView.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemEditItemAddonBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        viewHolder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding : ItemEditItemAddonBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(model : Item){
            binding.apply {
                val qty = model.qty / qty
                tvAddon.text = if(qty > BigDecimal.ONE) "$qty ${model.name1}" else model.name1
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Item>(){
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }

    }
}