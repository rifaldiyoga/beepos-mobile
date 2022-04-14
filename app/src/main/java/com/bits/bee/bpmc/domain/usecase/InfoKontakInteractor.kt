package com.bits.bee.bpmc.domain.usecase

import com.bits.bee.bpmc.data.repository.InfoKontakRepository
import javax.inject.Inject

class RegisterInteractor @Inject constructor(
    private val infoKontakRepository: InfoKontakRepository
) {
    fun infoKontak(nama: String, noWA: Int, email: String, pass1, pass2) = infoKontakRepository
}