package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.CcTypeEntity
import com.bits.bee.bpmc.data.data_source.remote.response.CcTypeResponse
import com.bits.bee.bpmc.domain.model.CcType
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.DateFormatUtils

/**
 * Created by aldi on 22/04/22.
 */
object CcTypeDataMapper : BaseMapper<CcTypeEntity, CcType, CcTypeResponse.CcTypeModel>(){

    override fun fromDbToDomain(model: CcTypeEntity): CcType {
        return CcType(
            model.id,
            model.cctype,
            model.cctypeDesc,
        )
    }

    override fun fromDomainToDb(model: CcType): CcTypeEntity {
        return CcTypeEntity(
            model.id,
            model.cctype,
            model.cctypeDesc,
        )
    }

    override fun fromNetworkToDb(model: CcTypeResponse.CcTypeModel): CcTypeEntity {
        return CcTypeEntity(
            null,
            model.ccType,
            model.ccTypeDesc,
        )
    }
}