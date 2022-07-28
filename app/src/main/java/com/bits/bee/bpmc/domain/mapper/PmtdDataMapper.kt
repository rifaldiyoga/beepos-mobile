package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.PmtdEntity
import com.bits.bee.bpmc.data.data_source.remote.response.PmtdResponse
import com.bits.bee.bpmc.domain.model.Pmtd

/**
 * Created by aldi on 22/04/22.
 */
object PmtdDataMapper : BaseMapper<PmtdEntity, Pmtd, PmtdResponse.PmtdModel>(){

    override fun fromDbToDomain(model: PmtdEntity): Pmtd {
        return Pmtd(
            model.id ,
            model.idx ,
            model.code ,
            model.name,
            model.cashId ,
            model.mdrExp ,
            model.mdrAcc ,
            model.surExp ,
            model.surAcc ,
            model.branchId ,
            model.settleDays ,
            model.cashName ,
            model.branchName ,
            model.ccType,
            model.edcSurcType
        )
    }

    override fun fromDomainToDb(model: Pmtd): PmtdEntity {
        return PmtdEntity(
            model.id ,
            model.idx ,
            model.code ,
            model.name,
            model.cashId ,
            model.mdrExp ,
            model.mdrAcc ,
            model.surExp ,
            model.surAcc ,
            model.branchId ,
            model.settleDays ,
            model.cashName ,
            model.branchName ,
            model.ccType,
            model.edcSurcType
        )
    }

    override fun fromNetworkToDb(model: PmtdResponse.PmtdModel): PmtdEntity {
        TODO("Not yet implemented")
    }
}