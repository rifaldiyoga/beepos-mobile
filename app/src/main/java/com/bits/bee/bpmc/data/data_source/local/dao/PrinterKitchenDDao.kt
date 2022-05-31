package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchenD
import javax.inject.Singleton

@Singleton
@Dao
interface PrinterKitchenDDao: BaseDao<PrinterKitchenD> {
    @Query("SELECT * FROM printer_kitchend where printer_kitchen_id = :id")
    fun getPrinterKitchen(id: Int): List<PrinterKitchenD>

    @Query("DELETE FROM printer_kitchend where printer_kitchen_id = :id")
    fun deletePrinterKitchen(id: Int)
}