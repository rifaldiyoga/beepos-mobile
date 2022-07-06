package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.DistrictEntity
import com.bits.bee.bpmc.data.data_source.remote.response.DistrictResponse
import com.bits.bee.bpmc.domain.model.District

object DistrictDataMapper: BaseMapper<DistrictEntity, District>() {
    override fun fromDataToDomain(model: DistrictEntity): District {
        return District(
            model.code,
            model.name,
            model.regencyCode,
            model.isActive
        )
    }

    override fun fromDomainToData(model: District): DistrictEntity {
        return DistrictEntity(
            model.code,
            model.name,
            model.regencyCode,
            model.isActive
        )
    }

    fun fromResponseToData(model : DistrictResponse.DistrictModel) : DistrictEntity {
        return DistrictEntity(
            model.code,
            model.name,
            model.regency_code,
            model.active
        )
    }
}