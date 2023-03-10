package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.ProvinceEntity
import com.bits.bee.bpmc.data.data_source.remote.response.ProvinceResponse
import com.bits.bee.bpmc.domain.model.Province

object ProvinceDataMapper: BaseMapper<ProvinceEntity, Province, ProvinceResponse.ProvinceModel>() {

    override fun fromDbToDomain(model: ProvinceEntity): Province {
        return Province(
            model.code,
            model.name,
            model.isActive
        )
    }


    override fun fromDomainToDb(model: Province): ProvinceEntity {
        return ProvinceEntity(
            model.code,
            model.name,
            model.isActive
        )

    }

    fun fromResponseToData(model : ProvinceResponse.ProvinceModel) : ProvinceEntity {
        return ProvinceEntity(
            model.code,
            model.name,
            model.active
        )
    }

    override fun fromNetworkToDb(model: ProvinceResponse.ProvinceModel): ProvinceEntity {
        return ProvinceEntity(
            model.code,
            model.name,
            model.active
        )
    }
}