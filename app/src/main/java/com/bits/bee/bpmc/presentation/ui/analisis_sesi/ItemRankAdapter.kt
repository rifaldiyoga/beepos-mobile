package com.bits.bee.bpmc.presentation.ui.analisis_sesi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemRankRvBinding
import com.bits.bee.bpmc.domain.model.RankItem

class ItemRankAdapter constructor(

): ListAdapter<RankItem, RecyclerView.ViewHolder>(Diffcallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemRankRvBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ItemRankAdapter.ViewHolder
        viewHolder.bind(getItem(viewHolder.absoluteAdapterPosition), position)
    }

    inner class ViewHolder(private val binding : ItemRankRvBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(model: RankItem, position: Int) {
            var i = position+1
            binding.apply {
                tvNo.text = i.toString()
                tvName.text = model.name
//                tvQty.text = model.qty.toString()
//                tvTotal.text = model.total.toString()
            }
        }

    }

    class Diffcallback : DiffUtil.ItemCallback<RankItem>(){

        override fun areItemsTheSame(oldItem: RankItem, newItem: RankItem): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: RankItem, newItem: RankItem): Boolean {
            return oldItem == newItem
        }

    }
}