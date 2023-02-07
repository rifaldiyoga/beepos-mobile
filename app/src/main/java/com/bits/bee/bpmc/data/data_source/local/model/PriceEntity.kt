package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.math.BigDecimal

@Entity(tableName = PriceEntity.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = PriceLvlEntity::class,
            parentColumns = [PriceLvlEntity.ID],
            childColumns = [PriceEntity.PRICELVL_ID]
        )
    ]
)
data class PriceEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    var id : Int? = null,
    @ColumnInfo(name = ITEM_ID, index = true)
    var itemId: Int,
    @ColumnInfo(name = PRICELVL_ID, index = true)
    var priceLvlId: Int,
    @ColumnInfo(name = PRICE1)
    var price1: BigDecimal,
    @ColumnInfo(name = DISCEXP1)
    var discExp1: String?,
    @ColumnInfo(name = PRICE2)
    var price2: BigDecimal,
    @ColumnInfo(name = DISCEXP2)
    var discExp2: String?,
    @ColumnInfo(name = PRICE3)
    var price3: BigDecimal,
    @ColumnInfo(name = DISCEXP3)
    var discExp3: String?,
    @ColumnInfo(name = CRC_ID)
    var crcId: Int,
    @ColumnInfo(name = CRC_SYMBOL)
    var crcSymbol: String,
) {
    companion object {
        const val TBL_NAME = "price"

        const val ID = "id"
        const val ITEM_ID = "itemid"
        const val PRICE1 = "price1"
        const val DISCEXP1 = "discexp1"
        const val PRICE2 = "price2"
        const val DISCEXP2 = "discexp2"
        const val PRICE3 = "price3"
        const val DISCEXP3 = "discexp3"
        const val PRICELVL_ID = "pricelvl_id"
        const val CRC_ID = "crc_id"
        const val CRC_SYMBOL = "crc_symbol"
        const val LASTSYNC = "last_sync"

    }
}