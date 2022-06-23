package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.PrinterEntity
import com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchenEntity
import com.bits.bee.bpmc.domain.model.PrinterKitchen

object PrinterKitchenDataMapper: BaseMapper<PrinterKitchenEntity, PrinterKitchen>() {
    override fun fromDataToDomain(model: PrinterKitchenEntity): PrinterKitchen {
        return PrinterKitchen(
            model.id,
            model.kitchenName,
            model.printerId
        )
    }

    override fun fromDomainToData(model: PrinterKitchen): PrinterKitchenEntity {
        return PrinterKitchenEntity(
            model.id,
            model.kitchenName,
            model.printerId
        )
    }

}