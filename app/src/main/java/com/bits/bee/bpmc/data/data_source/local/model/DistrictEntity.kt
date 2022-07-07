package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = DistrictEntity.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = RegencyEntity::class,
            parentColumns = [RegencyEntity.CODE],
            childColumns = [DistrictEntity.REGENCY_CODE],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class DistrictEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = CODE)
    var code: String,
    @ColumnInfo(name = NAME)
    var name : String,
    @ColumnInfo(name = REGENCY_CODE, index = true)
    var regencyCode : String,
    @ColumnInfo(name = ACTIVE)
    var isActive : Boolean,
) {
    companion object {
        const val TBL_NAME = "district"

        const val CODE = "code"
        const val NAME = "name"
        const val REGENCY_CODE = "regency_code"
        const val ACTIVE = "active"

    }
}