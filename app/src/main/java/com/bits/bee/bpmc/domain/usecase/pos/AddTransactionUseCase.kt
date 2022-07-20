package com.bits.bee.bpmc.domain.usecase.pos

import com.bits.bee.bpmc.domain.model.Sale
import com.bits.bee.bpmc.domain.model.Saled
import com.bits.bee.bpmc.domain.repository.SaleRepository
import com.bits.bee.bpmc.domain.repository.SaledRepository
import com.bits.bee.bpmc.domain.usecase.common.*
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.TrxNoGeneratorUtils
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

/**
 * Created by aldi on 20/05/22.
 */
class AddTransactionUseCase @Inject constructor(
    private val saleRepository: SaleRepository,
    private val saledRepository: SaledRepository,
    private val getActiveBranchUseCase: GetActiveBranchUseCase,
    private val getActiveCashierUseCase: GetActiveCashierUseCase,
    private val getActiveOperatorUseCase: GetActiveOperatorUseCase,
    private val getActivePossesUseCase: GetActivePossesUseCase,
    private val addCashAUseCase: AddCashAUseCase,
    private val addTotalPossesUseCase: AddTotalPossesUseCase,
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
            } ?: throw Exception("")

            sale.trxNo = TrxNoGeneratorUtils.counterNoTrx(1, branch!!, cashier!!)
            sale.trxDate = Date()
            val id = saleRepository.addSale(sale)

            saled.map {
                it.saleId = id.toInt()
            }
            saledRepository.addSaled(saled)

            addCashAUseCase(
                refId = id,
                refType = BPMConstants.SALE,
                cashId = posses?.possesId ?: throw Exception(""),
                cashierId = cashier.id,
                userId = user?.id ?: throw Exception(""),
                amt = sale.total
            )
            addTotalPossesUseCase(
                amt = sale.total
            )
        }
    }

}