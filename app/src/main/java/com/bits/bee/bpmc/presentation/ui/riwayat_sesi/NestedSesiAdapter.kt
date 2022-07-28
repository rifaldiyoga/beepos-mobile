package com.bits.bee.bpmc.presentation.ui.riwayat_sesi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemMemberBinding
import com.bits.bee.bpmc.databinding.ItemNestedSesiBinding
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.presentation.ui.member.MemberAdapter
import java.sql.Date
import java.text.SimpleDateFormat

class NestedSesiAdapter constructor(

): ListAdapter<Posses, RecyclerView.ViewHolder>(Diffcallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemNestedSesiBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as NestedSesiAdapter.ViewHolder
        viewHolder.bind(getItem(viewHolder.absoluteAdapterPosition))
    }

    inner class ViewHolder(private val binding : ItemNestedSesiBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(model : Posses) {
            binding.apply {
                tvSesi.text = "model.name"
                tvtotalRekap.text = model.endBal.toString()

                val backToDate = Date(model.trxDate.time)
                val format = SimpleDateFormat("yyyy.MM.dd")

                tvRekapWaktu.text = format.format(backToDate)

                clNestedSesi.setOnClickListener {

                }
//                lLContentMember.setOnClickListener {
//                    onMemberClick(model)
//                }
            }
        }

    }

    class Diffcallback : DiffUtil.ItemCallback<Posses>(){

        override fun areItemsTheSame(oldItem: Posses, newItem: Posses): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Posses, newItem: Posses): Boolean {
            return oldItem.possesId == newItem.possesId
        }

    }

}