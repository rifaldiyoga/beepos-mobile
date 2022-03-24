package com.bits.bee.bpmc.domain.repository

import androidx.lifecycle.LiveData
import com.bits.bee.bpmc.data.source.remote.response.BranchResponse
import com.bits.bee.bpmc.data.source.remote.response.CashierResponse
import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 17/03/22.
 */

interface CashierRepositoryI {

    fun getCashierList() : LiveData<Resource<CashierResponse>>

}