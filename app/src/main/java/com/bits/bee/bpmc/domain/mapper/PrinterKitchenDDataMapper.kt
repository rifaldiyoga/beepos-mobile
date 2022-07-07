package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchenDEntity
import com.bits.bee.bpmc.domain.model.PrinterKitchenD

object PrinterKitchenDDataMapper: BaseMapper<PrinterKitchenDEntity, PrinterKitchenD>() {
    override fun fromDataToDomain(model: PrinterKitchenDEntity): PrinterKitchenD {
        return PrinterKitchenD(
            model.id,
            model.printerKitchenId,
            model.kitchenId
        )
    }

    override fun fromDomainToData(model: PrinterKitchenD): PrinterKitchenDEntity {
        return PrinterKitchenDEntity(
            model.id,
            model.printerKitchenId,
            model.kitchenId
        )
    }
}