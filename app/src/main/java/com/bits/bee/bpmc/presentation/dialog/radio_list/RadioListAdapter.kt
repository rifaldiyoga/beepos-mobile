package com.bits.bee.bpmc.presentation.dialog.radio_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemRadioButtonBinding

/**
 * Created by aldi on 05/04/22.
 */
class RadioListAdapter(
    stringList: List<String>,
    selected: Int?
) : RecyclerView.Adapter<RadioListAdapter.ViewHolder>() {

    private var stringList : List<String> = mutableListOf()
    private var selectedPosition : Int? = -1
//    private var posStr: String

    init {
        this.stringList = stringList
        this.selectedPosition = selected
//        posStr = selectedStr
    }

    fun getSelectedPosition() : Int? = selectedPosition

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemRadioButtonBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            materialRadioButton.text = getItem(holder.absoluteAdapterPosition)

            materialRadioButton.isChecked = selectedPosition == holder.absoluteAdapterPosition

            materialRadioButton.setOnClickListener {
                selectedPosition = holder.absoluteAdapterPosition
                this@RadioListAdapter.notifyDataSetChanged()
            }
        }
    }

    override fun getItemCount(): Int = stringList.size

    fun getItem(i : Int) = stringList[i]

    class ViewHolder(val binding : ItemRadioButtonBinding) : RecyclerView.ViewHolder(binding.root)

}