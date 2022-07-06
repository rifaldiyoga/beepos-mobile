package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.ProvinceEntity
import com.bits.bee.bpmc.data.data_source.local.model.RegencyEntity
import com.bits.bee.bpmc.data.data_source.remote.response.ProvinceResponse
import com.bits.bee.bpmc.data.data_source.remote.response.RegencyResponse
import com.bits.bee.bpmc.domain.model.Regency

object RegencyDataMapper: BaseMapper<RegencyEntity, Regency>() {
    override fun fromDataToDomain(model: RegencyEntity): Regency {
        return Regency(
            model.code,
            model.name,
            model.provinceCode,
            model.isActive
        )
    }

    override fun fromDomainToData(model: Regency): RegencyEntity {
        return RegencyEntity(
            model.code,
            model.name,
            model.provinceCode,
            model.isActive
        )
    }

    fun fromResponseToData(model : RegencyResponse.RegencyModel) : RegencyEntity {
        return RegencyEntity(
            model.code,
            model.name,
            model.province_code,
            model.active
        )
    }
}