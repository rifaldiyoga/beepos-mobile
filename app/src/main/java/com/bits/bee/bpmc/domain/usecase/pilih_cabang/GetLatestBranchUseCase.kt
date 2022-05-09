package com.bits.bee.bpmc.domain.usecase.pilih_cabang

import com.bits.bee.bpmc.data.repository.BranchRepository
import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 22/03/22.
 */
class GetLatestBranchUseCase @Inject constructor(private val branchRepository: BranchRepository) {

    operator fun invoke(): Flow<Resource<List<Branch>>> = branchRepository.getBranchList()

}