package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.CityEntity
import com.bits.bee.bpmc.data.data_source.remote.response.CityResponse
import com.bits.bee.bpmc.domain.model.City

/**
 * Created by aldi on 18/05/22.
 */
object CityDataMapper : BaseMapper<CityEntity, City>() {

    override fun fromDataToDomain(model: CityEntity): City {
        return City(
            model.code,
            model.name,
            model.isActive
        )
    }

    override fun fromDomainToData(model: City): CityEntity {
        return CityEntity(
            model.code,
            model.name,
            model.isActive
        )
    }

    fun fromRemoteToData(model : CityResponse.CityModel) : CityEntity {
        return CityEntity(
            model.code,
            model.name,
            model.isActive
        )
    }
}