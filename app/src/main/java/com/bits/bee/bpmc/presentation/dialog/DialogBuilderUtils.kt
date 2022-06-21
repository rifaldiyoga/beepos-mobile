package com.bits.bee.bpmc.presentation.dialog

import android.app.Dialog
import android.content.Context
import com.bits.bee.bpmc.R
import javax.inject.Singleton

/**
 * Created by aldi on 10/06/22.
 */
@Singleton
class DialogBuilderUtils {

    companion object {

        fun showDialogInfo(context: Context, title : String, msg : String, positiveTxt : String, positiveListener : (Dialog) -> Unit) : CustomDialogBuilder {
            return CustomDialogBuilder.Builder(context)
                .setTitle(title)
                .setMessage(msg)
                .setPositiveText(positiveTxt)
                .setPositiveCallback(positiveListener)
                .build()
        }

        fun showDialogChoice(context: Context, title : String, msg : String, positiveTxt : String,
                             positiveListener : (Dialog) -> Unit, negativeTxt : String, negativeListener : ((Dialog) -> Unit)? = null) : CustomDialogBuilder {
            return CustomDialogBuilder.Builder(context)
                .setTitle(title)
                .setMessage(msg)
                .setPositiveText(positiveTxt)
                .setPositiveCallback(positiveListener)
                .setNegativeText(negativeTxt)
                .setNegativeCallback(negativeListener)
                .build()
        }

        fun showDialogYesNo(context: Context, title : String, msg : String,
                             positiveListener : (Dialog) -> Unit, negativeListener : ((Dialog) -> Unit)? = null) : CustomDialogBuilder {
            return CustomDialogBuilder.Builder(context)
                .setTitle(title)
                .setMessage(msg)
                .setPositiveText(context.getString(R.string.ya))
                .setPositiveCallback(positiveListener)
                .setNegativeText(context.getString(R.string.batal))
                .setNegativeCallback(negativeListener)
                .build()
        }
    }

}