package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.WhEntity
import com.bits.bee.bpmc.data.data_source.remote.model.WhModel
import com.bits.bee.bpmc.domain.model.Wh

/**
 * Created by aldi on 22/06/22.
 */
object WhDataMapper : BaseMapper<WhEntity, Wh, WhModel>() {

    override fun fromDbToDomain(model: WhEntity): Wh {
        return Wh(
            model.id,
            model.code,
            model.name,
            model.active,
        )
    }

    override fun fromDomainToDb(model: Wh): WhEntity {
        return WhEntity(
            model.id,
            model.code,
            model.name,
            model.active,
        )
    }

    override fun fromNetworkToDb(model: WhModel): WhEntity {
        return WhEntity(
            model.id,
            model.code,
            model.name,
            model.active,
        )
    }

}