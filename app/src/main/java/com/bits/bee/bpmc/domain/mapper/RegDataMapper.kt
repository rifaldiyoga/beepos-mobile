package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.RegEntity
import com.bits.bee.bpmc.data.data_source.remote.model.RegModel
import com.bits.bee.bpmc.domain.model.Reg

/**
 * Created by aldi on 22/04/22.
 */
object RegDataMapper : BaseMapper<RegEntity, Reg, RegModel>(){

    override fun fromDbToDomain(model: RegEntity): Reg {
        return Reg(
            model.code,
            model.name,
            model.value,
            model.isVisible,
            model.modulCode,
            model.validator,
        )
    }

    override fun fromDomainToDb(model: Reg): RegEntity {
        return RegEntity(
            model.code,
            model.name,
            model.value,
            model.isVisible,
            model.modulCode,
            model.validator,
        )
    }

    override fun fromNetworkToDb(model: RegModel): RegEntity {
        return RegEntity(
            model.code,
            model.name,
            model.value,
            model.isVisible,
            model.modulCode,
            model.valeditor,
        )
    }
}