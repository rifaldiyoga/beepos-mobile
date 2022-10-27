package com.bits.bee.bpmc.domain.usecase.pembayaran

import com.bits.bee.bpmc.data.data_source.remote.response.GopayStatusResponse
import com.bits.bee.bpmc.domain.repository.GopayRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 21/10/22
 */
class CheckPaymentGopayUseCase @Inject constructor(
    private val gopayRepository: GopayRepository
){

    operator fun invoke(transactionId : String) : Flow<Resource<GopayStatusResponse>>
            = gopayRepository.getGopayStatus(transactionId)
}