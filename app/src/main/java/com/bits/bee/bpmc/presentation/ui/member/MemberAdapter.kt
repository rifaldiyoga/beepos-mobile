package com.bits.bee.bpmc.presentation.ui.member

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.R
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

                tvNamaMember.setCompoundDrawablesWithIntrinsicBounds(null, null, if(model.isFavorit) ContextCompat.getDrawable(binding.root.context, R.drawable.ic_star_enabled) else null, null)

                clContent.setBackgroundColor(
                    ContextCompat.getColor(binding.root.context,
                        if(activeMember != null && activeMember!!.id == model.id)
                            R.color.light_red
                        else
                            R.color.white)
                )
                ivStatus.isVisible = activeMember != null && activeMember!!.id == model.id
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