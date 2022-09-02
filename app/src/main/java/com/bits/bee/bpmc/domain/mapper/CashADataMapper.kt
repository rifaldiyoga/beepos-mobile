package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.CashAEntity
import com.bits.bee.bpmc.data.data_source.local.model.CashEntity
import com.bits.bee.bpmc.domain.model.CashA
import java.math.BigDecimal

object CashADataMapper: BaseMapper<CashAEntity, CashA, Any>() {
    override fun fromDbToDomain(model: CashAEntity): CashA {
        return CashA(
            model.id,
            model.trxDate,
            model.amount,
            model.note,
            model.inOut,
            model.refType,
            model.refId,
            model.autoGen,
            model.cashId,
            model.userId,
            model.cashierId
        )
    }

    override fun fromDomainToDb(model: CashA): CashAEntity {
        return CashAEntity(
            model.id,
            model.trxDate,
            model.amount,
            model.note,
            model.inOut,
            model.refType,
            model.refId,
            model.autoGen,
            model.cashId,
            model.userId,
            model.cashierId
        )
    }

    override fun fromNetworkToDb(model: Any): CashAEntity {
        TODO("Not yet implemented")
    }
}