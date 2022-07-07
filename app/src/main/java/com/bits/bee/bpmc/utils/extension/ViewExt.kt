package com.bits.bee.bpmc.utils.extension

import android.content.Context
import android.util.TypedValue
import android.view.View
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by aldi on 01/03/22.
 */

fun View.visible(){
    visibility = View.VISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun <T> List<T>.mapButReplace(targetItem: T, newItem: T) = map {
    if (it == targetItem) {
        newItem
    } else {
        it
    }
}

@ColorInt
fun Context.getColorFromAttr(
    @AttrRes attrColor: Int,
    typedValue: TypedValue = TypedValue(),
    resolveRefs: Boolean = true
): Int {
    theme.resolveAttribute(attrColor, typedValue, resolveRefs)
    return typedValue.data
}

fun CombinedLoadStates.decideOnState(
    adapter : PagingDataAdapter<Any, RecyclerView.ViewHolder>,
    showLoading: (Boolean) -> Unit,
    showEmptyState: (Boolean) -> Unit,
    showError: (String) -> Unit
) {
    showLoading(refresh is LoadState.Loading)

    showEmptyState(
        source.append is LoadState.NotLoading
                && source.append.endOfPaginationReached
                && adapter.itemCount == 0
    )

    val errorState = source.append as? LoadState.Error
        ?: source.prepend as? LoadState.Error
        ?: source.refresh as? LoadState.Error
        ?: append as? LoadState.Error
        ?: prepend as? LoadState.Error
        ?: refresh as? LoadState.Error

    errorState?.let { showError(it.error.toString()) }
}

