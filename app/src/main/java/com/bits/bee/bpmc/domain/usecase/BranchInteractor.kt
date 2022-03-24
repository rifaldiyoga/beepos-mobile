package com.bits.bee.bpmc.domain.usecase

import androidx.lifecycle.LiveData
import com.bits.bee.bpmc.data.repository.BranchRepository
import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.domain.repository.BranchRepositoryI
import com.bits.bee.bpmc.utils.Resource
import javax.inject.Inject

/**
 * Created by aldi on 22/03/22.
 */
class BranchInteractor @Inject constructor(private val branchRepository: BranchRepository) : BranchRepositoryI {

    override fun getBranchList(): LiveData<Resource<List<Branch>>> = branchRepository.getBranchList()

}