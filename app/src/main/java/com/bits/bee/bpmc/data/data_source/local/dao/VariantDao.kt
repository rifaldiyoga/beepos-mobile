package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.RegEntity
import com.bits.bee.bpmc.data.data_source.local.model.VariantEntity

/**
 * Created by aldi on 07/06/22.
 */
@Dao
interface VariantDao : BaseDao<VariantEntity>{

    @Query("SELECT * FROM variant")
    fun getVariantList() : List<VariantEntity>

    @Query("SELECT * FROM variant WHERE id = :id")
    fun getVariantById(id : Int) : VariantEntity

    @Query("UPDATE variant SET isfavorit = :fav WHERE id = :id")
    fun updateFavoritVariant(id : Int, fav : Boolean)
}