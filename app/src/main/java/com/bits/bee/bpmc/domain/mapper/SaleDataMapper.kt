package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.SaleEntity
import com.bits.bee.bpmc.domain.model.Sale

/**
 * Created by aldi on 22/06/22.
 */
object SaleDataMapper : BaseMapper<SaleEntity, Sale, Any>(){

    override fun fromDbToDomain(model: SaleEntity): Sale {
        return Sale(
            id = model.id,
            trxOrderNum = model.trxOrderNum,
            trxNo = model.trxNo,
            isDraft = model.isDraft,
            subtotal = model.subtotal,
            total = model.total,
            userName = model.oprName,
            cashiername = model.cashiername,
            trxDate = model.trxDate,
            totPaid = model.totPaid,
            totChange = model.totChange,
            taxAmt = model.taxAmt,
            discAmt = model.discAmt,
            possesId = model.possesId,
            kodePosses = model.kodePosses,
            discExp = model.discExp,
            operatorId = model.userId,
            cashierId = model.cashierId,
            bpId = model.bpId,
            bpName = model.bpName,
            termType = model.termType,
            isUploaded = model.isUploaded,
            isVoid = model.isVoid,
            gopayUrl = model.gopayUrl,
            gopayTransactionId = model.gopayTransactionId,
            gopayPaymentStatus = model.gopayPaymentStatus,
            rounding = model.rounding,
            channelId = model.channelId,
            voidNote = model.voidNote,
            createdAt = model.createdAt,
            createdBy = model.createdBy,
            updatedAt = model.updatedAt,
            updatedBy = model.updatedBy,
            crcId = model.crcId
        )
    }

    override fun fromDomainToDb(model: Sale): SaleEntity {
        return SaleEntity(
            id = model.id,
            trxOrderNum = model.trxOrderNum,
            trxNo = model.trxNo,
            isDraft = model.isDraft,
            subtotal = model.subtotal,
            total = model.total,
            oprName = model.userName,
            cashiername = model.cashiername,
            trxDate = model.trxDate,
            totPaid = model.totPaid,
            totChange = model.totChange,
            taxAmt = model.taxAmt,
            discAmt = model.discAmt,
            possesId = model.possesId,
            kodePosses = model.kodePosses,
            discExp = model.discExp,
            userId = model.operatorId,
            cashierId = model.cashierId,
            bpId = model.bpId,
            bpName = model.bpName,
            termType = model.termType,
            isUploaded = model.isUploaded,
            isVoid = model.isVoid,
            gopayUrl = model.gopayUrl,
            gopayTransactionId = model.gopayTransactionId,
            gopayPaymentStatus = model.gopayPaymentStatus,
            rounding = model.rounding,
            channelId = model.channelId,
            voidNote = model.voidNote,
            createdAt = model.createdAt,
            createdBy = model.createdBy,
            updatedAt = model.updatedAt,
            updatedBy = model.updatedBy,
            crcId = model.crcId,
        )
    }

    override fun fromNetworkToDb(model: Any): SaleEntity {
        TODO("Not yet implemented")
    }


}