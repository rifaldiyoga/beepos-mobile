package com.bits.bee.bpmc.domain.usecase.analisa_sesi

import com.bits.bee.bpmc.domain.model.RankItem
import com.bits.bee.bpmc.domain.repository.SaledRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRankItemUseCase @Inject constructor(
    private val saledRepository: SaledRepository
) {
    operator fun invoke(possesId: Int): Flow<List<RankItem>>{
        return saledRepository.getRankItem(possesId)
    }
}