package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.data_source.local.model.PmtdEntity
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 30/03/22.
 */
interface PmtdRepository {

    fun getPmtdList() : Flow<Resource<List<PmtdEntity>>>

}