package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.VariantEntity
import com.bits.bee.bpmc.data.data_source.remote.response.VariantResponse
import com.bits.bee.bpmc.domain.model.Variant

/**
 * Created by aldi on 22/04/22.
 */
object VariantDataMapper : BaseMapper<VariantEntity, Variant, VariantResponse.VariantModel>(){

    override fun fromDbToDomain(model: VariantEntity): Variant {
        return Variant(
            model.id,
            model.code,
            model.name,
            model.itgrpId,
            model.picPath,
            model.isFavorit,
            model.isAvailable,
        )
    }

    override fun fromDomainToDb(model: Variant): VariantEntity {
        return VariantEntity(
            model.id,
            model.code,
            model.name,
            model.itgrpId,
            model.picPath,
            model.isFavorit,
            model.isAvailable,
        )
    }

    override fun fromNetworkToData(model: VariantResponse.VariantModel): VariantEntity {
        return VariantEntity(
            model.id,
            model.code,
            model.name,
            model.itgrpId,
            "",
            isFavorit = false,
            isAvailable = true,
        )
    }
}