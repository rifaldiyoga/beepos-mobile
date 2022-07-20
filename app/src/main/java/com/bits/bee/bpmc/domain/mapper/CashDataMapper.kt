package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.CashEntity
import com.bits.bee.bpmc.domain.model.Cash
import java.math.BigDecimal

object CashDataMapper: BaseMapper<CashEntity, Cash, Any>() {
    override fun fromDbToDomain(model: CashEntity): Cash {
        return Cash(
            model.id,
            model.code,
            model.name,
            model.balance
        )
    }

    override fun fromDomainToDb(model: Cash): CashEntity {
        return CashEntity(
            model.id,
            model.code,
            model.name,
            model.balance
        )
    }

    override fun fromNetworkToDb(model: Any): CashEntity {
        TODO("Not yet implemented")
    }
}