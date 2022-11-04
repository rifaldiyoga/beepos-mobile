package com.bits.bee.bpmc.presentation.ui.upload_manual

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemSyncBinding
import com.bits.bee.bpmc.domain.model.Sync

class SyncAdapter constructor(

): PagingDataAdapter<Sync, RecyclerView.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemSyncBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        getItem(position)?.let {
            viewHolder.bind(it)
        }
    }

    inner class ViewHolder(private val binding: ItemSyncBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(sync: Sync){
            binding.apply {
                tvNota.text = sync.trxNo
            }
        }

    }

    class DiffCallback : DiffUtil.ItemCallback<Sync>(){
        override fun areItemsTheSame(oldItem: Sync, newItem: Sync): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Sync, newItem: Sync): Boolean {
            return oldItem == newItem
        }

    }

}