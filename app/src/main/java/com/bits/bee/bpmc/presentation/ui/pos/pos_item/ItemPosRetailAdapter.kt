package com.bits.bee.bpmc.presentation.ui.pos.pos_item

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemPosRetailBinding
import com.bits.bee.bpmc.domain.model.Item

/**
 * Created by aldi on 22/04/22.
 */
class ItemPosRetailAdapter constructor(
    private val onItemClicK : (Item) -> Unit,
) : PagingDataAdapter<Item, RecyclerView.ViewHolder>(DiffCallback()){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemPosRetailBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        getItem(position)?.let { item ->
            viewHolder.bind(item)
            viewHolder.itemView.setOnClickListener {
                onItemClicK(item)
            }
        }
    }

    inner class ViewHolder(private val binding : ItemPosRetailBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(item : Item){
            binding.apply {
                tvNamaItem.text =  item.name1
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Item>(){
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }
    }
}