package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.CashierEntity
import com.bits.bee.bpmc.data.data_source.remote.response.CashierResponse
import com.bits.bee.bpmc.domain.model.Cashier

/**
 * Created by aldi on 07/06/22.
 */
object CashierDataMapper : BaseMapper<CashierEntity, Cashier, CashierResponse.CashierModel>() {

    override fun fromDbToDomain(model: CashierEntity): Cashier {
        return Cashier(
            model.id,
            model.code,
            model.cashierName,
            model.branchId,
            model.cashBranchId,
            model.whId,
            model.cashId,
            model.isActive,
            model.status
        )
    }

    override fun fromDomainToDb(model: Cashier): CashierEntity {
        return CashierEntity(
            model.id,
            model.code,
            model.cashierName,
            model.branchId,
            model.cashBranchId,
            model.whId,
            model.cashId,
            model.isActive,
            model.status
        )
    }

    override fun fromNetworkToDb(model: CashierResponse.CashierModel): CashierEntity {
        return CashierEntity(
            model.id,
            model.code,
            model.cashierName,
            model.branchId,
            model.cashBranchId,
            model.whId,
            model.cashId,
            model.isActive,
            model.isActive
        )
    }

}