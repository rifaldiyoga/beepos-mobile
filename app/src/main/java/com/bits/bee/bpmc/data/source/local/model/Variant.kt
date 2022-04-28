package com.bits.bee.bpmc.data.source.local.model

import androidx.room.*

@Entity(tableName = Variant.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = ItemGroupEntity::class,
            parentColumns = [ItemGroupEntity.ID],
            childColumns = [Variant.ITGRP_ID],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Variant(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = CODE)
    var code : String,
    @ColumnInfo(name = NAME)
    var name: String,
    @ColumnInfo(name = ITGRP_ID, index = true)
    var itgrpId: Int,
    @ColumnInfo(name = PICPATH)
    var picPath : String,
    @ColumnInfo(name = FAVORIT)
    var isFavorit : Boolean,
    @ColumnInfo(name = AVAIABLE)
    var isAvailable : Boolean,
) {
    companion object {
        const val TBL_NAME = "variant"

        const val ID = "id"
        const val CODE = "code"
        const val NAME = "name"
        const val ITGRP_ID = "itgrp_id"
        const val PICPATH = "picpath"
        const val FAVORIT = "isfavorit"
        const val AVAIABLE = "isavailable"


    }
}