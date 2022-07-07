package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = AddOnEntity.TBL_NAME)
data class AddOnEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = CODE)
    var code : String,
    @ColumnInfo(name = NAME)
    var name: String,
    @ColumnInfo(name = ISACTIVE)
    var isActive : Boolean,
    @ColumnInfo(name = CREATED_AT)
    var createdAt : Long
) {
    companion object {
        const val TBL_NAME = "addon"

        const val ID = "id"
        const val CODE = "code"
        const val NAME = "name"
        const val ISACTIVE = "is_active"
        const val CREATED_AT = "created_at"

    }
}