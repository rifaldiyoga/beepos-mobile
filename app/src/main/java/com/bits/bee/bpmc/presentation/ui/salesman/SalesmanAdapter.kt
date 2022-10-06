package com.bits.bee.bpmc.presentation.ui.salesman

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemMemberBinding
import com.bits.bee.bpmc.domain.model.Srep

/**
 * Created by aldi on 22/04/22.
 */
class SalesmanAdapter constructor(
    private val onMemberClick : (Srep) -> Unit,
    private val onEyeClick: (Srep) -> Unit
) : ListAdapter<Srep, RecyclerView.ViewHolder>(Diffcallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemMemberBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        viewHolder.bind(getItem(viewHolder.absoluteAdapterPosition))
    }

    inner class ViewHolder(private val binding : ItemMemberBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(model : Srep) {
            binding.apply {
                tvNamaMember.text = model.name
                lLContentMember.setOnClickListener {
                    onMemberClick(model)
                }
                llDetailMember.setOnClickListener {
                    onEyeClick(model)
                }
            }
        }

    }

    class Diffcallback : DiffUtil.ItemCallback<Srep>(){

        override fun areItemsTheSame(oldItem: Srep, newItem: Srep): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Srep, newItem: Srep): Boolean {
            return oldItem.id == newItem.id
        }

    }

}