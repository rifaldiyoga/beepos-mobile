package com.bits.bee.bpmc.domain.usecase

import androidx.lifecycle.LiveData
import com.bits.bee.bpmc.data.repository.CashierRepository
import com.bits.bee.bpmc.data.source.remote.response.CashierResponse
import com.bits.bee.bpmc.domain.repository.CashierRepositoryI
import com.bits.bee.bpmc.utils.Resource
import javax.inject.Inject

/**
 * Created by aldi on 23/03/22.
 */

class CashierInteractor @Inject constructor(
    private val cashierRepository: CashierRepository
) : CashierRepositoryI {

    override fun getCashierList(): LiveData<Resource<CashierResponse>> {
        return cashierRepository.getCashierList()
    }

}