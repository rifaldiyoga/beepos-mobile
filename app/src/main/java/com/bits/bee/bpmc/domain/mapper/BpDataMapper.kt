package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.BpEntity
import com.bits.bee.bpmc.data.data_source.remote.response.BpResponse
import com.bits.bee.bpmc.domain.model.Bp
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by aldi on 22/04/22.
 */
object BpDataMapper : BaseMapper<BpEntity, Bp, BpResponse.BpModel>(){

    override fun fromDbToDomain(model: BpEntity): Bp {
        return Bp(
            model.id,
            model.code,
            model.name,
            model.greeting,
            model.anniversary,
            model.isTaxedOnSale,
            model.isTaxIncOnSale,
            model.note,
            model.bpgrpId,
            model.priceLvlId,
            model.isActive,
            "",
            model.createdAt,
            model.createdBy,
            model.updatedAt,
            model.updatedBy,
            model.isFavorit,
            isSelected = model.isSelected
        )
    }

    override fun fromDomainToDb(model: Bp): BpEntity {
        return BpEntity(
            model.id,
            model.code,
            model.name,
            model.greeting,
            model.anniversary,
            model.isTaxedOnSale,
            model.isTaxIncOnSale,
            model.note,
            model.bpgrpId,
            model.priceLvlId,
            model.isActive,
            model.createdAt,
            model.createdBy,
            model.updatedAt,
            model.updatedBy,
            model.isFavorit,
            isSelected = model.isSelected
        )
    }

    override fun fromNetworkToDb(model: BpResponse.BpModel): BpEntity {
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
        return BpEntity(
            id = model.id,
            code = model.code,
            name = model.name,
            greeting = "",
            anniversary = "",
            isTaxIncOnSale = model.saletaxinc,
            isTaxedOnSale = model.saleistaxed,
            priceLvlId = model.pricelvl_id,
            bpgrpId = model.bpgrpid,
            createdAt =  model.created_at?.let { format.parse(it) } ?: kotlin.run { Date(-1) } ,
            createdBy = -1,
        )
    }
}