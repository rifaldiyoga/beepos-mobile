package com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemRadioButtonBinding
import com.bits.bee.bpmc.domain.model.ItemGroup

/**
 * Created by aldi on 05/04/22.
 */
class GroupListAdapter(
    val list: MutableList<ItemGroup> = mutableListOf(),
    var selectedPos: Int? = null,
) : RecyclerView.Adapter<GroupListAdapter.ViewHolder>() {

    fun submitData(list : List<ItemGroup>) {
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()
    }

    fun getSelectedPosition() : Int? = selectedPos

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemRadioButtonBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            materialRadioButton.text = getItem(holder.absoluteAdapterPosition).name

            materialRadioButton.isChecked = selectedPos == holder.absoluteAdapterPosition

            materialRadioButton.setOnClickListener {
                selectedPos = holder.absoluteAdapterPosition
                this@GroupListAdapter.notifyDataSetChanged()
            }
        }
    }

    override fun getItemCount(): Int = list.size

    fun getItem(i : Int) = list[i]

    class ViewHolder(val binding : ItemRadioButtonBinding) : RecyclerView.ViewHolder(binding.root)

}