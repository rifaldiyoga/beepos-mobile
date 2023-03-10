package com.bits.bee.bpmc.presentation.ui.riwayat_sesi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.ItemParentSesiAdptBinding
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.model.Sesi
import com.bits.bee.bpmc.utils.DateFormatUtils
import java.util.*

class ParentSesiAdapter constructor(
    val ctx: Context,
    val listener: NestedSesiAdapter.PilihRiwayatSesiI
): RecyclerView.Adapter<ParentSesiAdapter.ViewHolder>() {

    private var mList: MutableList<Sesi> = mutableListOf()
    private var mlistPosses: MutableList<Posses> = mutableListOf()
    private lateinit var nestedSesiAdapter: NestedSesiAdapter


    fun initList(sesi: MutableList<Sesi>) {
        this.mList = sesi
        notifyDataSetChanged()
    }

    class ViewHolder(val binding : ItemParentSesiAdptBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemParentSesiAdptBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sesiModel = mList.get(position)
        holder.binding.apply {
            tvTglSesi.text = DateFormatUtils.getDate(Date(sesiModel.date))
            tvJmlTrans.text = "${sesiModel.jmltrans} Sesi"

            var isExpand = sesiModel.expand
            clExpand.visibility = if (isExpand) View.VISIBLE else View.GONE

            if (isExpand){
                imgChevron.setImageResource(R.drawable.ic_cv_up);
            }else{
                imgChevron.setImageResource(R.drawable.ic_cv_down);
            }

            nestedSesiAdapter = NestedSesiAdapter(listener, ctx)

            rvChildSesi.apply {
                layoutManager = LinearLayoutManager(ctx)
                adapter = nestedSesiAdapter
            }
            nestedSesiAdapter.submitList(sesiModel.listPosses)

            clHeaderExpand.setOnClickListener {
                sesiModel.expand = !sesiModel.expand
                notifyItemChanged(holder.absoluteAdapterPosition)
            }

        }

    }

    override fun getItemCount(): Int {
        return mList.size
    }

}