package com.bits.bee.bpmc.domain.usecase.pos

import com.bits.bee.bpmc.data.repository.BpRepository
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 26/04/22.
 */
class GetDefaultBpUseCase @Inject constructor(
    private val bpRepository: BpRepository
) {

    operator fun invoke() : Flow<Resource<Bp>> {
        return bpRepository.getDefaultBp()
    }

}