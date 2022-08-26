package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.SyncEntity
import com.bits.bee.bpmc.domain.model.Sync

object SyncDataMapper: BaseMapper<SyncEntity, Sync, Any>() {
    override fun fromDbToDomain(model: SyncEntity): Sync {
        return Sync(
            id = model.id,
            trxNo = model.trxNo,
            trxDate = model.trxDate,
            bpId = model.bpId,
            bpName = model.bpName,
            isUploaded = model.isUploaded
        )
    }

    override fun fromDomainToDb(model: Sync): SyncEntity {
        TODO("Not yet implemented")
    }

    override fun fromNetworkToDb(model: Any): SyncEntity {
        TODO("Not yet implemented")
    }
}