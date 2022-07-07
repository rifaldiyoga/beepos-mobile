package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.CrcEntity
import com.bits.bee.bpmc.data.data_source.remote.response.CrcResponse
import com.bits.bee.bpmc.domain.model.Crc

/**
 * Created by aldi on 30/06/22.
 */
object CrcDataMapper : BaseMapper<CrcEntity, Crc>() {

    override fun fromDataToDomain(model: CrcEntity): Crc {
        return Crc(
            id = model.id,
            code = model.code,
            name = model.name,
            symbol = model.symbol,
            isDefault = model.isDefault,
            excRate = model.excRate,
            fisRate = model.fisRate,
            rateType = model.rateType,
            active = model.active,
        )
    }

    override fun fromDomainToData(model: Crc): CrcEntity {
        return CrcEntity(
            id = model.id,
            code = model.code,
            name = model.name,
            symbol = model.symbol,
            isDefault = model.isDefault,
            excRate = model.excRate,
            fisRate = model.fisRate,
            rateType = model.rateType,
            active = model.active,
        )
    }

    fun fromResponseToData(model: CrcResponse.CrcModel): CrcEntity {
        return CrcEntity(
            id = model.id,
            code = model.code,
            name = model.name,
            symbol = model.symbol,
            isDefault = model.isDefault,
            excRate = model.excRate,
            fisRate = model.fisRate,
            rateType = model.rateType,
            active = model.active,
        )
    }


}