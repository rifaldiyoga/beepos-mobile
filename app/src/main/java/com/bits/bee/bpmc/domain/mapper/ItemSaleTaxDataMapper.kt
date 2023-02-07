package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.ItemSaleTaxEntity
import com.bits.bee.bpmc.data.data_source.remote.response.ItemTaxResponse
import com.bits.bee.bpmc.domain.model.ItemSaleTax

/**
 * Created by aldi on 22/04/22.
 */
object ItemSaleTaxDataMapper : BaseMapper<ItemSaleTaxEntity, ItemSaleTax, ItemTaxResponse.ItemTaxData>(){

    override fun fromDbToDomain(model: ItemSaleTaxEntity ): ItemSaleTax {
        return ItemSaleTax(
            model.id,
            model.itemCode,
            model.code,
            model.calcMtd,
            model.expr,
            model.exprNoReg
        )
    }

    override fun fromDomainToDb(model: ItemSaleTax): ItemSaleTaxEntity {
        return ItemSaleTaxEntity(
            model.id,
            model.itemCode,
            model.code,
            model.calcMtd,
            model.expr,
            model.exprNoReg
        )
    }

    override fun fromNetworkToDb(model: ItemTaxResponse.ItemTaxData): ItemSaleTaxEntity {
        return ItemSaleTaxEntity(
            model.id,
            model.code,
            model.saletax,
            "",
            "",
            ""
        )
    }
}