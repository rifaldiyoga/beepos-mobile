package com.bits.bee.bpmc.presentation.ui.rekap_produk

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemDetailProdukBinding
import com.bits.bee.bpmc.domain.model.Stock

class DetailProdukAdapter(private val ctx: Context): ListAdapter<Stock, RecyclerView.ViewHolder>(Diffcallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemDetailProdukBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as DetailProdukAdapter.ViewHolder
        viewHolder.bind(getItem(viewHolder.absoluteAdapterPosition))
    }

    inner class ViewHolder(private val binding : ItemDetailProdukBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(model : Stock) {
            binding.apply {
                tvPid.text = model.pid
                tvQty.text = model.qty.toString() + " "
            }
        }

    }

    class Diffcallback : DiffUtil.ItemCallback<Stock>(){

        override fun areItemsTheSame(oldItem: Stock, newItem: Stock): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Stock, newItem: Stock): Boolean {
            return oldItem.id == newItem.id
        }

    }
}