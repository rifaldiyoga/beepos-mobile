package com.bits.bee.bpmc.domain.usecase.upload_manual

import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.domain.repository.SaledRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSaledDeletedItemUseCase @Inject constructor(
    private val saledRepository: SaledRepository
) {
    operator fun invoke(): Flow<List<Saled>>{
        return saledRepository.getSaledDeletedItem()
    }
}