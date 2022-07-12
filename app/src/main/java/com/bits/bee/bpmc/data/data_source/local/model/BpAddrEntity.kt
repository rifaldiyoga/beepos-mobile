package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = BpAddrEntity.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = BpEntity::class,
            parentColumns = [BpEntity.ID],
            childColumns = [BpAddrEntity.BP_ID],
            onDelete = CASCADE
        )
//        ForeignKey(
//            entity = ProvinceEntity::class,
//            parentColumns = [ProvinceEntity.CODE],
//            childColumns = [BpAddrEntity.PROVINCE_CODE],
//            onDelete = CASCADE
//        ),
//        ForeignKey(
//            entity = RegencyEntity::class,
//            parentColumns = [RegencyEntity.CODE],
//            childColumns = [BpAddrEntity.REGENCY_CODE],
//            onDelete = CASCADE
//        )
//        ForeignKey(
//            entity = CityEntity::class,
//            parentColumns = [CityEntity.CODE],
//            childColumns = [BpAddrEntity.CITY_CODE],
//            onDelete = CASCADE
//        ),
//        ForeignKey(
//            entity = DistrictEntity::class,
//            parentColumns = [DistrictEntity.CODE],
//            childColumns = [BpAddrEntity.DISTRICT_CODE],
//            onDelete = CASCADE
//        )
    ]
)
data class BpAddrEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    var id : Int?,
    @ColumnInfo(name = BP_ID, index = true)
    var bpId : Int?,
    @ColumnInfo(name = NAME)
    var name: String,
    @ColumnInfo(name = GREETING)
    var greeting: String,
    @ColumnInfo(name = ADDRESS)
    var address : String,
    @ColumnInfo(name = PHONE)
    var phone : String,
    @ColumnInfo(name = ZIPCODE)
    var zipCode : String,
    @ColumnInfo(name = EMAIL)
    var email : String,
    @ColumnInfo(name = NOTE)
    var note : String,
    @ColumnInfo(name = ISBILLADDR)
    var isBillAddr : Boolean,
    @ColumnInfo(name = ISSHIPADDR)
    var isShipAddr : Boolean,
    @ColumnInfo(name = ISMAINADDR)
    var isMainAddr : Boolean,
    @ColumnInfo(name = PROVINCE_CODE, index = true)
    var provinceCode : String,
    @ColumnInfo(name = REGENCY_CODE, index = true)
    var regencyCode : String,
    @ColumnInfo(name = CITY_CODE, index = true)
    var cityId : Int,
    @ColumnInfo(name = DISTRICT_CODE, index = true)
    var districtCode : String,
//    @ColumnInfo(name = CREATED_AT)
//    var createdAt : Date,
//    @ColumnInfo(name = UPDATED_AT)
//    var updatedAt : Date,
) {
    companion object {
        const val TBL_NAME = "bpaddr"

        const val ID = "id"
        const val BP_ID = "bp_id"
        const val NAME = "name"
        const val GREETING = "greeting"
        const val ADDRESS = "address"
        const val PHONE = "phone"
        const val ZIPCODE = "zipcode"
        const val EMAIL = "email"
        const val NOTE = "note"
        const val ISBILLADDR = "isbilladdr"
        const val ISSHIPADDR = "isshipaddr"
        const val ISMAINADDR = "ismainaddr"
        const val PROVINCE_CODE = "province_code"
        const val REGENCY_CODE = "regency_code"
        const val CITY_CODE = "city_code"
        const val DISTRICT_CODE = "district_code"
        const val CREATED_AT = "created_at"
        const val UPDATED_AT = "updated_at"

    }
}