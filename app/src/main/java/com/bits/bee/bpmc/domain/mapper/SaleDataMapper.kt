package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.SaleEntity
import com.bits.bee.bpmc.domain.model.Sale

/**
 * Created by aldi on 22/06/22.
 */
object SaleDataMapper : BaseMapper<SaleEntity, Sale>(){

    override fun fromDataToDomain(model: SaleEntity): Sale {
        return Sale(
            id = model.id,
            trxOrderNum = model.trxOrderNum,
            trxNo = model.trxNo,
            isDraft = model.isDraft,
            subtotal = model.subtotal,
            total = model.total,
            oprName = model.oprName,
            cashiername = model.cashiername,
            trxDate = model.trxDate,
            totPaid = model.totPaid,
            totChange = model.totChange,
            taxAmt = model.taxAmt,
            discAmt = model.discAmt,
            possesId = model.possesId,
            kodePosses = model.kodePosses,
            discExp = model.discExp,
            operatorId = model.operatorId,
            cashierId = model.cashierId,
            bpId = model.cashierId,
            custName = model.custName,
            termType = model.termType,
            isUploaded = model.isUploaded,
            isVoid = model.isVoid,
            gopayUrl = model.gopayUrl,
            gopayTransactionId = model.gopayTransactionId,
            gopayPaymentStatus = model.gopayPaymentStatus,
            rounding = model.rounding,
            channelId = model.channelId,
            voidNote = model.voidNote
        )
    }

    override fun fromDomainToData(model: Sale): SaleEntity {
        return SaleEntity(
            id = model.id,
            trxOrderNum = model.trxOrderNum,
            trxNo = model.trxNo,
            isDraft = model.isDraft,
            subtotal = model.subtotal,
            total = model.total,
            oprName = model.oprName,
            cashiername = model.cashiername,
            trxDate = model.trxDate,
            totPaid = model.totPaid,
            totChange = model.totChange,
            taxAmt = model.taxAmt,
            discAmt = model.discAmt,
            possesId = model.possesId,
            kodePosses = model.kodePosses,
            discExp = model.discExp,
            operatorId = model.operatorId,
            cashierId = model.cashierId,
            bpId = model.cashierId,
            custName = model.custName,
            termType = model.termType,
            isUploaded = model.isUploaded,
            isVoid = model.isVoid,
            gopayUrl = model.gopayUrl,
            gopayTransactionId = model.gopayTransactionId,
            gopayPaymentStatus = model.gopayPaymentStatus,
            rounding = model.rounding,
            channelId = model.channelId,
            voidNote = model.voidNote
        )
    }


}