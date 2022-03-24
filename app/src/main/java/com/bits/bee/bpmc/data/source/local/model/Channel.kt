package com.bits.bee.bpmc.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = Channel.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = PriceLvl::class,
            parentColumns = [PriceLvl.ID],
            childColumns = [Channel.PRICELVL_ID]
        )
    ]
)
data class Channel(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    val id : Int,
    @ColumnInfo(name = CODE)
    val code : String,
    @ColumnInfo(name = NAME)
    val name: String,
    @ColumnInfo(name = ACTIVE)
    val active: Boolean,
    @ColumnInfo(name = IS_POS)
    val isPos : Boolean,
    @ColumnInfo(name = CREATED_BY)
    val createdBy : Int,
    @ColumnInfo(name = CREATED_AT)
    val createdAt : Long,
    @ColumnInfo(name = UPDATED_BY)
    val updatedBy : Int,
    @ColumnInfo(name = UPDATED_AT)
    val updatedAt : Long,
    @ColumnInfo(name = COLOR)
    val color : String,
    @ColumnInfo(name = PRICELVL_ID, index = true)
    val priceLvlId : Int,
) {
    companion object {
        const val TBL_NAME = "channel"

        const val ID = "id"
        const val CODE = "code"
        const val NAME = "name"
        const val ACTIVE = "active"
        const val IS_POS = "ispos"
        const val CREATED_BY = "created_by"
        const val CREATED_AT = "created_at"
        const val UPDATED_BY = "updated_by"
        const val UPDATED_AT = "updated_at"
        const val COLOR = "color"
        const val PRICELVL_ID = "pricelvl_id"
    }
}