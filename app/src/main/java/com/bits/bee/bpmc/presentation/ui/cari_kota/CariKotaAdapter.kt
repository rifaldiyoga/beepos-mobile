package com.bits.bee.bpmc.presentation.ui.cari_kota

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemAdapterSimpleBinding
import com.bits.bee.bpmc.domain.model.City

/**
 * Created by aldi on 18/05/22.
 */
class CariKotaAdapter : ListAdapter<City, RecyclerView.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemAdapterSimpleBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        viewHolder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemAdapterSimpleBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(city: City){
            binding.apply {
                tvItem.text = city.name
            }
        }

    }

    class DiffCallback : DiffUtil.ItemCallback<City>(){
        override fun areItemsTheSame(oldItem: City, newItem: City): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: City, newItem: City): Boolean {
            return oldItem.code == newItem.code
        }

    }
}