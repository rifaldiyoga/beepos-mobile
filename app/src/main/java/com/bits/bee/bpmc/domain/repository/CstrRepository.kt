package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.data_source.local.model.CstrEntity
import com.bits.bee.bpmc.domain.model.Cstr
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 10/06/22.
 */
interface CstrRepository {

    suspend fun addCstr(cstr: CstrEntity)

    suspend fun updateCode(code: String, id: Int)

    fun getLastId(): Flow<Cstr?>
}