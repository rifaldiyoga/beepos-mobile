package com.bits.bee.bpmc.presentation.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.bits.bee.bpmc.databinding.DialogInfoBuilderBinding
import com.bits.bee.bpmc.presentation.base.BaseDialogFragment
import dagger.hilt.android.qualifiers.ApplicationContext

/**
 * Created by aldi on 21/03/22.
 */

class CustomDialogBuilder private constructor (
    private val builder : Builder,
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogInfoBuilderBinding = DialogInfoBuilderBinding::inflate
) : BaseDialogFragment<DialogInfoBuilderBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponents()
    }

    override fun initComponents() {
        binding.apply {
            tvTitle.text = builder.title
            tvMessage.text = builder.message
            btnSecondary.text = builder.negative
            btnPrimary.text = builder.positive
            btnSecondary.isVisible = !builder.isInfo
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            btnSecondary.setOnClickListener{
                builder.negativeCallback?.let { it(dialog!!) }
                dismiss()
            }
            btnPrimary.setOnClickListener{
                builder.positiveCallback?.let { it(dialog!!) }
            }
        }
    }

    override fun subscribeObservers() {

    }


    data class Builder (
        @ApplicationContext val context: Context,
        var positiveCallback: ((Dialog) -> Unit)? = null,
        var negativeCallback: ((Dialog) -> Unit)? = null,
        var title: String? = null,
        var message: String? = null,
        var isInfo : Boolean = false,
        var positive : String = "OK",
        var negative : String = "Batal",
    ){

        fun setPositiveCallback(positiveCallback: (Dialog) -> Unit): Builder {
            this.positiveCallback = positiveCallback
            return this
        }

        fun setNegativeCallback(negativeCallback: ((Dialog) -> Unit)?): Builder {
            this.negativeCallback = negativeCallback
            return this
        }

        fun setTitle(title: String?): Builder {
            this.title = title
            return this
        }

        fun setMessage(message: String?): Builder {
            this.message = message
            return this
        }

        fun setInfo(info: Boolean): Builder {
            isInfo = info
            return this
        }

        fun setPositiveText(positive: String?): Builder {
            positive?.let {
                this.positive = positive
            }
            return this
        }

        fun setNegativeText(negative: String?): Builder {
            negative?.let {
                this.negative = negative
            }
            return this
        }

        fun build(): CustomDialogBuilder {
            return CustomDialogBuilder(this)
        }
    }

}
