package com.bits.bee.bpmc.data.repository

import com.bits.bee.bpmc.data.data_source.local.dao.ItemSaleTaxDao
import com.bits.bee.bpmc.data.data_source.remote.ApiUtils
import com.bits.bee.bpmc.domain.model.ItemSaleTax
import com.bits.bee.bpmc.domain.repository.ItemSaleTaxRepository
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Created by aldi on 20/05/22.
 */
class ItemSaleTaxRepositoryImpl @Inject constructor(
    private val defaultDispatcher: CoroutineDispatcher,
    private val itemSaleTaxDao: ItemSaleTaxDao,
    private val apiUtils: ApiUtils
) : ItemSaleTaxRepository {

    override fun getLatestItemSaleTax(): Flow<Resource<List<ItemSaleTax>>> {
        return flow {
//            emit()
        }
    }


}