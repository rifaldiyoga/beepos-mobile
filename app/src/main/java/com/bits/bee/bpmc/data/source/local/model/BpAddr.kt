package com.bits.bee.bpmc.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = BpAddr.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = Bp::class,
            parentColumns = [Bp.ID],
            childColumns = [BpAddr.BP_ID],
            onDelete = CASCADE
        ),
        ForeignKey(
            entity = Province::class,
            parentColumns = [Province.CODE],
            childColumns = [BpAddr.PROVINCE_CODE],
            onDelete = CASCADE
        ),
        ForeignKey(
            entity = Regency::class,
            parentColumns = [Regency.CODE],
            childColumns = [BpAddr.REGENCY_CODE],
            onDelete = CASCADE
        ),
        ForeignKey(
            entity = District::class,
            parentColumns = [District.CODE],
            childColumns = [BpAddr.DISTRICT_CODE],
            onDelete = CASCADE
        ),
    ]
)
data class BpAddr(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    val id : Int,
    @ColumnInfo(name = BP_ID, index = true)
    val bpId : Int,
    @ColumnInfo(name = NAME)
    val name: String,
    @ColumnInfo(name = GREETING)
    val greeting: String,
    @ColumnInfo(name = ADDRESS)
    val address : String,
    @ColumnInfo(name = PHONE)
    val phone : String,
    @ColumnInfo(name = ZIPCODE)
    val zipCode : String,
    @ColumnInfo(name = EMAIL)
    val email : String,
    @ColumnInfo(name = ISBILLADDR)
    val isBillAddr : Boolean,
    @ColumnInfo(name = ISSHIPADDR)
    val isShipAddr : Boolean,
    @ColumnInfo(name = ISMAINADDR)
    val isMainAddr : Boolean,
    @ColumnInfo(name = PROVINCE_CODE, index = true)
    val provinceId : String,
    @ColumnInfo(name = REGENCY_CODE, index = true)
    val regencyId : String,
    @ColumnInfo(name = DISTRICT_CODE, index = true)
    val districtId : String,
    @ColumnInfo(name = CREATED_AT)
    val createdAt : Date,
    @ColumnInfo(name = UPDATED_AT)
    val updatedAt : Date,
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
        const val DISTRICT_CODE = "district_code"
        const val CREATED_AT = "created_at"
        const val UPDATED_AT = "updated_at"

    }
}