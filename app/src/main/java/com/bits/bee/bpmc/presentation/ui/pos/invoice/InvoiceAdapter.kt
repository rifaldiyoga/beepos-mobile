package com.bits.bee.bpmc.presentation.ui.pos.invoice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemInvoiceBinding
import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.utils.CurrencyUtils

/**
 * Created by aldi on 24/05/22.
 */
class InvoiceAdapter(
    private val onItemClicK : (Saled) -> Unit,
    private val onDeleteClick : (Saled) -> Unit
) : ListAdapter<Saled, RecyclerView.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemInvoiceBinding.inflate(
                inflater, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        viewHolder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding : ItemInvoiceBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(model : Saled) {
            binding.apply {
                tvNamaItem.text = model.name
                tvQty.text = CurrencyUtils.formatCurrency(model.qty)
                tvHarga.text = CurrencyUtils.formatCurrency(model.listPrice)

                clContent.setOnClickListener {
                    onItemClicK(model)
                }
                ivDelete.setOnClickListener {
                    onDeleteClick(model)
                }
            }
        }

    }

    class DiffCallback : DiffUtil.ItemCallback<Saled>() {

        override fun areItemsTheSame(oldItem: Saled, newItem: Saled): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Saled, newItem: Saled): Boolean {
            return oldItem.id == newItem.id
        }

    }
}