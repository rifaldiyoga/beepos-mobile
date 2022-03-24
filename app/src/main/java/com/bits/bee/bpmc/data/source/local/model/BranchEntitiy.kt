package com.bits.bee.bpmc.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bits.bee.bpmc.domain.model.Branch

@Entity(tableName = BranchEntitiy.TBL_NAME)
data class BranchEntitiy(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    val id : Int,
    @ColumnInfo(name = CODE)
    val code : String,
    @ColumnInfo(name = NAME)
    val name: String,
    @ColumnInfo(name = VERSION)
    val version: String,
    @ColumnInfo(name = COMPANY_NAME)
    val cmpName : String,
    @ColumnInfo(name = COMPANY_PHONE)
    val cmpPhone : String,
    @ColumnInfo(name = ACTIVE)
    val active : Boolean,
    @ColumnInfo(name = COMPANY_ADDRESS)
    val cmpAddress : String,
    @ColumnInfo(name = COMPANY_FAX)
    val cmpFax : String,
    @ColumnInfo(name = CUST_DEFAULT_ID)
    val custDeftId : Int?,
    @ColumnInfo(name = CREATED_AT)
    val createdAt : Long,
    @ColumnInfo(name = CREATED_BY)
    val createdBy : Int,
    @ColumnInfo(name = UPDATED_AT)
    val updatedAt : Long,
    @ColumnInfo(name = UPDATED_BY)
    val updatedBy : Int,
) {
    companion object {
        const val TBL_NAME = "branch"

        const val ID = "id"
        const val CODE = "code"
        const val NAME = "name"
        const val VERSION = "version"
        const val ACTIVE = "active"
        const val CREATED_AT = "created_at"
        const val CREATED_BY = "created_by"
        const val UPDATED_AT = "updated_at"
        const val UPDATED_BY = "updated_by"
        const val COMPANY_NAME = "cmp_name"
        const val COMPANY_ADDRESS = "cmp_address"
        const val COMPANY_PHONE = "cmp_phone"
        const val COMPANY_FAX = "cmp_fax"
        const val CUST_DEFAULT_ID = "custdeft_id"

    }

    fun toBranch() : Branch {
        return Branch(
            id, code, name, version, cmpName, cmpPhone, active, cmpAddress, cmpFax, custDeftId, createdAt, createdBy, updatedAt, updatedBy
        )
    }
}