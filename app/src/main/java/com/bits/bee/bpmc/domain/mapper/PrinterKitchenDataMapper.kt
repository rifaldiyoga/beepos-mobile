package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.PrinterEntity
import com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchenEntity
import com.bits.bee.bpmc.domain.model.PrinterKitchen

object PrinterKitchenDataMapper: BaseMapper<PrinterKitchenEntity, PrinterKitchen, Any>() {
    override fun fromDbToDomain(model: PrinterKitchenEntity): PrinterKitchen {
        return PrinterKitchen(
            model.id,
            model.kitchenName,
            model.printerId
        )
    }

    override fun fromDomainToDb(model: PrinterKitchen): PrinterKitchenEntity {
        return PrinterKitchenEntity(
            model.id,
            model.kitchenName,
            model.printerId
        )
    }

    override fun fromNetworkToDb(model: Any): PrinterKitchenEntity {
        TODO("Not yet implemented")
    }

}