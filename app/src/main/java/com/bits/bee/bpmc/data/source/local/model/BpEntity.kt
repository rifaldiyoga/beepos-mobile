package com.bits.bee.bpmc.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = BpEntity.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = PriceLvlEntity::class,
            parentColumns = [PriceLvlEntity.ID],
            childColumns = [BpEntity.PRICELVL_ID],
            onDelete = CASCADE
        )
    ]
)
data class BpEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = CODE)
    var code : String,
    @ColumnInfo(name = NAME)
    var name: String,
    @ColumnInfo(name = GREETING)
    var greeting: String,
    @ColumnInfo(name = ANNIVERSARY)
    var anniversary : String,
    @ColumnInfo(name = TAXEDONSALE)
    var isTaxedOnSale : Boolean,
    @ColumnInfo(name = TAXINCONSALE)
    var isTaxIncOnSale : Boolean,
    @ColumnInfo(name = NOTE)
    var note : String,
    @ColumnInfo(name = BPGRP1_ID)
    var bpgrpId : Int?,
    @ColumnInfo(name = PRICELVL_ID, index = true)
    var priceLvlId : Int,
    @ColumnInfo(name = ACTIVE)
    var isActive : Boolean,
//    @ColumnInfo(name = CREATED_AT)
//    var createdAt : Date,
//    @ColumnInfo(name = UPDATED_AT)
//    var updatedAt : Date,
    @ColumnInfo(name = ISFAVORIT)
    var isFavorit : Boolean = false,
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