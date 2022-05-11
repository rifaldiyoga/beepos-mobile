package com.bits.bee.bpmc.data.data_source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

@Entity(tableName = AddOnD.TBL_NAME,
    foreignKeys = [
        ForeignKey(
            entity = AddOn::class,
            parentColumns = [AddOn.ID],
            childColumns = [AddOnD.ADDON_ID],
            onDelete = CASCADE
        ),
        ForeignKey(
            entity = Selection::class,
            parentColumns = [Selection.ID],
            childColumns = [AddOnD.SELECTION_ID],
            onDelete = CASCADE
        )
    ]
)
data class AddOnD(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = ID)
    var id : Int,
    @ColumnInfo(name = ADDON_ID, index = true)
    var addOnId: Int,
    @ColumnInfo(name = SELECTION_ID, index = true)
    var selectionId: Int,
    @ColumnInfo(name = IDX)
    var idx : Int,
    @ColumnInfo(name = UPIDX)
    var upIdx : Int,
    @ColumnInfo(name = ISSKIP)
    var isSkip : Boolean,
) {
    companion object {
        const val TBL_NAME = "addond"

        const val ID = "id"
        const val ADDON_ID = "addon_id"
        const val SELECTION_ID = "selection_id"
        const val IDX = "idx"
        const val UPIDX = "addond"
        const val ISSKIP = "isskip"

    }
}