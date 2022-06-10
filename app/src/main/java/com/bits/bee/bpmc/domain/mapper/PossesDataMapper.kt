package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.PossesEntity
import com.bits.bee.bpmc.domain.model.Posses

/**
 * Created by aldi on 07/06/22.
 */
object PossesDataMapper : BaseMapper<PossesEntity, Posses>() {

    override fun fromDataToDomain(model: PossesEntity): Posses {
        return Posses(
            model.possesId,
            model.trxDate,
            model.startTime,
            model.endTime,
            model.startBal,
            model.endBal,
            model.total,
            model.credit,
            model.shift,
            model.operatorId,
            model.cashierId,
            model.trxNo,
            model.totIn,
            model.totOut,
            model.endCash,
            model.totalActualCash,
            model.totalDiffCash
        )
    }

    override fun fromDomainToData(model: Posses): PossesEntity {
        return PossesEntity(
            model.possesId,
            model.trxDate,
            model.startTime,
            model.endTime,
            model.startBal,
            model.endBal,
            model.total,
            model.credit,
            model.shift,
            model.operatorId,
            model.cashierId,
            model.trxNo,
            model.totIn,
            model.totOut,
            model.endCash,
            model.totalActualCash,
            model.totalDiffCash
        )
    }
}