package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.Cmp
import com.bits.bee.bpmc.domain.model.Edc
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 30/06/22.
 */
interface EdcRepository {

    fun getLatestEdc() : Flow<Resource<List<Edc>>>

    fun getActiveEdcList(branchId : Int) : Flow<List<Edc>>

}