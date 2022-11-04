package com.bits.bee.bpmc.presentation.dialog.orientasi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.ItemOrientationBinding
import com.bits.bee.bpmc.utils.BPMConstants

/**
 * Created by aldi on 21/09/22
 */
class OrientasiAdapter(
    stringList: List<String>,
    selected: Int?
) : RecyclerView.Adapter<OrientasiAdapter.ViewHolder>() {

    private var stringList : List<String> = mutableListOf()
    private var selectedPosition : Int? = -1

    init {
        this.stringList = stringList
        this.selectedPosition = selected
        notifyDataSetChanged()
    }

    fun getSelectedPosition() : Int? = selectedPosition

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemOrientationBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            val context = holder.binding.root.context

            tvName.text = getItem(holder.absoluteAdapterPosition)

            if (getItem(holder.absoluteAdapterPosition) == BPMConstants.SCREEN_POTRAIT)
                imageView18.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_potrait))
            else
                imageView18.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_landscape))

            if(selectedPosition == holder.absoluteAdapterPosition) {
                imageView18.setColorFilter(ContextCompat.getColor(context, R.color.red))
                tvName.setTextColor(ContextCompat.getColor(context, R.color.maroon))
                clContent.background = ContextCompat.getDrawable(context, R.drawable.bg_rect_primary)
            } else {
                imageView18.setColorFilter(ContextCompat.getColor(context, R.color.gray))
                clContent.background = ContextCompat.getDrawable(context, R.drawable.bg_rect_stroke_light_gray)
                tvName.setTextColor(ContextCompat.getColor(context, R.color.black))
            }

            clContent.setOnClickListener {
                selectedPosition = holder.absoluteAdapterPosition
                notifyDataSetChanged()
            }
        }
    }

    override fun getItemCount(): Int = stringList.size

    fun getItem(i : Int) = stringList[i]

    class ViewHolder(val binding : ItemOrientationBinding) : RecyclerView.ViewHolder(binding.root)

}