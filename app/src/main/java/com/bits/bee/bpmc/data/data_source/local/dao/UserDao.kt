package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.UserEntity

/**
 * Created by aldi on 23/03/22.
 */

@Dao
interface UserDao : BaseDao<UserEntity>{

    @Query("SELECT * FROM user WHERE active = 1")
    fun geActiveUser() : UserEntity

    @Query("SELECT * FROM user WHERE used = 1")
    fun getDefaultUser() : UserEntity?

    @Query("DELETE FROM user")
    fun deleteAll()

    @Query("SELECT * FROM user WHERE id = :id")
    fun getUserById(id: Int) : UserEntity

    @Query("SELECT * FROM user WHERE pin = :user")
    fun getUserPin(user: String): List<UserEntity>

    @Query("SELECT * FROM user where username = :username AND auth_key LIKE '%'|| :userapi || '%'")
    fun getUserBySecretSauce(username: String, userapi: String): List<UserEntity>

    @Query("UPDATE user SET used = 0")
    suspend fun resetUsed()
}