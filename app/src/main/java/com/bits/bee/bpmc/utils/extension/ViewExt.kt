package com.bits.bee.bpmc.utils.extension

import android.app.Activity
import android.content.Context
import android.content.res.ColorStateList
import android.util.TypedValue
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.utils.NumberFormatWatcher
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

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

fun EditText.addNumberFormatChange(){
    addTextChangedListener(NumberFormatWatcher(this))
}

fun String.removeSymbol() : String{
    val sep = DecimalFormatSymbols(Locale.getDefault()).groupingSeparator
    val re = Regex("[Rp$sep %]")
    return if(this.isNotEmpty()) re.replace(this, "").trim() else ""
}

fun SearchView.setSearchViewStyle(context: Context, colorInt: Int) {
    setIconifiedByDefault(false)
    val editText = findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
    val imageIcon = findViewById<ImageView>(androidx.appcompat.R.id.search_mag_icon)
    val imageClose = findViewById<ImageView>(androidx.appcompat.R.id.search_close_btn)
    val home = findViewById<ImageView>(androidx.appcompat.R.id.home)
    imageIcon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_search))
    imageIcon.setColorFilter(ContextCompat.getColor(context, colorInt))
//    home.setColorFilter(ContextCompat.getColor(context, colorInt))
    imageClose.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_close))
    imageClose.setColorFilter(ContextCompat.getColor(context, colorInt))
    editText.setTextColor(ContextCompat.getColor(context, colorInt))
    editText.setHintTextColor(ContextCompat.getColor(context, colorInt))
}

fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}

fun Activity.hideKeyboard() {
    hideKeyboard(currentFocus ?: View(this))
}

fun Context.hideKeyboard(view: View) {
    val im = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    im.hideSoftInputFromWindow(view.windowToken, 0)
}
