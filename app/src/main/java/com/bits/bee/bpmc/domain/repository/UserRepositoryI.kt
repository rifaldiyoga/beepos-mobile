package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.source.local.model.User

/**
 * Created by aldi on 29/03/22.
 */
interface UserRepositoryI {

    fun getActiveUser() : User?

}