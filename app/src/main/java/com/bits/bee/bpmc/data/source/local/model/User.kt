package com.bits.bee.bpmc.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = User.TBL_NAME)
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = USERNAME)
    var username : String,
    @ColumnInfo(name = USER_APIKEY)
    var userApiKey: String,
    @ColumnInfo(name = COMPANY_NAME)
    var cmpName : String,
) {
    companion object {
        const val TBL_NAME = "user"

        const val ID = "id"
        const val USERNAME = "username"
        const val USER_APIKEY = "user_apikey"
        const val COMPANY_NAME = "cmp_name"

    }
}