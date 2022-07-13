package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.CityEntity
import com.bits.bee.bpmc.data.data_source.remote.model.CityModel
import com.bits.bee.bpmc.data.data_source.remote.response.CityResponse
import com.bits.bee.bpmc.domain.model.City

/**
 * Created by aldi on 18/05/22.
 */
object CityDataMapper : BaseMapper<CityEntity, City, CityModel>() {

    override fun fromDbToDomain(model: CityEntity): City {
        return City(
            model.code,
            model.name,
            model.isActive
        )
    }

    override fun fromDomainToDb(model: City): CityEntity {
        return CityEntity(
            model.code,
            model.name,
            model.isActive
        )
    }

    override fun fromNetworkToDb(model: CityModel): CityEntity {
        return CityEntity(
            model.code,
            model.name,
            true
        )
    }
}