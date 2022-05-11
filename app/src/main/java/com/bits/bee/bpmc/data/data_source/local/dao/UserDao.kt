package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.User

/**
 * Created by aldi on 23/03/22.
 */

@Dao
interface UserDao : BaseDao<User>{

    @Query("SELECT * FROM user")
    fun geActiveUser() : User?


}