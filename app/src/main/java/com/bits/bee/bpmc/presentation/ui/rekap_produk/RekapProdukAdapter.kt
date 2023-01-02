package com.bits.bee.bpmc.presentation.ui.rekap_produk

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.ItemRekapProdukBinding
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.RekapProduk
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.utils.CurrencyUtils

class RekapProdukAdapter(
    private val ctx: Context,
    private val mlistener: PilihProdukPidI
    ) : PagingDataAdapter<RekapProduk, RecyclerView.ViewHolder>(Diffcallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemRekapProdukBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        getItem(position)?.let {
            viewHolder.bind(it)
        }
    }

    inner class ViewHolder(private val binding : ItemRekapProdukBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(model : RekapProduk) {
            binding.apply {
                tvBarang.text = model.name
                tvQty.text = CurrencyUtils.formatCurrency(model.qty)
                tvSubtotal.text = ctx.getString(
                    R.string.mata_uang_nominal,
                    "Rp", CurrencyUtils.formatCurrency(model.subtotal))

//                clRekapProduk.setOnClickListener {
//                    if (model.usePid)
//                        mlistener.onClick(model)
//                }
            }
        }
    }

    class Diffcallback : DiffUtil.ItemCallback<RekapProduk>(){

        override fun areItemsTheSame(oldItem: RekapProduk, newItem: RekapProduk): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: RekapProduk, newItem: RekapProduk): Boolean {
            return oldItem.itemId == newItem.itemId
        }

    }

    interface PilihProdukPidI{
        fun onClick(item: Item)
    }
}