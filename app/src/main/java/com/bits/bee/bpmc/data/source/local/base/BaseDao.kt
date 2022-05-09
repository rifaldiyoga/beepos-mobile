package com.bits.bee.bpmc.data.source.local.base

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE

@Dao
interface BaseDao<T> {

    @Insert(onConflict = REPLACE)
    suspend fun insertBulk(listEntity: List<T>?)

    @Insert(onConflict = REPLACE)
    suspend fun insertSingle(entity: T): Long

    @Update
    fun update(entity: T)

    @Delete
    fun deleteBulk(listEntity: List<T>?)

    @Delete
    fun delete(entity: T)

}