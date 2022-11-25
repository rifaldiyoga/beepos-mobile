package com.bits.bee.bpmc.domain.repository

import com.bits.bee.bpmc.data.data_source.local.model.ItemGroupEntity
import com.bits.bee.bpmc.domain.model.ItemGroup
import com.bits.bee.bpmc.utils.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by aldi on 30/03/22.
 */
interface ItemGroupRepository {

    suspend fun insertBulkItemGroup(list : List<ItemGroupEntity>)

    fun getLastesItemGroupList(page : Int): Flow<Resource<List<ItemGroup>>>

    fun getActiveItemGroupList() : Flow<List<ItemGroup>>

    fun getById(id: Int) : Flow<ItemGroup>

    fun getItemgrpAddOn() : Flow<ItemGroup?>

    fun getItemgrps(): Flow<List<ItemGroup>>

    suspend fun addItemgrp(itemGroup: ItemGroup, edit: Boolean)

    fun getItgrpByKategori(kategori: String): Flow<ItemGroup>

    fun getItemgrpByUpId(upid: Int): Flow<List<ItemGroup>>

    suspend fun deleteItmgrp(itemGroup: ItemGroup)

}