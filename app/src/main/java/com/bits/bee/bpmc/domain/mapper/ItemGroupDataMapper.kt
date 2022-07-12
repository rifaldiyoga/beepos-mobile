package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.ItemGroupEntity
import com.bits.bee.bpmc.data.data_source.remote.response.ItemGroupResponse
import com.bits.bee.bpmc.domain.model.ItemGroup

/**
 * Created by aldi on 20/04/22.
 */

object ItemGroupDataMapper : BaseMapper<ItemGroupEntity, ItemGroup, ItemGroupResponse.ItemGroupModel>(){

    override fun fromDbToDomain(model: ItemGroupEntity): ItemGroup {
        return ItemGroup(
            model.id,
            model.code,
            model.name,
            model.level,
            model.upId,
            model.isPos
        )
    }

    override fun fromDomainToDb(model: ItemGroup): ItemGroupEntity {
        return ItemGroupEntity(
            model.id,
            model.code,
            model.name,
            model.level,
            model.upId,
            model.isPos
        )
    }

    override fun fromNetworkToData(model: ItemGroupResponse.ItemGroupModel): ItemGroupEntity {
        return ItemGroupEntity(
            model.id,
            model.code,
            model.name,
            model.level,
            model.upId,
            model.isPos
        )
    }

}