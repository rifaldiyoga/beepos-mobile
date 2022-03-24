package com.bits.bee.bpmc.data.source.local.model

import androidx.room.*

@Entity(tableName = PromoMulti.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = Promo::class,
            parentColumns = [Promo.ID],
            childColumns = [PromoMulti.PROMO_ID],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class PromoMulti(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    val id : Int,
    @ColumnInfo(name = PROMO_ID, index = true)
    val promoId : Int,
    @ColumnInfo(name = TYPE)
    val type : String,
    @ColumnInfo(name = VALUE)
    val value : String,
    @ColumnInfo(name = ISREQ)
    val isReq : Boolean,
    @ColumnInfo(name = ISDEAL)
    val isDeal : Boolean,
) {
    companion object {
        const val TBL_NAME = "promomulti"

        const val ID = "id"
        const val PROMO_ID = "promo_id"
        const val TYPE = "type"
        const val VALUE = "value"
        const val ISREQ = "isreq"
        const val ISDEAL = "isdeal"

    }
}