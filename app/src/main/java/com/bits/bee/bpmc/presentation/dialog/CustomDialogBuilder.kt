package com.bits.bee.bpmc.presentation.dialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.bits.bee.bpmc.databinding.DialogInfoBuilderBinding
import dagger.hilt.android.qualifiers.ApplicationContext

/**
 * Created by aldi on 21/03/22.
 */

class CustomDialogBuilder private constructor (
    private val builder : Builder
) : DialogFragment() {

    private lateinit var binding : DialogInfoBuilderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, android.R.style.ThemeOverlay_Material_Dialog_Alert)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogInfoBuilderBinding.inflate(inflater, container, false)
        return binding.root
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = DialogInfoBuilderBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        initComponents()
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponents()
    }


    private fun initComponents(){
        binding.apply {
            tvTitle.text = builder.title
            tvMessage.text = builder.message
            btnSecondary.text = builder.negative
            btnPrimary.text = builder.positive
            btnSecondary.setOnClickListener(builder.negativeCallback ?: View.OnClickListener { dismiss() })
            btnPrimary.setOnClickListener(builder.positiveCallback)
        }
    }

    data class Builder (
        @ApplicationContext val context: Context,
        var positiveCallback: View.OnClickListener? = null,
        var negativeCallback: View.OnClickListener? = null,
        var title: String? = null,
        var message: String? = null,
        var isInfo : Boolean = false,
        var positive : String = "OK",
        var negative : String = "Batal"
    ){

        fun setPositiveCallback(positiveCallback: View.OnClickListener?): Builder {
            this.positiveCallback = positiveCallback
            return this
        }

        fun setNegativeCallback(negativeCallback: View.OnClickListener?): Builder {
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
            this.positive = positive!!
            return this
        }

        fun setNegativeText(negative: String?): Builder {
            this.negative = negative!!
            return this
        }

        fun build(): CustomDialogBuilder {
            return CustomDialogBuilder(this)
        }
    }

}