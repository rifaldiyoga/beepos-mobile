package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.data_source.local.model.CityPopulerEntity
import com.bits.bee.bpmc.data.data_source.local.model.PrinterEntity
import com.bits.bee.bpmc.domain.model.CityPopuler
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

interface CityPopulerRepository {
    suspend fun addCity(cityPopuler: CityPopulerEntity)

    fun getCityPopuler(): Flow<List<CityPopuler>>
}