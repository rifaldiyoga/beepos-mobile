package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.CashEntity
import com.bits.bee.bpmc.data.data_source.local.model.CstrEntity
import com.bits.bee.bpmc.data.data_source.local.model.PossesEntity

/**
 * Created by aldi on 07/06/22.
 */
@Dao
interface CstrDao : BaseDao<CstrEntity>{
    @Query("UPDATE cstr\n" +
            "SET kode_cstr = :code\n" +
            "WHERE id = :id")
    fun updateCode(code: String, id: Int)

    @Query("SELECT * FROM cstr ORDER BY id DESC LIMIT 1")
    fun getLastId(): CstrEntity?
}