package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.CityPopulerEntity
import com.bits.bee.bpmc.domain.model.CityPopuler

object CityPopulerDataMapper: BaseMapper<CityPopulerEntity, CityPopuler, Any>() {

    override fun fromDbToDomain(model: CityPopulerEntity): CityPopuler {
        return CityPopuler(
            model.id,
            model.name_city
        )
    }

    override fun fromDomainToDb(model: CityPopuler): CityPopulerEntity {
        return CityPopulerEntity(
            model.id,
            model.nama_city
        )
    }

    override fun fromNetworkToDb(model: Any): CityPopulerEntity {
        TODO("Not yet implemented")
    }
}