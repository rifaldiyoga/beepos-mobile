package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.StockEntity
import com.bits.bee.bpmc.data.data_source.remote.response.StockResponse
import com.bits.bee.bpmc.domain.model.Stock

/**
 * Created by aldi on 22/06/22.
 */
object StockDataMapper : BaseMapper<StockEntity, Stock, StockResponse.StockModel>() {

    override fun fromDbToDomain(model: StockEntity): Stock {
        return Stock(
            model.id ,
            model.itemId,
            model.whId ,
            model.itemCode,
            model.whCode,
            model.pid,
            model.qty,
            model.qtyx,
            model.active,
        )
    }

    override fun fromDomainToDb(model: Stock): StockEntity {
        return StockEntity(
            model.id ,
            model.itemId,
            model.whId ,
            model.itemCode,
            model.whCode,
            model.pid,
            model.qty,
            model.qtyx,
            model.active,
        )
    }

    override fun fromNetworkToDb(model: StockResponse.StockModel): StockEntity {
        return StockEntity(
            null,
            model.itemId,
            model.whId,
            model.itemCode,
            model.whCode,
            model.pid,
            model.qty,
            model.qtyx,
            model.active,
        )
    }

    fun fromNetworkToDomain(model: StockResponse.StockModel): Stock {
        return Stock(
            null,
            model.itemId,
            model.whId,
            model.itemCode,
            model.whCode,
            model.pid,
            model.qty,
            model.qtyx,
            model.active,
        )
    }

}