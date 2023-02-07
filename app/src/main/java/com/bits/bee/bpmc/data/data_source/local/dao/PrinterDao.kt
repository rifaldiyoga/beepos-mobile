package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.PrinterEntity

@Dao
interface PrinterDao: BaseDao<PrinterEntity> {

    @Query("SELECT * FROM printer where address = :id ")
    fun readByAddress(id: String) : PrinterEntity?

    @Query("SELECT * FROM printer where is_receipt = 1 ")
    fun readByActiveReceipt() : List<PrinterEntity>

    @Query("SELECT * FROM printer where is_report = 1 ")
    fun readByActiveReport() : List<PrinterEntity>

    @Query("SELECT * FROM printer where is_kitchen = 1 ")
    fun readByActiveKitchen() : List<PrinterEntity>

    @Query("SELECT * FROM printer where is_checker = 1 ")
    fun readByActiveChecker() : List<PrinterEntity>

    @Query("SELECT * FROM printer where tipe = :tipe")
    fun readByTipe(tipe: Int): List<PrinterEntity>

    @Query("SELECT * FROM printer ORDER BY id DESC LIMIT 1")
    fun getLastId(): PrinterEntity

    @Query("SELECT * FROM printer")
    fun readPrinter(): List<PrinterEntity>
}
