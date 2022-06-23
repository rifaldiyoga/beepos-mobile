package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.PrinterEntity
import com.bits.bee.bpmc.domain.model.Printer

object PrinterDataMapper: BaseMapper<PrinterEntity, Printer>() {
    override fun fromDataToDomain(model: PrinterEntity): Printer {
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

    override fun fromDomainToData(model: Printer): PrinterEntity {
        return PrinterEntity(
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
}