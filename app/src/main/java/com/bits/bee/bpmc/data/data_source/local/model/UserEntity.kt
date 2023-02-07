package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = UserEntity.TBL_NAME)
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = NAME)
    var name : String,
    @ColumnInfo(name = USERNAME)
    var username : String,
    @ColumnInfo(name = AUTH_KEY)
    var userApiKey: String? = null,
    @ColumnInfo(name = PIN)
    var pin : String?,
    @ColumnInfo(name = ACTIVE)
    var active : Boolean,
    @ColumnInfo(name = USED)
    var used : Boolean = false,
) {
    companion object {
        const val TBL_NAME = "user"

        const val ID = "id"
        const val USERNAME = "username"
        const val NAME = "name"
        const val AUTH_KEY = "auth_key"
        const val PIN = "pin"
        const val ACTIVE = "active"
        const val USED = "used"

    }
}