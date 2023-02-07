package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.CstrEntity
import com.bits.bee.bpmc.data.data_source.remote.post.PostAll
import com.bits.bee.bpmc.domain.model.Cstr

object CstrDataMapper: BaseMapper<CstrEntity, Cstr, PostAll.CstrPost>() {
    override fun fromDbToDomain(model: CstrEntity): Cstr {
        return Cstr(
            model.id,
            model.trxDate,
            model.amount1,
            model.amount2,
            model.excrate1,
            model.excrate2,
            model.note,
            model.refType,
            model.refNo,
            model.autoGen,
            model.cashId1,
            model.cashId2,
            model.isUploaded,
            model.kodeCstr,
            model.createdAt,
            model.createdBy,
            model.updatedAt,
            model.updatedBy
        )
    }

    override fun fromDomainToDb(model: Cstr): CstrEntity {
        return CstrEntity(
            model.id,
            model.trxDate,
            model.amount1,
            model.amount2,
            model.excrate1,
            model.excrate2,
            model.note,
            model.refType,
            model.refNo,
            model.autoGen,
            model.cashId1,
            model.cashId2,
            model.isUploaded,
            model.kodeCstr,
            model.createdAt,
            model.createdBy,
            model.updatedAt,
            model.updatedBy
        )
    }

    override fun fromNetworkToDb(model: PostAll.CstrPost): CstrEntity {
        TODO("Not yet implemented")
    }
}