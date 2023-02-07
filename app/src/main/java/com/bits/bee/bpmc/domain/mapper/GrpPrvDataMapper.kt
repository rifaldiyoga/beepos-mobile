package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.GrpPrvEntity
import com.bits.bee.bpmc.data.data_source.remote.model.GrpPrvModel
import com.bits.bee.bpmc.domain.model.GrpPrv
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.DateFormatUtils

/**
 * Created by aldi on 22/04/22.
 */
object GrpPrvDataMapper : BaseMapper<GrpPrvEntity, GrpPrv, GrpPrvModel>(){

    override fun fromDbToDomain(model: GrpPrvEntity): GrpPrv {
        return GrpPrv(
            null ,
            model.updatedAt ,
            model.objCode ,
            model.acsType ,
            model.isEnable ,
            model.acsVal ,
            model.grpId ,
            model.codeObj ,
            model.upCode ,
            model.moduleCode ,
            model.nameObj ,
            model.mnemonic ,
            model.level ,
        )
    }

    override fun fromDomainToDb(model: GrpPrv): GrpPrvEntity {
        return GrpPrvEntity(
            model.id ,
            model.updatedAt ,
            model.objCode ,
            model.acsType ,
            model.isEnable ,
            model.acsVal ,
            model.grpId ,
            model.codeObj ,
            model.upCode ,
            model.moduleCode ,
            model.nameObj ,
            model.mnemonic ,
            model.level ,
        )
    }

    override fun fromNetworkToDb(model: GrpPrvModel): GrpPrvEntity {
        return GrpPrvEntity(
            null ,
            DateFormatUtils.formatStringToDate(BPMConstants.DATE_FORMAT_RESPONSE, model.updatedAt),
            model.objCode ,
            model.acsType ,
            model.enabled ,
            model.acsVal ,
            model.grpId.toInt() ,
            model.objCode ,
           "" ,
            "" ,
            "" ,
            "" ,
            -1,
        )
    }
}