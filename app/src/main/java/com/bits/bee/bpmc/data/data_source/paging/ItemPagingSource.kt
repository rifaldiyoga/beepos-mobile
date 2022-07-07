package com.bits.bee.bpmc.data.data_source.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bits.bee.bpmc.data.data_source.local.dao.ItemDao
import com.bits.bee.bpmc.data.data_source.local.model.ItemEntity
import javax.inject.Inject

/**
 * Created by aldi on 04/07/22.
 */
//class ItemPagingSource @Inject constructor(
//    private val itemDao: ItemDao
//) : PagingSource<Int, ItemEntity>() {
//
//    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ItemEntity> {
//
//
//
//        return
//    }
//
//    override fun getRefreshKey(state: PagingState<Int, ItemEntity>): Int? {
//    }
//}