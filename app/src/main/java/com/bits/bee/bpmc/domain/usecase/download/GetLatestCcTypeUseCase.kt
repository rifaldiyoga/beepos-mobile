package com.bits.bee.bpmc.domain.usecase.download

import com.bits.bee.bpmc.domain.repository.CcTypeRepository
import javax.inject.Inject

/**
 * Created by aldi on 18/07/22.
 */
class GetLatestCcTypeUseCase @Inject constructor(
    private val ccTypeRepository: CcTypeRepository
){

    operator fun invoke() = ccTypeRepository.getLatestCcTypeList()

}