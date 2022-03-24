package com.bits.bee.bpmc.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = AddOn.TBL_NAME)
data class AddOn(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    val id : Int,
    @ColumnInfo(name = CODE)
    val code : String,
    @ColumnInfo(name = NAME)
    val name: String,
    @ColumnInfo(name = ISACTIVE)
    val isActive : Boolean,
    @ColumnInfo(name = CREATED_AT)
    val createdAt : Long
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