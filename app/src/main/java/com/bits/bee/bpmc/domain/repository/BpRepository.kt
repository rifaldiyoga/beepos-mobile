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

    fun getBpById(id : Int) : Flow<Bp?>

    fun getFavoritBpList() : Flow<Resource<List<Bp>>>

    fun getlastId(): Flow<Resource<Bp>>

    fun searchBp(query: String): Flow<Resource<List<Bp>>>

    suspend fun addUpdateBp(bpEntity: BpEntity)

    fun getBpByDate(startDate: Long, endDate: Long): Flow<Resource<List<Bp>>>

}