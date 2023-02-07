package com.bits.bee.bpmc.domain.usecase.setting.favorit

import com.bits.bee.bpmc.domain.model.Bp
import com.bits.bee.bpmc.domain.repository.BpRepository
import javax.inject.Inject

/**
 * Created by aldi on 06/10/22
 */
class UpdateFavMemberUseCase @Inject constructor(
    private val bpRepository: BpRepository
) {

    suspend operator fun invoke(bp : Bp) {
        bp.isFavorit = !bp.isFavorit
        bpRepository.addUpdateBp(bp)
    }

}