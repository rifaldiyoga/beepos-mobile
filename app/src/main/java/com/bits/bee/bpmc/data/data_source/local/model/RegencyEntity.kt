package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.bits.bee.bpmc.domain.model.Regency

@Entity(tableName = RegencyEntity.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = ProvinceEntity::class,
            parentColumns = [ProvinceEntity.CODE],
            childColumns = [RegencyEntity.PROVINCE_CODE],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class RegencyEntity(
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

    fun toRegency(): Regency{
        return Regency(
            code, name, provinceCode, isActive
        )
    }
}