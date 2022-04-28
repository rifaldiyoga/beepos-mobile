package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.source.remote.response.RegisterResponse
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

interface InfoBisnisRepositoryI {

    fun infoBisnis(namaPerusahaan: String, tipe: String, kota: String, alamat: String): Flow<Resource<RegisterResponse>>

}