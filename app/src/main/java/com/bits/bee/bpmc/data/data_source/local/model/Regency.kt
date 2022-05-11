package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = Regency.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = Province::class,
            parentColumns = [Province.CODE],
            childColumns = [Regency.PROVINCE_CODE],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Regency(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = CODE)
    var code: String,
    @ColumnInfo(name = NAME)
    var name : String,
    @ColumnInfo(name = PROVINCE_CODE, index = true)
    var provinceCode : String,
    @ColumnInfo(name = ACTIVE)
    var isActive : Boolean,
) {
    companion object {
        const val TBL_NAME = "regency"

        const val CODE = "code"
        const val NAME = "name"
        const val PROVINCE_CODE = "province_code"
        const val ACTIVE = "active"

    }
}