package com.bits.bee.bpmc.domain.usecase.upload_manual

import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.repository.PossesRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPossesHaventUploadUseCase @Inject constructor(
    private val possesRepository: PossesRepository
) {
    operator fun invoke(): Flow<Resource<List<Posses>>>{
        return possesRepository.getPossesHaventUpload()
    }
}