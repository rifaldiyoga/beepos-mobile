package com.bits.bee.bpmc.presentation.dialog.pilih_kategori

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemRbPilihKategoriBinding
import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.domain.model.KategoriProduk

class RbPilihKategoriAdapter(
    private var selectedPosition : Int = 0,
    private val mListener: EditKategoriAdapterI
): ListAdapter<ItemGroup, RbPilihKategoriAdapter.ViewHolder>(DiffCallback()) {

    fun getSelectedPosition() : ItemGroup? {
        if(selectedPosition > -1)
            return getItem(selectedPosition)
        return null
    }

    fun setSelected(itemGrp: ItemGroup?) {
        itemGrp?.let {
            currentList.forEachIndexed { index, itemGroup ->
                if(itemGrp.id == itemGroup.id) {
                    selectedPosition = index
                    return
                }
            }
            notifyDataSetChanged()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemRbPilihKategoriBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            val itemGroup = getItem(position)
            materialRadioButton.text = itemGroup.name

            viewLeft.isVisible = itemGroup.upId != null

            materialRadioButton.isChecked = selectedPosition == holder.absoluteAdapterPosition

            materialRadioButton.setOnClickListener {
                if(selectedPosition == holder.absoluteAdapterPosition){
                    selectedPosition = -1
                } else {
                    selectedPosition = holder.absoluteAdapterPosition
                }
                this@RbPilihKategoriAdapter.notifyDataSetChanged()
            }
            imgEdit.setOnClickListener {
                mListener.onClick(itemGroup)
            }

        }
    }

    class ViewHolder(val binding : ItemRbPilihKategoriBinding) : RecyclerView.ViewHolder(binding.root)

    interface EditKategoriAdapterI{
        fun onClick(itemGrp : ItemGroup)
    }

    class DiffCallback : DiffUtil.ItemCallback<ItemGroup>(){
        override fun areItemsTheSame(oldItem: ItemGroup, newItem: ItemGroup): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ItemGroup, newItem: ItemGroup): Boolean {
            return oldItem == newItem
        }

    }
}