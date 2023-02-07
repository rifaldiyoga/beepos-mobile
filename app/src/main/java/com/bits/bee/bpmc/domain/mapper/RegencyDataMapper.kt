package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.RegencyEntity
import com.bits.bee.bpmc.data.data_source.remote.response.RegencyResponse
import com.bits.bee.bpmc.domain.model.Regency

object RegencyDataMapper: BaseMapper<RegencyEntity, Regency, RegencyResponse.RegencyModel>() {
    override fun fromDbToDomain(model: RegencyEntity): Regency {
        return Regency(
            model.code,
            model.name,
            model.provinceCode,
            model.isActive
        )
    }

    override fun fromDomainToDb(model: Regency): RegencyEntity {
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

    override fun fromNetworkToDb(model: RegencyResponse.RegencyModel): RegencyEntity {
        return RegencyEntity(
            model.code,
            model.name,
            model.province_code,
            model.active
        )
    }
}