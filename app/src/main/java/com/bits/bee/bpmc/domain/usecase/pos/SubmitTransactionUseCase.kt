package com.bits.bee.bpmc.domain.usecase.pos

import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.domain.repository.SaleRepository
import com.bits.bee.bpmc.domain.repository.SaledRepository
import com.bits.bee.bpmc.domain.usecase.common.GetActiveBranchUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActiveCashierUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActiveOperatorUseCase
import com.bits.bee.bpmc.domain.usecase.common.GetActivePossesUseCase
import com.bits.bee.bpmc.utils.TrxNoGeneratorUtils
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

/**
 * Created by aldi on 20/05/22.
 */
class SubmitTransactionUseCase @Inject constructor(
    private val saleRepository: SaleRepository,
    private val saledRepository: SaledRepository,
    private val getActiveBranchUseCase: GetActiveBranchUseCase,
    private val getActiveCashierUseCase: GetActiveCashierUseCase,
    private val getActiveOperatorUseCase: GetActiveOperatorUseCase,
    private val getActivePossesUseCase: GetActivePossesUseCase,
    private val defDispatcher: CoroutineDispatcher
) {

    suspend operator fun invoke(sale : Sale, saled : List<Saled>) {
        withContext(defDispatcher){
            val branch = getActiveBranchUseCase().first()
            val cashier = getActiveCashierUseCase().first()
            val user = getActiveOperatorUseCase().first()
            val posses = getActivePossesUseCase().first()


            cashier?.let {
                sale.cashierId = it.id
                sale.cashiername = it.cashierName
            }
            user?.let {
                sale.operatorId = it.id
                sale.userName = it.name
            }
            posses?.let {
                sale.possesId = it.possesId!!
                sale.kodePosses = it.trxNo
            }

            sale.trxNo = TrxNoGeneratorUtils.counterNoTrx(1, branch!!, cashier!!)
            sale.trxDate = Date()
            val id = saleRepository.addSale(sale)

            saled.map {
                it.saleId = id.toInt()
            }
            saledRepository.addSaled(saled)
        }
    }

}