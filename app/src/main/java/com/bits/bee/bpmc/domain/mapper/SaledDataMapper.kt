package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.SaledEntity
import com.bits.bee.bpmc.domain.model.Saled

/**
 * Created by aldi on 22/06/22.
 */
object SaledDataMapper : BaseMapper<SaledEntity, Saled, Any>() {

    override fun fromDbToDomain(model: SaledEntity): Saled {
        return Saled(
            id = model.id,
            itemId = model.itemId,
            itemCode = model.itemCode,
            name = model.name,
            qty = model.qty,
            listPrice = model.listPrice,
            disc = model.disc,
            tax = model.tax,
            discExp = model.discExp,
            discAmt = model.discAmt,
            disc2Amt = model.disc2Amt,
            taxAmt = model.taxAmt,
            basePrice = model.basePrice,
            taxableAmt = model.taxableAmt,
            subtotal = model.subtotal,
            saleId = model.saleId,
            dno = model.dno,
            totalDiscAmt = model.totalDiscAmt,
            totalDisc2Amt = model.totalDisc2Amt,
            totalTaxAmt = model.totalTaxAmt,
            pid = model.pid,
            conv = model.conv,
            unitId = model.unitId,
            crcId = model.crcId,
            taxCode = model.taxCode,
            dNotes = model.dNotes
        )
    }

    override fun fromDomainToDb(model: Saled): SaledEntity {
        return SaledEntity(
            id = model.id,
            itemId = model.itemId,
            name = model.name,
            qty = model.qty,
            listPrice = model.listPrice,
            disc = model.disc,
            tax = model.tax,
            discExp = model.discExp,
            discAmt = model.discAmt,
            disc2Amt = model.disc2Amt,
            taxAmt = model.taxAmt,
            basePrice = model.basePrice,
            taxableAmt = model.taxableAmt,
            subtotal = model.subtotal,
            saleId = model.saleId,
            dno = model.dno,
            totalDiscAmt = model.totalDiscAmt,
            totalDisc2Amt = model.totalDisc2Amt,
            totalTaxAmt = model.totalTaxAmt,
            dNotes = model.dNotes,
            itemCode = model.itemCode,
            pid = model.pid,
            conv = model.conv,
            unitId = model.unitId,
            crcId = model.crcId,
            taxCode = model.taxCode,
        )
    }

    override fun fromNetworkToDb(model: Any): SaledEntity {
        TODO("Not yet implemented")
    }

}