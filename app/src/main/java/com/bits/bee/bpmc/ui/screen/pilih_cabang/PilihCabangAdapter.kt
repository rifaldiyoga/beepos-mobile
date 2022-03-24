package com.bits.bee.bpmc.ui.screen.pilih_cabang

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemPilihCabangBinding
import com.bits.bee.bpmc.domain.model.Branch

/**
* Created by aldi on 04/03/22.
*/
class PilihCabangAdapter (
    private val onItemClick : (Branch) -> Unit
) : ListAdapter<Branch, RecyclerView.ViewHolder>(DiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemPilihCabangBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = getItem(position)
        val viewHolder = holder as ViewHolder
        viewHolder.bind(model)
    }

    inner class ViewHolder(private val binding: ItemPilihCabangBinding, ) : RecyclerView.ViewHolder(binding.root){

        fun bind(model : Branch){
            binding.apply {
                tvNamaDb.text = model.name
                rlContent.setOnClickListener {
                    onItemClick(model)
                }
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Branch>() {
        override fun areItemsTheSame(
            oldItem: Branch,
            newItem: Branch
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: Branch,
            newItem: Branch
        ) = oldItem == newItem
    }
}
