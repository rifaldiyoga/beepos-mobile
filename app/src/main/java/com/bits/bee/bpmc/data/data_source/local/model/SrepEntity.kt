package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.*
import com.bits.bee.bpmc.data.data_source.local.model.SrepEntity.Companion.TBL_NAME
import java.math.BigDecimal

@Entity(tableName = TBL_NAME,)
data class SrepEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    var id : Int?,
    @ColumnInfo(name = CODE)
    var code: String,
    @ColumnInfo(name = NAME)
    var name: String,
    @ColumnInfo(name = CITY_CODE)
    var cityCode: String?,
    @ColumnInfo(name = ADDRESS)
    var address: String?,
    @ColumnInfo(name = ZIPCODE,)
    var zipCode: String?,
    @ColumnInfo(name = PHONE)
    var phone: String?,
    @ColumnInfo(name = MOBILE)
    var mobile : String?,
    @ColumnInfo(name = EMAIL)
    var email : String?,
) {
    companion object {

        const val TBL_NAME = "srep"

        const val ID = "id"
        const val CODE = "code"
        const val NAME = "name"
        const val CITY_CODE = "city_code"
        const val ADDRESS = "address"
        const val ZIPCODE = "zipcode"
        const val PHONE = "phone"
        const val MOBILE = "mobile"
        const val EMAIL = "email"

    }
}