package com.bits.bee.bpmc.presentation.ui.pilih_kasir

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.ItemPilihKasirBinding
import com.bits.bee.bpmc.domain.model.Cashier

/**
 * Created by aldi on 22/03/22.
 */
class PilihKasirAdapter(private val onItemClick : (Cashier) -> Unit) : ListAdapter<Cashier, RecyclerView.ViewHolder>(DiffCallback()){

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

        fun bind(model : Cashier){
            binding.apply {
                val context = tvNamaKasir.context
                tvNamaKasir.text = model.cashierName
                clContent.setOnClickListener {
                    onItemClick(model)
                }
                tvStatus.background = if(!model.status) {
                    ContextCompat.getDrawable(clContent.context, R.drawable.bg_rounded_green)
                } else {
                    ContextCompat.getDrawable(clContent.context, R.drawable.bg_rounded_red)
                }

                tvStatus.text = if(!model.status) context.getString(R.string.tersedia) else context.getString(R.string.digunakan)

            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Cashier>() {
        override fun areItemsTheSame(
            oldItem: Cashier,
            newItem: Cashier
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: Cashier,
            newItem: Cashier
        ) = oldItem == newItem
    }
}
