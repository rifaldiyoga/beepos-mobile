package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.PriceLvlEntity

/**
 * Created by aldi on 26/04/22.
 */
@Dao
interface PriceLvlDao : BaseDao<PriceLvlEntity>{

    @Query("SELECT * FROM price_lvl")
    fun getActivePriceLvl() : List<PriceLvlEntity>

}