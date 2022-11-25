package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.bits.bee.bpmc.data.data_source.local.model.GrpPrvEntity
import kotlinx.parcelize.Parcelize
import java.util.*

/**
 * Created by aldi on 17/03/22.
 */
@Parcelize
data class GrpPrv (
    var id : Int?,
    var updatedAt : Date,
    var objCode : String,
    var acsType : String,
    var isEnable : Boolean,
    var acsVal : String?,
    var grpId : Int,
    var codeObj : String,
    var upCode : String,
    var moduleCode : String,
    var nameObj : String,
    var mnemonic : String,
    var level : Int,
) : Parcelable