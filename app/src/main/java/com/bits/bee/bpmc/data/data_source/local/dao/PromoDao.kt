package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.PrinterEntity
import com.bits.bee.bpmc.data.data_source.local.model.PromoEntity

/**
 * Created by aldi on 07/06/22.
 */
@Dao
interface PromoDao : BaseDao<PromoEntity>{

    @Query("SELECT * FROM promo WH")
    fun getPromoList() : List<PromoEntity>

}