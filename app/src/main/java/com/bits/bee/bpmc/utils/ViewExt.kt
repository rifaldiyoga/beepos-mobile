package com.bits.bee.bpmc.utils

import android.app.Activity
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.os.Build
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Patterns
import android.util.TypedValue
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.appcompat.widget.SearchView
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.paging.CombinedLoadStates
import androidx.paging.LoadState
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.data.data_source.local.model.SaleEntity.Companion.CHANNEL_ID
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.text.DecimalFormatSymbols
import java.util.*
import java.util.concurrent.TimeUnit
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

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
    val home = findViewById<ImageView>(androidx.appcompat.R.id.search_mag_icon)
    imageIcon.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_search))
    imageIcon.setColorFilter(ContextCompat.getColor(context, colorInt))
    home.setColorFilter(ContextCompat.getColor(context, colorInt))
    if(colorInt != R.color.black) {
        imageClose.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_close))
        imageClose.setColorFilter(ContextCompat.getColor(context, colorInt))
    }
    editText.setTextColor(ContextCompat.getColor(context, colorInt))
    editText.setHintTextColor(ContextCompat.getColor(context, colorInt))
    maxWidth = (context as Activity).resources.displayMetrics.widthPixels - 150
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

fun String.isContainsUpperCase() : Boolean {
    return contains(Regex("[A-Z]"))
}

fun String.isContainsLowerCase() : Boolean {
    return contains(Regex("[a-z]"))
}

fun String.isContainsNumber() : Boolean {
    return contains(Regex("[0-9]"))
}

fun String.isValidEmail() : Boolean {
    val patterns = Patterns.EMAIL_ADDRESS
    return patterns.matcher(this).matches()
}

fun String.replaceNumberWithStars() : String {
    return this.replace(Regex("[0-9]"), "*")
}

fun TextView.append(string: String?, @ColorRes color: Int) {
    if (string == null || string.isEmpty()) {
        return
    }

    val spannable: Spannable = SpannableString(string)
    spannable.setSpan(
        ForegroundColorSpan(ContextCompat.getColor(context, color)),
        0,
        spannable.length,
        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
    )

    append(spannable)
}


fun showNotifications(ctx: Context, message: String, ) {

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val name = "Upload Notification"
        val importance = NotificationManager.IMPORTANCE_HIGH
        val channel = NotificationChannel(CHANNEL_ID, name, importance)

        val notificationManager = ctx.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager?

        notificationManager?.createNotificationChannel(channel)
    }

    // Create notification
    val builder = NotificationCompat.Builder(ctx, CHANNEL_ID)
        .setSmallIcon(R.mipmap.ic_launcher)
        .setContentTitle("Beepos Mobile")
        .setContentText(message)
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .setVibrate(LongArray(0))

    // Show notification
    NotificationManagerCompat.from(ctx).notify(BPMConstants.NOTIFICATION_ID, builder.build())
}


fun BroadcastReceiver.goAsync(
    context: CoroutineContext = EmptyCoroutineContext,
    block: suspend CoroutineScope.() -> Unit
) {
    val pendingResult = goAsync()
    CoroutineScope(SupervisorJob()).launch(context) {
        try {
            block()
        } finally {
            pendingResult.finish()
        }
    }
}

fun getDateDiff(oldDate : Date, newDate: Date): Long {
    return try {
        TimeUnit.DAYS.convert(newDate.time - oldDate.time, TimeUnit.MILLISECONDS)
    } catch (e: Exception) {
        e.printStackTrace()
        0
    }
}



