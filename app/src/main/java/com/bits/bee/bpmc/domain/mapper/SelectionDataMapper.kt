package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.SelectionEntity
import com.bits.bee.bpmc.data.data_source.remote.response.SelectionResponse
import com.bits.bee.bpmc.domain.model.Selection

/**
 * Created by aldi on 22/04/22.
 */
object SelectionDataMapper : BaseMapper<SelectionEntity, Selection, SelectionResponse.SelectionModel>(){

    override fun fromDbToDomain(model: SelectionEntity): Selection {
        return Selection(
            model.id,
            model.code,
            model.name,
            model.note,
            model.isActive,
            model.isMultiSelect,
            model.isMultiQty,
        )
    }

    override fun fromDomainToDb(model: Selection): SelectionEntity {
        return SelectionEntity(
            model.id,
            model.code,
            model.name,
            model.note,
            model.isActive,
            model.isMultiSelect,
            model.isMultiQty,
        )
    }

    override fun fromNetworkToData(model: SelectionResponse.SelectionModel): SelectionEntity {
        return SelectionEntity(
            model.id,
            model.code,
            model.name,
            model.note,
            model.isActive,
            model.isMultiSelect,
            model.isMultiQty,
        )
    }
}