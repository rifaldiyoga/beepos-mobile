package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.UnitEntity
import com.bits.bee.bpmc.data.data_source.remote.response.ItemResponse
import com.bits.bee.bpmc.domain.model.Unit

/**
 * Created by aldi on 20/04/22.
 */

object UnitDataMapper : BaseMapper<UnitEntity, Unit, ItemResponse.UnitModel>(){

    override fun fromDbToDomain(model: UnitEntity): Unit {
        return Unit(
            id = model.id,
            itemId = model.itemId,
            idx = model.idx,
            conv = model.conv,
            unit = model.unit
        )
    }

    override fun fromDomainToDb(model: Unit): UnitEntity {
        return UnitEntity(
            id = model.id,
            itemId = model.itemId,
            idx = model.idx,
            conv = model.conv,
            unit = model.unit
        )
    }

    override fun fromNetworkToData(model: ItemResponse.UnitModel): UnitEntity {
        return UnitEntity(
            id = model.id,
            itemId = model.itemId,
            idx = model.idx,
            conv = model.conv,
            unit = model.unit
        )
    }

}