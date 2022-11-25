package com.bits.bee.bpmc.domain.usecase.download

import com.bits.bee.bpmc.domain.model.GrpPrv
import com.bits.bee.bpmc.domain.repository.GrpPrvRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 14/04/22.
 */
class GetLatestGrpPrvUseCase @Inject constructor(private val variantRepository: GrpPrvRepository) {

    operator fun invoke(): Flow<Resource<List<GrpPrv>>> {
        return variantRepository.getLatestGrpPrvList()
    }

}