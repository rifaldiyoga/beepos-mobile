package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.source.remote.response.RegisterResponse
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

interface InfoKontakRepositoryI {

    fun infoKontak(nama: String, noWA: String, email: String, pass1: String, pass2: String): Flow<Resource<RegisterResponse>>

}