package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.SaleEntity
import com.bits.bee.bpmc.data.data_source.remote.model.LineChartData
import java.math.BigDecimal

/**
 * Created by aldi on 20/05/22.
 */
@Dao
interface SaleDao : BaseDao<SaleEntity> {

    @Query("SELECT * FROM sale WHERE draft = :isDraft AND (trx_no LIKE '%' || :query || '%' OR bp_name LIKE '%' || :query || '%') ORDER BY id DESC")
    fun getLatestSaleList(query : String, isDraft : Boolean) : PagingSource<Int, SaleEntity>

    @Query("SELECT * FROM sale WHERE draft = 1 ORDER BY id DESC LIMIT 5")
    fun getLatestDraftList() : List<SaleEntity>

    @Query("SELECT * FROM sale WHERE posses_id = :id AND draft = 0")
    fun getSaleByPosses(id: Int): List<SaleEntity>

    @Query("SELECT COUNT(*) FROM sale WHERE posses_id = :id and isvoid = 0 and draft = 0")
    fun getTotalNota(id: Int): BigDecimal

    @Query("SELECT COUNT(*) FROM sale WHERE posses_id = :id and isvoid = 1")
    fun getTotalNotaVoid(id: Int): BigDecimal

    @Query("SELECT SUM(total) FROM sale WHERE posses_id = :id and termtype = 'TUNAI' and isvoid = 0")
    fun getTotalPaidTunai(id: Int): BigDecimal?

    @Query("SELECT SUM(total) FROM sale WHERE posses_id = :id and termtype = 'Debit Card' and isvoid = 0")
    fun getTotalPaidDebit(id: Int): BigDecimal?

    @Query("SELECT SUM(total) FROM sale WHERE posses_id = :id and termtype = 'Credit Card' and isvoid = 0")
    fun getTotalPaidKredit(id: Int): BigDecimal?

    @Query("SELECT SUM(total) FROM sale WHERE posses_id = :id and termtype = 'GOPAY' and isvoid = 0")
    fun getTotalPaidGopay(id: Int): BigDecimal?

    @Query("SELECT * FROM sale where isuploaded = 0 and draft = 0 and id not in (:saledlist) limit :limit_trx")
    fun getSaleHaventUploaded(limit_trx: Long, saledlist: String): List<SaleEntity>

    @Query("UPDATE sale SET bp_id = :idCust WHERE bp_id = :oldIdCust")
    fun updateNewIdCust(oldIdCust: Int, idCust: Int)

    @Query("SELECT * FROM sale where id = :id")
    fun getSaleById(id: Int): SaleEntity

    @Query("SELECT * FROM sale where isuploaded = 0 and draft = 0")
    fun getSaleNotUploaded(): List<SaleEntity>

    @Query("select strftime('%H', datetime(trx_date/1000, 'unixepoch', 'localtime')) as date, sum(a.total) as qty from sale a " +
            "WHERE date = :hour AND a.isvoid = '0' AND a.posses_id = :id group by strftime('%H', datetime(trx_date/1000, 'unixepoch', 'localtime'))")
    fun sumQtyByHour(id: Int, hour: String): LineChartData

}