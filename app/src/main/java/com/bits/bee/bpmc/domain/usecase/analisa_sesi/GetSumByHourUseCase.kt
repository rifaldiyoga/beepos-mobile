package com.bits.bee.bpmc.domain.usecase.analisa_sesi

import com.bits.bee.bpmc.data.data_source.remote.model.LineChartData
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.domain.repository.SaleRepository
import com.github.mikephil.charting.data.Entry
import kotlinx.coroutines.flow.first
import java.sql.SQLException
import javax.inject.Inject

class GetSumByHourUseCase @Inject constructor(
    private val saleRepository: SaleRepository
) {
    suspend operator fun invoke(posses: Posses): ArrayList<Entry>?{
        var maxQty = 0f
        val arrayList = ArrayList<Entry>()
        for (i in 0..23) {
            try {
                val chartData = saleRepository.sumQtyByHour(posses.possesId!!, String.format("%02d", i)).first()
                val qty: Float = if (chartData != null) chartData.qty!!.toFloat() else 0f
                if (qty > maxQty) maxQty = qty
                arrayList.add(Entry(i.toFloat(), qty))
            } catch (e: SQLException) {
                e.printStackTrace()
            }
        }
        var isEmpty = true
        for (entry in arrayList) {
            if (entry.y > 0) {
                isEmpty = false
                break
            }
        }
        return if (isEmpty) null else arrayList
    }
}