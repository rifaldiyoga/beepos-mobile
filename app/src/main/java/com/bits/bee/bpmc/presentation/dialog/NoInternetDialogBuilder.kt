package com.bits.bee.bpmc.presentation.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.bits.bee.bpmc.databinding.DialogNoIntenetBuilderBinding
import com.bits.bee.bpmc.presentation.base.BaseDialogFragment
import dagger.hilt.android.qualifiers.ApplicationContext

class NoInternetDialogBuilder(
    private val builder : Builder,
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogNoIntenetBuilderBinding = DialogNoIntenetBuilderBinding::inflate
): BaseDialogFragment<DialogNoIntenetBuilderBinding>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponents()
    }

    override fun initComponents(){
        binding.apply {
            btnCobaLagi.setOnClickListener {
                builder.positiveCallback?.let { it(dialog!!) }
            }
            btnClose.setOnClickListener {
                builder.negativeCallback
                dismiss()
            }
        }
    }

    data class Builder (
        @ApplicationContext val context: Context,
        var positiveCallback: ((Dialog) -> Unit)? = null,
        var negativeCallback: ((Dialog) -> Unit)? = null
    ){

        fun setPositiveCallback(positiveCallback: (Dialog) -> Unit): Builder {
            this.positiveCallback = positiveCallback
            return this
        }

        fun setNegativeCallback(negativeCallback: ((Dialog) -> Unit)?): Builder {
            this.negativeCallback = negativeCallback
            return this
        }

        fun build(): NoInternetDialogBuilder {
            return NoInternetDialogBuilder(this)
        }
    }

    override fun subscribeListeners() {
        TODO("Not yet implemented")
    }

    override fun subscribeObservers() {
        TODO("Not yet implemented")
    }

}