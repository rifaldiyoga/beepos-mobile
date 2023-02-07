package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.Pmtd
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 30/03/22.
 */
interface PmtdRepository {

    fun getLatestPmtdList() : Flow<Resource<List<Pmtd>>>

    fun getActivePmtdList() : Flow<List<Pmtd>>

}