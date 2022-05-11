package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.data_source.local.model.BpEntity
import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 17/03/22.
 */

interface BpRepository {

    fun getLastesBpList() : Flow<Resource<List<Bp>>>

    fun getDefaultBp() : Flow<Resource<Bp>>

    fun getFavoritBpList() : Flow<Resource<List<Bp>>>

    suspend fun addUpdateBp(bpEntity: BpEntity)

}