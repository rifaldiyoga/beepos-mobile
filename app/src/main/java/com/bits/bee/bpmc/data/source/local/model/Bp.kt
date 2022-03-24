package com.bits.bee.bpmc.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = Bp.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = PriceLvl::class,
            parentColumns = [PriceLvl.ID],
            childColumns = [Bp.PRICELVL_ID],
            onDelete = CASCADE
        )
    ]
)
data class Bp(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    val id : Int,
    @ColumnInfo(name = CODE)
    val code : String,
    @ColumnInfo(name = NAME)
    val name: String,
    @ColumnInfo(name = GREETING)
    val greeting: String,
    @ColumnInfo(name = ANNIVERSARY)
    val anniversary : Boolean,
    @ColumnInfo(name = TAXEDONSALE)
    val isTaxedOnSale : Boolean,
    @ColumnInfo(name = TAXINCONSALE)
    val isTaxIncOnSale : Boolean,
    @ColumnInfo(name = NOTE)
    val note : String,
    @ColumnInfo(name = BPGRP1_ID)
    val bpgrpId : Int,
    @ColumnInfo(name = PRICELVL_ID, index = true)
    val priceLvlId : Int,
    @ColumnInfo(name = ACTIVE)
    val isActive : Boolean,
    @ColumnInfo(name = CREATED_AT)
    val createdAt : Date,
    @ColumnInfo(name = UPDATED_AT)
    val updatedAt : Date,
    @ColumnInfo(name = ISFAVORIT)
    val isFavorit : Boolean,
) {
    companion object {
        const val TBL_NAME = "bp"

        const val ID = "id"
        const val CODE = "code"
        const val NAME = "name"
        const val GREETING = "greeting"
        const val ANNIVERSARY = "anniversary"
        const val TAXEDONSALE = "taxedonsale"
        const val TAXINCONSALE = "taxinconsale"
        const val NOTE = "note"
        const val BPGRP1_ID = "bpgrp1_id"
        const val PRICELVL_ID = "pricelvl_id"
        const val ACTIVE = "active"
        const val CREATED_AT = "created_at"
        const val UPDATED_AT = "updated_at"
        const val ISFAVORIT = "isfavorit"

    }
}