package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.SalePromoEntity
import com.bits.bee.bpmc.domain.model.*

object SalePromoDataMapper: BaseMapper<SalePromoEntity, SalePromo, Any>() {
    override fun fromDbToDomain(model: SalePromoEntity): SalePromo {
        return SalePromo(
            model.id,
            Sale(id = model.saleId),
            model.saleNo,
            Saled(id = model.saledId),
            Promo(id = model.promoId),
            Bp(model.bpId),
            model.promoQty,
            model.promoRule
        )
    }

    override fun fromDomainToDb(model: SalePromo): SalePromoEntity {
        return SalePromoEntity(
            model.id,
            model.sale!!.id,
            model.saleNo,
            model.saled!!.id,
            model.promo!!.id,
            model.bp!!.id,
            model.promoQty,
            model.promoRule
        )
    }

    override fun fromNetworkToDb(model: Any): SalePromoEntity {
        TODO("Not yet implemented")
    }
}