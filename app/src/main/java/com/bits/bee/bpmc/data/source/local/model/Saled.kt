package com.bits.bee.bpmc.data.source.local.model

import androidx.room.*
import java.math.BigDecimal

@Entity(tableName = Saled.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = Item::class,
            parentColumns = [Item.ID],
            childColumns = [Saled.ITEM_ID],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Sale::class,
            parentColumns = [Sale.ID],
            childColumns = [Saled.SALE_ID],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Saled(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    val id : Int,
    @ColumnInfo(name = ITEM_ID, index = true)
    val itemId : Int,
    @ColumnInfo(name = NAME)
    val name : String,
    @ColumnInfo(name = QTY)
    val qty : BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = LISTPRICE)
    val listPrice : BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = DISC)
    val disc: BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = TAX)
    val tax : BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = DISCEXP)
    val discExp : String,
    @ColumnInfo(name = DISCAMT)
    val discAmt : BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = DISC2AMT)
    val disc2Amt: BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = TAXAMT)
    val taxAmt : BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = BASEPRICE)
    val basePrice : BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = TAXABLEAMT)
    val taxableAmt : BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = SUBTOTAL)
    val subtotal : BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = SALE_ID, index = true)
    val saleId: Int,
    @ColumnInfo(name = DNO)
    val dno : Int,
    @ColumnInfo(name = TOTAL_DISC_AMOUNT)
    val totalDiscAmt : BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = TOTAL_DISC2_AMOUNT)
    val totalDisc2Amt: BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = TOTAL_TAX_AMOUNT)
    val totalTaxAmt : BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = DNOTES)
    val dNotes: String,
//    @Ignore private var isBonus : Boolean = false,
//    @Ignore private var isBonusUsed : Boolean = false,
//    @Ignore private var isDeleted : Boolean = true,
) {
    companion object {
        const val TBL_NAME = "saled"

        const val ID = "id"
        const val ITEM = "item"
        const val ITEM_ID = "item_id"
        const val NAME = "name"
        const val QTY = "qty"
        const val LISTPRICE = "listprice"
        const val DISC = "disc"
        const val TAX = "tax"
        const val DISCEXP = "discexp"
        const val DISCAMT = "discamt"
        const val DISC2AMT = "disc2amt"
        const val TAXAMT = "taxamt"
        const val BASEPRICE = "baseprice"
        const val TAXABLEAMT = "taxableamt"
        const val SUBTOTAL = "subtotal"
        const val SALE_ID = "sale_id"
        const val DNO = "dno"
        const val TOTAL_TAX_AMOUNT = "totaltaxamt"
        const val TOTAL_DISC_AMOUNT = "totaldiscamt"
        const val TOTAL_DISC2_AMOUNT = "totaldisc2amt"
        const val DNOTES = "dnote"
    }
}