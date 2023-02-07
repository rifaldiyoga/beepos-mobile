package com.bits.bee.bpmc.presentation.ui.cek_stok_detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemPidStockBinding
import com.bits.bee.bpmc.domain.model.Stock
import com.bits.bee.bpmc.utils.CurrencyUtils
import java.math.BigDecimal

class StokPIDAdapter : ListAdapter<Stock, RecyclerView.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemPidStockBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        viewHolder.bind(getItem(position))
    }

    inner class ViewHolder(val binding : ItemPidStockBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(model : Stock) {
            binding.apply {
                tvNamaItem.text = model.pid
                tvQty.text = CurrencyUtils.formatCurrency(BigDecimal(model.qty))
            }
        }

    }

    class DiffCallback : DiffUtil.ItemCallback<Stock>(){
        override fun areItemsTheSame(oldItem: Stock, newItem: Stock): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Stock, newItem: Stock): Boolean {
            return oldItem.id == newItem.id
        }

    }

}