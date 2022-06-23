package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.PrinterEntity

@Dao
interface PrinterDao: BaseDao<PrinterEntity> {
    @Query("SELECT * FROM printer where address = :id ")
    fun readByAddress(id: String) : List<PrinterEntity>

    @Query("SELECT * FROM printer where is_receipt = :isReceipt ")
    fun readByActiveReceipt(isReceipt: Boolean) : List<PrinterEntity>

    @Query("SELECT * FROM printer where is_report = :isReport ")
    fun readByActiveReport(isReport: Boolean) : List<PrinterEntity>

    @Query("SELECT * FROM printer where is_kitchen = :isKitchen ")
    fun readByActiveKitchen(isKitchen: Boolean) : List<PrinterEntity>

    @Query("SELECT * FROM printer where is_checker = :isChecker ")
    fun readByActiveChecker(isChecker: Boolean) : List<PrinterEntity>

    @Query("SELECT * FROM printer where tipe = :tipe")
    fun readByTipe(tipe: Int): List<PrinterEntity>

    @Query("SELECT * FROM printer ORDER BY id DESC LIMIT 1")
    fun getLastId(): PrinterEntity

    @Query("SELECT * FROM printer")
    fun readPrinter(): List<PrinterEntity>
}
