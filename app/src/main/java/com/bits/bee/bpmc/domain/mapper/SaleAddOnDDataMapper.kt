package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.SaleAddOnDEntity
import com.bits.bee.bpmc.domain.model.SaleAddOn
import com.bits.bee.bpmc.domain.model.SaleAddOnD
import com.bits.bee.bpmc.domain.model.Saled

/**
 * Created by aldi on 22/04/22.
 */
object SaleAddOnDDataMapper : BaseMapper<SaleAddOnDEntity, SaleAddOnD, Any>(){

    override fun fromDbToDomain(model: SaleAddOnDEntity): SaleAddOnD {
        return SaleAddOnD(
            model.id ,
            SaleAddOn(id = model.saleAddOnId),
            Saled(id = model.upSaledId),
            Saled(id = model.saledId),
        )
    }

    override fun fromDomainToDb(model: SaleAddOnD): SaleAddOnDEntity {
        return SaleAddOnDEntity(
            model.id,
            model.saleAddOn!!.id!!,
            model.upSaled!!.id!!,
            model.saled!!.id!!,
        )
    }

    override fun fromNetworkToDb(model: Any): SaleAddOnDEntity {
        TODO("Not yet implemented")
    }

}