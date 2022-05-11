package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.ChannelEntity
import com.bits.bee.bpmc.domain.model.Channel

/**
 * Created by aldi on 20/04/22.
 */
object ChannelDataMapper : BaseMapper<ChannelEntity, Channel>() {

    override fun fromDataToDomain(model: ChannelEntity): Channel {
        return Channel(
            model.id,
            model.code,
            model.name,
            model.active,
            model.isPos,
            model.createdBy,
            model.createdAt,
            model.updatedBy,
            model.updatedAt,
            model.color,
            model.priceLvlId
        )
    }

    override fun fromDomainToData(model: Channel): ChannelEntity {
        return ChannelEntity(
            model.id,
            model.code,
            model.name,
            model.active,
            model.isPos,
            model.createdBy,
            model.createdAt,
            model.updatedBy,
            model.updatedAt,
            model.color,
            model.priceLvlId
        )
    }

}