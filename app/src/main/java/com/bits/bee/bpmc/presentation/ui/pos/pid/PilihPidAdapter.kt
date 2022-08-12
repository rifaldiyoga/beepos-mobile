package com.bits.bee.bpmc.presentation.ui.pos.pid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemPidRetailBinding
import com.bits.bee.bpmc.domain.model.Stock

/**
 * Created by aldi on 04/08/22.
 */
class PilihPidAdapter(private val onItemClick : (Stock) -> Unit) : ListAdapter<Stock, RecyclerView.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemPidRetailBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        viewHolder.bind(getItem(position))
        viewHolder.itemView.setOnClickListener {
            onItemClick(getItem(position))
        }
    }

    inner class ViewHolder(val binding: ItemPidRetailBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(stock: Stock) {
            binding.apply {
                tvNamaItem.text = stock.pid
            }
        }
    }

    class DiffCallback() : DiffUtil.ItemCallback<Stock>(){
        override fun areItemsTheSame(oldItem: Stock, newItem: Stock): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Stock, newItem: Stock): Boolean {
            return oldItem == newItem
        }

    }

}