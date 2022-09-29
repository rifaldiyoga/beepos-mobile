package com.bits.bee.bpmc.domain.usecase.draft

import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.repository.BpRepository
import com.bits.bee.bpmc.domain.repository.ChannelRepository
import com.bits.bee.bpmc.domain.repository.SaleRepository
import com.bits.bee.bpmc.domain.usecase.upload_manual.GetBpByIdUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*
import javax.inject.Inject

/**
 * Created by aldi on 24/06/22.
 */
class GetLatestDraftUseCase @Inject constructor(
    private val saleRepository: SaleRepository,
    private val getBpByIdUseCase : GetBpByIdUseCase,
    private val channelRepository: ChannelRepository,
    private val coroutineDispatcher: CoroutineDispatcher
){

    operator fun invoke() : Flow<List<Sale>> {
        return flow {
            val saleList = saleRepository.getLatestDraftList().first().onEach {
                it.bp = getBpByIdUseCase(it.bpId).first()
//                it.channel = channelRepository.getChannelById(it.channelId).first()
            }
            emit(saleList)
        }.flowOn(coroutineDispatcher)
    }

}