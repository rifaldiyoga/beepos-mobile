package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.PromoEntity
import com.bits.bee.bpmc.data.data_source.remote.response.PromoResponse
import com.bits.bee.bpmc.domain.model.Promo

object PromoDataMapper: BaseMapper<PromoEntity, Promo, PromoResponse.DataPromo>() {

    override fun fromDbToDomain(model: PromoEntity): Promo {
        return Promo(
            model.id,
            model.isActive ,
            model.isBranch ,
            model.branchId,
            model.isPeriod ,
            model.startDate ,
            model.endDate,
            model.isTime ,
            model.startTime ,
            model.endTime ,
            model.isDow,
            model.dowExp ,
            model.isBpgrp ,
            model.bpgrpId,
            model.offerType ,
            model.minAmt ,
            model.isTargetItem ,
            model.itemId,
            model.isTargetItgrp ,
            model.itgrpId,
            model.isTargetBrand ,
            model.brandId,
            model.isTargetVendor ,
            model.vendorId,
            model.isMinQty ,
            model.minQty,
            model.priority,
            model.isMinAmt,
            model.note ,
            model.code ,
            model.promoType ,
            model.promoName ,
            model.itemDiscExp ,
            model.promoCat ,
            model.isPriceOveride ,
            model.dealItemId,
            model.itemPrice ,
            model.isMinQtyMultiply ,
            model.isMaxQty ,
            model.maxQty,
            model.isUsed ,
            model.isOn ,
            model.isMulti ,
            model.dealQty,
            model.isDealSameItem ,
        )
    }


    override fun fromDomainToDb(model: Promo): PromoEntity {
        return PromoEntity(
            model.id,
            model.isActive ,
            model.isBranch ,
            model.branchId,
            model.isPeriod ,
            model.startDate ,
            model.endDate,
            model.isTime ,
            model.startTime ,
            model.endTime ,
            model.isDow,
            model.dowExp ,
            model.isBpgrp ,
            model.bpgrpId,
            model.offerType ,
            model.minAmt ,
            model.isTargetItem ,
            model.itemId,
            model.isTargetItgrp ,
            model.itgrpId,
            model.isTargetBrand ,
            model.brandId,
            model.isTargetVendor ,
            model.vendorId,
            model.isMinQty ,
            model.minQty,
            model.priority,
            model.isMinAmt,
            model.note ,
            model.code ,
            model.promoType ,
            model.promoName ,
            model.itemDiscExp ,
            model.promoCat ,
            model.isPriceOveride ,
            model.dealItemId,
            model.itemPrice ,
            model.isMinQtyMultiply ,
            model.isMaxQty ,
            model.maxQty,
            model.isUsed ,
            model.isOn ,
            model.isMulti ,
            model.dealQty,
            model.isDealSameItem ,
        )

    }

    override fun fromNetworkToDb(model: PromoResponse.DataPromo): PromoEntity {
        return PromoEntity(
            model.id,
            model.isActive ,
            model.isBranch ,
            model.branchId?.toInt(),
            model.isPeriode ,
            model.startDate ,
            model.endDate,
            model.isTime ,
            model.starttime ,
            model.endTime ,
            model.isDow,
            model.dowExp ,
            model.isBpgrp1 ,
            model.bpgrp1Id,
            model.offerType ,
            model.minAmt ,
            model.isTargetItem ,
            model.itemId ,
            model.isTargetItgrp1 ,
            model.itemgrp1Id?.toInt(),
            model.isTargetBrand ,
            model.brandId?.toInt(),
            model.isTargetVendor ,
            model.vendorId?.toInt(),
            model.isMinQty ,
            model.minQty,
            model.priority,
            model.isMinAmt,
            model.note ,
            model.code ,
            model.type ,
            model.promoName ,
            model.itemDiscExp ,
            model.promoCat ,
            model.isPriceOverride ,
            model.dealItemId,
            model.itemPrice,
            model.isMinQtyMultiply,
            model.isMaxQty,
            model.maxQty,
            isMulti = model.isMulti,
            dealQty = model.dealQty,
            isDealSameItem = model.isDealSameItem,
        )
    }
}