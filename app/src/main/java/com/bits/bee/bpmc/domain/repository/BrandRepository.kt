package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.Brand
import kotlinx.coroutines.flow.Flow

interface BrandRepository {
    suspend fun addBrand(brand: Brand, isEdit: Boolean)

    fun getBrandList(): Flow<List<Brand>>

    fun getBrandByName(merk: String): Flow<Brand>

    fun getBrandById(id: Int): Flow<Brand>
}