package com.bits.bee.bpmc.data.source.local.model

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
    val code: String,
    @ColumnInfo(name = NAME)
    val name : String,
    @ColumnInfo(name = PROVINCE_CODE, index = true)
    val provinceCode : String,
    @ColumnInfo(name = ACTIVE)
    val isActive : Boolean,
) {
    companion object {
        const val TBL_NAME = "regency"

        const val CODE = "code"
        const val NAME = "name"
        const val PROVINCE_CODE = "province_code"
        const val ACTIVE = "active"

    }
}