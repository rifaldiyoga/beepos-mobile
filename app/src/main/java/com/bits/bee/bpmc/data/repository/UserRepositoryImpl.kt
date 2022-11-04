package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.UserDao
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.data.data_source.remote.response.BranchResponse
import com.bits.bee.bpmc.data.data_source.remote.response.BranchUserResponse
import com.bits.bee.bpmc.data.data_source.remote.response.InitialResponse
import com.bits.bee.bpmc.domain.mapper.UserDataMapper
import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.domain.model.User
import com.bits.bee.bpmc.domain.repository.UserRepository
import com.bits.bee.bpmc.utils.ApiResponse
import com.bits.bee.bpmc.utils.NetworkDatabaseBoundResource
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject


/**
 * Created by aldi on 29/03/22.
 */
class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao,
    private val defaultDispatcher: CoroutineDispatcher,
    private val apiUtils: ApiUtils
) : UserRepository {

    override suspend fun getUser(): Flow<Resource<List<User>>> = flow<Resource<List<User>>> {
//        userDao.deleteAll()

    }.flowOn(defaultDispatcher)

    override fun getActiveUser(): Flow<User?> {
        return flow {
            val data = userDao.getDefaultUser()
            emit(data?.let { UserDataMapper.fromDbToDomain(it) })
        }.flowOn(defaultDispatcher)
    }

    override fun getUserById(id: Int): Flow<User> {
        return flow {
            emit(UserDataMapper.fromDbToDomain(userDao.getUserById(id)))
        }.flowOn(defaultDispatcher)
    }

    override fun getBranchUser(): Flow<Resource<Any>> {
        return object : NetworkDatabaseBoundResource<Any, InitialResponse>(){
            override suspend fun loadFormDB(): Any? = Any()

            override fun shouldFetch(data: Any?): Boolean = true

            override suspend fun createCall(): Flow<ApiResponse<InitialResponse>> {
                return apiUtils.getInitialApiService().getInitial()
            }

            override suspend fun saveCallResult(data: InitialResponse) {
                val valdata = data.data
                userDao.insertBulk(valdata.usr.map { UserDataMapper.fromNetworkToDb(it)})
            }

        }.getAsFlow()
    }

    override fun getUserPin(user: String): Flow<List<User>> {
        return flow {
            val data = userDao.getUserPin(user).map { UserDataMapper.fromDbToDomain(it) }
            emit(data)
        }.flowOn(defaultDispatcher)
    }

    override fun getUserBySecretSauce(
        username: String,
        userapi: String
    ): Flow<Resource<List<User>>> {
        return flow {
            val data = userDao.getUserBySecretSauce(username, userapi).map { UserDataMapper.fromDbToDomain(it) }
            emit(Resource.success(data))
        }.flowOn(defaultDispatcher)
    }

    override suspend fun updateUser(user: User) {
        withContext(defaultDispatcher){
            userDao.update(UserDataMapper.fromDomainToDb(user))
        }
    }

    override suspend fun resetUsedUser() {
        withContext(defaultDispatcher){
            userDao.resetUsed()
        }
    }
}