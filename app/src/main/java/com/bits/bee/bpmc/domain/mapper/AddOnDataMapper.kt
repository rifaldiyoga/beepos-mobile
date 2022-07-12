package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.AddOnEntity
import com.bits.bee.bpmc.data.data_source.remote.response.AddOnResponse
import com.bits.bee.bpmc.domain.model.AddOn
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.DateFormatUtils

/**
 * Created by aldi on 22/04/22.
 */
object AddOnDataMapper : BaseMapper<AddOnEntity, AddOn, AddOnResponse.AddOnModel>(){

    override fun fromDbToDomain(model: AddOnEntity): AddOn {
        return AddOn(
            model.id,
            model.code,
            model.name,
            model.isActive,
            model.createdAt
        )
    }

    override fun fromDomainToDb(model: AddOn): AddOnEntity {
        return AddOnEntity(
            model.id,
            model.code,
            model.name,
            model.isActive,
            model.createdAt
        )
    }

    override fun fromNetworkToData(model: AddOnResponse.AddOnModel): AddOnEntity {
        return AddOnEntity(
            model.id,
            model.code,
            model.name,
            model.isActive,
            DateFormatUtils.formatStringToDate(BPMConstants.DEFAULT_DATE_FORMAT, model.createdAt)
        )
    }
}