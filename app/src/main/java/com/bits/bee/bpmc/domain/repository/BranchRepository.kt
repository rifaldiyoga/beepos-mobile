package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 17/03/22.
 */
interface BranchRepository {

    fun getBranchList() : Flow<Resource<List<Branch>>>

    suspend fun updateActiveBranch(branch : Branch)

    fun getActiveBranch() : Flow<Branch?>

    fun getBranchById(id : Int) : Flow<Branch?>
}