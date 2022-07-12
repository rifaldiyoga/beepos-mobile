package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.ChannelEntity
import com.bits.bee.bpmc.data.data_source.remote.response.ChannelResponse
import com.bits.bee.bpmc.domain.model.Channel
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.DateFormatUtils

/**
 * Created by aldi on 20/04/22.
 */
object ChannelDataMapper : BaseMapper<ChannelEntity, Channel, ChannelResponse.ChannelModel>() {

    override fun fromDbToDomain(model: ChannelEntity): Channel {
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

    override fun fromDomainToDb(model: Channel): ChannelEntity {
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

    override fun fromNetworkToData(model: ChannelResponse.ChannelModel): ChannelEntity {
        return ChannelEntity(
            model.id,
            model.code,
            model.name,
            model.active,
            model.isPos,
            model.createdBy,
            DateFormatUtils.formatStringToDate(BPMConstants.DEFAULT_DATE_FORMAT, model.createdAt).time,
            model.updatedBy,
            DateFormatUtils.formatStringToDate(BPMConstants.DEFAULT_DATE_FORMAT, model.updatedAt).time,
            model.color,
            model.priceLvlId
        )
    }

}