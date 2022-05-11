package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.LicenseDao
import javax.inject.Inject

class LicenseRepository @Inject constructor(
    private val licDao: LicenseDao
) {
}