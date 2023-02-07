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
            crcId = model.crcId,
            price1 = model.price1,
            discExp1 = model.discExp1,
            price2 = model.price2,
            discExp2 = model.discExp2,
            price3 = model.price3,
            discExp3 = model.discExp3,
            crcSymbol = model.crcSymbol
        )
    }

    override fun fromDomainToDb(model: Price): PriceEntity {
        return PriceEntity(
            id = model.id,
            itemId = model.itemId,
            priceLvlId = model.priceLvlId,
            price1 = model.price1,
            crcId = model.crcId,
            discExp1 = model.discExp1,
            price2 = model.price2,
            discExp2 = model.discExp2,
            price3 = model.price3,
            discExp3 = model.discExp3,
            crcSymbol = model.crcSymbol
        )
    }

    override fun fromNetworkToDb(model: PriceResponse.ItemPriceData): PriceEntity {
        return PriceEntity(
            itemId = model.itemId,
            priceLvlId = model.pricelvlId,
            price1 = model.price1,
            crcId = model.crcId,
            discExp1 = model.disc1exp,
            price2 = model.price2,
            discExp2 = model.disc2exp,
            price3 = model.price3,
            discExp3 = model.disc3exp,
            crcSymbol = model.crcid
        )
    }

}