package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.math.BigDecimal

/**
 * Created by aldi on 30/06/22.
 */
@Entity(tableName = CmpEntity.TBL_NAME)
data class CmpEntity (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    var id : Int?,
    @ColumnInfo(name = CITY_CODE)
    var cityCode : String,
    @ColumnInfo(name = CRC_ID)
    var crcId : Int,
    @ColumnInfo(name = NAME)
    var name : String,
    @ColumnInfo(name = ADDRESS)
    var address : String,
    @ColumnInfo(name = PHONE)
    var phone : String,
    @ColumnInfo(name = FAX)
    var fax : String,
    @ColumnInfo(name = ZIPCODE)
    var zipCode : String,
    @ColumnInfo(name = STARTDATE)
    var startDate : String,
    @ColumnInfo(name = FISCALYEAR)
    var fiscalYear : String,
    @ColumnInfo(name = OWNERNAME)
    var ownerName : String?,
    @ColumnInfo(name = OWNERTAXREGNO)
    var ownerTaxRegNo : String?,
    @ColumnInfo(name = FORMSERNO)
    var formSerno : String,
    @ColumnInfo(name = TAXREGNO)
    var taxRegNo : String,
    @ColumnInfo(name = VATREGNO)
    var vatRegNo : String,
    @ColumnInfo(name = COSSTYPE)
    var cossType : String,
) {

    companion object{
        const val TBL_NAME = "cmp"

        const val ID = "id"
        const val CITY_CODE = "city_code"
        const val CRC_ID = "crc_id"
        const val NAME = "name"
        const val ADDRESS = "address"
        const val PHONE = "phone"
        const val FAX = "fax"
        const val ZIPCODE = "zipcode"
        const val STARTDATE = "startdate"
        const val FISCALYEAR = "fiscalyear"
        const val OWNERNAME = "ownername"
        const val OWNERTAXREGNO = "ownertaxregno"
        const val FORMSERNO = "formserno"
        const val TAXREGNO = "taxregno"
        const val VATREGNO = "vatregno"
        const val VATREGDATE = "vatregdate"
        const val COSSTYPE = "cosstype"
    }

}