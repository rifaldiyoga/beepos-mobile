package com.bits.bee.bpmc.domain.usecase.upload_manual

import com.bits.bee.bpmc.domain.model.Cadj
import com.bits.bee.bpmc.domain.repository.CadjRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCadjByReftypeInOutHaventUploadUseCase @Inject constructor(
   private val cadjRepository: CadjRepository
) {
    operator fun invoke(): Flow<List<Cadj>>{
        return cadjRepository.getCadjByReftypeInOutHaventUpload()
    }
}