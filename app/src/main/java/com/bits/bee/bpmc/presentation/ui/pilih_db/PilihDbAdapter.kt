package com.bits.bee.bpmc.presentation.ui.pilih_db

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.data.source.remote.response.LoginResponse
import com.bits.bee.bpmc.databinding.ItemPilihDbBinding

/**
* Created by aldi on 04/03/22.
*/class PilihDbAdapter constructor(
    val mListener: PilihDbAdapterI
) : ListAdapter<LoginResponse.Db, RecyclerView.ViewHolder>(DiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemPilihDbBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val model = getItem(position)
        val viewHolder = holder as ViewHolder
        viewHolder.bind(model)
    }

    inner class ViewHolder(private val binding: ItemPilihDbBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(model : LoginResponse.Db){
            binding.apply {
                tvNamaDb.text = model.cmpName
                rlContent.setOnClickListener {
                    mListener.onItemClick(model)
                }
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<LoginResponse.Db>() {
        override fun areItemsTheSame(
            oldItem: LoginResponse.Db,
            newItem: LoginResponse.Db
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: LoginResponse.Db,
            newItem: LoginResponse.Db
        ) = oldItem == newItem
    }

    interface PilihDbAdapterI{
        fun onItemClick(db : LoginResponse.Db)
    }
}
