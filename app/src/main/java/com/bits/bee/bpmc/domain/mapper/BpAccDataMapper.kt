package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.BpAccEntity
import com.bits.bee.bpmc.data.data_source.remote.model.BpAccModel
import com.bits.bee.bpmc.domain.model.BpAcc

/**
 * Created by aldi on 22/04/22.
 */
object BpAccDataMapper : BaseMapper<BpAccEntity, BpAcc, BpAccModel>(){

    override fun fromDbToDomain(model: BpAccEntity): BpAcc {
        return BpAcc(
            model.id ,
            model.bpId ,
            model.crcId,
            model.purcTermType,
            model.saleTermType,
            model.isDefault,
        )
    }

    override fun fromDomainToDb(model: BpAcc): BpAccEntity {
        return BpAccEntity(
            model.id,
            model.bpId,
            model.crcId,
            model.purcTermType,
            model.saleTermType,
            model.isDefault,
        )
    }

    override fun fromNetworkToDb(model: BpAccModel): BpAccEntity {
        return BpAccEntity(
            null,
            model.bp_id ,
            model.crc_id,
            model.purcTermType,
            model.saleTermType,
            model.isdefault,
        )
    }
}