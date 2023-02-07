package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.PrinterEntity
import com.bits.bee.bpmc.domain.model.Printer

object PrinterDataMapper: BaseMapper<PrinterEntity, Printer, Any>() {

    override fun fromDbToDomain(model: PrinterEntity): Printer {
        return Printer(
            model.id,
            model.printerName,
            model.address,
            model.tipe,
            model.size,
            model.isReceipt,
            model.isKitchen,
            model.isReport,
            model.isChecker
        )
    }

    override fun fromDomainToDb(model: Printer): PrinterEntity {
        return PrinterEntity(
            model.id,
            model.printerName,
            model.address,
            model.tipe ?: -1,
            model.size,
            model.isReceipt,
            model.isKitchen,
            model.isReport,
            model.isChecker
        )
    }

    override fun fromNetworkToDb(model: Any): PrinterEntity {
        TODO("Not yet implemented")
    }
}