package com.bits.bee.bpmc.data.data_source.local.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = BrandEntity.TBL_NAME)
data class BrandEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    var id: Int? = null,
    @ColumnInfo(name = CODE)
    var code: String,
    @ColumnInfo(name = NAME)
    var brandName: String,
    @ColumnInfo(name = ACTIVE)
    var active: Boolean
): Parcelable{
    companion object {
        const val TBL_NAME = "brand"

        const val ID = "id"
        const val CODE = "code"
        const val NAME = "name"
        const val ACTIVE = "active"

    }
}