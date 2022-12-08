package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.BrandDao
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.domain.mapper.BrandDataMapper
import com.bits.bee.bpmc.domain.model.Brand
import com.bits.bee.bpmc.domain.repository.BrandRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BrandRepositoryImpl @Inject constructor(
    private val apiUtils: ApiUtils,
    private val brandDao: BrandDao,
    private val ioDispatcher: CoroutineDispatcher
): BrandRepository {
    override suspend fun addBrand(brand: Brand, isEdit: Boolean) {
        withContext(ioDispatcher){
            if (isEdit){
                brandDao.update(BrandDataMapper.fromDomainToDb(brand))
            }else{
                brandDao.insertSingle(BrandDataMapper.fromDomainToDb(brand))
            }
        }
    }

    override fun getBrandList(): Flow<List<Brand>> {
        return flow {
            val data = brandDao.getBrandList().map { BrandDataMapper.fromDbToDomain(it) }
            emit(data)
        }.flowOn(ioDispatcher)
    }

    override fun getBrandByName(merk: String): Flow<Brand> {
        return flow {
            val data = brandDao.getBrandByName(merk)
            emit(BrandDataMapper.fromDbToDomain(data))
        }.flowOn(ioDispatcher)
    }

    override fun getBrandById(id: Int): Flow<Brand> {
        return flow {
            val data = brandDao.getBrandById(id)
            emit(BrandDataMapper.fromDbToDomain(data))
        }.flowOn(ioDispatcher)
    }

    override suspend fun deleteMerk(brand: Brand) {
        withContext(ioDispatcher){
            brandDao.delete(BrandDataMapper.fromDomainToDb(brand))
        }
    }

    override fun getLastBrand(): Flow<Brand?> {
        return flow {
            val data = brandDao.getLastBrand()
            emit(data?.let { BrandDataMapper.fromDbToDomain(it) })
        }.flowOn(ioDispatcher)
    }
}