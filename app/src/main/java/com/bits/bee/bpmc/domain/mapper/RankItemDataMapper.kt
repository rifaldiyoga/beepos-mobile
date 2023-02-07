package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.RankItemEntity
import com.bits.bee.bpmc.domain.model.RankItem

object RankItemDataMapper:BaseMapper<RankItemEntity, RankItem, Any>(){
    override fun fromDbToDomain(model: RankItemEntity): RankItem {
        return RankItem(
            name = model.name,
            qty = model.qty,
            total = model.total
        )
    }

    override fun fromDomainToDb(model: RankItem): RankItemEntity {
        TODO("Not yet implemented")
    }

    override fun fromNetworkToDb(model: Any): RankItemEntity {
        TODO("Not yet implemented")
    }

}