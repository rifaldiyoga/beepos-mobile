package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.ItemKitchenEntity
import com.bits.bee.bpmc.data.data_source.remote.response.ItemKitchenResponse
import com.bits.bee.bpmc.data.data_source.remote.response.ItemTaxResponse
import com.bits.bee.bpmc.domain.model.ItemKitchen
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.DateFormatUtils

/**
 * Created by aldi on 22/04/22.
 */
object ItemKitchenDataMapper : BaseMapper<ItemKitchenEntity, ItemKitchen, ItemKitchenResponse.ItemKitchenData>(){

    override fun fromDbToDomain(model: ItemKitchenEntity ): ItemKitchen {
        return ItemKitchen(
            model.id ,
            model.itemId,
            model.kitchenId,
            model.createdBy ,
            model.createdAt ,
            model.updatedBy ,
            model.updatedAt ,
        )
    }

    override fun fromDomainToDb(model: ItemKitchen): ItemKitchenEntity {
        return ItemKitchenEntity(
            model.id ,
            model.itemId,
            model.kitchenId,
            model.createdBy ,
            model.createdAt ,
            model.updatedBy ,
            model.updatedAt ,
        )
    }

    override fun fromNetworkToDb(model: ItemKitchenResponse.ItemKitchenData): ItemKitchenEntity {
        return ItemKitchenEntity(
            model.id ,
            model.item_id,
            model.kitchen_id,
            model.created_by ,
            DateFormatUtils.formatStringToDate(BPMConstants.DEFAULT_DATE_FORMAT,model.created_at ),
            model.updated_by ,
            DateFormatUtils.formatStringToDate(BPMConstants.DEFAULT_DATE_FORMAT,model.updated_at ),
        )
    }
}