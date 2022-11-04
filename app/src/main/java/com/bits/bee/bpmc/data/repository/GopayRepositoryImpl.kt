package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.model.GopayPost
import com.bits.bee.bpmc.data.data_source.remote.model.GopayRefundPost
import com.bits.bee.bpmc.data.data_source.remote.response.GopayRefundResponse
import com.bits.bee.bpmc.data.data_source.remote.response.GopayResponse
import com.bits.bee.bpmc.data.data_source.remote.response.GopayStatusResponse
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.domain.repository.GopayRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.NetworkBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import java.math.BigDecimal
import java.math.RoundingMode
import javax.inject.Inject

/**
 * Created by aldi on 20/05/22.
 */
class GopayRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils
) : GopayRepository {

    override fun getGopayStatus(transactionID: String): Flow<Resource<GopayStatusResponse>> {
        return object : NetworkBoundResource<GopayStatusResponse>(){
            override fun createCall(): Flow<ApiResponse<GopayStatusResponse>> {
                return apiUtils.getGopayApiService().getGopayStatus(transactionID)
            }
        }.getAsFlow()
    }

    override fun getGopayCancel(transactionID: String): Flow<Resource<GopayStatusResponse>> {
        return object : NetworkBoundResource<GopayStatusResponse>(){
            override fun createCall(): Flow<ApiResponse<GopayStatusResponse>> {
                return apiUtils.getGopayApiService().getGopayCancel(transactionID)
            }
        }.getAsFlow()
    }

    override fun postGoPay(
        gopayPost : GopayPost
    ): Flow<Resource<GopayResponse>> {
        return object : NetworkBoundResource<GopayResponse>(){
            override fun createCall(): Flow<ApiResponse<GopayResponse>> {
                return apiUtils.getGopayApiService().postGoPay(gopayPost)
            }
        }.getAsFlow()
    }


    override fun postGopayRefund(
        transactionID: String,
        goPayRefundPost: GopayRefundPost
    ): Flow<Resource<GopayRefundResponse>> {
        return object : NetworkBoundResource<GopayRefundResponse>(){
            override fun createCall(): Flow<ApiResponse<GopayRefundResponse>> {
                return apiUtils.getGopayApiService().postGopayRefund(transactionID, goPayRefundPost)
            }
        }.getAsFlow()
    }


}