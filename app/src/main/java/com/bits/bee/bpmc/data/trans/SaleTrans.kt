package com.bits.bee.bpmc.data.trans

import com.bits.bee.bpmc.data.calc.SaleCalc
import com.bits.bee.bpmc.domain.model.Item
import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.utils.BPMConstants
import java.math.BigDecimal
import java.math.RoundingMode
import javax.inject.Singleton


/**
 * Created by aldi on 19/05/22.
 */
@Singleton
class SaleTrans : BaseTrans<Sale, Saled>() {

    private var currentSaled: Saled? = null
    private var roundVal : Int = 1

    override fun newTrans() {
        mTblMaster = Sale();
    }

    override fun saveTrans() {

    }

    override fun voidTrans() {
    }

    override fun loadTrans(var1: Sale) {
    }

    fun addDetail(item: Item, isBonus: Boolean = false, useItemqty: Boolean = false) {
        if (getListDetail().isEmpty()) {
            var saledNew = Saled()
            saledNew.itemId = item.id
//            saledNew.itemId(item)
                saledNew.listPrice = item.price
            if (useItemqty) {
                saledNew.qty = item.qty
            } else {
                saledNew.qty = BigDecimal.ONE
            }
            saledNew.name = item.name1
            saledNew.discExp = "0"
            saledNew.disc2Amt = BigDecimal.ZERO
            saledNew.isBonus = isBonus
            saledNew.isBonusUsed = isBonus
            if (item.tax == "") {
                saledNew.tax = BigDecimal.ZERO
            } else {
                saledNew.tax = BigDecimal(item.tax)
            }
            currentSaled = saledNew
        } else {
            var isNew = true
            for (saled in getListDetail()) {
                if (saled.itemId.equals(item.id)
//                    && !ItemAddOnDao.itemAddOnDao().checkAddon(item)
//                    && (grpAddon == null || grpAddon != null && item.itemGrpId !== grpAddon.id())
                    && saled.isBonus == isBonus
                ) {
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
                    //                    PromoCalc.instance().generatePromoItem(saled);
                    calculate()
                    break
                }
            }
            if (isNew) {
                val saledNew = Saled()
                saledNew.itemId = item.id
//                saledNew.setItem(item)
                saledNew.listPrice = item.price
                if (useItemqty
//                    || grpAddon != null && grpAddon.id().equals(item.itemgrpId())
                ) {
                    saledNew.qty = item.qty
                } else {
                    saledNew.qty = BigDecimal.ONE
                }
                saledNew.name = item.name1
                saledNew.discExp = "0"
                saledNew.disc2Amt = BigDecimal.ZERO
                saledNew.isBonus = isBonus
                saledNew.isBonusUsed = isBonus
                if (item.tax == "") {
                    saledNew.tax = BigDecimal.ZERO
                } else {
                    saledNew.tax = BigDecimal(item.tax)
                }
                addDetail(saledNew)
                currentSaled = saledNew
            }
        }
//        if (grpAddon != null && item.itemGrpId === grpAddon.id()) {
//            if (addOnTrans == null) {
//                addOnTrans = AddOnTrans()
//                addOnTrans.New()
//                addOnTrans.getMaster().setSale(mTblMaster)
//            }
//            val saleAddOnD = SaleAddOnD()
//            saleAddOnD.setSaleAddOn(addOnTrans.getMaster())
//            saleAddOnD.setSaled(currentSaled)
//            saleAddOnD.setUp_saled(saledParent)
//            addOnTrans.addDetail(saleAddOnD)
//        } else {
//            saledParent = currentSaled
//        }
        if (isBonus) {
            //Tambah salebonus apabila item bonus
//            PromoCalc.instance()
//                .addSalePromoItem(promoBonus.getPromo(), promoBonus.getSaled(), currentSaled)
        }
    }

    override fun addDetail(d: Saled) {
        super.addDetail(d)
    }

    fun calculate(){
//        SaleCalc.calculate(getMaster(), getListDetail(), state)
    }
}