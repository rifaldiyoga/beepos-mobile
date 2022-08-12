package com.bits.bee.bpmc.presentation.ui.transaksi_penjualan

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemTransaksiPenjualanBinding
import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.utils.CurrencyUtils
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by aldi on 23/06/22.
 */
class TransaksiPenjualanAdapter(private val onItemClick : (Sale) -> Unit) : PagingDataAdapter<Sale, RecyclerView.ViewHolder>(DiffCallback()){

    private val hourFormat = SimpleDateFormat("HH:mm", Locale.getDefault())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemTransaksiPenjualanBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        getItem(position)?.let {
            viewHolder.bind(it)
        }
    }

    inner class ViewHolder(private val binding : ItemTransaksiPenjualanBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(model : Sale){
            binding.apply {
                tvNamaCust.text = model.custName

                tvTotal.text = CurrencyUtils.formatCurrency(model.total)

                tvJam.text = hourFormat.format(model.trxDate)

                clContent.setOnClickListener {
                    onItemClick(model)
                }
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Sale>(){
        override fun areItemsTheSame(oldItem: Sale, newItem: Sale): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Sale, newItem: Sale): Boolean {
            return oldItem == newItem
        }
    }
}