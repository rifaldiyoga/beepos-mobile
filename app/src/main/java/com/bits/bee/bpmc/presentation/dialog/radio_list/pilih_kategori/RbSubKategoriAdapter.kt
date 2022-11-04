package com.bits.bee.bpmc.presentation.dialog.radio_list.pilih_kategori

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemRbSubKategoriBinding

class RbSubKategoriAdapter(
    listSubKategori: List<String>
): RecyclerView.Adapter<RbSubKategoriAdapter.ViewHolder>() {

    private var mListSubKategori: List<String> = mutableListOf()
    private var selectedPosition : Int = -1

    init {
//        this.selectedPosition = selected
        this.mListSubKategori = listSubKategori
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemRbSubKategoriBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            materialRadioButton.text = getItem(holder.absoluteAdapterPosition)
            materialRadioButton.isChecked = selectedPosition == holder.absoluteAdapterPosition
            materialRadioButton.setOnClickListener {
                selectedPosition = holder.absoluteAdapterPosition
                return@setOnClickListener
//                this@RbSubKategoriAdapter.notifyDataSetChanged()
            }
        }
    }

    override fun getItemCount(): Int {
        return mListSubKategori.size
    }

    fun getItem(i : Int) = mListSubKategori[i]

    class ViewHolder(val binding : ItemRbSubKategoriBinding) : RecyclerView.ViewHolder(binding.root)
}