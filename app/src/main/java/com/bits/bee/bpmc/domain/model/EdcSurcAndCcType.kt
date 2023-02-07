package com.bits.bee.bpmc.domain.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.bits.bee.bpmc.data.data_source.local.model.EdcSurcEntity
import kotlinx.parcelize.Parcelize

/**
 * Created by aldi on 17/03/22.
 */
@Parcelize
data class EdcSurcAndCcType (
    var edcSurc: EdcSurc,
    var ccType: CcType
) : Parcelable