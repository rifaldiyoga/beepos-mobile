package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.SaleAddOnDEntity
import com.bits.bee.bpmc.domain.model.SaleAddOnD

/**
 * Created by aldi on 22/04/22.
 */
object SaleAddOnDDataMapper : BaseMapper<SaleAddOnDEntity, SaleAddOnD, Any>(){

    override fun fromDbToDomain(model: SaleAddOnDEntity): SaleAddOnD {
        return SaleAddOnD(
            model.id ,
            null,
            null,
            null,
        )
    }

    override fun fromDomainToDb(model: SaleAddOnD): SaleAddOnDEntity {
        return SaleAddOnDEntity(
            model.id ,
            model.saleAddOnId!!.id!!,
            model.upSaledId!!.id!!,
            model.saledId!!.id!!,
        )
    }

    override fun fromNetworkToDb(model: Any): SaleAddOnDEntity {
        TODO("Not yet implemented")
    }

}