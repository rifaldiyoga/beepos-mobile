package com.bits.bee.bpmc.presentation.ui.pos.promo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemPromoBinding
import com.bits.bee.bpmc.domain.model.Promo

/**
 * Created by aldi on 19/08/22.
 */
class PromoAdapter : ListAdapter<Promo, RecyclerView.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemPromoBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        viewHolder.bind(getItem(position))
    }

    inner class ViewHolder(val binding : ItemPromoBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(promo : Promo){
            binding.apply {
                tvTitle.text = promo.promoName
                tvDesc.isVisible = promo.note.isNotEmpty()
                tvDesc.text = promo.note
            }
        }

    }

    class DiffCallback : DiffUtil.ItemCallback<Promo>(){
        override fun areItemsTheSame(oldItem: Promo, newItem: Promo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Promo, newItem: Promo): Boolean {
            return oldItem == newItem
        }

    }
}