package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.SalePromoEntity
import com.bits.bee.bpmc.domain.model.SalePromo

object SalePromoDataMapper: BaseMapper<SalePromoEntity, SalePromo, Any>() {
    override fun fromDbToDomain(model: SalePromoEntity): SalePromo {
        return SalePromo(
            model.id,
            model.saleId,
            model.saleNo,
            model.saledId,
            model.promoId,
            model.bpId,
            model.promoQty,
            model.promoRule
        )
    }

    override fun fromDomainToDb(model: SalePromo): SalePromoEntity {
        return SalePromoEntity(
            model.id ?: -1,
            model.saleId,
            model.saleNo,
            model.saledId,
            model.promoId,
            model.bpId,
            model.promoQty,
            model.promoRule
        )
    }

    override fun fromNetworkToDb(model: Any): SalePromoEntity {
        TODO("Not yet implemented")
    }
}