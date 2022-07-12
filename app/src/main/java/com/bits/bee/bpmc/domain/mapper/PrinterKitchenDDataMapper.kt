package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.PrinterKitchenDEntity
import com.bits.bee.bpmc.domain.model.PrinterKitchenD

object PrinterKitchenDDataMapper: BaseMapper<PrinterKitchenDEntity, PrinterKitchenD, Any>() {
    override fun fromDbToDomain(model: PrinterKitchenDEntity): PrinterKitchenD {
        return PrinterKitchenD(
            model.id,
            model.printerKitchenId,
            model.kitchenId
        )
    }

    override fun fromDomainToDb(model: PrinterKitchenD): PrinterKitchenDEntity {
        return PrinterKitchenDEntity(
            model.id,
            model.printerKitchenId,
            model.kitchenId
        )
    }

    override fun fromNetworkToData(model: Any): PrinterKitchenDEntity {
        TODO("Not yet implemented")
    }
}