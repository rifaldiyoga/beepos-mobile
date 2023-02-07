package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.RekapProdukEntity
import com.bits.bee.bpmc.domain.model.RekapProduk

object RekapProdukDataMapper: BaseMapper<RekapProdukEntity, RekapProduk, Any>() {
    override fun fromDbToDomain(model: RekapProdukEntity): RekapProduk {
        return RekapProduk(
            itemId = model.itemId,
            itemCode = model.itemCode,
            name = model.name,
            subtotal = model.subtotal,
            draft = model.draft,
            isVoid = model.isVoid,
            trxDate = model.trxDate,
            qty = model.qty
        )
    }

    override fun fromDomainToDb(model: RekapProduk): RekapProdukEntity {
        TODO("Not yet implemented")
    }

    override fun fromNetworkToDb(model: Any): RekapProdukEntity {
        TODO("Not yet implemented")
    }
}