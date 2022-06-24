package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.Operator
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 22/06/22.
 */
interface OperatorRepository {

    suspend fun getOperator() : Flow<Resource<List<Operator>>>

    fun getActiveOperator() : Flow<Operator?>
}