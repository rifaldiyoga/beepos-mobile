package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.CrcEntity

@Dao
interface CrcDao : BaseDao<CrcEntity> {

    @Query("SELECT * FROM crc")
    fun getCrcList() : List<CrcEntity>

    @Query("DELETE FROM crc")
    fun deleteAll()

    @Query("SELECT * FROM crc WHERE isdefault = 1")
    fun getDefaultCrc() : CrcEntity?


    @Query("SELECT * FROM crc WHERE id = :id")
    fun getCrcById(id : Int) : CrcEntity?

}