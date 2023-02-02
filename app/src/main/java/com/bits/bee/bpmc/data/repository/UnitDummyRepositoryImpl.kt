package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.UnitDummyDao
import com.bits.bee.bpmc.data.data_source.local.model.UnitDummyEntity
import com.bits.bee.bpmc.domain.mapper.UnitDummyDummyDataMapper
import com.bits.bee.bpmc.domain.model.UnitDummy
import com.bits.bee.bpmc.domain.repository.UnitDummyRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

/**
 * Created by aldi on 30/03/22.
 */
class UnitDummyRepositoryImpl @Inject constructor(
    private val unitDummyDao: UnitDummyDao,
    private val ioDispatcher: CoroutineDispatcher
) : UnitDummyRepository{
    override suspend fun addUpdate(unitDummyEntity: UnitDummyEntity, edit: Boolean) {
        withContext(ioDispatcher){
            unitDummyDao.insertSingle(unitDummyEntity)
//            if (edit){
//                unitDummyDao.update(unitDummyEntity)
//            }else{
//                unitDummyDao.insertSingle(unitDummyEntity)
//            }
        }
    }

    override fun getUnitByItemId(id: Int): Flow<List<UnitDummy>> {
        return flow {
            val data = unitDummyDao.getUnitByItemId(id).map { UnitDummyDummyDataMapper.fromDbToDomain(it) }
            emit(data)
        }.flowOn(ioDispatcher)
    }

    override suspend fun deleteByItem(id: Int) {
        withContext(ioDispatcher){
            unitDummyDao.deleteByItem(id)
        }
    }

}