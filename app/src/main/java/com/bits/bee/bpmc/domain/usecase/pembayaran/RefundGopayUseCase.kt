package com.bits.bee.bpmc.domain.usecase.pembayaran

import com.bits.bee.bpmc.data.data_source.remote.model.GopayRefundPost
import com.bits.bee.bpmc.data.data_source.remote.response.GopayRefundResponse
import com.bits.bee.bpmc.data.data_source.remote.response.GopayStatusResponse
import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.repository.GopayRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import java.math.RoundingMode
import javax.inject.Inject

/**
 * Created by aldi on 21/10/22
 */
class RefundGopayUseCase @Inject constructor(
    private val gopayRepository: GopayRepository
){

    operator fun invoke(sale : Sale) : Flow<Resource<GopayRefundResponse>>{
        val gopayRefundPost = GopayRefundPost(
            sale.trxNo,
            sale.total.setScale(0, RoundingMode.HALF_UP),
            sale.voidNote
        )
        return gopayRepository.postGopayRefund(sale.gopayTransactionId, gopayRefundPost)
    }
}