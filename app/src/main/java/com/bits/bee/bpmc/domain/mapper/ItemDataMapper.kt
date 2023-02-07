package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.ItemEntity
import com.bits.bee.bpmc.data.data_source.remote.response.ItemResponse
import com.bits.bee.bpmc.domain.model.Item

/**
 * Created by aldi on 12/05/22.
 */
object ItemDataMapper : BaseMapper<ItemEntity, Item, ItemResponse.ItemModel>() {

    override fun fromDbToDomain(model: ItemEntity): Item {
        return Item(
            id = model.id,
            code = model.code,
            name1= model.name1,
            brandId= model.brandId,
            itemTypeCode = model.itemTypeCode,
            usePid = model.usePid,
            uniqueid= model.uniquePid,
            itemGrpId = model.itemGrpId,
            isStock = model.isStock,
            isSale = model.isSale,
            unitdesc = model.unitdesc,
            note = model.note,
            active = model.active,
            saleUnit = model.saleUnit,
            stockUnit = model.stockUnit,
            isPos = model.isPos,
            type = model.type,
            isAvailable = model.isAvailable,
            isVariant = model.isVariant,
            vCode = model.vCode,
            vColor = model.vColor,
            isFavorit = model.isFavorit,
            bucket = model.bucket,
            objKey = model.objKey,
            tempUrl = model.tempUrl,
        )
    }

    override fun fromDomainToDb(model: Item): ItemEntity {
        return ItemEntity(
            id = model.id,
            code = model.code,
            name1= model.name1,
            brandId= model.brandId,
            itemTypeCode = model.itemTypeCode,
            usePid = model.usePid,
            uniquePid = model.uniqueid,
            itemGrpId = model.itemGrpId,
            isStock = model.isStock,
            isSale = model.isSale,
            unitdesc = model.unitdesc,
            note = model.note,
            active = model.active,
            saleUnit = model.saleUnit,
            stockUnit = model.stockUnit,
            isPos = model.isPos,
            type = model.type,
            isAvailable = model.isAvailable,
            isVariant = model.isVariant,
            vCode = model.vCode,
            vColor = model.vColor,
            isFavorit = model.isFavorit,
            bucket = model.bucket,
            objKey = model.objKey,
            tempUrl = model.tempUrl,
        )
    }


    override fun fromNetworkToDb(model: ItemResponse.ItemModel): ItemEntity {
        return ItemEntity(
            id = model.id,
            code = model.code,
            name1= model.name1,
            brandId= model.brandId,
            itemTypeCode = model.itemtypeCode,
            usePid = model.usepid,
            uniquePid = model.uniquepid,
            itemGrpId = model.itemgrp1Id?.toIntOrNull(),
            isStock = model.isstock,
            isSale = model.issale,
            unitdesc = model.unitdesc,
            note = model.note,
            active = model.active,
            saleUnit = model.saleunit?.toIntOrNull(),
            stockUnit = model.stockunit?.toIntOrNull(),
            isPos = model.ispos,
            isVariant = model.isvariant,
            vColor = model.vcolor,
            vCode = model.vcode,
            barCode = model.barcode
        )
    }

}