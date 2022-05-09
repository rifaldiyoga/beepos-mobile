package com.bits.bee.bpmc.domain.usecase.download

import com.bits.bee.bpmc.data.repository.BpRepository
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.repository.BpRepositoryI
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 14/04/22.
 */
class GetLatestBpUseCase @Inject constructor(private val bpRepository: BpRepository) : BpRepositoryI {

    override fun getBpList(): Flow<Resource<List<Bp>>> {
        return bpRepository.getLastesBpList()
    }


}