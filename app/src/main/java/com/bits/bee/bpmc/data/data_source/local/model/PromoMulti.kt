package com.bits.bee.bpmc.data.data_source.local.model

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
    var id : Int,
    @ColumnInfo(name = PROMO_ID, index = true)
    var promoId : Int,
    @ColumnInfo(name = TYPE)
    var type : String,
    @ColumnInfo(name = VALUE)
    var value : String,
    @ColumnInfo(name = ISREQ)
    var isReq : Boolean,
    @ColumnInfo(name = ISDEAL)
    var isDeal : Boolean,
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