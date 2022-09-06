package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.CityEntity
import com.bits.bee.bpmc.data.data_source.remote.model.CityModel
import com.bits.bee.bpmc.domain.model.City
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.DateFormatUtils
import java.util.*

/**
 * Created by aldi on 18/05/22.
 */
object CityDataMapper : BaseMapper<CityEntity, City, CityModel>() {

    override fun fromDbToDomain(model: CityEntity): City {
        return City(
            model.id,
            model.code,
            model.name,
//            model.isActive
            model.updatedAt
        )
    }

    override fun fromDomainToDb(model: City): CityEntity {
        return CityEntity(
            model.id,
            model.code,
            model.name,
//            model.isActive
            model.updatedAt
        )
    }

    override fun fromNetworkToDb(model: CityModel): CityEntity {
        return CityEntity(
            model.id,
            model.code,
            model.name,
//            true
            if(model.updatedAt.isNotBlank()) DateFormatUtils.formatStringToDate(BPMConstants.DEFAULT_DATE_FORMAT, model.updatedAt) else Date()
        )
    }
}