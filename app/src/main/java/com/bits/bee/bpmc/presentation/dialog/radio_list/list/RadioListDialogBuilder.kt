package com.bits.bee.bpmc.presentation.dialog.radio_list.list

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.databinding.DialogRadioListBinding
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext

/**
 * Created by aldi on 05/04/22.
 */
@AndroidEntryPoint
class RadioListDialogBuilder(
    private val builder : Builder,
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogRadioListBinding = DialogRadioListBinding::inflate
) : BaseBottomSheetDialogFragment<DialogRadioListBinding>() {

    private lateinit var radioAdapter: RadioListAdapter

    override fun initComponents() {
        binding.apply {
            tvTitle.text = builder.title
            radioAdapter = RadioListAdapter(builder.list, builder.list.indexOf(builder.value))
            recyclerView.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = radioAdapter
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            btnSimpan.setOnClickListener {
                builder.onSaveClick?.let {
                    radioAdapter.getSelectedPosition()?.let { selectedPos ->
                        it(builder.list[selectedPos])
                    }
                }
                dismiss()
            }
            imageView2.setOnClickListener {
                dismiss()
            }
        }
    }

    override fun subscribeObservers() {

    }

    data class Builder(
        @ApplicationContext val context: Context,
         var title: String? = null,
         var list: List<String> = mutableListOf(),
         var value: String? = null,
         var onSaveClick: ((Any) -> Unit)? = null,
         var onCustomButton: ((Any) -> Unit)? = null,
    ){

        fun setTitle(title: String?): Builder {
            this.title = title
            return this
        }

        fun setList(list: List<String>): Builder {
            this.list = list
            return this
        }

        fun setValue(value: String?): Builder {
            this.value = value
            return this
        }

        fun setOnSaveListener(onSaveClick: (Any) -> Unit) : Builder {
            this.onSaveClick = onSaveClick
            return this
        }

        fun setOnCustomButtonListener(onSaveClick: (Any) -> Unit) : Builder {
            this.onCustomButton = onSaveClick
            return this
        }

        fun build(): RadioListDialogBuilder {
            return RadioListDialogBuilder(this)
        }
    }

}