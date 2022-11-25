package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchenDEntity
import javax.inject.Singleton

@Singleton
@Dao
interface PrinterKitchenDDao: BaseDao<PrinterKitchenDEntity> {
    @Query("SELECT * FROM printer_kitchend where printer_kitchen_id = :id")
    fun getPrinterKitchen(id: Int): List<PrinterKitchenDEntity>

    @Query("DELETE FROM printer_kitchend WHERE printer_kitchen_id = :id")
    suspend fun deleteByPrinterKitchen(id: Int)
}