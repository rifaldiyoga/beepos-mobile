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
        trxNo : String,
        total : String,
        saledList: List<Saled>,
        bp: Bp,
        rounding: BigDecimal?
    ): Flow<Resource<GopayResponse>> {
        return object : NetworkBoundResource<GopayResponse>(){
            override fun createCall(): Flow<ApiResponse<GopayResponse>> {
                val itemDetailList = saledList.map {
                    GopayPost.ItemDetail(
                        id = it.itemId,
                        quantity = it.qty.toString(),
                        price = ((it.subtotal / it.qty).setScale(0, RoundingMode.HALF_DOWN) + (it.totalTaxAmt / it.qty).setScale(0, RoundingMode.HALF_DOWN) - (it.totalDisc2Amt / it.qty).setScale(0, RoundingMode.HALF_DOWN)).setScale(0, RoundingMode.HALF_DOWN).toString(),
                        name = it.name
                    )
                }.toMutableList()

                if((rounding ?: BigDecimal.ZERO) > BigDecimal.ZERO){
                    itemDetailList.add(
                        GopayPost.ItemDetail(
                            id = 0,
                            quantity = "1",
                            price = rounding.toString(),
                            name = BPMConstants.BPM_TYPE_ROUNDING
                        )
                    )
                }

                val gopayPost = GopayPost(
                    order_id = trxNo,
                    item_details = itemDetailList,
                    total = total,
                    customer_detail = GopayPost.CustomerDetails(bp.name, "", bp.bpAddr?.email ?: "", bp.bpAddr?.phone ?: "")
                )

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