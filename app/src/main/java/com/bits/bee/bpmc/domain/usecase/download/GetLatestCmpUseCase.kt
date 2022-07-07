package com.bits.bee.bpmc.domain.usecase.download

import com.bits.bee.bpmc.domain.model.Cmp
import com.bits.bee.bpmc.domain.repository.CmpRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 26/04/22.
 */
class GetLatestCmpUseCase @Inject constructor(
    private val cmpRepository: CmpRepository
) {

    operator fun invoke() : Flow<Resource<Cmp>>{
        return cmpRepository.getLatestCmp()
    }

}