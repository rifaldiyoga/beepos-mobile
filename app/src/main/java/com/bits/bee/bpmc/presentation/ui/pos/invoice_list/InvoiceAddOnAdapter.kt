package com.bits.bee.bpmc.presentation.ui.pos.invoice_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemInvoiceAddonBinding
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.utils.CurrencyUtils
import java.math.BigDecimal

/**
 * Created by aldi on 26/08/22.
 */
class InvoiceAddOnAdapter(private val qty : BigDecimal) : ListAdapter<Saled, RecyclerView.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater =LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemInvoiceAddonBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        viewHolder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding : ItemInvoiceAddonBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(model : Saled){
            binding.apply {
                val qty = model.qty / qty
                tvAddon.text = if(qty > BigDecimal.ONE) "${CurrencyUtils.formatCurrency(qty)} ${model.name}" else model.name
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Saled>(){
        override fun areItemsTheSame(oldItem: Saled, newItem: Saled): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Saled, newItem: Saled): Boolean {
            return oldItem == newItem
        }
    }

}