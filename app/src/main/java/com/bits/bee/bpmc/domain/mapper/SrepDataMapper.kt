package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.SrepEntity
import com.bits.bee.bpmc.data.data_source.remote.model.SrepModel
import com.bits.bee.bpmc.domain.model.Srep

/**
 * Created by aldi on 22/06/22.
 */
object SrepDataMapper : BaseMapper<SrepEntity, Srep, SrepModel>() {

    override fun fromDbToDomain(model: SrepEntity): Srep {
        return Srep(
            model.id,
            model.code,
            model.name,
            model.cityCode,
            model.address,
            model.zipCode,
            model.phone,
            model.mobile ,
            model.email ,
            model.isselected
        )
    }

    override fun fromDomainToDb(model: Srep): SrepEntity {
        return SrepEntity(
            model.id,
            model.code,
            model.name,
            model.cityCode,
            model.address,
            model.zipCode,
            model.phone,
            model.mobile ,
            model.email ,
            model.isSelected
        )
    }

    override fun fromNetworkToDb(model: SrepModel): SrepEntity {
        return SrepEntity(
            model.id,
            model.code,
            model.name,
            model.cityCode,
            model.address,
            model.zipCode,
            model.phone,
            model.mobile ,
            model.email ,
        )
    }

}