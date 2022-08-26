package com.bits.bee.bpmc.domain.usecase.upload_manual

import com.bits.bee.bpmc.domain.model.Cstr
import com.bits.bee.bpmc.domain.repository.CstrRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCstrByReftypeHaventUpload @Inject constructor(
    private var cstrRepository: CstrRepository
) {
    operator fun invoke(): Flow<Resource<List<Cstr>>>{
        return cstrRepository.getCstrByReftypeHaventUpload()
    }
}