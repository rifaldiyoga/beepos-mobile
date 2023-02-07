package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.ItemAddOnEntity
import com.bits.bee.bpmc.data.data_source.remote.response.ItemAddOnResponse
import com.bits.bee.bpmc.domain.model.ItemAddOn

/**
 * Created by aldi on 22/04/22.
 */
object ItemAddOnDataMapper : BaseMapper<ItemAddOnEntity, ItemAddOn, ItemAddOnResponse.ItemAddOnModel>(){

    override fun fromDbToDomain(model: ItemAddOnEntity): ItemAddOn {
        return ItemAddOn(
            model.id ,
            model.addOnId,
            model.code,
            model.itemId ,
        )
    }

    override fun fromDomainToDb(model: ItemAddOn): ItemAddOnEntity {
        return ItemAddOnEntity(
            model.id ,
            model.addOnId,
            model.code,
            model.itemId ,
        )
    }

    override fun fromNetworkToDb(model: ItemAddOnResponse.ItemAddOnModel): ItemAddOnEntity {
        return ItemAddOnEntity(
            model.id ,
            model.addon_id,
            "",
            model.item_id,
        )
    }
}