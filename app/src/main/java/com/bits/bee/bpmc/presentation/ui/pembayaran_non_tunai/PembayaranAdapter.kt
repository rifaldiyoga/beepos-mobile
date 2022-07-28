package com.bits.bee.bpmc.presentation.ui.pembayaran_non_tunai

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemNonTunaiBinding
import com.bits.bee.bpmc.domain.model.Pmtd

/**
 * Created by aldi on 25/07/22.
 */

class PembayaranAdapter(private val onItemClick : (Pmtd) -> Unit) : ListAdapter<Pmtd, RecyclerView.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemNonTunaiBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        viewHolder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemNonTunaiBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(model : Pmtd) {
            binding.apply {
                tvName.text = model.name
                clContent.setOnClickListener {
                    onItemClick(model)
                }
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Pmtd>(){
        override fun areItemsTheSame(oldItem: Pmtd, newItem: Pmtd): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Pmtd, newItem: Pmtd): Boolean {
            return oldItem.id == newItem.id
        }

    }
}