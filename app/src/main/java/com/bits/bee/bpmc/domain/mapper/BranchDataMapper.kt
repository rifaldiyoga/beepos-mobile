package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.BranchEntity
import com.bits.bee.bpmc.data.data_source.remote.response.BranchResponse
import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.DateFormatUtils

/**
 * Created by aldi on 07/06/22.
 */
object BranchDataMapper : BaseMapper<BranchEntity, Branch, BranchResponse.BranchModel>(){

    override fun fromDbToDomain(model: BranchEntity): Branch {
        return Branch(
            model.id,
            model.code,
            model.name,
            model.version,
            model.cmpName,
            model.cmpPhone,
            model.active,
            model.status,
            model.cmpAddress,
            model.cmpFax,
            model.custDeftId,
            model.createdAt,
            model.createdBy,
            model.updatedAt,
            model.updatedBy
        )
    }

    override fun fromDomainToDb(model: Branch): BranchEntity {
        return BranchEntity(
            model.id,
            model.code,
            model.name,
            model.version,
            model.cmpName,
            model.cmpPhone,
            model.active,
            model.status,
            model.cmpAddress,
            model.cmpFax,
            model.custDeftId,
            model.createdAt,
            model.createdBy,
            model.updatedAt,
            model.updatedBy
        )
    }

    override fun fromNetworkToDb(model: BranchResponse.BranchModel): BranchEntity {
        return BranchEntity(
            model.id,
            model.code,
            model.name,
            model.version,
            model.cmpName,
            model.cmpPhone,
            model.active,
            model.active,
            model.cmpAddress,
            model.noFax,
            model.branchDefaultCust,
            DateFormatUtils.formatStringToDate(BPMConstants.DATE_FORMAT_RESPONSE, model.createdAt).time,
            model.createdBy,
            DateFormatUtils.formatStringToDate(BPMConstants.DATE_FORMAT_RESPONSE, model.updatedAt).time,
            model.updatedBy
        )
    }
}