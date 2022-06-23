package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchenEntity
import javax.inject.Singleton

@Singleton
@Dao
interface PrinterKitchenDao: BaseDao<PrinterKitchenEntity> {
    @Query("SELECT * FROM printer_kitchen where printer_id = :id ")
    fun getByPrinter(id: Int): List<PrinterKitchenEntity>

    @Query("SELECT * FROM printer_kitchen where id = :id")
    fun getById(id: Int): PrinterKitchenEntity

    @Query("SELECT * FROM printer_kitchen ORDER BY id DESC LIMIT 1")
    fun getLastId(): PrinterKitchenEntity
}