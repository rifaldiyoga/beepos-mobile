package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.KitchenEntity
import com.bits.bee.bpmc.data.data_source.remote.response.KitchenResponse
import com.bits.bee.bpmc.domain.model.Kitchen
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.DateFormatUtils

object KitchenDataMapper: BaseMapper<KitchenEntity, Kitchen, KitchenResponse.KitchenModel>() {
    override fun fromDbToDomain(model: KitchenEntity): Kitchen {

        return Kitchen(
            model.id,
            model.code,
            model.name,
            model.branchId,
            model.createdBy,
            model.createdAt,
            model.updatedBy,
            model.updatedAt,
            model.isUsed
        )
    }

    override fun fromDomainToDb(model: Kitchen): KitchenEntity {
        return KitchenEntity(
            model.id,
            model.code,
            model.name,
            model.branchId,
            model.createdBy,
            model.createdAt,
            model.updatedBy,
            model.updatedAt,
            model.isUsed
        )
    }

    override fun fromNetworkToDb(model: KitchenResponse.KitchenModel): KitchenEntity {
        return KitchenEntity(
            model.id,
            model.code,
            model.name,
            model.branchId,
            model.createdBy,
            DateFormatUtils.formatStringToDate(BPMConstants.DATE_FORMAT_RESPONSE, model.createdAt).time,
            model.updatedBy,
            DateFormatUtils.formatStringToDate(BPMConstants.DATE_FORMAT_RESPONSE, model.updatedAt).time,
            false
        )
    }
}