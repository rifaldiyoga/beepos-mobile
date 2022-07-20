package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.*
import androidx.room.ForeignKey.CASCADE
import com.bits.bee.bpmc.domain.model.EdcSurc

data class EdcSurcWithCcTypeEntity(
    @Embedded
    var edcSurc : EdcSurcEntity,
    @Relation(parentColumn = EdcSurcEntity.CCTYPE, entityColumn = CcTypeEntity.CCTYPE)
    var ccType : CcTypeEntity
) {
}