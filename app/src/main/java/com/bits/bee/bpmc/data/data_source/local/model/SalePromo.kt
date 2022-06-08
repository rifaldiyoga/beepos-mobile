package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.*
import java.math.BigDecimal

@Entity(tableName = SalePromo.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = SaleEntity::class,
            parentColumns = [SaleEntity.ID],
            childColumns = [SalePromo.SALE_ID],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = SaledEntity::class,
            parentColumns = [SaledEntity.ID],
            childColumns = [SalePromo.SALED_ID],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Promo::class,
            parentColumns = [Promo.ID],
            childColumns = [SalePromo.PROMO_ID],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = BpEntity::class,
            parentColumns = [BpEntity.ID],
            childColumns = [SalePromo.BP_ID],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class SalePromo(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = SALE_ID, index = true)
    var saleId: Int,
    @ColumnInfo(name = SALENO)
    var saleNo: String,
    @ColumnInfo(name = SALED_ID, index = true)
    var saledId: Int,
    @ColumnInfo(name = PROMO_ID, index = true)
    var promoId: Int,
    @ColumnInfo(name = BP_ID, index = true)
    var bpId: Int,
    @ColumnInfo(name = PROMOQTY)
    var promoQty: BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = PROMOROLE)
    var promoRule : String,
) {
    companion object {
        const val TBL_NAME = "salepromo"

        const val ID = "id"
        const val SALE_ID = "sale_id"
        const val SALENO = "saleno"
        const val SALED_ID = "saled_id"
        const val PROMO_ID = "promo_id"
        const val BP_ID = "bp_id"
        const val PROMOQTY = "promoqty"
        const val PROMOROLE = "promorole"

    }
}