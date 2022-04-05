package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.source.local.model.Bp
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 17/03/22.
 */

interface BpRepositoryI {

    fun getBpList() : Flow<Resource<List<Bp>>>

}