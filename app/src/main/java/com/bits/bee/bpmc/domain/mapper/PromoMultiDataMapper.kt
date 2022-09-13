package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.PromoMultiEntity
import com.bits.bee.bpmc.data.data_source.remote.response.PromoMultiResponse
import com.bits.bee.bpmc.domain.model.PromoMulti

object PromoMultiDataMapper: BaseMapper<PromoMultiEntity, PromoMulti, PromoMultiResponse.DataPromoMulti>() {

    override fun fromDbToDomain(model: PromoMultiEntity): PromoMulti {
        return PromoMulti(
            model.id,
            model.promoId,
            model.type,
            model.value,
            model.isReq,
            model.isDeal,
        )
    }


    override fun fromDomainToDb(model: PromoMulti): PromoMultiEntity {
        return PromoMultiEntity(
            model.id,
            model.promoId,
            model.type,
            model.value,
            model.isReq,
            model.isDeal,
        )

    }

    override fun fromNetworkToDb(model: PromoMultiResponse.DataPromoMulti): PromoMultiEntity {
        return PromoMultiEntity(
            null,
            model.promoid,
            model.type,
            model.value,
            model.isIsreq,
            model.isIsdeal,
        )
    }
}