package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.SaleEntity
import com.bits.bee.bpmc.data.data_source.remote.model.LineChartData
import com.bits.bee.bpmc.utils.BPMConstants
import java.math.BigDecimal

/**
 * Created by aldi on 20/05/22.
 */
@Dao
interface SaleDao : BaseDao<SaleEntity> {

    @Query("SELECT * FROM sale WHERE draft = :isDraft AND (trx_no LIKE '%' || :query || '%' OR bp_name LIKE '%' || :query || '%')" +
            " AND channel_id IN (:channelList) AND trx_date BETWEEN :startDate AND :endDate ORDER BY trx_date DESC")
    fun getLatestSaleList(query : String, isDraft : Boolean, channelList : List<Int>, startDate : Long, endDate : Long) : PagingSource<Int, SaleEntity>

    @Query("SELECT * FROM sale WHERE draft = :isDraft AND (trx_no LIKE '%' || :query || '%' OR bp_name LIKE '%' || :query || '%')" +
            " AND trx_date BETWEEN :startDate AND :endDate ORDER BY trx_date DESC")
    fun getLatestSaleList(query : String, isDraft : Boolean,  startDate : Long, endDate : Long) : PagingSource<Int, SaleEntity>

    @Query("SELECT * FROM sale WHERE draft = 1 ORDER BY id DESC LIMIT 5")
    fun getLatestDraftList() : List<SaleEntity>

    @Query("SELECT * FROM sale WHERE posses_id = :id AND draft = 0")
    fun getSaleByPosses(id: Int): List<SaleEntity>

    @Query("SELECT *, SUM(total) as total FROM sale WHERE posses_id = :id AND draft = 0 AND isvoid = 0 GROUP BY channel_id")
    fun getSaleByPossesGroupChannel(id: Int): List<SaleEntity>

    @Query("SELECT * FROM sale WHERE posses_id = :id AND draft = 0 AND isvoid = :isVoid AND termtype = :termType")
    fun getSaleByPosses(id: Int, isVoid: Boolean, termType : String): List<SaleEntity>

    @Query("SELECT COUNT(*) FROM sale WHERE posses_id = :id and isvoid = 0 and draft = 0")
    fun getTotalNota(id: Int): BigDecimal

    @Query("SELECT COUNT(*) FROM sale WHERE posses_id = :id and isvoid = 1")
    fun getTotalNotaVoid(id: Int): BigDecimal

    @Query("SELECT SUM(total) FROM sale WHERE posses_id = :id and termtype = '${BPMConstants.BPM_DEFAULT_TYPE_TUNAI}' and isvoid = 0")
    fun getTotalPaidTunai(id: Int): BigDecimal?

    @Query("SELECT SUM(total) FROM sale WHERE posses_id = :id and termtype = '${BPMConstants.BPM_DEFAULT_TYPE_DEBIT}' and isvoid = 0")
    fun getTotalPaidDebit(id: Int): BigDecimal?

    @Query("SELECT SUM(total) FROM sale WHERE posses_id = :id and termtype = '${BPMConstants.BPM_DEFAULT_TYPE_KREDIT}' and isvoid = 0")
    fun getTotalPaidKredit(id: Int): BigDecimal?

    @Query("SELECT SUM(total) FROM sale WHERE posses_id = :id and termtype = '${BPMConstants.BPM_DEFAULT_TYPE_CASH_GOPAY}' and isvoid = 0")
    fun getTotalPaidGopay(id: Int): BigDecimal?

    @Query("SELECT * FROM sale where isuploaded = 0 and draft = 0 and id not in (SELECT a.sale_id FROM saled a JOIN sale b ON b.id = a.sale_id JOIN item c ON c.id = a.item_id WHERE b.isuploaded = 0 AND substr(c.code, -4) = '-DEL') limit :limit_trx")
    fun getSaleHaventUploaded(limit_trx: Int): List<SaleEntity>

    @Query("UPDATE sale SET bp_id = :idCust WHERE bp_id = :oldIdCust")
    fun updateNewIdCust(oldIdCust: Int, idCust: Int)

    @Query("SELECT * FROM sale where id = :id")
    fun getSaleById(id: Int): SaleEntity?

    @Query("SELECT * FROM sale where isuploaded = 0 and draft = 0")
    fun getSaleNotUploaded(): List<SaleEntity>

    @Query("select strftime('%H', datetime(trx_date/1000, 'unixepoch', 'localtime')) as date, sum(a.total) as qty from sale a " +
            "WHERE date = :hour AND a.isvoid = '0' AND a.posses_id = :id group by strftime('%H', datetime(trx_date/1000, 'unixepoch', 'localtime'))")
    fun sumQtyByHour(id: Int, hour: String): LineChartData

    @Query("SELECT sale.*, SUM(total) as 'total' FROM sale WHERE (posses_id = :id AND draft = 0 AND isvoid = 0) GROUP BY bp_id")
    fun getSaleByPossesGroupByBp(id: Int): List<SaleEntity>

    @Query("SELECT SUM(total) FROM sale WHERE posses_id = :id AND isvoid = 0 AND channel_id = :channelId")
    fun sumTotalChannel(id: Int, channelId : Int): BigDecimal

    @Query("SELECT COUNT(total) FROM sale WHERE posses_id = :id AND isvoid = 0")
    fun sumTotalPaidAll(id: Int): BigDecimal

    @Query("SELECT COUNT(total) FROM sale WHERE draft = 1")
    fun getCountDraft(): Int
}