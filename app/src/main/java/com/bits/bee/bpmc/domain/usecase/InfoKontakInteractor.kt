package com.bits.bee.bpmc.domain.usecase

import com.bits.bee.bpmc.data.repository.InfoKontakRepository
import javax.inject.Inject

class InfoKontakInteractor @Inject constructor(
    private val infoKontakRepository: InfoKontakRepository
) {
    fun infoKontak(nama: String, noWA: String, email: String, pass1: String, pass2:String) = infoKontakRepository.infoKontak(
        nama,
        noWA,
        email,
        pass1,
        pass2
    )
}