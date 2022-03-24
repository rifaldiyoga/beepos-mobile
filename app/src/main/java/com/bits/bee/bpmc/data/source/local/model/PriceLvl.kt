package com.bits.bee.bpmc.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = PriceLvl.TBL_NAME)
data class PriceLvl(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    val id : Int,
    @ColumnInfo(name = NAME)
    val name: String,
    @ColumnInfo(name = CODE)
    val licNumber : String,
    @ColumnInfo(name = UPDATED_AT)
    val updatedAt : Long,
) {
    companion object {
        const val TBL_NAME = "price_lvl"

        const val ID = "id"
        const val CODE = "code"
        const val NAME = "name"
        const val UPDATED_AT = "updated_at"
    }
}