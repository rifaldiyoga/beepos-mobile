package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.EdcEntity
import com.bits.bee.bpmc.data.data_source.remote.response.EdcResponse
import com.bits.bee.bpmc.domain.model.Edc

/**
 * Created by aldi on 18/07/22.
 */
object EdcDataMapper : BaseMapper<EdcEntity, Edc, EdcResponse.EdcModel>() {

    override fun fromDbToDomain(model: EdcEntity): Edc {
        return Edc(
            model.id ,
            model.code ,
            model.name,
            model.cash,
            model.note ,
            model.surcPayTo ,
            model.branchId,
            model.active,
        )
    }

    override fun fromDomainToDb(model: Edc): EdcEntity {
        return EdcEntity(
            model.id ,
            model.code ,
            model.name,
            model.cash,
            model.note ,
            model.surcPayTo ,
            model.branchId,
            model.active,
        )
    }

    override fun fromNetworkToDb(model: EdcResponse.EdcModel): EdcEntity {
        return return EdcEntity(
            model.id ,
            model.code ,
            model.name,
            model.cashId.toInt(),
            model.note ,
            model.surcpayto ,
            model.branchId,
            model.active,
        )
    }
}