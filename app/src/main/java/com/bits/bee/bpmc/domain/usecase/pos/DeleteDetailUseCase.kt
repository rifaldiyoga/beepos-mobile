package com.bits.bee.bpmc.domain.usecase.pos

import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.repository.SaledRepository
import javax.inject.Inject

/**
 * Created by aldi on 20/05/22.
 */
class DeleteDetailUseCase @Inject constructor(
    private val saledRepository: SaledRepository,
) {

    suspend operator fun invoke(sale : Sale) {
        saledRepository.deleteSaledBySale(sale.id!!)
    }

}