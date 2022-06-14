package com.bits.bee.bpmc.presentation.dialog

import android.content.Context
import android.view.View
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

/**
 * Created by aldi on 10/06/22.
 */
@Singleton
class DialogBuilderUtils {

    companion object {

        fun showDialogInfo(context: Context, title : String, msg : String, positiveTxt : String, positiveListener : View.OnClickListener?) : CustomDialogBuilder {
            return CustomDialogBuilder.Builder(context)
                .setTitle(title)
                .setMessage(msg)
                .setPositiveText(positiveTxt)
                .setPositiveCallback(positiveListener)
                .build()
        }

        fun showDialogChoice(context: Context, title : String, msg : String, positiveTxt : String,
                             positiveListener : View.OnClickListener, negativeTxt : String, negativeListener : View.OnClickListener? = null) : CustomDialogBuilder {
            return CustomDialogBuilder.Builder(context)
                .setTitle(title)
                .setMessage(msg)
                .setPositiveText(positiveTxt)
                .setPositiveCallback(positiveListener)
                .setNegativeText(negativeTxt)
                .setNegativeCallback(negativeListener)
                .build()
        }
    }

}