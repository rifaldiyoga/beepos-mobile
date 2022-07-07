package com.bits.bee.bpmc.domain.model

import androidx.room.ColumnInfo
import com.bits.bee.bpmc.data.data_source.local.model.UserEntity

/**
 * Created by aldi on 22/06/22.
 */
data class User (
    var id : Int,
    var name : String,
    var username : String,
    var userApiKey: String,
    var pin : String,
    var active : Boolean,
)