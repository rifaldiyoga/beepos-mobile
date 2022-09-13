package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.LicenseEntity
import com.bits.bee.bpmc.data.data_source.remote.response.LicenseResponse
import com.bits.bee.bpmc.domain.model.License
import com.bits.bee.bpmc.utils.DateFormatUtils

/**
 * Created by aldi on 06/09/22
 */
object LicenseDataMapper : BaseMapper<LicenseEntity, License, LicenseResponse.Data>() {

    override fun fromDbToDomain(model: LicenseEntity): License {
        return License(
            model.name,
            model.licNumber ,
            model.item ,
            model.licExp,
        )
    }

    override fun fromDomainToDb(model: License): LicenseEntity {
        return LicenseEntity(
            model.name,
            model.licNumber ,
            model.item ,
            model.licExp,
        )
    }

    override fun fromNetworkToDb(model: LicenseResponse.Data): LicenseEntity {
        return LicenseEntity(
            name = model.cmpname,
            licNumber = model.serialNumber,
            item = model.item,
            licExp = DateFormatUtils.formatStringToDate("yyyy-MM-dd", model.expdate)
        )
    }
}