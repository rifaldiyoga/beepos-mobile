package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.SyncEntity

@Dao
interface SyncDao: BaseDao<SyncEntity> {
    @Query("select sale.id as id, sale.trx_no as trx_no, sale.isuploaded as isuploaded from sale where sale.isuploaded=0 and sale.draft=0 " +
            "union select cadj.id as id, cadj.kode_cadj as trx_no, cadj.isuploaded as isuploaded from cadj where cadj.isuploaded=0 " +
            "union select cstr.id, cstr.kode_cstr, cstr.isuploaded from cstr where cstr.isuploaded=0 " +
            "union select posses.id, posses.trxno, posses.isuploaded from posses where posses.isuploaded=0 order by id desc limit :limit offset :offset")
    fun getManualSync(limit: Long, offset: Long): List<SyncEntity>

//    @Query("select sale.id as id, sale.trx_no as trx_no, sale.trx_date as trxdate from sale where sale.isuploaded=0 and sale.draft=0 " +
//            "union select cadj.id as id, cadj.kode_cadj as trx_no, cadj.trxdate as trxdate from cadj where cadj.isuploaded=0 " +
//            "union select cstr.id, cstr.kode_cstr, cstr.trxdate as trxdate from cstr where cstr.isuploaded=0 " +
//            "union select posses.id, posses.trxno, posses.trxdate from posses " +
//            "join casha on casha.refid = posses.id where casha.reftype = 'POSSES' order by id desc limit :limit offset :offset")
//    fun getManualSync(limit: Long, offset: Long): List<SyncEntity>

    @Query("select sale.id as id, sale.trx_no as trx_no, sale.bp_id as bp_id, sale.bp_name as bp_name, sale.isuploaded as isuploaded from sale left join bp on bp.id = sale.bp_id " +
            "where sale.isuploaded=0 and sale.draft=0 and bp.id is null")
    fun getSaleNotHaveBp(): List<SyncEntity>

//    @Query("select sale.id as id, sale.trx_no as trx_no from sale where sale.isuploaded=0 and sale.draft=0 " +
//            "union select cadj.id as id, cadj.kode_cadj as trx_no from cadj where cadj.isuploaded=0 " +
//            "union select cstr.id, cstr.kode_cstr from cstr where cstr.isuploaded=0 " +
//            "union select posses.id as id, posses.trxno as trx_no from posses " +
//            "join casha on casha.reftype = 'POSSES' limit 10")
//    fun getSyncHaventUploaded(): List<SyncEntity>

    @Query("select sale.id as id, sale.trx_no as trx_no, sale.isuploaded as isuploaded from sale where sale.isuploaded=0")
    fun getSyncHaventUploaded(): List<SyncEntity>

}