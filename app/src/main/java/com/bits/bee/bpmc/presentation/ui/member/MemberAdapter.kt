package com.bits.bee.bpmc.presentation.ui.member

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemMemberBinding
import com.bits.bee.bpmc.domain.model.Bp

/**
 * Created by aldi on 22/04/22.
 */
class MemberAdapter constructor(
    private val onMemberClick : (Bp) -> Unit,
    private val onEyeClick: (Bp) -> Unit,
    private var activeMember : Bp? = null
) : PagingDataAdapter<Bp, RecyclerView.ViewHolder>(Diffcallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemMemberBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        getItem(viewHolder.absoluteAdapterPosition)?.let {
            viewHolder.bind(it)
        }
    }

    inner class ViewHolder(private val binding : ItemMemberBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(model : Bp) {
            binding.apply {
                tvNamaMember.text = model.name
                tvNoTelp.text = model.bpAddr?.phone ?: ""
                lLContentMember.setOnClickListener {
                    onMemberClick(model)
                }
                llDetailMember.setOnClickListener {
                    onEyeClick(model)
                }

                rbMember.isChecked = activeMember != null && activeMember!!.id == model.id
                rbMember.isSelected = activeMember != null && activeMember!!.id == model.id
            }
        }

    }

    class Diffcallback : DiffUtil.ItemCallback<Bp>(){

        override fun areItemsTheSame(oldItem: Bp, newItem: Bp): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Bp, newItem: Bp): Boolean {
            return oldItem.id == newItem.id
        }

    }
}