package com.bits.bee.bpmc.presentation.ui.setting_favorite.setting_fav_member

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.ItemMemberFavBinding
import com.bits.bee.bpmc.domain.model.Bp

/**
 * Created by aldi on 06/10/22
 */
class FavMemberAdapter constructor (
    private val onMemberClick : (Bp) -> Unit,
) : PagingDataAdapter<Bp, RecyclerView.ViewHolder>(Diffcallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemMemberFavBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        getItem(position)?.let {
            viewHolder.bind(it)
        }
    }

    inner class ViewHolder(private val binding : ItemMemberFavBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(model : Bp) {
            binding.apply {
                binding.root.setOnClickListener {
                    onMemberClick(model)
                    notifyDataSetChanged()
                }
                tvNamaMember.text = model.name
                tvNoTelp.text = model.bpAddr?.phone ?: ""

                val drawable = ContextCompat.getDrawable(tvNamaMember.context, when(model.isFavorit){
                    true -> R.drawable.ic_star_enabled
                    false -> R.drawable.ic_star_disabled
                })

                ivFav.setImageDrawable(drawable)
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