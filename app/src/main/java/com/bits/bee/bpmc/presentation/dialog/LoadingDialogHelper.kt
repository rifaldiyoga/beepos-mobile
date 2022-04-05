package com.bits.bee.bpmc.presentation.dialog

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.DialogLoadingHelperBinding

/**
 * Created by aldi on 16/03/22.
 */
class LoadingDialogHelper(val context: Context) {
    private var dialog: Dialog? = null

    fun show(title: String = "", message: String = context.getString(R.string.mohon_tunggu_sebentar), cancelable: Boolean = false) {
        if (dialog == null) {
            dialog = Dialog(context)
            val binding = DialogLoadingHelperBinding.inflate(LayoutInflater.from(context))
            dialog?.setContentView(binding.root)
            dialog?.window!!.setBackgroundDrawableResource(android.R.color.transparent)
            dialog?.setCancelable(cancelable)
            dialog?.show()

            binding.apply {
                if (title.isNotEmpty()) {
                    txtTitle.visibility = View.VISIBLE
                    txtTitle.text = title
                } else {
                    txtTitle.visibility = View.GONE
                }
                if (message.isNotEmpty()) {
                    txtMessage.text = message
                } else {
                    txtMessage.text = context.resources.getString(R.string.mohon_tunggu)
                }
            }
        }
    }

    fun hide() {
        if (dialog != null) {
            dialog?.dismiss()
            dialog = null
        }
    }
}