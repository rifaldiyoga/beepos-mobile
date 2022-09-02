package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.PossesEntity
import com.bits.bee.bpmc.domain.model.Posses

/**
 * Created by aldi on 07/06/22.
 */
object PossesDataMapper : BaseMapper<PossesEntity, Posses, Any>() {

    override fun fromDbToDomain(model: PossesEntity): Posses {
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
            model.userId,
            model.cashierId,
            model.trxNo,
            model.totIn,
            model.totOut,
            model.endCash,
            model.totalActualCash,
            model.totalDiffCash,
            model.isUploaded,
        )
    }

    override fun fromDomainToDb(model: Posses): PossesEntity {
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
            model.userId,
            model.cashierId,
            model.trxNo,
            model.totIn,
            model.totOut,
            model.endCash,
            model.totalActualCash,
            model.totalDiffCash,
            model.isUploaded,
        )
    }

    override fun fromNetworkToDb(model: Any): PossesEntity {
        TODO("Not yet implemented")
    }
}