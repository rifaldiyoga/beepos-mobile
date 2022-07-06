package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.data_source.local.model.DistrictEntity
import com.bits.bee.bpmc.data.data_source.remote.response.DistrictResponse
import com.bits.bee.bpmc.domain.model.District
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

interface DistrictRepository {
//    fun getDitrictList(): Flow<Resource<List<District>>>
    suspend fun insertBulkDistrict(list : List<DistrictEntity>)

    fun getLatestDistrict(page : Int): Flow<Resource<DistrictResponse>>

    fun getDistrictByCode(code: String): Flow<Resource<List<District>>>
}