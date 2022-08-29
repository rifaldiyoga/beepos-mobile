package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.SaleAddOnEntity
import com.bits.bee.bpmc.domain.model.SaleAddOn

/**
 * Created by aldi on 22/04/22.
 */
object SaleAddOnDataMapper : BaseMapper<SaleAddOnEntity, SaleAddOn, Any>(){

    override fun fromDbToDomain(model: SaleAddOnEntity): SaleAddOn {
        return SaleAddOn(
            model.id ,
            null,
        )
    }

    override fun fromDomainToDb(model: SaleAddOn): SaleAddOnEntity {
        return SaleAddOnEntity(
            model.id ,
            model.saleId!!.id!!,
        )
    }

    override fun fromNetworkToDb(model: Any): SaleAddOnEntity {
        TODO("Not yet implemented")
    }


}