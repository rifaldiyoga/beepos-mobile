package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.data_source.local.model.Printer
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

interface PrinterRespository {
    fun getAddressPrinterList(): Flow<Resource<List<Printer>>>

    fun getActiveReceiptList(): Flow<Resource<List<Printer>>>

    fun getActiveReportList(): Flow<Resource<List<Printer>>>

    fun getActiveKitchenList(): Flow<Resource<List<Printer>>>

    fun getActiveCheckerList(): Flow<Resource<List<Printer>>>

    fun getPrinterTipe(): Flow<Resource<List<Printer>>>

    fun getLastId(): Flow<Resource<List<Printer>>>
}