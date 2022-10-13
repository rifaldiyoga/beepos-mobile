package com.bits.bee.bpmc.presentation.ui.setting_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.ListPaneRowItemBinding

/**
 * Created by aldi on 12/10/22
 */
class TwoPaneAdapter(
    private val dataSet: Array<String>,
    private val onClick: (CharSequence) -> Unit,
) : RecyclerView.Adapter<TwoPaneAdapter.ViewHolder>() {

    inner class ViewHolder(val binding : ListPaneRowItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data : String) {
            binding.textView27.text = data
            binding.ivIcon.setImageDrawable(ContextCompat.getDrawable(binding.root.context, getDrawable(data)))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
        return ViewHolder(
            ListPaneRowItemBinding.inflate(view, parent, false)
        )
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.bind(dataSet[position])
        holder.itemView.setOnClickListener {
            onClick(dataSet[position])
        }
    }

    override fun getItemCount() = dataSet.size

    fun getDrawable(data: CharSequence) : Int =
        when(data){
            "POS" -> R.drawable.ic_browser
            "Favorit" -> R.drawable.ic_star
            "Nota" -> R.drawable.ic_note
            "Print" -> R.drawable.ic_printer
            "Sistem" -> R.drawable.ic_upload
            "Bantuan" -> R.drawable.ic_info
            "Keluar" -> R.drawable.ic_logout_black
            else -> R.drawable.ic_info
        }

}
