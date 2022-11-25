package com.bits.bee.bpmc.domain.usecase.download

import com.bits.bee.bpmc.domain.model.UsrGrp
import com.bits.bee.bpmc.domain.repository.UsrGrpRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 14/04/22.
 */
class GetLatestUsrGrpUseCase @Inject constructor(private val variantRepository: UsrGrpRepository) {

    operator fun invoke(): Flow<Resource<List<UsrGrp>>> {
        return variantRepository.getLatestUsrGrpList()
    }

}