package com.bits.bee.bpmc.domain.usecase.pilih_cabang

import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.domain.repository.BranchRepository
import javax.inject.Inject

/**
 * Created by aldi on 07/06/22.
 */
class UpdateActiveBranchUseCase @Inject constructor(private val branchRepository: BranchRepository) {

    suspend operator fun invoke(branch : Branch) {
        branchRepository.updateActiveBranch(branch)
    }

}