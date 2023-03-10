package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.data_source.local.model.RegencyEntity
import com.bits.bee.bpmc.data.data_source.remote.response.RegencyResponse
import com.bits.bee.bpmc.domain.model.Regency
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

interface RegencyRepository {
    suspend fun insertBulkRegency(list : List<RegencyEntity>)

    fun getLatestRegency(page : Int): Flow<Resource<RegencyResponse>>

    fun searchRegencyList(q: String): Flow<List<Regency>>

    fun getCodeByRegency(name: String): Flow<Regency?>

    fun getRegencyByCode(code: String): Flow<Regency?>
}