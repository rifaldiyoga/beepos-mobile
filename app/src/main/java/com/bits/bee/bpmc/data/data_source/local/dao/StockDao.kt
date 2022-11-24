package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.StockEntity

/**
 * Created by aldi on 20/05/22.
 */
@Dao
interface StockDao : BaseDao<StockEntity> {

    @Query("SELECT * FROM stock WHERE item_id = :itemId AND wh_id = :whId")
    fun getStockByItemAndWh(itemId : Int, whId : Int) : List<StockEntity>

    @Query("SELECT * FROM stock WHERE item_id = :itemId")
    fun getStockByItem(itemId : Int) : List<StockEntity>

    @Query("DELETE FROM stock WHERE item_id = :itemId AND wh_id = :whId")
    fun deleteStockByItemAndWh(itemId : Int, whId : Int)

}