package com.bits.bee.bpmc.presentation.ui.cari_kecamatan

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemAdapterSimpleBinding
import com.bits.bee.bpmc.domain.model.City
import com.bits.bee.bpmc.domain.model.District
import com.bits.bee.bpmc.presentation.ui.cari_kota.CariKotaAdapter

class KecamatanAdapter constructor(
    private val mListener: PilihKecamatanI
): ListAdapter<District, RecyclerView.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemAdapterSimpleBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as KecamatanAdapter.ViewHolder
        viewHolder.bind(getItem(position))
    }

    inner class ViewHolder(private val binding: ItemAdapterSimpleBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(district: District){
            binding.apply {
                tvItem.text = district.name
                clContent.setOnClickListener {
                    mListener.onItemClick(district)
                }
            }
        }

    }

    class DiffCallback : DiffUtil.ItemCallback<District>(){
        override fun areItemsTheSame(oldItem: District, newItem: District): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: District, newItem: District): Boolean {
            return oldItem.code == newItem.code
        }

    }

    interface PilihKecamatanI{
        fun onItemClick(district: District)
    }
}