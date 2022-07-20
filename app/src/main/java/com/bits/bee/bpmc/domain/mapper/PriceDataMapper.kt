package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.PriceEntity
import com.bits.bee.bpmc.data.data_source.remote.response.PriceResponse
import com.bits.bee.bpmc.domain.model.Price

/**
 * Created by aldi on 20/04/22.
 */

object PriceDataMapper : BaseMapper<PriceEntity, Price, PriceResponse.ItemPriceData>(){

    override fun fromDbToDomain(model: PriceEntity): Price {
        return Price(
            id = model.id!!,
            itemId = model.itemId,
            priceLvlId = model.priceLvlId,
            price = model.price,
            crcId = model.crcId,
            discExp = model.discExp,
            crcSymbol = model.crcSymbol
        )
    }

    override fun fromDomainToDb(model: Price): PriceEntity {
        return PriceEntity(
            id = model.id,
            itemId = model.itemId,
            priceLvlId = model.priceLvlId,
            price = model.price,
            crcId = model.crcId,
            discExp = model.discExp,
            crcSymbol = model.crcSymbol
        )
    }

    override fun fromNetworkToDb(model: PriceResponse.ItemPriceData): PriceEntity {
        return PriceEntity(
            itemId = model.itemId,
            priceLvlId = model.pricelvlId,
            price = model.price1,
            crcId = model.crcId,
            discExp = model.disc1exp,
            crcSymbol = model.crcid
        )
    }

}