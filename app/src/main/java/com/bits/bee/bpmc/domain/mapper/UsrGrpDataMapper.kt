package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.UsrGrpEntity
import com.bits.bee.bpmc.data.data_source.remote.model.UsrGrpModel
import com.bits.bee.bpmc.domain.model.UsrGrp
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.DateFormatUtils

/**
 * Created by aldi on 22/04/22.
 */
object UsrGrpDataMapper : BaseMapper<UsrGrpEntity, UsrGrp, UsrGrpModel>(){

    override fun fromDbToDomain(model: UsrGrpEntity): UsrGrp {
        return UsrGrp(
            model.id ,
            model.usrCode ,
            model.disabled ,
            model.grpId ,
            model.bpName ,
            model.updatedAt
        )
    }

    override fun fromDomainToDb(model: UsrGrp): UsrGrpEntity {
        return UsrGrpEntity(
            model.id ,
            model.usrCode ,
            model.disabled ,
            model.grpId ,
            model.bpName ,
            model.updatedAt
        )
    }

    override fun fromNetworkToDb(model: UsrGrpModel): UsrGrpEntity {
        return UsrGrpEntity(
            model.id ,
            model.usrCode ,
            model.isDisabled ,
            model.grpId.toInt(),
            "",
            DateFormatUtils.formatStringToDate(BPMConstants.DEFAULT_DATE_FORMAT,model.updatedAt)
        )
    }
}