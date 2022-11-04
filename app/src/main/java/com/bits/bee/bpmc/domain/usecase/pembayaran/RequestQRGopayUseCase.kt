package com.bits.bee.bpmc.domain.usecase.pembayaran

import com.bits.bee.bpmc.data.data_source.remote.response.GopayResponse
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.domain.repository.GopayRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 21/10/22
 */
class RequestQRGopayUseCase @Inject constructor(
    private val gopayRepository: GopayRepository
){

    operator fun invoke(sale : Sale, saledList : List<Saled>, bp : Bp) : Flow<Resource<GopayResponse>>
            = gopayRepository.postGoPay(sale.trxNo, sale.total.toString(), saledList, bp, sale.rounding)
}