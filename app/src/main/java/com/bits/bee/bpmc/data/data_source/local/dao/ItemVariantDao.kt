package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.ItemVariantEntity

/**
 * Created by aldi on 07/06/22.
 */
@Dao
interface ItemVariantDao : BaseDao<ItemVariantEntity>{

    @Query("SELECT * FROM item_variant")
    fun getItemVariantList() : List<ItemVariantEntity>

    @Query("SELECT * FROM item_variant WHERE variant_id = :variantId")
    fun getItemVariantByVariant(variantId : Int) : List<ItemVariantEntity>

}