package com.bits.bee.bpmc.domain.usecase

import com.bits.bee.bpmc.data.repository.BranchRepository
import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.domain.repository.BranchRepositoryI
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by aldi on 22/03/22.
 */
class BranchInteractor @Inject constructor(private val branchRepository: BranchRepository) : BranchRepositoryI {

    override fun getBranchList(): Flow<Resource<List<Branch>>> = branchRepository.getBranchList()

}