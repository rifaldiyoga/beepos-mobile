package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.TaxEntity
import com.bits.bee.bpmc.data.data_source.remote.response.TaxResponse
import com.bits.bee.bpmc.domain.model.Tax

/**
 * Created by aldi on 22/04/22.
 */
object TaxDataMapper : BaseMapper<TaxEntity, Tax, TaxResponse.TaxModel>(){

    override fun fromDbToDomain(model: TaxEntity ): Tax {
        return Tax(
            model.id ,
            model.code ,
            model.name ,
            model.expr ,
            model.isActive ,
            model.isDefault ,
        )
    }

    override fun fromDomainToDb(model: Tax): TaxEntity {
        return TaxEntity(
            model.id ,
            model.code ,
            model.name ,
            model.expr ,
            model.isActive ,
            model.isDefault ,
        )
    }

    override fun fromNetworkToDb(model: TaxResponse.TaxModel): TaxEntity {
        return TaxEntity(
            null,
            model.code ,
            model.name ,
            model.expr ,
            model.isActive ,
            model.isDefault ,
        )
    }
}