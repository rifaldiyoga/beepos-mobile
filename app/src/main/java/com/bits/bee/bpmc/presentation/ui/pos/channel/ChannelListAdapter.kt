package com.bits.bee.bpmc.presentation.ui.pos.channel

import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.ImageViewCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemChannelBinding
import com.bits.bee.bpmc.domain.model.Channel

/**
 * Created by aldi on 05/04/22.
 */
class ChannelListAdapter(
    private val onChannelClick : (Channel) -> Unit,
) : ListAdapter<Channel, RecyclerView.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemChannelBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        viewHolder.bind(getItem(holder.absoluteAdapterPosition))
    }

    inner class ViewHolder(private val binding : ItemChannelBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(model : Channel){
            binding.apply {
                tvChannel.text = model.name
                model.color?.let {
                    if(it.isNotEmpty()){
                        ImageViewCompat.setImageTintList(imageChannel, ColorStateList.valueOf(Color.parseColor(model.color)))
                    }
                }

                clContent.setOnClickListener {
                    onChannelClick(model)
                }
            }
        }
    }


    class DiffCallback : DiffUtil.ItemCallback<Channel>(){
        override fun areItemsTheSame(oldItem: Channel, newItem: Channel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Channel, newItem: Channel): Boolean {
            return oldItem.id == newItem.id
        }

    }

}