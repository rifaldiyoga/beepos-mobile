package com.bits.bee.bpmc.domain.trans

import com.bits.bee.bpmc.data.calc.SaleCalc
import com.bits.bee.bpmc.domain.model.*
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.CalcUtils
import java.math.BigDecimal
import java.math.RoundingMode
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by aldi on 19/05/22.
 */
@Singleton
class SaleTrans @Inject constructor() : BaseTrans<Sale, Saled>() {

    private var bp: Bp? = null
    private var saledParent: Saled? = null
    private var currentSaled: Saled? = null
    private var grpAddon : ItemGroup? = null
    //    var salePromoList: List<SalePromo>? = null
    private var dnoCounter = 0
    private var roundVal = 0
    var addOnTrans: AddOnTrans? = null

    fun setBp(bp: Bp){
        this.bp = bp
    }

    fun setGrpAddOn(itemGroup: ItemGroup?){
        this.grpAddon = itemGroup
    }

    override fun newTrans() {
        mTblMaster = Sale()
    }

    override fun saveTrans() {

    }

    override fun voidTrans() {
    }

    override fun loadTrans(var1: Sale) {
    }

    fun addDetail(itemWithUnit: ItemWithUnit, isBonus: Boolean = false, useItemqty: Boolean = false) {
        val item = itemWithUnit.item
        val discExp = itemWithUnit.discExp
        val discAmt = itemWithUnit.discAmt
        val unit = itemWithUnit.unit
        val pid = itemWithUnit.pid

        if (getListDetail().isEmpty()) {
            /** when list empty add new detail to list and set current saled*/
            val saledNew = Saled(
                itemId = item.id,
                itemCode = item.code,
                listPrice = item.price,
                qty = if(useItemqty) item.qty else BigDecimal.ONE,
                name = item.name1,
                discExp = discExp,
                discAmt = discAmt,
                disc2Amt = BigDecimal.ZERO,
                isBonus = isBonus,
                isBonusUsed = isBonus,
                tax = if(item.tax.isEmpty()) BigDecimal.ZERO else BigDecimal(item.tax),
                crcId = item.crcId,
                crcSymbol = item.crcSymbol,
                unitId = unit?.id,
                unit = unit?.unit,
                conv = unit?.conv,
                pid = pid,
                isAddOn = item.isAddOn,
                item = item
            )
            addDetail(saledNew)
            currentSaled = saledNew
        } else {
            var isNew = true
            for (saled in getListDetail()) {
                if (saled.itemId == item.id && !item.isVariant &&!item.isAddOn && saled.isBonus == isBonus) {
                    saled.listPrice = item.price
                    saled.qty = saled.qty.add(if (useItemqty) item.qty else BigDecimal.ONE)
                    if (saled.disc != BigDecimal.ZERO) {
                        if (!saled.discExp.contains("%")) {
                            saled.disc = saled.disc
                            saled.discAmt = saled.disc.setScale(roundVal, RoundingMode.HALF_UP)
                            saled.discExp = saled.discExp
                        } else if (saled.discExp.contains("%")) {
                            saled.disc = saled.disc
                            saled.discAmt =
                                saled.listPrice.multiply(saled.disc, BPMConstants.MC_FOUR)
                                    .divide(BigDecimal(100), BPMConstants.MC_FOUR)
                                    .setScale(roundVal, RoundingMode.HALF_UP)

                            saled.discExp = saled.discExp
                        }
                    }
                    currentSaled = saled
                    isNew = false
                    calculate()
                    break
                }
            }
            if(isNew) {
                val saledNew = Saled(
                    itemId = item.id,
                    itemCode = item.code,
                    listPrice = item.price,
                    qty = if (useItemqty) item.qty else BigDecimal.ONE,
                    name = item.name1,
                    discExp = "0",
                    disc2Amt = BigDecimal.ZERO,
                    isBonus = isBonus,
                    isBonusUsed = isBonus,
                    tax = if (item.tax.isEmpty()) BigDecimal.ZERO else BigDecimal(item.tax),
                    crcId = item.crcId,
                    crcSymbol = item.crcSymbol,
                    unitId = unit?.id,
                    unit = unit?.unit,
                    conv = unit?.conv,
                    pid = pid,
                    isAddOn = item.isAddOn,
                    item = item
                )
                addDetail(saledNew)
                currentSaled = saledNew
            }
        }
        if (grpAddon != null && item.itemGrpId == grpAddon!!.id) {
            if (addOnTrans == null) {
                addOnTrans = AddOnTrans()
                addOnTrans!!.newTrans()
                addOnTrans!!.getMaster().saleId = getMaster()
            }
            val saleAddOnD = SaleAddOnD()
            saleAddOnD.saleAddOnId = addOnTrans?.getMaster()
            saleAddOnD.saledId = currentSaled
            saleAddOnD.upSaledId = saledParent
            addOnTrans?.addDetail(saleAddOnD)
        } else {
            saledParent = currentSaled
        }
//        if (isBonus) {
//        Tambah salebonus apabila item bonus
//            PromoCalc.instance()
//                .addSalePromoItem(promoBonus.getPromo(), promoBonus.getSaled(), currentSaled)
//        }
    }

    override fun addDetail(d: Saled) {
        dnoCounter++
        d.dno = dnoCounter
        super.addDetail(d)
        calculate()
    }


    fun editDetail(saledEdit: Saled) {
        val saled  = getListDetail().firstOrNull { it.itemId == saledEdit.itemId }
        saled?.let {
            getListDetail().map {
                if(it.itemId == saled.itemId) {
                    editSaled(it, saledEdit)
                }
            }
        }
        calculate()
    }

    fun diskonMaster(diskon : String) {
        if(diskon.isNotEmpty()) {
            val sale = getMaster()
            sale.discExp = diskon
            sale.discAmt = BigDecimal.ZERO
            sale.discAmt = CalcUtils.getDiscAmt(diskon, sale.subtotal)

            calcDetailDiskon()
            calculate()
        }
    }

    fun calcDetailDiskon() {
        val sale = getMaster()
        for (saled in getListDetail()){
            var disc2Amt = BigDecimal.ZERO
            if(sale.discAmt > BigDecimal.ZERO){
                disc2Amt = sale.discAmt.multiply(saled.subtotal).divide(sale.subtotal, BPMConstants.MC_FOUR).divide(saled.qty, BPMConstants.MC_FOUR)
            }
            saled.disc2Amt = disc2Amt
        }
        calculate()
    }

    private fun editSaled(saled: Saled, newSaled: Saled) : Saled  {
        saled.listPrice =  newSaled.listPrice
        saled.qty = newSaled.qty
        saled.disc = newSaled.disc
        saled.discAmt = newSaled.discAmt
        saled.tax = newSaled.tax
        saled.taxAmt = newSaled.taxAmt
        saled.disc2Amt = newSaled.disc2Amt
        return saled
    }

    fun deleteDetail(saledDel: Saled) {
        var indexDelete = -1

        for (i in 0 until getListDetail().size){
            val saled = getListDetail()[i]
            if(saledDel == saled){
                indexDelete = i
                break
            }
        }
        if(indexDelete > -1) {
            getListDetail().removeAt(indexDelete)
        }
        calculate()
    }

    private fun calculate(){
        SaleCalc.calculate(getMaster(), getListDetail(), bp!!)
    }

    fun mergeAddon() {
        //Rubah data saleaddon ke map
        val mapAddOn: MutableMap<Saled, MutableList<Saled>> = HashMap()
        //Map untuk seleksi  addon yg dimerge
        val mapSaled: MutableMap<Saled, List<Saled>> = HashMap()
        if (addOnTrans != null) {
            for (saleAddOnD in addOnTrans!!.getListDetail()) {
                val up_saled: Saled = saleAddOnD.upSaledId!!
                val saled: Saled = saleAddOnD.saledId!!
                if (mapAddOn.containsKey(up_saled)) {
                    mapAddOn[up_saled]!!.add(saled)
                } else {
                    mapAddOn[up_saled] = ArrayList(listOf(saled))
                }
            }
            for ((addOnKey, value) in mapAddOn) {
                if (mapSaled.isNotEmpty()) {
                    var exist = false
                    //matching saled dan addon, apabila reorder qty dipecah menjadi per satuan
                    for ((saledKey, value1) in mapSaled) {
                        if (addOnKey.itemId == saledKey.itemId && addOnKey.listPrice.compareTo(saledKey.listPrice) == 0) {
                            val addonItem: MutableList<String> = ArrayList()
                            val saledItem: MutableList<String> = ArrayList()
                            for (saled in value1) {
                                addonItem.add(saled.name + saled.qty.divide(addOnKey.qty))
                            }
                            for (saled in value1) {
                                saledItem.add(saled.name + saled.qty.divide(saledKey.qty))
                            }
                            addonItem.sort()
                            saledItem.sort()
                            if (addonItem == saledItem) {
                                mergeSaled(saledKey, addOnKey)
                                for (saled in value1) {
                                    for (saled1 in value1) {
                                        if (saled.itemId == saled1.itemId) {
                                            mergeSaled(saled, saled1)
                                            deleteOldSaleAddonD(addOnKey)
                                        }
                                    }
                                }
                                exist = true
                            }
                        }
                    }
                    if (!exist) {
                        mapSaled[addOnKey] = value
                    }
                } else {
                    mapSaled[addOnKey] = value
                }
            }
        }
    }

    //Merge item addon tanpa addon
    fun mergeItemAddon() {
        if (addOnTrans != null) {
            val saledList: MutableList<Saled> = ArrayList()
            val saledListResult: MutableList<Saled> = ArrayList()
            for (saled in getListDetail()) {
                if (saled.isAddOn) {
                    var isMerge = true
                    if (addOnTrans != null) {
                        for (saleAddOnD in addOnTrans!!.getListDetail()) {
                            if (saled == saleAddOnD.upSaledId) {
                                isMerge = false
                                break
                            }
                        }
                    }
                    if (isMerge) {
                        saledList.add(saled)
                    }
                }
            }
            if (saledList.size > 0) {
                for (saled in saledList) {
                    var isExist = false
                    if (saledListResult.size == 0) {
                        saledListResult.add(saled)
                    } else {
                        for (saled1 in saledListResult) {
                            if (saled.itemId == saled1.itemId && saled.listPrice.compareTo(saled1.listPrice) == 0) {
                                mergeSaled(saled1, saled)
                                isExist = true
                                break
                            }
                        }
                        if (!isExist) {
                            saledListResult.add(saled)
                        }
                    }
                }
            }
        }
    }

    fun mergeSaled(saled1: Saled, saled2: Saled) {
        for (saled in getListDetail()) {
            if (saled == saled1) {
                saled.listPrice = saled.item?.price ?: BigDecimal.ZERO
                saled.qty = saled.qty.add(saled2.qty)
                if (saled.disc != BigDecimal.ZERO) {
                    if (!saled.discExp.contains("%")) {
                        saled.disc = saled.disc
                        saled.discAmt = saled.disc.setScale(roundVal, RoundingMode.HALF_UP)
                        saled.discExp = saled.discExp
                    } else if (saled.discExp.contains("%")) {
                        saled.disc = saled.disc
                        saled.discAmt = (saled.listPrice * saled.disc / BigDecimal(100)).setScale(roundVal, RoundingMode.HALF_UP)
                        saled.discExp = saled.discExp
                    }
                }
                calculate()
            }
        }
        for (saled in getListDetail()) {
            //hapus data saled yg ingin dimerge ke item tujuan
            if (saled === saled2) {
                getListDetail().remove(saled)
                break
            }
        }
        calculate()
    }

    private fun deleteOldSaleAddonD(saled: Saled) {
        val duplicateSaled: MutableList<SaleAddOnD> = ArrayList()
        for (saleAddOnD in addOnTrans!!.getListDetail()) {
            if (saled == saleAddOnD.upSaledId) {
                duplicateSaled.add(saleAddOnD)
            }
        }
        addOnTrans!!.getListDetail().removeAll(duplicateSaled)
    }

    fun getSaledByUpSaledList(model : Saled)
            = addOnTrans?.let { it.getListDetail().filter { model == it.upSaledId }.map { it.saledId } } ?: mutableListOf()

    override fun getMaster() : Sale = mTblMaster ?: Sale()

}