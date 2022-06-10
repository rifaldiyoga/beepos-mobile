package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.BranchEntity
import com.bits.bee.bpmc.data.data_source.remote.response.BranchResponse
import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.DateFormatUtils

/**
 * Created by aldi on 07/06/22.
 */
object BranchDataMapper : BaseMapper<BranchEntity, Branch>(){

    override fun fromDataToDomain(model: BranchEntity): Branch {
        return Branch(
            model.id,
            model.code,
            model.name,
            model.version,
            model.cmpName,
            model.cmpPhone,
            model.active,
            model.cmpAddress,
            model.cmpFax,
            model.custDeftId,
            model.createdAt,
            model.createdBy,
            model.updatedAt,
            model.updatedBy
        )
    }

    override fun fromDomainToData(model: Branch): BranchEntity {
        return BranchEntity(
            model.id,
            model.code,
            model.name,
            model.version,
            model.cmpName,
            model.cmpPhone,
            model.active,
            model.cmpAddress,
            model.cmpFax,
            model.custDeftId,
            model.createdAt,
            model.createdBy,
            model.updatedAt,
            model.updatedBy
        )
    }

    fun fromResponseToData(model : BranchResponse.BranchModel) : BranchEntity {
        return BranchEntity(
            model.id,
            model.code,
            model.name,
            model.version,
            model.cmpName,
            model.phone,
            model.active,
            model.cmpAddress,
            model.cmpFax,
            model.custDeftId?.value,
            DateFormatUtils.formatStringToDate(BPMConstants.DEFAULT_DATE_FORMAT, model.createdAt).time,
            model.createdBy,
            DateFormatUtils.formatStringToDate(BPMConstants.DEFAULT_DATE_FORMAT, model.updatedAt).time,
            model.updatedBy
        )
    }
}