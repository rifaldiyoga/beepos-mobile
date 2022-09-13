package com.bits.bee.bpmc.presentation.ui.pos.klaim_promo

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemPosMenuBinding
import com.bits.bee.bpmc.domain.model.Item

/**
 * Created by aldi on 09/09/22
 */
class KlaimPromoAdapater : ListAdapter<Item, RecyclerView.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    inner class ViewHolder(val binding : ItemPosMenuBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(){
            
        }

    }

    class DiffCallback() : DiffUtil.ItemCallback<Item>(){

        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.id == newItem.id
        }

    }

}