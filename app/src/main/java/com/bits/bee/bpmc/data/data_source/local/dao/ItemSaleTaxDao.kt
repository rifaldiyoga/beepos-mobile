package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.ItemKitchenEntity
import com.bits.bee.bpmc.data.data_source.local.model.ItemSaleTaxEntity

@Dao
interface ItemSaleTaxDao : BaseDao<ItemSaleTaxEntity> {

    @Query("SELECT * FROM item_tax")
    fun getItemSaleTax() : List<ItemSaleTaxEntity>

    @Query("SELECT a.*, b.expr FROM item_tax a JOIN tax b ON a.tax_code = b.code WHERE item_code = :itemCode ")
    fun getItemTaxByCodeItem(itemCode : String) : ItemSaleTaxEntity?

}