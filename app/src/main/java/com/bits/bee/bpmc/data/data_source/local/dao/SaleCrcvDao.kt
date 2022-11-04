package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.SaleCrcvEntity

/**
 * Created by aldi on 07/06/22.
 */
@Dao
interface SaleCrcvDao : BaseDao<SaleCrcvEntity>{

    @Query("SELECT * FROM salecrcvs")
    fun getSaleCrcvList() : List<SaleCrcvEntity>

    @Query("SELECT * FROM salecrcvs where sale = :id")
    fun getSalecrcvBySale(id: Int): List<SaleCrcvEntity>

    @Query("SELECT a.* FROM salecrcvs a JOIN sale b ON b.id = a.sale where b.posses_id = :id AND a.rcvtype_code = :type AND b.isvoid = 0")
    fun getSalecrcvBySale(id: Int, type : String): List<SaleCrcvEntity>

}