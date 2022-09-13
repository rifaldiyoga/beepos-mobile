package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.bits.bee.bpmc.data.data_source.local.model.SyncEntity
import kotlinx.parcelize.Parcelize

@Parcelize
data class Sync(
    var id : Int? = null,
    var trxNo : String ? = null,
    var trxDate: Long? = null,
    var bpId : Int? = null,
    var bpName : String? = null,
    var isUploaded : Boolean = false
): Parcelable