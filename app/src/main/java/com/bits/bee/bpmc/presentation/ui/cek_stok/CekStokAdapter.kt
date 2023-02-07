package com.bits.bee.bpmc.presentation.ui.cek_stok

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.ItemCekStokBinding
import com.bits.bee.bpmc.domain.model.Stock
import com.bits.bee.bpmc.utils.CurrencyUtils
import java.math.BigDecimal

class CekStokAdapter(val onClickItem : (Stock) -> Unit) : ListAdapter<Stock, CekStokAdapter.ViewHolder>(DiffCallback()) {

    class ViewHolder(val binding : ItemCekStokBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemCekStokBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val stock = getItem(position)
        holder.binding.apply {
            root.setOnClickListener {
                onClickItem(stock)
            }
            tvItem.text = stock.itemName
            tvPorsi.text = CurrencyUtils.formatCurrency(BigDecimal(stock.qty))
            tvHarga.text = root.context.getString(R.string.mata_uang_nominal, stock.symbol, CurrencyUtils.formatCurrency(stock.harga))
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