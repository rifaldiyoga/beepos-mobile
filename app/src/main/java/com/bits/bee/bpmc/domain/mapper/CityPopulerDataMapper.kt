package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.CityPopulerEntity
import com.bits.bee.bpmc.domain.model.CityPopuler

object CityPopulerDataMapper: BaseMapper<CityPopulerEntity, CityPopuler>() {
    override fun fromDataToDomain(model: CityPopulerEntity): CityPopuler {
        return CityPopuler(
            model.id,
            model.name_city
        )
    }

    override fun fromDomainToData(model: CityPopuler): CityPopulerEntity {
        return CityPopulerEntity(
            model.id,
            model.nama_city
        )
    }
}