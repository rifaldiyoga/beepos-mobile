package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.Printer

@Dao
interface PrinterDao: BaseDao<Printer> {
    @Query("SELECT * FROM printer where address = :id ")
    fun readByAddress(id: String) : List<Printer>

    @Query("SELECT * FROM printer where is_receipt = :isReceipt ")
    fun readByActiveReceipt(isReceipt: Boolean) : List<Printer>

    @Query("SELECT * FROM printer where is_report = :isReport ")
    fun readByActiveReport(isReport: Boolean) : List<Printer>

    @Query("SELECT * FROM printer where is_kitchen = :isKitchen ")
    fun readByActiveKitchen(isKitchen: Boolean) : List<Printer>

    @Query("SELECT * FROM printer where is_checker = :isChecker ")
    fun readByActiveChecker(isChecker: Boolean) : List<Printer>
}
