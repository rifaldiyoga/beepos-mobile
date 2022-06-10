package com.bits.bee.bpmc.domain.usecase.pilih_kasir

import com.bits.bee.bpmc.data.data_source.local.dao.BranchDao
import com.bits.bee.bpmc.domain.mapper.BranchDataMapper
import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.domain.model.Cashier
import com.bits.bee.bpmc.domain.repository.BranchRepository
import com.bits.bee.bpmc.domain.repository.CashierRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by aldi on 23/03/22.
 */

class GetLatestCashierUseCase @Inject constructor(
    private val cashierRepository: CashierRepository,
    private val branchDao: BranchDao,
    private val dispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(): Flow<Resource<List<Cashier>>> {
        var branch : Branch?
        withContext(dispatcher){
            branch = BranchDataMapper.fromDataToDomain(branchDao.getActiveBranch()!!)
        }
        return cashierRepository.getCashierList(branch!!.id)
    }

}