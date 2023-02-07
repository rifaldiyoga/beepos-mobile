package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.SaleCrcvEntity
import com.bits.bee.bpmc.domain.model.SaleCrcv

/**
 * Created by aldi on 20/07/22.
 */
object SaleCrcvDataMapper : BaseMapper<SaleCrcvEntity, SaleCrcv, Any>(){

    override fun fromDbToDomain(model: SaleCrcvEntity): SaleCrcv {
        return SaleCrcv(
            model.id ,
            model.rcvTypeCode ,
            model.saleInt,
            model.rcvAmt ,
            model.note ,
            model.edcId,
            model.cashId,
            model.cardNo ,
            model.cctypeCode ,
            model.mdrExp ,
            model.mdrAmt ,
            model.surcExp ,
            model.surcAmt ,
            model.mdrAccId ,
            model.surAccId ,
            model.refId ,
            model.trackNo ,)
    }

    override fun fromDomainToDb(model: SaleCrcv): SaleCrcvEntity {
        return SaleCrcvEntity(
            model.id ,
            model.rcvTypeCode ,
            model.saleInt,
            model.rcvAmt ,
            model.note ,
            model.edcId,
            model.cashId,
            model.cardNo ,
            model.cctypeCode ,
            model.mdrExp ,
            model.mdrAmt ,
            model.surcExp ,
            model.surcAmt ,
            model.mdrAccId ,
            model.surAccId ,
            model.refId ,
            model.trackNo ,)
    }

    override fun fromNetworkToDb(model: Any): SaleCrcvEntity {
        TODO("Not yet implemented")
    }

}