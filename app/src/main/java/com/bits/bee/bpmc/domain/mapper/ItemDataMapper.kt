package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.ItemEntitiy
import com.bits.bee.bpmc.domain.model.Item

/**
 * Created by aldi on 12/05/22.
 */
class ItemDataMapper : BaseMapper<ItemEntitiy, Item>() {

    override fun fromDataToDomain(model: ItemEntitiy): Item {
        TODO("Not yet implemented")
    }

    override fun fromDomainToData(model: Item): ItemEntitiy {
        TODO("Not yet implemented")
    }
}