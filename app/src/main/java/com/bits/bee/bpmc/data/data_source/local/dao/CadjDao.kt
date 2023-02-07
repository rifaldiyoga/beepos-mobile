package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.CadjEntity
import com.bits.bee.bpmc.data.data_source.local.model.PossesEntity
import kotlinx.coroutines.flow.Flow
import java.math.BigDecimal

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

    @Query("SELECT * from cadj where inout = 'i' and autogen = 0 and note LIKE '%'|| :query || '%' order by id desc")
    fun getKasMasukDesc(query: String): List<CadjEntity>

    @Query("SELECT * from cadj where inout = 'i' and autogen = 0 and note LIKE '%'|| :query || '%' order by id asc")
    fun getKasMasukAsc(query: String): List<CadjEntity>

    @Query("SELECT * from cadj where inout = 'o' and note LIKE '%'|| :query || '%' order by id desc")
    fun getKasKeluarDesc(query: String): List<CadjEntity>

    @Query("SELECT * from cadj where inout = 'o' and note LIKE '%'|| :query || '%' order by id asc")
    fun getKasKeluarAsc(query: String): List<CadjEntity>

    @Query("SELECT * FROM cadj WHERE inout = 'i' and trxdate between :startDate and :endDate")
    fun getJmlCadjInByDate(startDate: Long, endDate: Long): List<CadjEntity>

    @Query("SELECT * FROM cadj where inout = 'o' and trxdate between :startDate and :endDate")
    fun getJmlCadjOutByDate(startDate: Long, endDate: Long): List<CadjEntity>

    @Query("SELECT * FROM cadj where cash_id = :cashId AND autogen = 0")
    fun getCashInOut(cashId : Long): List<CadjEntity>

    @Query("select sum(amount) from cadj where inout = 'i' and refno = :refno ")
    fun sumCashIn(refno: String): BigDecimal?


}