package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.PriceEntity
import com.bits.bee.bpmc.data.data_source.remote.response.ItemResponse
import com.bits.bee.bpmc.domain.model.Price

/**
 * Created by aldi on 20/04/22.
 */

object PriceDataMapper : BaseMapper<PriceEntity, Price, ItemResponse.PriceModel>(){

    override fun fromDbToDomain(model: PriceEntity): Price {
        return Price(
            id = model.id!!,
            itemId = model.itemId,
            priceLvlId = model.priceLvlId,
            price = model.price,
            crcId = model.crcId,
            discExp = model.discExp
        )
    }

    override fun fromDomainToDb(model: Price): PriceEntity {
        return PriceEntity(
            id = model.id,
            itemId = model.itemId,
            priceLvlId = model.priceLvlId,
            price = model.price,
            crcId = model.crcId,
            discExp = model.discExp
        )
    }

    override fun fromNetworkToData(model: ItemResponse.PriceModel): PriceEntity {
        return PriceEntity(
            itemId = model.itemId,
            priceLvlId = model.priceLvl.value,
            price = model.price1,
            crcId = model.crc.value,
            discExp = model.discExp1
        )
    }

}