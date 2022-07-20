package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.UserDao
import com.bits.bee.bpmc.domain.mapper.UserDataMapper
import com.bits.bee.bpmc.domain.model.User
import com.bits.bee.bpmc.domain.repository.UserRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


/**
 * Created by aldi on 29/03/22.
 */
class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao,
    private val defaultDispatcher: CoroutineDispatcher
) : UserRepository {

    override suspend fun getUser(): Flow<Resource<List<User>>> = flow<Resource<List<User>>> {
//        userDao.deleteAll()

    }.flowOn(defaultDispatcher)

    override fun getActiveUser(): Flow<User?> = flow {
        emit(UserDataMapper.fromDbToDomain(userDao.geActiveUser()))
    }. flowOn(defaultDispatcher)

    override fun getDefaultUser(): Flow<Resource<User>> {
        return flow {
            emit(Resource.success(UserDataMapper.fromDbToDomain(userDao.getDefaultUser())))
        }.flowOn(defaultDispatcher)
    }

    override fun getUserById(id: Int): Flow<Resource<User>> {
        return flow {
            emit(Resource.success(UserDataMapper.fromDbToDomain(userDao.getUserById(id))))
        }.flowOn(defaultDispatcher)
    }
}