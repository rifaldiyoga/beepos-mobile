package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.ItemDummyEntity
import com.bits.bee.bpmc.domain.model.ItemDummy

/**
 * Created by aldi on 20/04/22.
 */

object ItemDummyDummyDataMapper : BaseMapper<ItemDummyEntity, ItemDummy, Any>(){

    override fun fromDbToDomain(model: ItemDummyEntity): ItemDummy {
        return ItemDummy(
            model.id,
            model.name,
            model.itemTypeCode,
            model.itemGroup,
            model.price,
            model.picPath,
            model.pid
        )
    }

    override fun fromDomainToDb(model: ItemDummy): ItemDummyEntity {
        return ItemDummyEntity(
            model.id,
            model.name,
            model.itemTypeCode,
            model.itemGroup ,
            model.price ,
            model.pid,
            model.picPath ,
        )
    }

    override fun fromNetworkToDb(model: Any): ItemDummyEntity {
        TODO("Not yet implemented")
    }

}