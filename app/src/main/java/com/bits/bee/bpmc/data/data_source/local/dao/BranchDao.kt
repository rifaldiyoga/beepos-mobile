package com.bits.bee.bpmc.data.data_source.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.bits.bee.bpmc.data.data_source.local.base.BaseDao
import com.bits.bee.bpmc.data.data_source.local.model.BranchEntity
import com.bits.bee.bpmc.domain.model.Branch
import javax.inject.Singleton

/**
 * Created by aldi on 17/03/22.
 */

@Singleton
@Dao
interface BranchDao : BaseDao<BranchEntity>{

    @Query("SELECT * FROM branch")
    fun getBranchList() : List<BranchEntity>

    @Query("UPDATE branch SET active = 0")
    fun resetActive()

    @Query("SELECT * FROM branch WHERE active = 1 LIMIT 1")
    fun getActiveBranch() : BranchEntity?

    @Query("SELECT * FROM branch WHERE id = :branchId")
    fun getBranchById(branchId : Int) : BranchEntity?


}