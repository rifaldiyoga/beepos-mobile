package com.bits.bee.bpmc.presentation.dialog.draft_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemDraftDialogBinding
import com.bits.bee.bpmc.domain.model.Sale

/**
 * Created by aldi on 24/06/22.
 */
class DraftDialogAdapter(private val onItemClick : (Sale) -> Unit) : ListAdapter<Sale, RecyclerView.ViewHolder>(DiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemDraftDialogBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        viewHolder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding : ItemDraftDialogBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(model : Sale){
            binding.apply {
                tvCust.text = model.custName
                llContent.setOnClickListener {
                    onItemClick(model)
                }
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Sale>(){
        override fun areItemsTheSame(oldItem: Sale, newItem: Sale): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Sale, newItem: Sale): Boolean {
            return oldItem == newItem
        }

    }
}