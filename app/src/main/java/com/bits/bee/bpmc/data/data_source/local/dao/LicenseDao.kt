package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.License
import javax.inject.Singleton

@Singleton
@Dao
interface LicenseDao: BaseDao<License> {
    @Query("SELECT * FROM license")
    fun getLicense() : List<License>
}