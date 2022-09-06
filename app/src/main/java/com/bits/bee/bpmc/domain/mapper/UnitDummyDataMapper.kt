package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.UnitDummyEntity
import com.bits.bee.bpmc.domain.model.UnitDummy

/**
 * Created by aldi on 20/04/22.
 */

object UnitDummyDummyDataMapper : BaseMapper<UnitDummyEntity, UnitDummy, Any>(){

    override fun fromDbToDomain(model: UnitDummyEntity): UnitDummy {
        return UnitDummy(
            id = model.id,
            itemId = model.itemId,
            idx = model.idx,
            conv = model.conv,
            unit = model.unit
        )
    }

    override fun fromDomainToDb(model: UnitDummy): UnitDummyEntity {
        return UnitDummyEntity(
            id = model.id,
            itemId = model.itemId,
            idx = model.idx,
            conv = model.conv,
            unit = model.unit
        )
    }

    override fun fromNetworkToDb(model: Any): UnitDummyEntity {
        TODO("Not yet implemented")
    }


}