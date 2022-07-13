package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.ItemVariantEntity
import com.bits.bee.bpmc.data.data_source.remote.response.ItemVariantResponse
import com.bits.bee.bpmc.domain.model.ItemVariant

/**
 * Created by aldi on 22/04/22.
 */
object ItemVariantDataMapper : BaseMapper<ItemVariantEntity, ItemVariant, ItemVariantResponse.ItemVariantModel>(){

    override fun fromDbToDomain(model: ItemVariantEntity): ItemVariant {
        return ItemVariant(
            model.id,
            model.variantId,
            model.itemId,
        )
    }

    override fun fromDomainToDb(model: ItemVariant): ItemVariantEntity {
        return ItemVariantEntity(
            model.id,
            model.variantId,
            model.itemId,
        )
    }

    override fun fromNetworkToDb(model: ItemVariantResponse.ItemVariantModel): ItemVariantEntity {
        return ItemVariantEntity(
            model.id,
            model.variantId,
            model.itemId,
        )
    }
}