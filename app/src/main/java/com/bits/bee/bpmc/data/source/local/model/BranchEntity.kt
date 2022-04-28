package com.bits.bee.bpmc.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bits.bee.bpmc.domain.model.Branch

@Entity(tableName = BranchEntity.TBL_NAME)
data class BranchEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = CODE)
    var code : String,
    @ColumnInfo(name = NAME)
    var name: String,
    @ColumnInfo(name = VERSION)
    var version: String,
    @ColumnInfo(name = COMPANY_NAME)
    var cmpName : String,
    @ColumnInfo(name = COMPANY_PHONE)
    var cmpPhone : String,
    @ColumnInfo(name = ACTIVE)
    var active : Boolean,
    @ColumnInfo(name = COMPANY_ADDRESS)
    var cmpAddress : String,
    @ColumnInfo(name = COMPANY_FAX)
    var cmpFax : String,
    @ColumnInfo(name = CUST_DEFAULT_ID)
    var custDeftId : Int?,
    @ColumnInfo(name = CREATED_AT)
    var createdAt : Long,
    @ColumnInfo(name = CREATED_BY)
    var createdBy : Int,
    @ColumnInfo(name = UPDATED_AT)
    var updatedAt : Long,
    @ColumnInfo(name = UPDATED_BY)
    var updatedBy : Int,
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