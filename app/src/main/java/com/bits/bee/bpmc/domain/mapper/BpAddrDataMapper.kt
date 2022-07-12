package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.BpAddrEntity
import com.bits.bee.bpmc.domain.model.BpAddr
import java.util.*

object BpAddrDataMapper: BaseMapper<BpAddrEntity, BpAddr, Any>() {

    override fun fromDbToDomain(model: BpAddrEntity): BpAddr {
        return BpAddr(
            model.id,
            model.bpId,
            model.name,
            model.greeting,
            model.address,
            model.phone,
            model.zipCode,
            model.email,
            model.note,
            model.isBillAddr,
            model.isShipAddr,
            model.isMainAddr,
            model.provinceCode,
            model.regencyCode,
            model.cityId,
            model.districtCode
        )
    }

    override fun fromDomainToDb(model: BpAddr): BpAddrEntity {
        return BpAddrEntity(
            model.id,
            model.bpId,
            model.name,
            model.greeting.toString(),
            model.address,
            model.phone,
            model.zipCode.toString(),
            model.email.toString(),
            model.note.toString(),
            model.isBillAddr,
            model.isShipAddr,
            model.isMainAddr,
            model.provinceCode,
            model.regencyCode,
            model.cityId,
            model.districtCode
        )
    }

    override fun fromNetworkToData(model: Any): BpAddrEntity {
        TODO("Not yet implemented")
    }
}