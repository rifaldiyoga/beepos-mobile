package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.domain.model.User
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 22/06/22.
 */
interface UserRepository {

    suspend fun getUser() : Flow<Resource<List<User>>>

    fun getActiveUser() : Flow<User?>

    fun getUserById(id: Int): Flow<User>

    fun getBranchUser(): Flow<Resource<Any>>

    fun getUserPin(user: String): Flow<List<User>>

    fun getUserBySecretSauce(username: String, userapi: String): Flow<Resource<List<User>>>

    suspend fun updateUser(user: User)

    suspend fun resetUsedUser()
}