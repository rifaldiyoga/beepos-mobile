package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.BrandEntity
import com.bits.bee.bpmc.domain.model.Brand

object BrandDataMapper: BaseMapper<BrandEntity, Brand, Any>() {
    override fun fromDbToDomain(model: BrandEntity): Brand {
        return Brand(
            model.id,
            model.code,
            model.brandName,
            model.active
        )
    }

    override fun fromDomainToDb(model: Brand): BrandEntity {
        return BrandEntity(
            model.id,
            model.code,
            model.brandName,
            model.active
        )
    }

    override fun fromNetworkToDb(model: Any): BrandEntity {
        TODO("Not yet implemented")
    }
}