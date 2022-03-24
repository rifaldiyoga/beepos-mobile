package com.bits.bee.bpmc.data.source.local.model

import androidx.room.*

@Entity(tableName = Variant.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = Itemgrp::class,
            parentColumns = [Itemgrp.ID],
            childColumns = [Variant.ITGRP_ID],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Variant(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    val id : Int,
    @ColumnInfo(name = CODE)
    val code : String,
    @ColumnInfo(name = NAME)
    val name: String,
    @ColumnInfo(name = ITGRP_ID, index = true)
    val itgrpId: Int,
    @ColumnInfo(name = PICPATH)
    val picPath : String,
    @ColumnInfo(name = FAVORIT)
    val isFavorit : Boolean,
    @ColumnInfo(name = AVAIABLE)
    val isAvailable : Boolean,
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