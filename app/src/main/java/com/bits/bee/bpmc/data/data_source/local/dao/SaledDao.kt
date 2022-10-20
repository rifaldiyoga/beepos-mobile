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

    @Query("SELECT a.* FROM saled a JOIN sale b ON b.id = a.sale_id JOIN item c ON c.id = a.item_id " +
            "WHERE b.isuploaded = 0 AND substr(c.code, -4) = '-DEL'")
    fun getSaledDeletedItem(): List<SaledEntity>

    @Query("select saled.item_code, saled.disc, saled.tax, saled.discexp, saled.discamt, saled.disc2amt, saled.taxamt, saled.baseprice, saled.taxableamt, saled.dno, saled.totaldiscamt, saled.totaldisc2amt, saled.totaltaxamt, saled.dnote, saled.id, saled.item_id, saled.name, saled.listprice, sum(saled.qty) as qty, count(saled.sale_id) as sale_id, saled.subtotal from saled " +
            "left join sale on saled.sale_id = sale.id " +
            "left join item on saled.item_id = item.id " +
            "left join itemgrp on item.itemgrp1_id = itemgrp.id group by saled.item_id order by qty DESC")
    fun queryByPenjualan(): List<SaledEntity>

    @Query("select saled.subtotal, saled.item_code, saled.disc, saled.tax, saled.discexp, saled.discamt, saled.disc2amt, saled.taxamt, saled.baseprice, saled.taxableamt, saled.dno, saled.totaldiscamt, saled.totaldisc2amt, saled.totaltaxamt, saled.dnote, saled.id, saled.item_id, saled.name, saled.listprice, saled.qty, saled.sale_id from saled, sale where sale.draft = 0 and saled.item_id = :id and sale.isvoid = 0 and sale.id == saled.sale_id and sale.trx_date between :startDate and :endDate")
    fun sumTotalByItem(id: Int, startDate: Long, endDate: Long): List<SaledEntity>

    @Query("select saled.qty, saled.subtotal, saled.item_code, saled.disc, saled.tax, saled.discexp, saled.discamt, saled.disc2amt, saled.taxamt, saled.baseprice, saled.taxableamt, saled.dno, saled.totaldiscamt, saled.totaldisc2amt, saled.totaltaxamt, saled.dnote, saled.id, saled.item_id, saled.name, saled.listprice, saled.sale_id from saled, sale where sale.draft = 0 and saled.item_id = :id and sale.isvoid = 0 and sale.id == saled.sale_id and sale.trx_date between :startDate and :endDate")
    fun sumStokByItem(id: Int, startDate: Long, endDate: Long): List<SaledEntity>

}