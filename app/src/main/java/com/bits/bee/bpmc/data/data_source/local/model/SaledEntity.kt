package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.*
import java.math.BigDecimal

@Entity(tableName = SaledEntity.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = ItemEntity::class,
            parentColumns = [ItemEntity.ID],
            childColumns = [SaledEntity.ITEM_ID],
        ),
        ForeignKey(
            entity = SaleEntity::class,
            parentColumns = [SaleEntity.ID],
            childColumns = [SaledEntity.SALE_ID],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class SaledEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    var id : Int? = null,
    @ColumnInfo(name = ITEM_ID, index = true)
    var itemId : Int = -1,
    @ColumnInfo(name = ITEM_CODE)
    var itemCode : String = "",
    @ColumnInfo(name = NAME)
    var name : String = "",
    @ColumnInfo(name = QTY)
    var qty : BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = LISTPRICE)
    var listPrice : BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = DISC)
    var disc: BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = TAX)
    var tax : BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = DISCEXP)
    var discExp : String = "",
    @ColumnInfo(name = DISCAMT)
    var discAmt : BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = DISC2AMT)
    var disc2Amt: BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = TAXAMT)
    var taxAmt : BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = BASEPRICE)
    var basePrice : BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = TAXABLEAMT)
    var taxableAmt : BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = SUBTOTAL)
    var subtotal : BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = SALE_ID, index = true)
    var saleId: Int = -1,
    @ColumnInfo(name = DNO)
    var dno : Int = -1,
    @ColumnInfo(name = TOTAL_DISC_AMOUNT)
    var totalDiscAmt : BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = TOTAL_DISC2_AMOUNT)
    var totalDisc2Amt: BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = TOTAL_TAX_AMOUNT)
    var totalTaxAmt : BigDecimal = BigDecimal.ZERO,
    @ColumnInfo(name = DNOTES)
    var dNotes: String = "",
    @ColumnInfo(name = CRC_ID)
    var crcId: Int? = -1,
    @ColumnInfo(name = UNIT_ID)
    var unitId: Int? = -1,
    @ColumnInfo(name = CONV)
    var conv: BigDecimal? = BigDecimal.ZERO,
    @ColumnInfo(name = PID)
    var pid: String? = "",
    @Ignore var isBonus : Boolean = false,
    @Ignore var isBonusUsed : Boolean = false,
    @Ignore var isDeleted : Boolean = true,
) {
    companion object {
        const val TBL_NAME = "saled"

        const val ID = "id"
        const val ITEM = "item"
        const val ITEM_ID = "item_id"
        const val ITEM_CODE = "item_code"
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
        const val CRC_ID = "crc_id"
        const val UNIT_ID = "unit_id"
        const val CONV = "conv"
        const val PID = "pid"
    }
}