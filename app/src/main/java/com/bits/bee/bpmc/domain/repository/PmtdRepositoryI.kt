package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.source.local.model.Pmtd
import com.bits.bee.bpmc.data.source.local.model.Tax
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 30/03/22.
 */
interface PmtdRepositoryI {

    fun getPmtdList() : Flow<Resource<List<Pmtd>>>

}