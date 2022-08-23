package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.RankItemEntity
import com.bits.bee.bpmc.data.data_source.local.model.SaledEntity

/**
 * Created by aldi on 20/05/22.
 */
@Dao
interface SaledDao : BaseDao<SaledEntity>{

    @Query("SELECT * FROM saled WHERE sale_id = :id")
    fun getSaledList(id : Int) : List<SaledEntity>

    @Query("select a.name, sum(qty) qty, sum(a.subtotal) total from saled a " +
            "JOIN sale d ON d.id = a.sale_id WHERE d.posses_id = :possesId AND d.isvoid = 0 " +
            "group by item_id order by qty DESC LIMIT 10")
    fun getRankItem(possesId: Int): List<RankItemEntity>

}