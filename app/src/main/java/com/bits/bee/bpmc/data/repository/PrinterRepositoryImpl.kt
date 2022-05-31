package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.PrinterDao
import com.bits.bee.bpmc.data.data_source.local.model.Printer
import com.bits.bee.bpmc.domain.repository.PrinterRespository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PrinterRepositoryImpl @Inject constructor(
    private val printerDao: PrinterDao

): PrinterRespository {
    override fun getAddressPrinterList(): Flow<Resource<List<Printer>>> {
        return flow {
            val data: List<Printer> = printerDao.readByAddress("sdsd")
        }
    }

    override fun getActiveReceiptList(): Flow<Resource<List<Printer>>> {
        TODO("Not yet implemented")
    }

    override fun getActiveReportList(): Flow<Resource<List<Printer>>> {
        TODO("Not yet implemented")
    }

    override fun getActiveKitchenList(): Flow<Resource<List<Printer>>> {
        TODO("Not yet implemented")
    }

    override fun getActiveCheckerList(): Flow<Resource<List<Printer>>> {
        TODO("Not yet implemented")
    }

    override fun getPrinterTipe(): Flow<Resource<List<Printer>>> {
        TODO("Not yet implemented")
    }

    override fun getLastId(): Flow<Resource<List<Printer>>> {
        TODO("Not yet implemented")
    }
}