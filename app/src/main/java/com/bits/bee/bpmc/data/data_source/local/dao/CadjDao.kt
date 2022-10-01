package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.CadjEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CadjDao: BaseDao<CadjEntity> {

    @Query("SELECT * from cadj where isuploaded = 0")
    fun getCadjByReftypeInOutHaventUpload(): List<CadjEntity>

    @Query("SELECT * FROM cadj order by id desc LIMIT 1")
    fun getCadjLastRow(): CadjEntity

    @Query("UPDATE cadj set kode_cadj = :code where id = :id")
    fun updateCode(code: String, id: Int)

    @Query("SELECT * from cadj wHERE cash_id = :cashid order by id desc limit 1")
    fun getLastInOutStatus(cashid: Long): CadjEntity

    @Query("SELECT * from cadj where inout = 'i' and autogen = 0")
    fun getKasMasuk(): List<CadjEntity>

    @Query("SELECT * from cadj where inout = 'o'")
    fun getKasKeluar(): List<CadjEntity>
}