package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.CmpEntity
import com.bits.bee.bpmc.data.data_source.remote.model.CmpModel
import com.bits.bee.bpmc.domain.model.Cmp

/**
 * Created by aldi on 30/06/22.
 */
object CmpDataMapper : BaseMapper<CmpEntity, Cmp, CmpModel>() {

    override fun fromDbToDomain(model: CmpEntity): Cmp {
        return Cmp(
            id = model.id,
            cityCode = model.cityCode,
            crcId = model.crcId,
            name = model.name,
            address = model.address,
            phone = model.phone,
            fax = model.fax,
            zipCode = model.zipCode,
            startDate = model.startDate,
            fiscalYear = model.fiscalYear,
            ownerName = model.ownerName,
            ownerTaxRegNo = model.ownerTaxRegNo,
            formSerno = model.formSerno,
            taxRegNo = model.taxRegNo,
            vatRegNo = model.vatRegNo,
            cossType = model.cossType,
        )
    }

    override fun fromDomainToDb(model: Cmp): CmpEntity {
        return CmpEntity(
            id = model.id,
            cityCode = model.cityCode,
            crcId = model.crcId,
            name = model.name,
            address = model.address,
            phone = model.phone,
            fax = model.fax,
            zipCode = model.zipCode,
            startDate = model.startDate,
            fiscalYear = model.fiscalYear,
            ownerName = model.ownerName,
            ownerTaxRegNo = model.ownerTaxRegNo,
            formSerno = model.formSerno,
            taxRegNo = model.taxRegNo,
            vatRegNo = model.vatRegNo,
            cossType = model.cossType,
        )
    }

    override fun fromNetworkToDb(model: CmpModel): CmpEntity {
        return CmpEntity(
            id = model.id,
            cityCode = model.cityCode,
            crcId = model.crcId,
            name = model.name,
            address = model.address,
            phone = model.phone,
            fax = model.fax,
            zipCode = model.zipCode,
            startDate = model.startDate,
            fiscalYear = model.fiscalYear,
            ownerName = model.ownerName,
            ownerTaxRegNo = model.ownerTaxRegNo,
            formSerno = model.formSerno,
            taxRegNo = model.taxRegNo,
            vatRegNo = model.vatRegNo,
            cossType = model.cossType,
        )
    }

}