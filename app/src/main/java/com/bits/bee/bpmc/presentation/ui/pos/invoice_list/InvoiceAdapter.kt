package com.bits.bee.bpmc.presentation.ui.pos.invoice_list

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.ItemInvoiceBinding
import com.bits.bee.bpmc.databinding.ItemInvoiceRetailBinding
import com.bits.bee.bpmc.domain.model.SaleAddOnD
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.presentation.ui.pos.PosModeState
import com.bits.bee.bpmc.utils.CurrencyUtils
import com.bits.bee.bpmc.utils.gone
import com.bits.bee.bpmc.utils.visible
import java.math.BigDecimal

/**
 * Created by aldi on 24/05/22.
 */
class InvoiceAdapter(
    private val onItemClicK : (Saled) -> Unit,
    private val onDeleteClick : (Saled) -> Unit,
    private val isDelete : Boolean = true,
    private val modePos : PosModeState = PosModeState.RetailState,
    private var saleAddOnList : List<SaleAddOnD> = mutableListOf()
) : ListAdapter<Saled, RecyclerView.ViewHolder>(DiffCallback()) {

    fun submitSaleAddOnDList(saleAddOnList: List<SaleAddOnD>){
        this.saleAddOnList = saleAddOnList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when(modePos) {
            PosModeState.FnBState -> {
                ViewHolderFnb(
                    ItemInvoiceBinding.inflate(
                        inflater, parent, false
                    )
                )
            }
            PosModeState.RetailState -> {
                ViewHolderRetail(
                    ItemInvoiceRetailBinding.inflate(
                        inflater, parent, false
                    )
                )
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as ViewHolder
        viewHolder.bind(getItem(position))
    }

    interface ViewHolder {
        fun bind(model: Saled)
    }

    inner class ViewHolderFnb(private val binding : ItemInvoiceBinding) : RecyclerView.ViewHolder(binding.root), ViewHolder{

        override fun bind(model : Saled) {

            binding.apply {
                val context = binding.root.context
                var subtotal = model.subtotal
                tvNamaItem.text = model.name
                tvQty.text = CurrencyUtils.formatCurrency(model.qty)
                tvHargaDiskon.text = context.getString(R.string.mata_uang_nominal, model.crcSymbol, CurrencyUtils.formatCurrency(model.listPrice * model.qty))
                tvHargaDiskon.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG

                if(model.discAmt.compareTo(BigDecimal.ZERO) == 0){
                    tvLabelItem.gone()
                    tvHargaDiskon.gone()
                } else {
                    tvLabelItem.visible()
                    tvHargaDiskon.visible()
                    tvLabelItem.text = context.getString(R.string.diskon_nominal, CurrencyUtils.formatCurrency(model.discAmt))
                }

                if(!isDelete){
                    ivDelete.gone()
                } else {
                    ivDelete.visibility = if (model.isBonus) View.INVISIBLE else View.VISIBLE
                }

                clContent.setOnClickListener {
                    onItemClicK(model)
                }

                ivDelete.setOnClickListener {
                    if (!model.isBonus)
                        onDeleteClick(model)
                }

                ivDelete.isEnabled = !model.isBonus

                val saledAddonList = saleAddOnList.filter { model == it.upSaled ||(model.id != null && it.upSaled != null && it.upSaled!!.id != null && model.id == it.upSaled!!.id) }.map { it.saled }

                rvAddon.isVisible = saledAddonList.isNotEmpty()

                if(saledAddonList.isNotEmpty()) {
                    val addOnAdapter = InvoiceAddOnAdapter(model.qty)

                    rvAddon.apply {
                        adapter = addOnAdapter
                        layoutManager = LinearLayoutManager(context)
                    }

                    addOnAdapter.submitList(saledAddonList)

                    saledAddonList.forEach {
                        subtotal += it?.subtotal ?: BigDecimal.ZERO
                    }
                }

                tvHarga.text =  context.getString(R.string.mata_uang_nominal, model.crcSymbol, CurrencyUtils.formatCurrency(subtotal))

                if (model.isBonus && model.isBonusUsed) {
                    tvLabelItem.visibility = View.VISIBLE
                    tvLabelItem.text = "Free"
                }
                tvNote.isVisible = model.dNotes.isNotEmpty()
                tvNote.text = "Note : ${model.dNotes}"
            }
        }
    }

    inner class ViewHolderRetail(private val binding : ItemInvoiceRetailBinding) : RecyclerView.ViewHolder(binding.root), ViewHolder {

        override fun bind(model : Saled) {
            binding.apply {
                val context = binding.root.context
                tvNamaItem.text = model.name
                tvPid.isVisible = !model.pid.isNullOrEmpty()
                tvPid.text = model.pid
                tvQty.text = "${CurrencyUtils.formatCurrency(model.qty)} ${model.unit}. @${CurrencyUtils.formatCurrency(model.listPrice)}"
                tvHarga.text =  context.getString(R.string.mata_uang_nominal, model.crcSymbol, CurrencyUtils.formatCurrency(model.subtotal))
                tvHargaDiskon.text = context.getString(R.string.mata_uang_nominal, model.crcSymbol, CurrencyUtils.formatCurrency(model.listPrice * model.qty))
                tvHargaDiskon.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG

                if(model.discAmt.compareTo(BigDecimal.ZERO) == 0){
                    tvLabelItem.gone()
                    tvHargaDiskon.gone()
                } else {
                    tvLabelItem.visible()
                    tvHargaDiskon.visible()
                    tvLabelItem.text = context.getString(R.string.diskon_nominal, CurrencyUtils.formatCurrency(model.discAmt))
                }
                if(!isDelete){
                    ivDelete.gone()
                }

                clContent.setOnClickListener {
                    onItemClicK(model)
                }
                ivDelete.setOnClickListener {
                    onDeleteClick(model)
                }
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Saled>() {

        override fun areItemsTheSame(oldItem: Saled, newItem: Saled): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Saled, newItem: Saled): Boolean {
            return oldItem == newItem
        }

    }
}