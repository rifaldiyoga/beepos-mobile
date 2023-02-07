package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.CrcEntity
import com.bits.bee.bpmc.data.data_source.remote.model.CrcModel
import com.bits.bee.bpmc.domain.model.Crc

/**
 * Created by aldi on 30/06/22.
 */
object CrcDataMapper : BaseMapper<CrcEntity, Crc, CrcModel>() {

    override fun fromDbToDomain(model: CrcEntity): Crc {
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

    override fun fromDomainToDb(model: Crc): CrcEntity {
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

    override fun fromNetworkToDb(model: CrcModel): CrcEntity {
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