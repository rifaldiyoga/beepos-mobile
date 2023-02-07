package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.AddOnDEntity
import com.bits.bee.bpmc.data.data_source.remote.response.AddOnDResponse
import com.bits.bee.bpmc.domain.model.AddOnD

/**
 * Created by aldi on 22/04/22.
 */
object AddOnDDataMapper : BaseMapper<AddOnDEntity, AddOnD, AddOnDResponse.AddOnDModel>(){

    override fun fromDbToDomain(model: AddOnDEntity): AddOnD {
        return AddOnD(
            model.id,
            model.addOnId,
            model.selectionId,
            model.idx ,
            model.upIdx ,
            model.isSkip ,
        )
    }

    override fun fromDomainToDb(model: AddOnD): AddOnDEntity {
        return AddOnDEntity(
            model.id ,
            model.addOnId,
            model.selectionId,
            model.idx ,
            model.upIdx ,
            model.isSkip ,
        )
    }

    override fun fromNetworkToDb(model: AddOnDResponse.AddOnDModel): AddOnDEntity {
        return AddOnDEntity(
            null,
            model.addOnId,
            model.selectaddonId,
            model.idx ,
            model.addOnId,
            model.isSkip,
        )
    }
}