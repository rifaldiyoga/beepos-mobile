package com.bits.bee.bpmc.presentation.ui.pos.pos

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.ItemPosItgrpBinding
import com.bits.bee.bpmc.domain.model.ItemGroup

/**
 * Created by aldi on 26/09/22
 */
class ItgrpAdapter(
    val onItemClick : (ItemGroup) -> Unit
) : ListAdapter<ItemGroup, RecyclerView.ViewHolder>(DiffCallback()) {

    var selectedPos : Int = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemPosItgrpBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder

        viewHolder.bind(getItem(position))

        viewHolder.itemView.setOnClickListener {
            onItemClick(getItem(position))
            selectedPos = position
            notifyDataSetChanged()
        }
    }

    inner class ViewHolder(val binding : ItemPosItgrpBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(model : ItemGroup){
            binding.apply {
                val context = binding.root.context

                tvName.text = model.name

                if(selectedPos == absoluteAdapterPosition)
                    tvName.setTextColor(ContextCompat.getColor(context, R.color.red))
                else
                    tvName.setTextColor(ContextCompat.getColor(context, R.color.black))
            }
        }

    }

    class DiffCallback : DiffUtil.ItemCallback<ItemGroup>(){
        override fun areItemsTheSame(oldItem: ItemGroup, newItem: ItemGroup): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ItemGroup, newItem: ItemGroup): Boolean {
            return oldItem == newItem
        }

    }
}