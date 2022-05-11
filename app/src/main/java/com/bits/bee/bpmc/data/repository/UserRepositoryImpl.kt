package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.UserDao
import com.bits.bee.bpmc.data.data_source.local.model.User
import javax.inject.Inject

/**
 * Created by aldi on 29/03/22.
 */
class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao
) {

    fun getActiveUser(): User? {
        return userDao.geActiveUser()
    }
}