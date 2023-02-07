package com.bits.bee.bpmc.data.data_source.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bits.bee.bpmc.data.data_source.local.dao.ItemDao
import com.bits.bee.bpmc.data.data_source.local.model.ItemEntity
import kotlinx.coroutines.delay
import java.math.BigDecimal
import kotlin.math.max

private const val STARTING_KEY = 0
private const val LOAD_DELAY_MILLIS = 3_000L

/**
 * Created by aldi on 04/07/22.
 */
class ItemPagingSource constructor(
    private val itemDao: ItemDao
)  : PagingSource<Int, ItemEntity>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ItemEntity> {
        val page = params.key ?: 0

        return try {
            val entities = itemDao.getItemList()

            // simulate page loading
            if (page != 0) delay(1000)

            LoadResult.Page(
                data = entities,
                prevKey = if (page == 0) null else page - 1,
                nextKey = if (entities.isEmpty()) null else page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ItemEntity>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}
