package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.CmpEntity

@Dao
interface CmpDao : BaseDao<CmpEntity> {

    @Query("SELECT * FROM cmp")
    fun getCmp() : CmpEntity

    @Query("DELETE FROM cmp")
    fun deleteAll()

}