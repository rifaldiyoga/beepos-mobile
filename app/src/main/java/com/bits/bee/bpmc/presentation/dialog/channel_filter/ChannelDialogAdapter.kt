package com.bits.bee.bpmc.presentation.dialog.channel_filter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemCheckboxButtonBinding
import com.bits.bee.bpmc.domain.model.Channel

/**
 * Created by aldi on 24/06/22.
 */
class ChannelDialogAdapter(
    private val onItemClick : (Channel) -> Unit
) : ListAdapter<Channel, RecyclerView.ViewHolder>(DiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemCheckboxButtonBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        viewHolder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding : ItemCheckboxButtonBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(model : Channel){
            binding.apply {
                materialCheckBoxButton.text = model.name
                materialCheckBoxButton.isChecked = model.isSelected
                materialCheckBoxButton.setOnClickListener {
                    onItemClick(model)
                }
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Channel>(){
        override fun areItemsTheSame(oldItem: Channel, newItem: Channel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Channel, newItem: Channel): Boolean {
            return oldItem == newItem
        }

    }
}