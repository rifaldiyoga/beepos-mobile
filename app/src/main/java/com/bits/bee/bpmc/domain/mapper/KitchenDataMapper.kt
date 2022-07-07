package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.KitchenEntity
import com.bits.bee.bpmc.domain.model.Kitchen

object KitchenDataMapper: BaseMapper<KitchenEntity, Kitchen>() {
    override fun fromDataToDomain(model: KitchenEntity): Kitchen {
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

    override fun fromDomainToData(model: Kitchen): KitchenEntity {
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
}