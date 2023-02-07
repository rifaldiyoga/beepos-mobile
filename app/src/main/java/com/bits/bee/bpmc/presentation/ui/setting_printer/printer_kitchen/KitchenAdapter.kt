package com.bits.bee.bpmc.presentation.ui.setting_printer.printer_kitchen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemKitchenBinding
import com.bits.bee.bpmc.domain.model.Kitchen

class KitchenAdapter(
    private val onItemClick : (Kitchen) -> Unit
) : ListAdapter<Kitchen, KitchenAdapter.ViewHolder>(DiffCallback()) {

    inner class ViewHolder(private val binding : ItemKitchenBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(model : Kitchen){
            binding.apply {
                tvTitle.text = model.name
                cbChecked.isChecked = model.isUsed
                cbChecked.setOnClickListener {
                    onItemClick(model)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemKitchenBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val printerKitchen = getItem(position)
        holder.bind(printerKitchen)
        holder.itemView.setOnClickListener {
            onItemClick(printerKitchen)
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Kitchen>() {
        override fun areItemsTheSame(oldItem: Kitchen, newItem: Kitchen): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Kitchen, newItem: Kitchen): Boolean {
            return oldItem == newItem
        }

    }

}