package com.bits.bee.bpmc.ui.screen.pilih_kasir

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.data.source.remote.response.CashierResponse
import com.bits.bee.bpmc.databinding.ItemPilihKasirBinding

/**
 * Created by aldi on 22/03/22.
 */
class PilihKasirAdapter(private val onItemClick : (CashierResponse.Cashier) -> Unit) : ListAdapter<CashierResponse.Cashier, RecyclerView.ViewHolder>(DiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemPilihKasirBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = getItem(position)
        val viewHolder = holder as ViewHolder
        viewHolder.bind(model)
    }

    inner class ViewHolder(private val binding: ItemPilihKasirBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(model : CashierResponse.Cashier){
            binding.apply {
                tvNamaKasir.text = model.cashierName
                rlContent.setOnClickListener {
                    onItemClick(model)
                }
                tvStatus.background = if(model.isActive)
                    ContextCompat.getDrawable(rlContent.context, R.drawable.bg_rounded_green)
                else
                    ContextCompat.getDrawable(rlContent.context, R.drawable.bg_rounded_red)
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<CashierResponse.Cashier>() {
        override fun areItemsTheSame(
            oldItem: CashierResponse.Cashier,
            newItem: CashierResponse.Cashier
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: CashierResponse.Cashier,
            newItem: CashierResponse.Cashier
        ) = oldItem == newItem
    }
}
