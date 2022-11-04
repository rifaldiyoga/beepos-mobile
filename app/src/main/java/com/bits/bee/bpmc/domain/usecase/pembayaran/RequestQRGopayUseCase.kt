package com.bits.bee.bpmc.domain.usecase.pembayaran

import com.bits.bee.bpmc.data.data_source.remote.model.GopayPost
import com.bits.bee.bpmc.data.data_source.remote.response.GopayResponse
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.domain.repository.GopayRepository
import com.bits.bee.bpmc.domain.usecase.common.GetRegUseCase
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import java.math.BigDecimal
import java.math.RoundingMode
import javax.inject.Inject

/**
 * Created by aldi on 21/10/22
 */
class RequestQRGopayUseCase @Inject constructor(
    private val gopayRepository: GopayRepository,
    private val getRegUseCase: GetRegUseCase
){

    suspend operator fun invoke(sale : Sale, saledList : List<Saled>, bp : Bp) : Flow<Resource<GopayResponse>> {

        val reg = getRegUseCase(BPMConstants.REG_ROUND).first()
        val roundVal = 0

        val itemDetailList = saledList.map {
            GopayPost.ItemDetail(
                id = it.itemId,
                quantity = it.qty.toString(),
                price = ((it.subtotal / it.qty).setScale(roundVal, RoundingMode.HALF_UP) + (it.totalTaxAmt / it.qty).setScale(roundVal, RoundingMode.HALF_UP) - (it.totalDisc2Amt / it.qty).setScale(roundVal, RoundingMode.HALF_UP)).setScale(roundVal, RoundingMode.HALF_UP).toString(),
                name = it.name
            )
        }.toMutableList()

        if(sale.rounding > BigDecimal.ZERO){
            itemDetailList.add(
                GopayPost.ItemDetail(
                    id = 0,
                    quantity = "1",
                    price = sale.rounding.toString(),
                    name = BPMConstants.BPM_TYPE_ROUNDING
                )
            )
        }

        val gopayPost = GopayPost(
            order_id = sale.trxNo,
            item_details = itemDetailList,
            total = sale.total.setScale(roundVal, RoundingMode.HALF_UP).toString(),
            customer_detail = GopayPost.CustomerDetails(bp.name, "", bp.bpAddr?.email ?: "", bp.bpAddr?.phone ?: "")
        )
        return gopayRepository.postGoPay(gopayPost)
    }
}