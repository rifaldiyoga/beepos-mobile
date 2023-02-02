package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = BpEntity.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = PriceLvlEntity::class,
            parentColumns = [PriceLvlEntity.ID],
            childColumns = [BpEntity.PRICELVL_ID],
        )
    ]
)
data class BpEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    var id : Int?,
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
    var note : String = "",
    @ColumnInfo(name = BPGRP1_ID)
    var bpgrpId : Int? = null,
    @ColumnInfo(name = PRICELVL_ID, index = true)
    var priceLvlId : Int,
    @ColumnInfo(name = ACTIVE)
    var isActive : Boolean = true,
    @ColumnInfo(name = CREATED_AT)
    var createdAt : Date = Date(),
    @ColumnInfo(name = CREATED_BY)
    var createdBy : Int = -1,
    @ColumnInfo(name = UPDATED_AT)
    var updatedAt : Date? = null,
    @ColumnInfo(name = UPDATED_BY)
    var updatedBy : Int? = null,
    @ColumnInfo(name = ISFAVORIT)
    var isFavorit : Boolean = false,
    @ColumnInfo(name = ISSELECTED)
    var isSelected : Boolean = false,
    @ColumnInfo(name = STATUS)
    var status : Boolean = false,
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
        const val STATUS = "status"
        const val CREATED_AT = "created_at"
        const val CREATED_BY = "created_by"
        const val UPDATED_AT = "updated_at"
        const val UPDATED_BY = "updated_by"
        const val ISFAVORIT = "isfavorit"
        const val ISSELECTED = "isselected"

    }
}