package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchen
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

interface PrinterKitchenRepository {
    fun getIdPrinter(id: Int): List<PrinterKitchen>

    fun getId(id: Int): Flow<Resource<PrinterKitchen>>

    fun getLastId(id: Int): Flow<Resource<PrinterKitchen>>
}