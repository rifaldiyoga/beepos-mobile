package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.Cadj
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

interface CadjRepository {
    fun getCadjByReftypeInOutHaventUpload(): Flow<Resource<List<Cadj>>>

    suspend fun updateCadj(cadj: Cadj)
}