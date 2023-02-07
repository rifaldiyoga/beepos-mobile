package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.SelectionDEntity
import com.bits.bee.bpmc.data.data_source.remote.response.SelectionDResponse
import com.bits.bee.bpmc.domain.model.SelectionD
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.DateFormatUtils

/**
 * Created by aldi on 22/04/22.
 */
object SelectionDDataMapper : BaseMapper<SelectionDEntity, SelectionD, SelectionDResponse.SelectionDModel>(){

    override fun fromDbToDomain(model: SelectionDEntity): SelectionD {
        return SelectionD(
            model.id ,
            model.selectionId,
            model.dno,
            model.itemId,
        )
    }

    override fun fromDomainToDb(model: SelectionD): SelectionDEntity {
        return SelectionDEntity(
            model.id ,
            model.selectionId,
            model.dno,
            model.itemId,
        )
    }

    override fun fromNetworkToDb(model: SelectionDResponse.SelectionDModel): SelectionDEntity {
        return SelectionDEntity(
            null,
            model.selectAddonId,
            model.dno,
            model.itemId,
        )
    }
}