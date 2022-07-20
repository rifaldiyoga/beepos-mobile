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

    @Query("SELECT * FROM user WHERE id = 3")
    fun getDefaultUser() : UserEntity

    @Query("DELETE FROM user")
    fun deleteAll()

    @Query("SELECT * FROM user WHERE id = :id")
    fun getUserById(id: Int) : UserEntity

}