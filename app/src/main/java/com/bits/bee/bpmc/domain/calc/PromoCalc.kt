package com.bits.bee.bpmc.domain.calc

import android.util.Log
import com.bits.bee.bpmc.data.data_source.local.model.PromoEntity
import com.bits.bee.bpmc.data.list.ListPromoBonus
import com.bits.bee.bpmc.domain.model.*
import com.bits.bee.bpmc.domain.repository.ItemRepository
import com.bits.bee.bpmc.domain.repository.PromoMultiRepository
import com.bits.bee.bpmc.domain.repository.PromoRepository
import com.bits.bee.bpmc.domain.trans.SaleTrans
import com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetPriceItemUseCase
import com.bits.bee.bpmc.utils.DateFormatUtils
import kotlinx.coroutines.flow.first
import java.math.BigDecimal
import java.sql.SQLException
import java.sql.Time
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by aldi on 08/09/22
 */
@Singleton
class PromoCalc @Inject constructor(
    private val promoRepository: PromoRepository,
    private val getActiveCashierUseCase: GetActiveCashierUseCase,
    private val itemRepository: ItemRepository,
    private val getPriceItemUseCase: GetPriceItemUseCase,
    private val promoMultiRepository: PromoMultiRepository
) {

    private var listPromoActive: List<Promo> = mutableListOf()
    private var listPromoAvailable: MutableList<Promo> = mutableListOf()
    private lateinit var mSaleTrans: SaleTrans
    private var bp: Bp? = null
    var mapItemPromo: MutableMap<Int, MutableList<Promo>> = mutableMapOf()
    var mapItemPromoApplied: MutableMap<Int, Promo> = mutableMapOf()
    var listPromoBonus: ListPromoBonus = ListPromoBonus()
    private var saledTemp: Saled? = null
    private var qtyTemp: BigDecimal = BigDecimal.ZERO


    suspend fun initPromo() {
        try {
            scanPromo()
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }

    suspend fun initPromo(saleTrans: SaleTrans) {
        try {
            mSaleTrans = saleTrans
            bp = mSaleTrans.getMaster().bp
            scanPromo()
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }

    private suspend fun scanPromo() {
        Log.i("Promo", "SCANNING PROMO")

        listPromoActive = promoRepository.getActivePromoList().first()
        listPromoAvailable = ArrayList(listPromoActive)
        for (promo in listPromoActive) {
            if (!checkPromo(promo)) {
                listPromoAvailable.remove(promo)
            }
        }
        listItemAvailableforPromo()
    }

    /* -------------------------------------------------Check promo available------------------------------------------------- */
    private suspend fun checkPromo(promo: Promo): Boolean {
        return checkPeriode(promo) && checkTime(promo) && checkBranch(promo) && checkDOW(promo) && checkBPGrp(
            promo
        )
    }

    private fun checkPeriode(promo: Promo): Boolean {
        if (promo.isPeriod) {
            val now: Long = Calendar.getInstance().timeInMillis
            val start: Long =
                DateFormatUtils.formatStringToDate("yyyy-MM-dd", promo.startDate).time
            val end: Long =
                DateFormatUtils.formatStringToDate("yyyy-MM-dd", promo.endDate).time
            if (start > now || now > end) {
                return false
            }
        }
        return true
    }

    private fun checkTime(promo: Promo): Boolean {
        if (promo.isTime) {
            val f = SimpleDateFormat("HH:mm:ss", Locale.getDefault())
            val timeNow = Time(System.currentTimeMillis())
            val time: String = f.format(timeNow)
            try {
                val nowTimeC: Calendar = Calendar.getInstance()
                val startTimeC: Calendar = Calendar.getInstance()
                val endTimeC: Calendar = Calendar.getInstance()
                nowTimeC.time = f.parse(time)!!
                startTimeC.time = f.parse(promo.startTime!!)!!
                endTimeC.time = f.parse(promo.endTime!!)!!
                val now = Time(nowTimeC.time.time)
                val startTime = Time(startTimeC.time.time)
                val endTime = Time(endTimeC.time.time)
                if (now.before(startTime) || now.after(endTime)) {
                    return false
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return true
    }

    private suspend fun checkBranch(promo: Promo): Boolean {
        if (promo.isBranch) {
            try {
                val cashier = getActiveCashierUseCase().first()
                cashier?.let {
                    if (promo.isMulti) {
                        val promoMultiList: List<PromoMulti> =
                            promoMultiRepository.getBranchPromoMultiByPromo(
                                promo.id,
                                it.branchId.toInt()
                            ).first()
                        if (promoMultiList.isEmpty()) return false
                    } else {
                        if (it.branchId.toInt() != promo.branchId) {
                            return false
                        }
                    }
                }
            } catch (e: SQLException) {
                e.printStackTrace()
            }
        }
        return true
    }

    private fun checkDOW(promo: Promo): Boolean {
        if (promo.isDow) {
            val day: Int = Calendar.getInstance().get(Calendar.DAY_OF_WEEK) - 1
            if (!promo.dowExp!!.contains(day.toString())) {
                return false
            }
        }
        return true
    }

    private fun checkBPGrp(promo: Promo): Boolean {
        if (promo.isBpgrp) {
            try {
                bp = mSaleTrans.getMaster().bp
                if (promo.bpgrpId != null && bp!!.bpgrpId != promo.bpgrpId?.toInt()) {
                    return false
                }
            } catch (e: SQLException) {
                e.printStackTrace()
            }
        }
        return true
    }

    /* -------------------------------------------------Check item available for promo------------------------------------------------- */
    private suspend fun listItemAvailableforPromo() {
        try {
            val itemList: List<Item> = itemRepository.getActiveItemList().first()
            mapItemPromo.clear()
            for (item in itemList) {
                for (promo in listPromoAvailable) {
                    if (promo.promoCat == PromoEntity.DISC) {
                        if (checkPromoItemDisc(
                                promo,
                                item
                            ) && promo.promoCat != PromoEntity.MINAMT
                        ) {
                            addToMapItemPromo(item.id, promo)
                        }
                    } else if (promo.promoCat == PromoEntity.BONUS) {
                        if (checkPromoItemBonus(
                                promo,
                                item
                            ) && promo.promoCat != PromoEntity.MINAMT
                        ) {
                            addToMapItemPromo(item.id, promo)
                        }
                    } else if (promo.promoCat == PromoEntity.XY) {
                        if (checkPromoItemBonus(
                                promo,
                                item
                            ) && promo.promoCat != PromoEntity.MINAMT
                        ) {
                            addToMapItemPromo(item.id, promo)
                        }
                    }
                }
            }
        } catch (e: SQLException) {
            e.printStackTrace()
        }
    }

    private fun addToMapItemPromo(itemid: Int, promo: Promo) {
        if (mapItemPromo.containsKey(itemid)) {
            mapItemPromo[itemid]!!.add(promo)
        } else {
            mapItemPromo[itemid] = ArrayList(listOf(promo))
        }
    }

    /* -------------------------------------------------Generate Promo------------------------------------------------- */
    suspend fun generatePromo() {
        resetPromo()
        generatePromoItem()
        generatePromoNota()
        removeUnusedBonus()
        mSaleTrans.calculate()
    }

    suspend fun generatePromoSingle(itemid: Int) {
        removePromoSingleMinAmt(itemid)
        resetPromo()
        generatePromoSingleItem(itemid)
        generatePromoNota()
        mSaleTrans.calculate()
    }

    /* -------------------------------------------------Generate Promo Nota------------------------------------------------- */
    private suspend fun generatePromoNota() {
        val listPromoNota: MutableList<Promo> = ArrayList()
        for (promo in listPromoAvailable) {
            if (promo.promoCat == PromoEntity.MINAMT) {
                if (checkPromoMinAmt(promo)) {
                    listPromoNota.add(promo)
                }
            }
        }
        if (listPromoNota.size > 0) {
            val promoActive = getPromoByPriorityMinAmt(listPromoNota)
            if (promoActive.promoCat == PromoEntity.MINAMT) {
                applyPromoMinAmt(promoActive)
            }
        }
    }

    private fun checkPromoMinAmt(promo: Promo): Boolean {
        if (promo.isMinAmt) {
            if (mSaleTrans.getMaster().subtotal.compareTo(promo.minAmt) != -1) {
                return true
            }
        }
        return false
    }

    private suspend fun applyPromoMinAmt(promo: Promo) {
        val sale = mSaleTrans.getMaster()
        if (promo.offerType == PromoEntity.OFFERTYPE_HEADER) {
            if (promo.isPriceOveride) {
                sale.discAmt = BigDecimal.ZERO
                sale.discExp = ""
                sale.subtotal = promo.itemPrice ?: BigDecimal.ZERO
            } else {
                val itemDiscExp: String? = promo.itemDiscExp
                if (itemDiscExp != null) {
                    mSaleTrans.updateDiskonMaster(itemDiscExp)
                }
            }
            addSalePromoNota(promo)
        }
        if (promo.offerType == PromoEntity.OFFERTYPE_DETAIL) {
            val qtySisa: BigDecimal
            val qtyPromo = promo.dealQty ?: BigDecimal.ZERO // get qty deal promo
            qtySisa = applyPromoMinAmtItem(qtyPromo, promo, null)
            addPromoBonus(promo, qtySisa, null)
        }
    }

    private suspend fun applyPromoMinAmtItem(
        qtyPromo: BigDecimal,
        promoActive: Promo,
        lastSaled: Saled?
    ): BigDecimal {
        var isLastSaled = false
        var newLastSaled: Saled? = null
        var qtySisa: BigDecimal = qtyPromo
        var promoItemOffer: List<Int?> = ArrayList()
        if (promoActive.isMulti) {
            promoItemOffer =
                getListItemidOfferPromoMulti(promoActive) // get item yang termasuk offer promo
        }
        for (saled in mSaleTrans.getListDetail()) {
            if (isLastSaled || lastSaled == null) {
                if (promoItemOffer.contains(saled.item!!.id)) {
//                    if (saled.itemId == itemid) {
                    if (promoActive.isPriceOveride) {
                        saled.listPrice = promoActive.itemPrice ?: BigDecimal.ZERO
                        saled.disc = BigDecimal.ZERO
                        saled.discAmt = BigDecimal.ZERO
                        saled.discExp = "0"
                    } else if (promoActive.itemDiscExp != null && promoActive.itemDiscExp
                            .equals("100%")
                    ) {
                        saled.listPrice = BigDecimal.ZERO
                        saled.disc = BigDecimal.ZERO
                        saled.discAmt = BigDecimal.ZERO
                        saled.discExp = "0"
                    } else {
                        val isPercentage: Boolean = promoActive.itemDiscExp?.contains("%") ?: false
                        var discAmt: BigDecimal?
                        var disc: BigDecimal?
                        if (isPercentage) {
                            disc = BigDecimal(promoActive.itemDiscExp?.replace("%", "") ?: "0")
                            discAmt = saled.listPrice.multiply(disc).divide(BigDecimal(100))
                                .setScale(2, 0)
                            saled.discExp = promoActive.itemDiscExp ?: ""
                        } else {
                            discAmt = BigDecimal(promoActive.itemDiscExp ?: "0")
                            disc = discAmt
                            saled.discExp = "0"
                        }
                        saled.disc = disc
                        saled.discAmt = discAmt ?: BigDecimal.ZERO
                    }
                    mSaleTrans.calculate()
                    addSalePromoNota(promoActive, saled)
                    if (saled.qty.compareTo(qtySisa) == 1) {
                        val qtyLeft: BigDecimal = saled.qty.subtract(qtySisa)
                        saled.qty = qtySisa
                        duplicateSaled(saled, qtyLeft)
                        if (promoActive.itemDiscExp != null && promoActive.itemDiscExp
                                .equals("100%")
                        ) {
                            saled.isBonus = true
                            saled.isBonusUsed = true
                        }
                        qtySisa = BigDecimal.ZERO
                    } else {
                        qtySisa = qtySisa.subtract(saled.qty)
                        if (promoActive.itemDiscExp != null && promoActive.itemDiscExp
                                .equals("100%")
                        ) {
                            saled.isBonus = true
                            saled.isBonusUsed = true
                        }
                    }
                }
            }
            if (lastSaled != null && saled.dno == lastSaled.dno) {
                isLastSaled = true
            }
            newLastSaled = saled
            //            if(qtySisa.compareTo(BigDecimal.ZERO) > 0){
//                addPromoBonus(promoActive, qtyPromo, null);
//            }
            if (qtySisa.compareTo(BigDecimal.ZERO) == 0) {
                break
            }
        }
        mergeItemPromo(promoActive, true)
        return qtySisa
    }

    /* -------------------------------------------------Generate Promo Item------------------------------------------------- */
    private suspend fun generatePromoItem() {
        val itemList: MutableList<Int> = ArrayList()
        for (saled in mSaleTrans.getListDetail()) {
            if (!itemList.contains(saled.itemId)) {
                itemList.add(saled.itemId)
            }
        }
        for (itemid in itemList) {
            if (mapItemPromo.containsKey(itemid)) {
                val totalQtyItem: BigDecimal = countQtyItem(itemid)
                autoGeneratePromoItem(itemid, totalQtyItem, null)
            }
        }
    }

    private suspend fun generatePromoSingleItem(itemid: Int) {
        val totalQtyItem: BigDecimal = countQtyItem(itemid)
        validateQtyItem(itemid, totalQtyItem)
        removePromoSingleItem(itemid)
        autoGeneratePromoItem(itemid, totalQtyItem, null)
        removeUnusedBonusSingleItem(itemid)
    }

    private fun validateQtyItem(itemid: Int, totalQtyItem: BigDecimal) {
        if (totalQtyItem.compareTo(BigDecimal.ONE) < 0) {
            if (mapItemPromoApplied.containsKey(itemid)) {
                mapItemPromoApplied.remove(itemid)
                val salePromo: SalePromo? = mSaleTrans.findSalePromo(itemid)
                if (salePromo != null) {
                    mSaleTrans.salePromoList.remove(salePromo)
                }
            }
        }
    }

    private suspend fun removePromoSingleItem(itemid: Int) {
        if (mapItemPromoApplied.containsKey(itemid)) {
            val promo = mapItemPromoApplied[itemid]
            if (promo != null && promo.promoCat == PromoEntity.DISC) {
                while (mSaleTrans.findSalePromo(itemid) != null) {
                    val salePromo: SalePromo? = mSaleTrans.findSalePromo(itemid)
                    salePromo?.saled?.let {
                        removePromoDisc(promo, it)
                        mapItemPromoApplied.remove(itemid)
                        mSaleTrans.salePromoList.remove(salePromo)
                    }
                }
            }
        }
    }

    private suspend fun autoGeneratePromoItem(
        itemid: Int,
        totalQty: BigDecimal,
        lastSaled: Saled?
    ) {
        var totalQtyItem: BigDecimal = totalQty
        val listPromoItem: MutableList<Promo> = ArrayList()
        val listPromoForItem: List<Promo>? = mapItemPromo[itemid]
        if (listPromoForItem != null && listPromoForItem.isNotEmpty()) {
            for (promo in listPromoForItem) {
                if (promo.isMulti
                    && !promo.isDealSameItem //                        ((promo.promoCat.equals(PromoEntity.BONUS) && !promo.isDealSameItem)
                    //                        || promo.promoCat.equals(PromoEntity.DISC))
                    && lastSaled == null
                ) {
                    totalQtyItem = countQtyItemMulti(promo)
                }
                if (promo.promoCat == PromoEntity.DISC) {
                    if (checkPromoDisc(
                            promo,
                            itemid,
                            totalQtyItem,
                            lastSaled != null
                        ) && promo.promoCat != PromoEntity.MINAMT
                    ) {
                        listPromoItem.add(promo)
                    }
                } else if (promo.promoCat == PromoEntity.BONUS) {
                    if (checkPromoBonus(
                            promo,
                            itemid,
                            totalQtyItem,
                            lastSaled != null
                        ) && promo.promoCat != PromoEntity.MINAMT
                    ) {
                        listPromoItem.add(promo)
                    }
                } else if (promo.promoCat == PromoEntity.XY) {
                    if (checkPromoXY(
                            promo,
                            itemid,
                            totalQtyItem,
                            lastSaled != null
                        ) && promo.promoCat != PromoEntity.MINAMT
                    ) {
                        listPromoItem.add(promo)
                    }
                }
            }
            if (listPromoItem.size > 0) {
                applyPromoItem(listPromoItem, itemid, lastSaled)
            }
        }
    }

    private suspend fun applyPromoItem(listPromoItem: List<Promo>, itemid: Int, lastSaled: Saled?) {
        val promoActive = getPromoByPriority(listPromoItem)
        val qtyPromo: BigDecimal //qty maksimal untuk item
        var totalQtyItem: BigDecimal
        totalQtyItem = if (promoActive.isMulti
            && !promoActive.isDealSameItem //                ((promoActive.promoCat.equals(PromoEntity.BONUS) && !promoActive.isDealSameItem) || promoActive.promoCat.equals(PromoEntity.DISC))
            && lastSaled == null
        ) {
            countQtyItemMulti(promoActive)
        } else {
            countQtyItem(itemid)
        }
        if (promoActive.promoCat == PromoEntity.DISC) {
            if (promoActive.isMinQtyMultiply) {
                qtyPromo = getMaxQtyPromo(totalQtyItem, promoActive)
            } else {
                qtyPromo = promoActive.minQty ?: BigDecimal.ZERO
            }
            //untuk split saled apabila jumlah qtypromo lebih sedikit/banyak daripada jumlah qty saled
            totalQtyItem = totalQtyItem.subtract(qtyPromo)
            if (!mapItemPromoApplied.containsKey(itemid)) {
                mapItemPromoApplied[itemid] = promoActive
            }
            val saledLeft = applyPromoDisc(promoActive, itemid, qtyPromo, lastSaled)
            if (totalQtyItem.compareTo(BigDecimal.ZERO) == 1) {
                autoGeneratePromoItem(itemid, totalQtyItem, saledLeft)
            }
        } else if (promoActive.promoCat == PromoEntity.BONUS) {
            qtyPromo = if (promoActive.isMinQtyMultiply) {
                getMaxQtyPromo(totalQtyItem, promoActive)
            } else {
                promoActive.dealQty ?: BigDecimal.ZERO
            }
            applyPromoBonus(promoActive, qtyPromo, totalQtyItem, itemid)
        } else if (promoActive.promoCat == PromoEntity.XY) {
            qtyPromo = if (promoActive.isMinQtyMultiply) {
                getMaxQtyPromo(totalQtyItem, promoActive)
            } else {
                promoActive.dealQty ?: BigDecimal.ZERO
            }
            applyPromoXY(qtyPromo, totalQtyItem, promoActive, itemid, null)
        }
    }

    private suspend fun countQtyItemMulti(promo: Promo): BigDecimal {
        val promoItem: MutableList<Int> = ArrayList()
        var qty: BigDecimal = BigDecimal.ZERO
        try {
            val promoMultiList: List<PromoMulti> =
                promoMultiRepository.getSyaratPromoMultiByPromo(promo.id).first()
            for (promoMulti in promoMultiList) {
                if (promoMulti.type == "ITEMGRP1") {
                    val itemList =
                        itemRepository.getActiveItemListByItemGrp(promoMulti.value.toInt()).first()
                    for (item in itemList)
                        promoItem.add(item.id)
                }
                if (promoMulti.type == "ITEM") {
                    promoItem.add(Integer.valueOf(promoMulti.value))
                }
            }
        } catch (e: SQLException) {
            e.printStackTrace()
        }
        if (promoItem.size > 0) {
            for (promoItemid in promoItem) {
                for (saled in mSaleTrans.getListDetail()) {
                    if (saled.itemId == promoItemid && !saled.isBonus) {
                        qty = qty.add(saled.qty)
                    }
                }
            }
        }
        return qty
    }

    private fun getMaxQtyPromo(totalQty: BigDecimal, promo: Promo): BigDecimal {
        val minQtyPromo = promo.minQty ?: BigDecimal.ZERO
        val dealQty: BigDecimal = promo.dealQty ?: BigDecimal.ZERO
        var result: BigDecimal = BigDecimal.ZERO
        var currentQty: BigDecimal = BigDecimal.ZERO
        val resultQty: BigDecimal =
            if (promo.promoType == PromoEntity.DISC) minQtyPromo else dealQty
        val maxQtyPromo: BigDecimal? = if (promo.maxQty != null)
            if (totalQty < promo.maxQty)
                totalQty else promo.maxQty else null
        if (promo.maxQty == null) {
            do {
                result = result.add(resultQty)
                currentQty = currentQty.add(minQtyPromo)
            } while (currentQty.add(minQtyPromo).compareTo(totalQty) < 1)
        } else {
            do {
                result = result.add(minQtyPromo)
                currentQty = currentQty.add(minQtyPromo)
            } while (currentQty.add(minQtyPromo).compareTo(maxQtyPromo) < 1)
        }
        return result
    }

    private fun countQtyItem(itemId: Int): BigDecimal {
        var result: BigDecimal = BigDecimal.ZERO
        for (saled in mSaleTrans.getListDetail()) {
            if (saled.itemId == itemId && !saled.isBonus) {
                result = result.add(saled.qty)
            }
        }
        return result
    }

    private fun checkPromoXY(
        promo: Promo,
        itemid: Int,
        totalQty: BigDecimal,
        generatedByPromo: Boolean
    ): Boolean {
        return checkPromoItemMinQty(
            promo,
            itemid,
            totalQty,
            generatedByPromo
        ) && checkPromoItemMaxQty(promo, itemid, totalQty, generatedByPromo)
    }

    private fun checkPromoDisc(
        promo: Promo,
        itemid: Int,
        totalQty: BigDecimal,
        generatedByPromo: Boolean
    ): Boolean {
        return checkPromoItemMinQty(
            promo,
            itemid,
            totalQty,
            generatedByPromo
        ) && checkPromoItemMaxQty(promo, itemid, totalQty, generatedByPromo)
    }

    private fun checkPromoBonus(
        promo: Promo,
        itemid: Int,
        totalQty: BigDecimal,
        generatedByPromo: Boolean
    ): Boolean {
        return checkPromoItemMinQty(
            promo,
            itemid,
            totalQty,
            generatedByPromo
        ) && checkPromoItemMaxQty(promo, itemid, totalQty, generatedByPromo)
    }

    private suspend fun checkPromoItemDisc(promo: Promo, item: Item): Boolean {
        if (promo.isMulti) {
            return checkPromoMultiItem(promo, item)
        }
        return promo.itemId != null && promo.itemId == item.id
    }

    private suspend fun checkPromoItemBonus(promo: Promo, item: Item): Boolean {
        if (promo.isMulti) {
            return checkPromoMultiItem(promo, item)
        }
        if (promo.isTargetItem) {
            if (item.id == promo.itemId) {
                return true
            }
        } else if (promo.isTargetItgrp) {
            if (promo.itgrpId == item.itemGrpId) {
                return true
            }
        }
        return false
    }

    private suspend fun checkPromoMultiItem(promoActive: Promo, item: Item): Boolean {
//        if (promoActive.isDealSameItem) {
        var promoMultiList: List<PromoMulti> = ArrayList<PromoMulti>()
        var promoOfferMultiList: List<PromoMulti> = ArrayList<PromoMulti>()
        try {
            promoMultiList = promoMultiRepository.getSyaratPromoMultiByPromo(promoActive.id).first()
            promoOfferMultiList =
                promoMultiRepository.getOfferPromoMultiByPromo(promoActive.id).first()
        } catch (e: SQLException) {
            e.printStackTrace()
        }
        for (promoMulti in promoMultiList) {
            if (promoMulti.type == "ITEMGRP1" && Integer.valueOf(promoMulti.value) == item.itemGrpId) {
                return true
            }
            if (promoMulti.type == "ITEM" && Integer.valueOf(promoMulti.value) == item.id) {
                return true
            }
        }
        for (promoMulti in promoOfferMultiList) {
            if (promoMulti.type == "ITEMGRP1" && Integer.valueOf(promoMulti.value) == item.itemGrpId) {
                return true
            }
            if (promoMulti.type == "ITEM" && Integer.valueOf(promoMulti.value) == item.id) {
                return true
            }
        }
        //        }
        return false
    }

    private fun checkPromoItemMinQty(
        promo: Promo,
        itemid: Int,
        totalQty: BigDecimal,
        autoGenerate: Boolean
    ): Boolean {
        val itemQty: BigDecimal = if (autoGenerate) {
            countQtyItem(itemid)
        } else {
            totalQty
        }
        if (promo.isMinQty) {
            if (promo.minQty!!.compareTo(totalQty) == 1) {
                return false
            } else {
                if (autoGenerate) {
                    return !promo.isMinQtyMultiply && itemQty.compareTo(promo.minQty) != -1 || promo.isMaxQty && promo.isMinQtyMultiply && itemQty.compareTo(
                        promo.maxQty
                    ) != 1
                }
            }
        }
        return true
    }

    private fun checkPromoItemMaxQty(
        promo: Promo,
        itemid: Int,
        totalQty: BigDecimal,
        generatedByPromo: Boolean
    ): Boolean {
        val itemQty: BigDecimal = if (generatedByPromo) {
            countQtyItem(itemid)
        } else {
            totalQty
        }
        return if (itemQty.compareTo(promo.minQty) == 1) {
            promo.isMinQtyMultiply || !generatedByPromo
        } else true
    }

    private suspend fun applyPromoDisc(
        promoActive: Promo,
        itemid: Int,
        qtyPromo: BigDecimal,
        lastSaled: Saled?
    ): Saled? {
        var qtyPromo: BigDecimal = qtyPromo
        var isLastSaled = false
        var newLastSaled: Saled? = null
        var promoItemSyarat: List<Int?> = ArrayList()
        if (promoActive.isMulti) {
            promoItemSyarat = getListItemidSyaratPromoMulti(promoActive)
        }
        for (saled in mSaleTrans.getListDetail()) {
            if (isLastSaled || lastSaled == null) {
                //check tipe promo, jika promo multi check sesuai syarat promo multi
                if (!promoActive.isMulti && saled.item!!.id == itemid) {
                    if (promoActive.isPriceOveride) {
                        saled.listPrice = promoActive.itemPrice ?: BigDecimal.ZERO
                        saled.disc = BigDecimal.ZERO
                        saled.discAmt = BigDecimal.ZERO
                        saled.discExp = "0"
                    } else {
                        val isPercentage: Boolean = promoActive.itemDiscExp?.contains("%") ?: false
                        var discAmt: BigDecimal?
                        var disc: BigDecimal?
                        if (isPercentage) {
                            disc = BigDecimal(promoActive.itemDiscExp!!.replace("%", ""))
                            discAmt = saled.listPrice.multiply(disc).divide(BigDecimal(100))
                                .setScale(2, 0)
                            saled.discExp = promoActive.itemDiscExp ?: ""
                        } else {
                            discAmt = BigDecimal(promoActive.itemDiscExp)
                            disc = discAmt
                            saled.discExp = "0"
                        }
                        saled.disc = disc
                        saled.discAmt = discAmt ?: BigDecimal.ZERO
                    }
                    mSaleTrans.calculate()
                    addSalePromoItem(promoActive, saled, saled)
                    try {
                        promoActive.isUsed = true
//                        PromoDao.getInstance().save(promoActive)
                    } catch (e: SQLException) {
                        e.printStackTrace()
                    }
                    if (saled.qty.compareTo(qtyPromo) == 1) {
                        val qtyLeft: BigDecimal = saled.qty.subtract(qtyPromo)
                        saled.qty = qtyPromo
                        duplicateSaled(saled, qtyLeft)
                        qtyPromo = BigDecimal.ZERO
                    } else {
                        qtyPromo = qtyPromo.subtract(saled.qty)
                    }
                } else if (promoActive.isMulti && promoItemSyarat.contains(saled.item!!.id)) {
                    if (saled.item!!.id == itemid) {
                        if (promoActive.isPriceOveride) {
                            saled.listPrice = promoActive.itemPrice ?: BigDecimal.ZERO
                            saled.disc = BigDecimal.ZERO
                            saled.discAmt = BigDecimal.ZERO
                            saled.discExp = "0"
                        } else {
                            val isPercentage: Boolean =
                                promoActive.itemDiscExp?.contains("%") ?: false
                            var discAmt: BigDecimal?
                            var disc: BigDecimal?
                            if (isPercentage) {
                                disc = BigDecimal(promoActive.itemDiscExp!!.replace("%", ""))
                                discAmt = saled.listPrice.multiply(disc).divide(BigDecimal(100))
                                    .setScale(2, 0)
                                saled.discExp = promoActive.itemDiscExp ?: ""
                            } else {
                                discAmt = BigDecimal(promoActive.itemDiscExp)
                                disc = discAmt
                                saled.discExp = "0"
                            }
                            saled.disc = disc
                            saled.discAmt = discAmt ?: BigDecimal.ZERO
                        }
                        mSaleTrans.calculate()
                        addSalePromoItem(promoActive, saled, saled)
                        try {
                            promoActive.isUsed = true
//                            PromoDao.getInstance().save(promoActive)
                        } catch (e: SQLException) {
                            e.printStackTrace()
                        }
                        if (saled.qty.compareTo(qtyPromo) == 1) {
                            val qtyLeft: BigDecimal = saled.qty.subtract(qtyPromo)
                            saled.qty = qtyPromo
                            duplicateSaled(saled, qtyLeft)
                            qtyPromo = BigDecimal.ZERO
                        } else {
                            qtyPromo = qtyPromo.subtract(saled.qty)
                        }
                    }
                }
            }
            if (lastSaled != null && saled.dno == lastSaled.dno) {
                isLastSaled = true
            }
            newLastSaled = saled
            if (qtyPromo.compareTo(BigDecimal.ZERO) == 0) {
                break
            }
        }
        mergeItemPromo(promoActive, false)
        return newLastSaled
    }

    private suspend fun applyPromoXY(
        qtyPromo: BigDecimal,
        totalQtyItem: BigDecimal,
        promoActive: Promo,
        itemid: Int,
        lastSaled: Saled?
    ): BigDecimal {
        val isLastSaled = false
        var saled: Saled? = null
        var qtySisa: BigDecimal = qtyPromo
        var promoItemSyarat: List<Int> = ArrayList()
        var promoItemOffer: List<Int> = ArrayList()
        if (promoActive.isMulti) {
            promoItemSyarat = getListItemidSyaratPromoMulti(promoActive)
            promoItemOffer = getListItemidOfferPromoMulti(promoActive)
        }
        for (saled1 in mSaleTrans.getListDetail()) {
            if (promoActive.isMulti) {
                saled = findSaledSyaratPromoMulti(promoActive, itemid)
                break
            }
            if (promoActive.isTargetItem) {
                if (saled1.item!!.id == promoActive.itemId) {
                    saled = saled1
                    break
                }
            } else if (promoActive.isTargetItgrp) {
                if (promoActive.itgrpId == saled1.item!!.itemGrpId) {
                    saled = saled1
                    break
                }
            }
        }
        for (saled1 in mSaleTrans.getListDetail()) {
            if (promoItemOffer.contains(saled1.item!!.id)) {
//                    if (saled.itemId == itemid) {
                if (promoActive.isPriceOveride) {
                    saled1.listPrice = promoActive.itemPrice ?: BigDecimal.ZERO
                    saled1.disc = BigDecimal.ZERO
                    saled1.discAmt = BigDecimal.ZERO
                    saled1.discExp = "0"
                } else {
                    val isPercentage: Boolean = promoActive.itemDiscExp?.contains("%") ?: false
                    var discAmt: BigDecimal?
                    var disc: BigDecimal?
                    if (isPercentage) {
                        disc = BigDecimal(promoActive.itemDiscExp?.replace("%", ""))
                        discAmt = saled1.listPrice.multiply(disc).divide(BigDecimal(100))
                            .setScale(2, 0)
                        saled1.discExp = promoActive.itemDiscExp ?: ""
                    } else {
                        discAmt = BigDecimal(promoActive.itemDiscExp)
                        disc = discAmt
                        saled1.discExp = "0"
                    }
                    saled1.disc = disc
                    saled1.discAmt = discAmt ?: BigDecimal.ZERO
                }
                mSaleTrans.calculate()
                addSalePromoItem(promoActive, saled, saled1)
                if (saled1.qty.compareTo(qtySisa) == 1) {
                    val qtyLeft: BigDecimal = saled1.qty.subtract(qtySisa)
                    saled1.qty = qtySisa
                    duplicateSaled(saled1, qtyLeft)
                    qtySisa = BigDecimal.ZERO
                } else {
                    qtySisa = qtySisa.subtract(saled1.qty)
                }
            }
            if (qtySisa.compareTo(BigDecimal.ZERO) == 0) {
                break
            }
        }
        addPromoBonus(promoActive, qtySisa, saled)
        mergeItemPromo(promoActive, true)
        return qtySisa
    }

    private suspend fun applyPromoBonus(
        promoActive: Promo,
        qtyPromo: BigDecimal,
        totalQty: BigDecimal,
        itemid: Int
    ) {
        val qtySisa: BigDecimal
        var saledNew: Saled
        var saled: Saled? = null //saled syarat
        saledTemp = null
        qtyTemp = BigDecimal.ZERO
        for (saled1 in mSaleTrans.getListDetail()) {
            if (promoActive.isMulti) {
                saled = findSaledSyaratPromoMulti(promoActive, itemid)
                break
            }
            if (promoActive.isTargetItem) {
                if (saled1.item!!.id == promoActive.itemId) {
                    saled = saled1
                    break
                }
            } else if (promoActive.isTargetItgrp) {
                if (promoActive.itgrpId == saled1.item!!.itemGrpId) {
                    saled = saled1
                    break
                }
            }
        }
        if (saled != null) {
            qtySisa = checkExistItemDeal(qtyPromo, promoActive, saled, totalQty)
            // Jika promo bonus dealsame item cek qty sisa dan item bonus langsung ditambahkan
            if (qtySisa > BigDecimal.ZERO) {
                if (promoActive.isDealSameItem) {
                    addBonusLeft(qtySisa, promoActive, saled)
                } else {
                    addPromoBonus(
                        promoActive,
                        qtySisa,
                        findSaledSyaratPromoMulti(promoActive, itemid)
                    )
                }
            }
        }
    }

    private suspend fun addBonusLeft(qty: BigDecimal, promoActive: Promo, saled: Saled) {
        val qtySisa: BigDecimal = qty
        val saledNew: Saled

        val item: Item? = itemRepository.getItemById(saled.itemId).first()

        item?.let {
            saledNew = generateItemBonus(item, promoActive, qtySisa)
            saledNew.isBonus = true
            saledNew.isBonusUsed = true
            saledNew.isDeleted = false
            mSaleTrans.addDetail(saledNew)
            addSalePromoItem(promoActive, saled, saledNew)

        }
    }

    private suspend fun checkExistItemDeal(
        qtyPromo: BigDecimal,
        promoActive: Promo,
        saled: Saled,
        totalQty: BigDecimal
    ): BigDecimal {
        var qtySyarat: BigDecimal = countQtyItemSyarat(promoActive, totalQty)
        var qtySisa: BigDecimal = qtyPromo
        var promoItemSyarat: List<Int?> = ArrayList()
        var promoItemOffer: List<Int?> = ArrayList()
        if (promoActive.isMulti) {
            promoItemSyarat = getListItemidSyaratPromoMulti(promoActive)
            promoItemOffer = getListItemidOfferPromoMulti(promoActive)
        }
        for (saled1 in mSaleTrans.getListDetail()) {
            if (!promoActive.isMulti && saled1.item!!.id == promoActive.dealItemId) {
                val sameItem =
                    promoActive.isDealSameItem || !promoActive.isDealSameItem && promoActive.itemId == promoActive.dealItemId
                if (sameItem && checkItemSyarat(qtySyarat, saled1) || !sameItem) {
                    if (saled1.qty.compareTo(qtySisa) != 1) {
                        applyBonusSaled(promoActive.dealItemId!!, saled1, promoActive, qtyPromo)
                        qtySisa = qtySisa.subtract(saled1.qty)
                        addSalePromoItem(promoActive, saled, saled1)
                    } else {
                        saled1.isBonusUsed = false
                    }
                } else {
                    qtySyarat = qtySyarat.subtract(saled1.qty)
                }
            } else if (promoActive.isMulti) {
                if (promoActive.isDealSameItem && promoItemSyarat.size == 1) {
                    if (saled.itemId == saled1.itemId && checkItemSyarat(
                            qtySyarat,
                            saled1
                        )
                    ) {
                        if (saled1.qty.compareTo(qtySisa) != 1 && promoItemSyarat.contains(saled1.item!!.id)) {
                            saled1.listPrice = promoActive.itemPrice ?: BigDecimal.ZERO
                            saled1.isBonus = true
                            saled1.isBonusUsed = true
                            qtySisa = qtySisa.subtract(saled1.qty)
                            addSalePromoItem(promoActive, saled, saled1)
                        }
                    } else if (saled.itemId.equals(saled1.itemId)) {
                        saled1.isBonusUsed = false
                        qtySyarat = qtySyarat.subtract(saled1.qty)
                    }
                } else if (promoActive.isDealSameItem && promoItemSyarat.contains(saled1.item!!.id)) {
                    if (saled.itemId == saled1.itemId && checkItemSyarat(
                            qtySyarat,
                            saled1
                        )
                    ) {
                        if (saled1.qty >= qtySisa) {
                            if (qtySisa > BigDecimal.ZERO) saled1.qty = qtySisa
                            saled1.isBonusUsed = true
                            qtySisa = BigDecimal.ZERO
                            addSalePromoItem(promoActive, saled, saled1)
                        }
                    } else if (saled.itemId.equals(saled1.itemId)) {
                        saled1.isBonusUsed = false
                        qtySyarat = qtySyarat.subtract(saled1.qty)
                    }
                } else {
                    if (saled1.isBonus && promoItemOffer.contains(saled1.item!!.id)) {
                        if (saled1.qty >= qtySisa) {
                            saled1.qty = qtySisa
                            saled1.isBonusUsed = true
                            qtySisa = BigDecimal.ZERO
                        } else {
                            saled1.isBonusUsed = true
                            qtySisa = qtySisa.subtract(saled1.qty)
                        }
                        addSalePromoItem(promoActive, saled, saled1)
                    }
                }
            }
        }
        if (saledTemp != null) {
            if (saledTemp!!.isBonus) {
                if (qtySisa.compareTo(qtyTemp) == 0) {
                    duplicateSaled(saledTemp!!, qtySisa, BigDecimal.ZERO)
                    qtySisa = BigDecimal.ZERO
                } else if (qtySisa > qtyTemp) {
                    duplicateSaled(saledTemp!!, qtyTemp, BigDecimal.ZERO)
                    qtySisa = qtySisa.subtract(qtyTemp)
                } else if (qtySisa < qtyTemp) {
                    duplicateSaled(saledTemp!!, qtySisa, BigDecimal.ZERO)
                    duplicateSaled(saledTemp!!, qtyTemp.subtract(qtySisa))
                    qtySisa = BigDecimal.ZERO
                }
            } else {
                saledTemp!!.qty = saledTemp!!.qty.add(qtyTemp)
            }
        }
        return qtySisa
    }

    //Menghindari item deal diambil dari item syarat apabila item sama
    private fun checkItemSyarat(qtySyarat: BigDecimal, saled: Saled): Boolean {
        if (qtySyarat.compareTo(BigDecimal.ZERO) > 0 && saled.isBonus) {
            return false
        }
        if (qtySyarat.compareTo(BigDecimal.ZERO) > 0 && qtySyarat.compareTo(saled.qty) > -1) {
            saled.isBonus = false
            saled.isBonusUsed = false
            return false
        } else if (qtySyarat.compareTo(BigDecimal.ZERO) > 0 && qtySyarat.compareTo(saled.qty) < 0) {
            //Jika qty syarat lebih kecil dari qty saled maka harus dipecah, kemudian dicek lagi qty sisa merukapakan saled biasa atau menjadi bonus
            qtyTemp = saled.qty.subtract(qtySyarat)
            saled.isBonus = false
            saled.isBonusUsed = false
            saled.qty = qtySyarat
            saledTemp = saled
            return false
        }
        return true
    }

    private fun countQtyItemSyarat(promo: Promo, totalQty: BigDecimal): BigDecimal {
        var result: BigDecimal = BigDecimal.ZERO
        if (promo.isMinQtyMultiply) {
            do {
                result = result.add(promo.minQty)
            } while (result.add(promo.minQty).compareTo(totalQty) < 1)
        } else {
            result = promo.minQty ?: BigDecimal.ZERO
        }
        return result
    }

    private suspend fun findSaledSyaratPromoMulti(promo: Promo, itemid: Int): Saled? {
        val promoItem = getListItemidSyaratPromoMulti(promo)
        for (saled in mSaleTrans.getListDetail()) {
            if (!saled.isBonus) {
                if (itemid > -1 && saled.item!!.id.equals(itemid)) {
                    return saled
                } else if (itemid == -1 && promoItem.contains(saled.item!!.id)) {
                    return saled
                }
            }
        }
        return null
    }

    private suspend fun getPromoMultiByPromo(promo: Promo): List<PromoMulti?> {
        var promoMultiList: List<PromoMulti?> = ArrayList<PromoMulti?>()
        try {
            promoMultiList = promoMultiRepository.getPromoMultiByPromo(promo.id).first()
        } catch (e: SQLException) {
            e.printStackTrace()
        }
        return promoMultiList
    }

    private suspend fun getListItemidSyaratPromoMulti(promo: Promo): List<Int> {
        val promoItem: MutableList<Int> = ArrayList()
        try {
            val promoMultiList: List<PromoMulti> =
                promoMultiRepository.getSyaratPromoMultiByPromo(promo.id).first()
            for (promoMulti in promoMultiList) {
                if (promoMulti.type == "ITEM") {
                    promoItem.add(Integer.valueOf(promoMulti.value))
                }
                if (promoMulti.type == "ITEMGRP1") {
                    val itemList: List<Item> =
                        itemRepository.getActiveItemListByItemGrp(promoMulti.value.toInt()).first()
                    for (item in itemList) {
                        promoItem.add(Integer.valueOf(item.id))
                    }
                }
            }
        } catch (e: SQLException) {
            e.printStackTrace()
        }
        return promoItem
    }

    private suspend fun getListItemidOfferPromoMulti(promo: Promo): List<Int> {
        val promoItem: MutableList<Int> = ArrayList()
        try {
            val promoMultiList: List<PromoMulti> =
                promoMultiRepository.getOfferPromoMultiByPromo(promo.id).first()
            for (promoMulti in promoMultiList) {
                promoItem.add(Integer.valueOf(promoMulti.value))
            }
        } catch (e: SQLException) {
            e.printStackTrace()
        }
        return promoItem
    }

    private fun applyBonusSaled(itemid: Int, saled: Saled, promo: Promo, qtyPromo: BigDecimal) {
        editQtyAddonByUpSaled(saled, qtyPromo)
        saled.listPrice = promo.itemPrice ?: BigDecimal.ZERO
        saled.qty = qtyPromo
        saled.isBonus = true
        saled.isBonusUsed = true
    }

    private fun generateItemBonus(item: Item, promoActive: Promo, qtyPromo: BigDecimal): Saled {
        val saledNew = Saled()
        saledNew.itemId = item.id
        saledNew.item = item
        saledNew.listPrice = promoActive.itemPrice ?: BigDecimal.ZERO
        saledNew.qty = qtyPromo
        saledNew.name = item.name1
        saledNew.discExp = "0"
        saledNew.disc2Amt = BigDecimal.ZERO
//        if (item.tax == "") {
//            saledNew.tax = BigDecimal.ZERO
//        } else {
//            try {
//                val tax = BigDecimal(TaxDao.getTaxDao().getCodeTax(item.getTax()))
//                saledNew.tax = tax
//            } catch (e: SQLException) {
//                e.printStackTrace()
//            }
//        }
        return saledNew
    }

    private fun removeUnusedItemDeal() {
        val saledList: MutableList<Saled> = ArrayList()
        for (saled in mSaleTrans.getListDetail()) {
            for (salePromo in mSaleTrans.salePromoList) {
                if (saled === salePromo.saled) {
                    break
                }
            }
            saledList.add(saled)
        }
        mSaleTrans.getListDetail().removeAll(saledList)
    }

    private fun editQtyAddonByUpSaled(saled: Saled, qtyPromo: BigDecimal) {
        if (mSaleTrans.addOnTrans != null) {
            for (saleAddOnD in mSaleTrans.addOnTrans!!.getListDetail()) {
                if (saleAddOnD.upSaled === saled) {
                    saleAddOnD.saled?.let { saledAddOn ->
                        saledAddOn.qty = saledAddOn.qty.divide(saled.qty).multiply(qtyPromo)
                    }
                }
            }
        }
    }

    private suspend fun duplicateSaled(saled: Saled, qtyLeft: BigDecimal) {
        duplicateSaled(saled, qtyLeft, null)
    }

    private suspend fun duplicateSaled(saled: Saled, qtyLeft: BigDecimal, price: BigDecimal?) {
        val saledNew = Saled()
        saledNew.itemId = saled.itemId
        saledNew.item = saled.item
        saledNew.listPrice = price ?: saled.item!!.price
        saledNew.qty = qtyLeft
        saledNew.name = saled.name
        saledNew.discExp = "0"
        saledNew.disc2Amt = BigDecimal.ZERO
        if (price != null && price.compareTo(BigDecimal.ZERO) == 0) {
            saledNew.isBonus = true
            saledNew.isBonusUsed = true
        }
        saledNew.tax = saled.tax
        mSaleTrans.addDetail(saledNew)

        if (mSaleTrans.addOnTrans != null) {
            val saledAddOnList: MutableList<Saled> = ArrayList()
            for (saleAddOnD in mSaleTrans.addOnTrans!!.getListDetail()) {
                if (saleAddOnD.upSaled != null && saleAddOnD.upSaled!! === saled) {
                    val saledAddOnNew = Saled()
                    val saledAddOn: Saled? = saleAddOnD.saled
                    saledAddOn?.let {
                        val qtyPcs: BigDecimal = saledAddOn.qty.divide(saled.qty.add(qtyLeft))
                        saledAddOn.qty = saled.qty.multiply(qtyPcs)
                        saledAddOnNew.itemId = saledAddOn.itemId
                        saledAddOnNew.item = saledAddOn.item
                        saledAddOnNew.listPrice = saledAddOn.item!!.price
                        saledAddOnNew.qty = qtyLeft.multiply(qtyPcs)
                        saledAddOnNew.name = saledAddOn.name
                        saledAddOnNew.discExp = "0"
                        saledAddOnNew.disc2Amt = BigDecimal.ZERO

                        saledAddOnNew.tax = saledAddOn.tax
                        saledAddOnList.add(saledAddOnNew)
                    }

                }
            }
            for (saled1 in saledAddOnList) {
                mSaleTrans.addDetail(saled1)
                val saleAddOnDNew = SaleAddOnD()
                saleAddOnDNew.saleAddOn = mSaleTrans.addOnTrans!!.getMaster()
                saleAddOnDNew.saled = saled1
                saleAddOnDNew.upSaled = saledNew
                mSaleTrans.addOnTrans!!.addDetail(saleAddOnDNew)
            }
        }
    }

    fun getSaled(saled: Saled): Saled {
        for (i in mSaleTrans.getListDetail().indices) {
            val saleds = mSaleTrans.getListDetail()[i]
            if (saled.item!!.id == saled.itemId) {
                return saleds
            }
        }
        return Saled()
    }

    private suspend fun removeUnusedBonusSingleItem(itemid: Int) {
        if (mapItemPromoApplied.containsKey(itemid)) {
            val promo = mapItemPromoApplied[itemid]
            if (promo != null && promo.promoCat == PromoEntity.BONUS) {
                while (mSaleTrans.findSalePromo(itemid) != null) {
                    val salePromo: SalePromo? = mSaleTrans.findSalePromo(itemid)
                    if (salePromo?.saled != null) {
                        val itemidList = getListItemidOfferPromoMulti(promo)
                        removeUnusedBonus(itemidList)
                    }
                }
            }
        }
    }

    private suspend fun removeUnusedBonus(itemidList: List<Int?>) {
        val addOnTrans = mSaleTrans.addOnTrans
        val iterator: Iterator<*> = mSaleTrans.getListDetail().iterator()
        while (iterator.hasNext()) {
            val saled = iterator.next() as Saled
            if (itemidList.contains(saled.itemId)) {
                if (saled.isBonus && !saled.isBonusUsed) {
                    if (addOnTrans != null && addOnTrans.isExistUpSaled(saled)) {
                        val price: BigDecimal =
                            getPriceItemUseCase(saled.item!!, bp!!.priceLvlId, bp!!).price
                        saled.listPrice = price
                        saled.isBonus = false
                        saled.isBonusUsed = false
                    } else {
                        mSaleTrans.getListDetail().remove(saled)
                    }
                }
            }
        }
        mSaleTrans.calculate()
    }

    private suspend fun removeUnusedBonus() {
        val saledListRemove: MutableList<Saled> = ArrayList()
        val addOnTrans = mSaleTrans.addOnTrans
        for (saled in mSaleTrans.getListDetail()) {
            if (saled.isBonus && !saled.isBonusUsed) {
                if (addOnTrans != null && addOnTrans.isExistUpSaled(saled)) {
                    val price: BigDecimal =
                        getPriceItemUseCase(saled.item!!, bp!!.priceLvlId, bp!!).price
                    saled.listPrice = price
                    saled.isBonus = false
                    saled.isBonusUsed = false
                } else {
                    saledListRemove.add(saled)
                }
            }
        }
        mSaleTrans.getListDetail().removeAll(saledListRemove)
        mSaleTrans.calculate()
    }

    /* -------------------------------------------------Add To List Promo Bonus ------------------------------------------------- */
    fun addPromoBonus(promoActive: Promo, qtySisa: BigDecimal, saled: Saled?) {
        if (promoActive.isMulti && qtySisa > BigDecimal.ZERO) {
            listPromoBonus.add(ListPromoBonus.PromoBonus(promoActive, qtySisa, saled))
        }
        //cek jika ada promo yang sudah terklaim tapi belum dihapus dikarenakan input dari sale trans 1 per 1
        if (promoActive.isMulti && qtySisa.compareTo(BigDecimal.ZERO) == 0) {
            val listPromo: Iterator<*> = listPromoBonus.iterator()
            while (listPromo.hasNext()) {
                val promoBonus: ListPromoBonus.PromoBonus =
                    listPromo.next() as ListPromoBonus.PromoBonus
                if (promoBonus.getPromo().code == promoActive.code) listPromoBonus.remove(
                    promoBonus
                )
            }
        }
    }

    /* -------------------------------------------------ADD PROMO TO SALE PROMO------------------------------------------------- */
    private fun addSalePromoNota(promo: Promo) {
        addSalePromo(promo, null, "S")
    }

    fun addSalePromoItem(promo: Promo, saledSyarat: Saled?, saledPromo: Saled?) {
        addSalePromo(promo, saledSyarat, "S")
        addSalePromo(promo, saledPromo, "D")
    }

    private fun addSalePromoNota(promo: Promo, saledPromo: Saled?) {
        addSalePromo(promo, null, "S")
        addSalePromo(promo, saledPromo, "D")
    }

    private fun addSalePromo(promo: Promo, saled: Saled?, promoRole: String) {
        // cek apakah salepromo untuk saled sudah tersedia
        var i = checkExistSaledPromo(saled)

        // cek untuk promo nota apakah salepromo untuk promo tersebut sudah ada
        if (saled == null) i = checkExistSalePromo()
        val salePromo = SalePromo()
        salePromo.sale = mSaleTrans.getMaster()
        if (saled != null) {
            salePromo.saled = saled
            salePromo.promoQty = saled.qty
        }
        salePromo.promo = promo
        salePromo.promoRule = promoRole
        if (i > -1) {
            mSaleTrans.salePromoList[i] = salePromo
        } else {
            mSaleTrans.salePromoList.add(salePromo)
        }
    }

    private fun checkExistSaledPromo(saled: Saled?): Int {
        if (saled != null) {
            mSaleTrans.salePromoList.withIndex().forEach { (n, saledPromo) ->
                if (saledPromo.saled != null && saled.dno == saledPromo.saled!!.dno) {
                    return n
                }
            }
        }
        return -1
    }

    private fun checkExistSalePromo(): Int {
        return mSaleTrans.salePromoList.indexOfFirst { it.saled == null }
    }

    /* -------------------------------------------------Reset Promo------------------------------------------------- */
    private suspend fun resetPromo() {
        val salePromoList: List<SalePromo> = mSaleTrans.salePromoList
        for (salePromo in salePromoList) {
            try {
                salePromo.promo?.let { promo ->
                    if (promo.promoCat == PromoEntity.DISC) {
                        removePromoDisc(promo, salePromo.saled)
                    } else if (promo.promoCat == PromoEntity.MINAMT) {
                        removePromoMinAmt(promo, salePromo.saled)
                    } else if (promo.promoCat == PromoEntity.XY) {
                        removePromoDisc(promo, salePromo.saled)
                    }
                }
            } catch (e: SQLException) {
                e.printStackTrace()
            }
        }
        resetUsedBonus()
        listPromoBonus.clear()
        mSaleTrans.salePromoList.clear()
        saledTemp = null
        qtyTemp = BigDecimal.ZERO
    }

    private fun resetUsedBonus() {
        for (saled in mSaleTrans.getListDetail()) {
            if (saled.isBonus) {
                saled.isBonusUsed = false
            }
        }
    }

    private fun resetQtyAddonByUpSaled(saled: Saled) {
        for (saleAddOnD in mSaleTrans.addOnTrans!!.getListDetail()) {
            if (saleAddOnD.upSaled === saled) {
                if (saleAddOnD.saled != null && saleAddOnD.upSaled != null) {
                    saleAddOnD.saled!!.qty = saleAddOnD.saled!!.qty.divide(saleAddOnD.upSaled!!.qty)
                }
            }
        }
    }

    private suspend fun removePromoDisc(promo: Promo?, saled: Saled?) {
        try {
            if (promo != null && saled != null) {
                val price: BigDecimal = getPriceItemUseCase(saled.item!!, 1, bp!!).price
                saled.listPrice = price
                saled.discExp = ""
                saled.disc = BigDecimal.ZERO
                saled.discAmt = BigDecimal.ZERO
                promo.isUsed = false
//                PromoDao.getInstance().save(promo)
            }
        } catch (e: SQLException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private suspend fun removePromoMinAmt(promo: Promo, saled: Saled?) {
        if (promo.offerType.equals(PromoEntity.OFFERTYPE_HEADER)) {
            val sale = mSaleTrans.getMaster()
            sale.discExp = ""
            sale.discAmt = BigDecimal.ZERO
            mSaleTrans.updateDiskonMaster("")
        } else {
            saled?.let { removePromoDisc(promo, it) }
        }
    }

    private suspend fun removePromoSingleMinAmt(itemid: Int) {
        val salePromo: SalePromo? = mSaleTrans.findSalePromo(PromoEntity.MINAMT)
        if (salePromo?.promo != null) {
            try {
                removePromoMinAmt(salePromo.promo!!, salePromo.saled)
            } catch (throwables: SQLException) {
                throwables.printStackTrace()
            }
            mSaleTrans.salePromoList.remove(salePromo)
        }
    }

    private fun removePromoXY(saled: Saled, promoRole: String) {
        if (promoRole.equals("D", ignoreCase = true)) {
            mSaleTrans.getListDetail().remove(saled)
        }
    }

    /* -------------------------------------------------Merge Item Promo------------------------------------------------- */ //menghindari duplicate saled
    suspend fun mergeItemPromo(promo: Promo, isDeal: Boolean) {
        val saledList: MutableList<Saled> = ArrayList()
        val saledListResult: MutableList<Saled> = ArrayList()
        val listItemidSyaratPromoMulti = getListItemidSyaratPromoMulti(promo)
        val listItemidDealPromoMulti = getListItemidOfferPromoMulti(promo)
        for (saled in mSaleTrans.getListDetail()) {
            if (!isDeal && listItemidSyaratPromoMulti.contains(saled.item!!.id)) {
                saledList.add(saled)
            }
            if (isDeal && listItemidDealPromoMulti.contains(saled.item!!.id)) {
                saledList.add(saled)
            }
        }
        if (saledList.size > 0) {
            for (saled in saledList) {
                var isExist = false
                if (saledListResult.size == 0) {
                    saledListResult.add(saled)
                } else {
                    for (saled1 in saledListResult) {
                        if (saled.item!!.id == saled1.item!!.id
                            && saled.listPrice
                                .compareTo(saled1.listPrice) == 0 && saled.discAmt
                                .compareTo(saled1.discAmt) == 0
                        ) {
                            mSaleTrans.mergeSaled(saled1, saled)
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

    /* -------------------------------------------------SORTING PRIORITY PROMO------------------------------------------------- */
    private fun getPromoByPriority(promoList: List<Promo>): Promo {
        return Collections.min(promoList, PromoComp())
    }

    internal inner class PromoComp : Comparator<Promo> {
        override fun compare(o1: Promo, o2: Promo): Int {
            return o1.priority.compareTo(o2.priority)
        }
    }

    private fun getPromoByPriorityMinAmt(promoList: List<Promo>): Promo {
        return Collections.min(promoList, PromoAmtComp())
    }

    internal inner class PromoAmtComp : Comparator<Promo> {
        override fun compare(o1: Promo, o2: Promo): Int {
            val priority = o1.priority.compareTo(o2.priority)
            return if (priority != 0) {
                priority
            } else o2.minAmt.compareTo(o1.minAmt)
        }
    }

}