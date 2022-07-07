package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.BpEntity
import com.bits.bee.bpmc.domain.model.Bp

/**
 * Created by aldi on 22/04/22.
 */
object BpDataMapper : BaseMapper<BpEntity, Bp>(){

    override fun fromDataToDomain(model: BpEntity): Bp {
        return Bp(
            model.id,
            model.code,
            model.name,
            model.greeting,
            model.anniversary,
            model.isTaxedOnSale,
            model.isTaxIncOnSale,
            model.note,
            model.bpgrpId,
            model.priceLvlId,
            model.isActive,
            "",
            model.createdAt,
            model.createdBy,
            model.updatedAt,
            model.updatedBy,
            model.isFavorit,
        )
    }

    override fun fromDomainToData(model: Bp): BpEntity {
        return BpEntity(
            model.id,
            model.code,
            model.name,
            model.greeting,
            model.anniversary,
            model.isTaxedOnSale,
            model.isTaxIncOnSale,
            model.note,
            model.bpgrpId,
            model.priceLvlId,
            model.isActive,
            model.createdAt,
            model.createdBy,
            model.updatedAt,
            model.updatedBy,
            model.isFavorit,
        )
    }
}