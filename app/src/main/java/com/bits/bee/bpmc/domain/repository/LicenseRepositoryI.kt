package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.source.local.model.License
import com.bits.bee.bpmc.domain.model.Branch
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

interface LicenseRepositoryI {
    fun getBranchList() : Flow<Resource<List<License>>>
}