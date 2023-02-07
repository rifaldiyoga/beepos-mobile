package com.bits.bee.bpmc.domain.usecase.common

import com.bits.bee.bpmc.data.data_source.remote.model.MonitCashierPost
import com.bits.bee.bpmc.domain.repository.CashierRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import okhttp3.RequestBody
import okhttp3.ResponseBody
import javax.inject.Inject

/**
 * Created by aldi on 06/09/22
 */
class PostMonitCashierUseCase @Inject constructor(
    private val cashierRepository: CashierRepository
){

    suspend operator fun invoke(lastDownload : String = "", lastUpload : String = "") : Flow<Resource<ResponseBody>> {

        val licensePost = MonitCashierPost(
            cashierId = cashierRepository.getActiveCashier().first()?.code.toString(),
            lastDowndate = lastDownload,
            lastSyncdate = lastUpload
        )

        return cashierRepository.postMonitCashier(licensePost)
    }

}