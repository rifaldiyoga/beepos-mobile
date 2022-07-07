package com.bits.bee.bpmc.domain.mapper

import com.bits.bee.bpmc.data.data_source.local.model.UserEntity
import com.bits.bee.bpmc.domain.model.User

/**
 * Created by aldi on 22/06/22.
 */
object UserDataMapper : BaseMapper<UserEntity, User>(){

    override fun fromDataToDomain(model: UserEntity): User {
        return User(
            id = model.id,
            name = model.name,
            username = model.username,
            userApiKey = model.userApiKey,
            pin = model.pin,
            active = model.active,
        )
    }

    override fun fromDomainToData(model: User): UserEntity {
        return UserEntity(
            id = model.id,
            name = model.name,
            username = model.username,
            userApiKey = model.userApiKey,
            pin = model.pin,
            active = model.active,
        )
    }

}