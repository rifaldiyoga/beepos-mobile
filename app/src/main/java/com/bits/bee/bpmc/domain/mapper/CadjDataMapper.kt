package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.CadjEntity
import com.bits.bee.bpmc.domain.model.Cadj

object CadjDataMapper: BaseMapper<CadjEntity, Cadj, Any>() {
    override fun fromDbToDomain(model: CadjEntity): Cadj {
        return Cadj(
            model.id,
            model.trxDate,
            model.amount,
            model.note,
            model.status,
            model.refType,
            model.autoGen,
            model.cashAId,
            model.operatorId,
            model.cashierId,
            model.isUploaded,
            model.kodeCadj,
            model.refNo
        )
    }

    override fun fromDomainToDb(model: Cadj): CadjEntity {
        return CadjEntity(
            model.id,
            model.trxDate,
            model.amount,
            model.note,
            model.status,
            model.refType,
            model.autoGen,
            model.cashAId,
            model.operatorId,
            model.cashierId,
            model.isUploaded,
            model.kodeCadj,
            model.refNo
        )
    }

    override fun fromNetworkToDb(model: Any): CadjEntity {
        TODO("Not yet implemented")
    }

}