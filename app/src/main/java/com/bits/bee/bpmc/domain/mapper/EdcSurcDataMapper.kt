package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.EdcSurcEntity
import com.bits.bee.bpmc.data.data_source.remote.response.EdcSurcResponse
import com.bits.bee.bpmc.domain.model.EdcSurc

/**
 * Created by aldi on 18/07/22.
 */
object EdcSurcDataMapper : BaseMapper<EdcSurcEntity, EdcSurc, EdcSurcResponse.DataEdcSurc>() {

    override fun fromDbToDomain(model: EdcSurcEntity): EdcSurc {
        return EdcSurc(
            model.id ,
            model.edcSurcNo ,
            model.edcId,
            model.ccType ,
            model.ccTypeDesc ,
            model.surcExp ,
            model.mdrExp ,
            model.surcAccId ,
            model.mdrAccId ,
            model.edcSurcType ,
            model.active ,
        )
    }

    override fun fromDomainToDb(model: EdcSurc): EdcSurcEntity {
        return EdcSurcEntity(
            model.id ,
            model.edcSurcNo ,
            model.edcId,
            model.ccType ,
            model.ccTypeDesc ,
            model.surcExp ,
            model.mdrExp ,
            model.surcAccId ,
            model.mdrAccId ,
            model.edcSurcType ,
            model.active ,
        )
    }

    override fun fromNetworkToDb(model: EdcSurcResponse.DataEdcSurc): EdcSurcEntity {
        return EdcSurcEntity(
            model.id ,
            model.edcSurcNo ,
            model.edcId,
            model.ccType ,
            model.ccTypeDesc ,
            model.surcExp ,
            model.mdrExp ,
            model.surcAccId ,
            model.mdrAccId ,
            model.edcSurcType ,
            model.active ,
        )
    }
}