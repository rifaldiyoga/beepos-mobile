package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.OperatorEntity
import com.bits.bee.bpmc.domain.model.Operator

/**
 * Created by aldi on 22/06/22.
 */
object OperatorDataMapper : BaseMapper<OperatorEntity, Operator>(){

    override fun fromDataToDomain(model: OperatorEntity): Operator {
        return Operator(
            id = model.id,
            branchId = model.branchId,
            cloudLogin = model.cloudLogin,
            operator = model.operator,
            sandi = model.sandi,
            active = model.active
        )
    }

    override fun fromDomainToData(model: Operator): OperatorEntity {
        return OperatorEntity(
            id = model.id,
            branchId = model.branchId,
            cloudLogin = model.cloudLogin,
            operator = model.operator,
            sandi = model.sandi,
            active = model.active
        )
    }

}