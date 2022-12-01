package com.bits.bee.bpmc.presentation.dialog.pilih_merk

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemRbPilihMerkBinding

class RbPilihMerkAdapter(
    value: Int,
    val stringList: List<String>,
    private val mListener: EditMerkAdapterI
): RecyclerView.Adapter<RbPilihMerkAdapter.ViewHolder>() {

    private var selectedPosition : Int = 0

    init {
        this.selectedPosition = value
    }

    fun getSelectedPosition() : Int = selectedPosition

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemRbPilihMerkBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            materialRadioButton.text = getItem(holder.absoluteAdapterPosition)

            materialRadioButton.isChecked = selectedPosition == holder.absoluteAdapterPosition

            materialRadioButton.setOnClickListener {
                selectedPosition = holder.absoluteAdapterPosition
                this@RbPilihMerkAdapter.notifyDataSetChanged()
            }
            imgEdit.setOnClickListener {
                mListener.onClick(holder.absoluteAdapterPosition)
            }
        }
    }

    override fun getItemCount(): Int {
        return stringList.size
    }

    fun getItem(i : Int) = stringList[i]

    class ViewHolder(val binding : ItemRbPilihMerkBinding) : RecyclerView.ViewHolder(binding.root)

    interface EditMerkAdapterI{
        fun onClick(pos: Int)
    }

}