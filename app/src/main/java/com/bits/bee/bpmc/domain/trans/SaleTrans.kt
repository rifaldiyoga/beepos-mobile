package com.bits.bee.bpmc.domain.trans

import com.bits.bee.bpmc.data.data_source.local.model.PromoEntity
import com.bits.bee.bpmc.data.list.ListPromoBonus
import com.bits.bee.bpmc.domain.calc.PromoCalc
import com.bits.bee.bpmc.domain.calc.SaleCalc
import com.bits.bee.bpmc.domain.model.*
import com.bits.bee.bpmc.domain.repository.PromoRepository
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.CalcUtils
import kotlinx.coroutines.flow.first
import java.math.BigDecimal
import java.math.RoundingMode
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by aldi on 19/05/22.
 */
@Singleton
class SaleTrans @Inject constructor(
    private val promoCalc: PromoCalc,
    private val saleCalc: SaleCalc,
    private val promoRepository: PromoRepository
) : BaseTrans<Sale, Saled>() {

    private var bp: Bp? = null
    private var saledParent: Saled? = null
    private var currentSaled: Saled? = null
    private var grpAddon : ItemGroup? = null
    var salePromoList: MutableList<SalePromo> = mutableListOf()
    private var dnoCounter = 0
    private var roundVal = 0
    var addOnTrans: AddOnTrans? = null

    suspend fun setBp(bp: Bp){
        this.bp = bp
        getMaster().bpId = bp.id!!
        getMaster().bp = bp
        getMaster().bpName = bp.name
        calculate()
    }

    fun setGrpAddOn(itemGroup: ItemGroup?){
        this.grpAddon = itemGroup
    }

    override fun newTrans() {
        mTblMaster = Sale()
        mTblDetail.clear()
        salePromoList.clear()
        promoCalc.listPromoBonus.clear()
        addOnTrans = null
    }

    override fun saveTrans() {

    }

    override fun voidTrans() {
    }

    override fun loadTrans(var1: Sale) {

    }

    suspend fun loadTrans(sale : Sale, saledList : MutableList<Saled>, saleAddOn: SaleAddOn? = null,
                  saleAddOnDList : MutableList<SaleAddOnD> = mutableListOf(),
                  salePromoList: MutableList<SalePromo> = mutableListOf()){
        mTblMaster = sale
        mTblDetail = saledList
        if(saleAddOn != null){
            if(addOnTrans == null)
                addOnTrans = AddOnTrans()

            addOnTrans!!.loadTrans(saleAddOn, saleAddOnDList)
            addOnTrans!!.getListDetail().forEach { saleAddOnD ->
                getListDetail().forEach { saled ->
                    if(saleAddOnD.upSaled?.id == saled.id){
                        saleAddOnD.upSaled = saled
                    }
                    if(saleAddOnD.saled?.id == saled.id){
                        saleAddOnD.saled = saled
                    }
                }
            }
        }
        this.salePromoList = salePromoList
       this.salePromoList.forEach { salePromo ->
           getListDetail().forEach { saled ->
               if(salePromo.saled?.id == saled.id){
                   val promo = promoRepository.getPromoById(salePromo.promo!!.id).first()
                   if(promo.promoCat == PromoEntity.BONUS && salePromo.promoRule == "D") {
                       saled.isBonus = true
                       saled.isBonusUsed = true
                   }
                   salePromo.saled = saled
               }
           }
        }
    }


    suspend fun addDetail(itemWithUnit: ItemWithUnit, isBonus: Boolean = false, useItemqty: Boolean = false, promoBonus: ListPromoBonus.PromoBonus? = null) {
        val item = itemWithUnit.item
        val discExp = itemWithUnit.discExp
        val discAmt = itemWithUnit.discAmt
        val unit = itemWithUnit.unit
        val pid = itemWithUnit.pid
        val stock = itemWithUnit.stock

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
                item = item,
                taxCode = item.taxCode,
                stock = stock
            )
            addDetail(saledNew)
            currentSaled = saledNew
        } else {
            var isNew = true
            for (saled in getListDetail()) {
                if (saled.itemId == item.id && !item.isVariant && !item.isHaveAddOn && (grpAddon == null || (grpAddon != null && item.itemGrpId != grpAddon!!.id))) {
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
                    item = item,
                    taxCode = item.taxCode,
                    stock = stock
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
            saleAddOnD.saleAddOn = addOnTrans?.getMaster()
            saleAddOnD.saled = currentSaled
            saleAddOnD.upSaled = saledParent
            addOnTrans?.addDetail(saleAddOnD)
        } else {
            this.saledParent = currentSaled
        }
        if (isBonus) {
//        Tambah salebonus apabila item bonus
            promoBonus?.let {
                promoCalc.addSalePromoItem(promoBonus.getPromo(), promoBonus.saled, currentSaled)
            }
        }
    }


    suspend fun addDetail(itemWithUnit: ItemWithUnit, saledParent : Saled){
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
                qty = if(grpAddon != null && item.itemGrpId == grpAddon!!.id) item.qty else BigDecimal.ONE,
                name = item.name1,
                discExp = discExp,
                discAmt = discAmt,
                disc2Amt = BigDecimal.ZERO,
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
                if (saled.itemId == item.id && !item.isVariant && !item.isHaveAddOn && (grpAddon == null || (grpAddon != null && item.itemGrpId == grpAddon!!.id))) {
                    saled.listPrice = item.price
                    saled.qty = saled.qty.add(BigDecimal.ONE)
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
                    qty = if(grpAddon != null && item.itemGrpId == grpAddon!!.id) item.qty else BigDecimal.ONE,
                    name = item.name1,
                    discExp = "0",
                    disc2Amt = BigDecimal.ZERO,
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
            saleAddOnD.saleAddOn = addOnTrans?.getMaster()
            saleAddOnD.saled = currentSaled
            saleAddOnD.upSaled = saledParent
            addOnTrans?.addDetail(saleAddOnD)
        } else {
            this.saledParent = currentSaled
        }
    }

    override suspend fun addDetail(d: Saled) {
        dnoCounter++
        d.dno = dnoCounter
        super.addDetail(d)
        calculate()
    }


    suspend fun editDetail(saledEdit: Saled) {
        getListDetail().map { saled ->
            if(saled === saledEdit) {
//                if(saled.item != null && saled.item!!.isHaveAddOn){
//                    addOnTrans?.getListDetail()?.forEach { saleAddOnD ->
//                        if(saleAddOnD.upSaled == saled){
//                            getListDetail().forEach { saled1 ->
//                                val saled2 = saleAddOnD.saled
//                                if(saled1 === saled2){
//                                    val qtyPcs = saled2.qty / saledEdit.qty
//                                    saled1.qty = qtyPcs.multiply(newQty)
//                                    editSaled(saled1, saled2)
//                                }
//                            }
//                        }
//                    }
//                }
                editSaled(saled, saledEdit)
            }
        }
        calculate()
    }

    suspend fun updateDiskonMaster(diskon : String)  {
        val sale = getMaster()
        if(diskon.isNotEmpty()) {
            sale.discExp = diskon
            sale.discAmt = CalcUtils.getDiscAmt(diskon, sale.subtotal)
        } else {
            sale.discExp = ""
            sale.discAmt = BigDecimal.ZERO
        }
        calcDetailDiskon()
        calculate()
    }

    private suspend fun calcDetailDiskon() {
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
        saled.discExp = newSaled.discExp
        saled.discAmt = newSaled.discAmt
        saled.tax = newSaled.tax
        saled.taxAmt = newSaled.taxAmt
        saled.disc2Amt = newSaled.disc2Amt
        saled.dNotes = newSaled.dNotes
        return saled
    }

    suspend fun deleteDetail(saledDel: Saled) {
        var indexDelete = -1

        for (i in 0 until getListDetail().size){
            val saled = getListDetail()[i]
            if(saledDel === saled){
                indexDelete = i
                break
            }
        }
        if(indexDelete > -1) {
            getListDetail().removeAt(indexDelete)
        }
        calculate()
    }

    suspend fun calculate(){
        saleCalc.calculate(getMaster(), getListDetail(), bp!!)
    }

    suspend fun mergeAddon() {
        //Rubah data saleaddon ke map
        val mapAddOn: MutableMap<Saled, MutableList<Saled>> = HashMap()
        //Map untuk seleksi  addon yg dimerge
        val mapSaled: MutableMap<Saled, List<Saled>> = HashMap()
        if (addOnTrans != null) {
            for (saleAddOnD in addOnTrans!!.getListDetail()) {
                val up_saled: Saled? = saleAddOnD.upSaled
                val saled: Saled? = saleAddOnD.saled
                if (mapAddOn.containsKey(up_saled)) {
                    if(saled != null)
                        mapAddOn[up_saled]!!.add(saled)
                } else {
                    if(up_saled != null && saled != null)
                        mapAddOn[up_saled] = ArrayList(listOf(saled))
                }
            }
            for ((addOnKey, valueAddOn) in mapAddOn) {
                if (mapSaled.isNotEmpty()) {
                    var exist = false
                    //matching saled dan addon, apabila reorder qty dipecah menjadi per satuan
                    for ((saledKey, valueSaled) in mapSaled) {
                        if (addOnKey.itemId == saledKey.itemId && addOnKey.listPrice.compareTo(saledKey.listPrice) == 0) {
                            val addonItem: MutableList<String> = ArrayList()
                            val saledItem: MutableList<String> = ArrayList()
                            for (saled in valueAddOn) {
                                addonItem.add(saled.name + saled.qty.divide(addOnKey.qty))
                            }
                            for (saled in valueSaled) {
                                saledItem.add(saled.name + saled.qty.divide(saledKey.qty))
                            }
                            addonItem.sort()
                            saledItem.sort()
                            if (addonItem == saledItem) {
                                mergeSaled(saledKey, addOnKey)
                                for (saled in valueSaled) {
                                    for (saled1 in valueAddOn) {
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
                        mapSaled[addOnKey] = valueAddOn
                    }
                } else {
                    mapSaled[addOnKey] = valueAddOn
                }
            }
        }
    }

    //Merge item addon tanpa addon
    suspend fun mergeItemAddon() {
        if (addOnTrans != null) {
            val saledList: MutableList<Saled> = ArrayList()
            val saledListResult: MutableList<Saled> = ArrayList()
            for (saled in getListDetail()) {
                if (saled.item!!.isHaveAddOn) {
                    var isMerge = true
                    for (saleAddOnD in addOnTrans!!.getListDetail()) {
                        if (saled == saleAddOnD.upSaled) {
                            isMerge = false
                            break
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

    suspend fun mergeSaled(saled1: Saled, saled2: Saled) {
        for (saled in getListDetail()) {
            if (saled === saled1) {
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

    suspend fun deleteAddon(up_saled: Saled?, saled: Saled) {
        val saledList = mutableListOf<Saled>()
        getListDetail().forEach { saled1 ->
            if (saled1 === saled) {
                saledList.add(saled1)
            }
        }
        if(saledList.size > 0){
            getListDetail().removeAll(saledList)
            calculate()
        }
        val saleAddOnDList: MutableList<SaleAddOnD> = ArrayList()
        for (saleAddOnD in addOnTrans!!.getListDetail()) {
            if (saleAddOnD.upSaled!! === up_saled && saleAddOnD.saled === saled) {
                saleAddOnDList.add(saleAddOnD)
            }
        }
        if (saleAddOnDList.size > 0) {
            deleteSaleAddonD(saleAddOnDList)
            addOnTrans!!.getListDetail().removeAll(saleAddOnDList)
        }
    }

    private fun deleteSaleAddonD(saleAddOnDList: List<SaleAddOnD>) {
//        try {
//            val saleAddOn: SaleAddOn = SaleAddOnDao.getSaleAddOnDao().readById(addOnTrans!!.getMaster())
//            val saleAddOnDS: List<SaleAddOnD> = SaleAddOnDDao.getSaleAddOnDDao().getSaleAddOnD(saleAddOn)
//            val iterator = saleAddOnDS.iterator()
//            while (iterator.hasNext()) {
//                val (id) = iterator.next()
//                for (saleAddOnd in saleAddOnDList) {
//                    if (id == saleAddOnd.id) {
////                        SaleAddOnDDao.getSaleAddOnDDao().delete(saleAddOnD);
//                    }
//                }
//            }
//        } catch (e: SQLException) {
//            e.printStackTrace()
//        }
    }

    private fun deleteOldSaleAddonD(saled: Saled) {
        val duplicateSaled: MutableList<SaleAddOnD> = ArrayList()
        for (saleAddOnD in addOnTrans!!.getListDetail()) {
            if (saled === saleAddOnD.upSaled) {
                duplicateSaled.add(saleAddOnD)
            }
        }
        addOnTrans!!.getListDetail().removeAll(duplicateSaled)
    }

    fun getSaledByUpSaledList(model : Saled)
            = addOnTrans?.let { it.getListDetail().filter { model == it.upSaled }.map { it.saled } } ?: mutableListOf()

    fun removeSalePromo(salePromo: SalePromo) {
        val salePromoRemoveList: MutableList<SalePromo> = ArrayList()
        for (salePromo1 in salePromoList) {
            if (salePromo1.promo!!.id == salePromo.promo!!.id) {
                salePromoRemoveList.add(salePromo1)
            }
            if (salePromoRemoveList.size == 2) {
                break
            }
        }
        salePromoList.removeAll(salePromoRemoveList)
    }

    fun findSalePromo(itemid: Int): SalePromo? = salePromoList.firstOrNull{ it.saled != null && it.saled!!.itemId == itemid}

    fun findSalePromo(promoType: String): SalePromo? = salePromoList.firstOrNull { it.promo!!.promoCat == promoType }

    override fun getMaster() : Sale {
        if(mTblMaster == null)
            mTblMaster = Sale()
        return mTblMaster!!
    }

}