package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.PriceLvlEntity
import com.bits.bee.bpmc.data.data_source.remote.response.PriceLvlResponse
import com.bits.bee.bpmc.domain.model.PriceLvl
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.DateFormatUtils

/**
 * Created by aldi on 26/04/22.
 */
object PriceLvlDataMapper : BaseMapper<PriceLvlEntity, PriceLvl, PriceLvlResponse.PriceLvlModel>() {

    override fun fromDbToDomain(model: PriceLvlEntity): PriceLvl {
        return PriceLvl(
            model.id,
            model.name,
            model.code,
//            model.active,
            model.updatedAt
        )
    }

    override fun fromDomainToDb(model: PriceLvl): PriceLvlEntity {
        return PriceLvlEntity(
            model.id,
            model.name,
            model.code,
//            model.active,
            model.updatedAt
        )
    }

    override fun fromNetworkToDb(model: PriceLvlResponse.PriceLvlModel): PriceLvlEntity {
        return PriceLvlEntity(
            model.id,
            model.name,
            model.code,
//            model.active,
            DateFormatUtils.formatStringToDate(BPMConstants.DEFAULT_DATE_FORMAT, model.updatedAt)
        )
    }


}