package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.bits.bee.bpmc.data.data_source.local.model.WhEntity.Companion.TBL_NAME

@Entity(tableName = TBL_NAME)
data class WhEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = CODE)
    var code : String,
    @ColumnInfo(name = NAME)
    var name: String,
    @ColumnInfo(name = ACTIVE)
    var active: Boolean,
) {
    companion object {
        const val TBL_NAME = "wh"

        const val ID = "id"
        const val CODE = "code"
        const val NAME = "name"
        const val ACTIVE = "active"

    }
}