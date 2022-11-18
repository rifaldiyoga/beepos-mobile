package com.bits.bee.bpmc.presentation.ui.rekap_produk

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.ItemRekapProdukBinding
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.utils.CurrencyUtils

class RekapProdukAdapter(
    private val ctx: Context,
    private val mlistener: PilihProdukPidI
    ) : ListAdapter<Item, RecyclerView.ViewHolder>(Diffcallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemRekapProdukBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as RekapProdukAdapter.ViewHolder
        viewHolder.bind(getItem(viewHolder.absoluteAdapterPosition))
    }

    inner class ViewHolder(private val binding : ItemRekapProdukBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(model : Item) {
            binding.apply {
                tvBarang.text = model.name1
                tvQty.text = model.qty.toString() + " "
                tvSubtotal.text = ctx.getString(
                    R.string.mata_uang_nominal,
                    "Rp", CurrencyUtils.formatCurrency(model.subtotal))
            }
        }

    }

    class Diffcallback : DiffUtil.ItemCallback<Item>(){

        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }

    }

    interface PilihProdukPidI{
        fun onClick(item: Item)
    }
}