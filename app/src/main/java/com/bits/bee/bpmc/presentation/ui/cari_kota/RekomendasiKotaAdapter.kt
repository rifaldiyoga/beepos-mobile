package com.bits.bee.bpmc.presentation.ui.cari_kota

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemKotaBinding
import com.bits.bee.bpmc.domain.model.City
import com.bits.bee.bpmc.domain.model.CityPopuler

/**
 * Created by aldi on 18/05/22.
 */
class RekomendasiKotaAdapter constructor(
    private val mListener: PilihKotaPopulerI
) : ListAdapter<CityPopuler, RecyclerView.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemKotaBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        viewHolder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemKotaBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(city: CityPopuler){
            binding.apply {
                tvNamaKota.text = city.nama_city
                clContent.setOnClickListener {
                    mListener.onItemClick(city)
                }
            }
        }

    }

    class DiffCallback : DiffUtil.ItemCallback<CityPopuler>(){
        override fun areItemsTheSame(oldItem: CityPopuler, newItem: CityPopuler): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CityPopuler, newItem: CityPopuler): Boolean {
            return oldItem.id == newItem.id
        }

    }

    interface PilihKotaPopulerI{
        fun onItemClick(city: CityPopuler)
    }
}