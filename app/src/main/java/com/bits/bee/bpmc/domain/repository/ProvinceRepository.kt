package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.data_source.local.model.ItemGroupEntity
import com.bits.bee.bpmc.data.data_source.local.model.ProvinceEntity
import com.bits.bee.bpmc.data.data_source.remote.response.ItemGroupResponse
import com.bits.bee.bpmc.data.data_source.remote.response.ProvinceResponse
import com.bits.bee.bpmc.domain.model.Province
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

interface ProvinceRepository {
//    fun getProvinceList(): Flow<Resource<List<Province>>>
    suspend fun insertBulkProvince(list : List<ProvinceEntity>)

    fun getLatestProvince(page : Int): Flow<Resource<ProvinceResponse>>
}