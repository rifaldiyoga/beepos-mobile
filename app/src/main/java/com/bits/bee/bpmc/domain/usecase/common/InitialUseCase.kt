package com.bits.bee.bpmc.domain.usecase.common

import com.bits.bee.bpmc.domain.repository.InitialRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 13/07/22.
 */
class InitialUseCase @Inject constructor(
    private val initialRepository: InitialRepository
){

    operator fun invoke() : Flow<Resource<Any>>{
        return initialRepository.getInitialData()
    }
}