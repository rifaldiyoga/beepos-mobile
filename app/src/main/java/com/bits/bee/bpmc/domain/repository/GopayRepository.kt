package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.data_source.remote.model.GopayPost
import com.bits.bee.bpmc.data.data_source.remote.model.GopayRefundPost
import com.bits.bee.bpmc.data.data_source.remote.response.GopayRefundResponse
import com.bits.bee.bpmc.data.data_source.remote.response.GopayResponse
import com.bits.bee.bpmc.data.data_source.remote.response.GopayStatusResponse
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import java.math.BigDecimal

/**
 * Created by aldi on 21/10/22
 */
interface GopayRepository {

    fun getGopayStatus( transactionID: String): Flow<Resource<GopayStatusResponse>>

    fun getGopayCancel( transactionID: String): Flow<Resource<GopayStatusResponse>>

    fun postGoPay(gopayPost: GopayPost): Flow<Resource<GopayResponse>>

    fun postGopayRefund(
        transactionID: String,
        goPayRefundPost: GopayRefundPost
    ): Flow<Resource<GopayRefundResponse>>

}