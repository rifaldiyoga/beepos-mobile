package com.bits.bee.bpmc.domain.usecase.pilih_kasir

import com.bits.bee.bpmc.data.data_source.remote.model.CashierPost
import com.bits.bee.bpmc.data.data_source.remote.response.CashierStatusResponse
import com.bits.bee.bpmc.domain.model.Cashier
import com.bits.bee.bpmc.domain.model.License
import com.bits.bee.bpmc.domain.repository.CashierRepository
import com.bits.bee.bpmc.domain.usecase.common.GetActiveLicenseUseCase
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import javax.inject.Inject

/**
 * Created by aldi on 07/06/22.
 */
class DetachCashierUseCase @Inject constructor(
    private val cashierRepository: CashierRepository,
    private val getActiveLicenseUseCase: GetActiveLicenseUseCase
) {

    suspend operator fun invoke(cashier: Cashier, deviceName : String) : Flow<Resource<CashierStatusResponse>>{

        val license : License = getActiveLicenseUseCase().first() ?: throw Exception("No Active License!")

        val cashierPost = CashierPost(
            cashierid = cashier.id,
            serial_number = license.licNumber,
        )

        return cashierRepository.detachActivateCashier(cashierPost)
    }
}