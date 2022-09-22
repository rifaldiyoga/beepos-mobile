package com.bits.bee.bpmc.presentation.ui.cek_stok

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.ItemCekStokBinding
import com.bits.bee.bpmc.databinding.ItemParentSesiAdptBinding
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.Stock
import com.bits.bee.bpmc.presentation.ui.riwayat_sesi.ParentSesiAdapter
import com.bits.bee.bpmc.utils.CurrencyUtils
import java.math.BigDecimal

class CekStokAdapter constructor(

): RecyclerView.Adapter<CekStokAdapter.ViewHolder>() {

    private var mListStock: List<Stock> = mutableListOf()
    private var mListItem: List<Item> = mutableListOf()

    fun initLists(stock: List<Stock>, itemsList: List<Item>) {
        this.mListStock = stock
        this.mListItem = itemsList
        notifyDataSetChanged()
    }

    class ViewHolder(val binding : ItemCekStokBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(
            ItemCekStokBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val stock = mListStock.get(position)
        val item = mListItem.get(position)
        holder.binding.apply {
            tvItem.text = item.name1
            tvPorsi.text = CurrencyUtils.formatCurrency(BigDecimal(stock.qty))+" Porsi"
            tvHarga.text = root.context.getString(R.string.mata_uang_nominal,item.crcSymbol, CurrencyUtils.formatCurrency(item.price))
        }
    }

    override fun getItemCount(): Int {
        return mListStock.size.and(mListItem.size)
    }

}