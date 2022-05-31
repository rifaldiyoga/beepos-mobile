package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.PriceEntity
import com.bits.bee.bpmc.data.data_source.remote.response.ItemResponse
import com.bits.bee.bpmc.domain.model.Price

/**
 * Created by aldi on 20/04/22.
 */

object PriceDataMapper : BaseMapper<PriceEntity, Price>(){

    override fun fromDataToDomain(model: PriceEntity): Price {
        return Price(
            id = model.id!!,
            itemId = model.itemId,
            priceLvlId = model.priceLvlId,
            price = model.price,
            crcId = model.crcId,
            discExp = model.discExp
        )
    }

    override fun fromDomainToData(model: Price): PriceEntity {
        return PriceEntity(
            id = model.id,
            itemId = model.itemId,
            priceLvlId = model.priceLvlId,
            price = model.price,
            crcId = model.crcId,
            discExp = model.discExp
        )
    }

    fun fromDataToResponse(model : ItemResponse.PriceModel) : PriceEntity {
        return PriceEntity(
            itemId = model.itemId,
            priceLvlId = model.priceLvl.value,
            price = model.price1,
            crcId = model.crc.value,
            discExp = model.discExp1
        )
    }

}