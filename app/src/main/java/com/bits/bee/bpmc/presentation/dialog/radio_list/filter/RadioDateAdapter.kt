package com.bits.bee.bpmc.presentation.dialog.radio_list.filter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.bits.bee.bpmc.databinding.ItemRadioButtonBinding
import com.bits.bee.bpmc.databinding.ItemRadioDatepickerBinding
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.DateFormatUtils
import com.google.android.material.datepicker.CalendarConstraints
import com.google.android.material.datepicker.MaterialDatePicker
import java.util.*

class RadioDateAdapter(
    private val childFragmentManager: FragmentManager,
    private val ctx: Context,
    private val stringList: List<String>,
    private var selectedPosition: Int = 0,
    private var mStartDate: Long?,
    private var mEndDate: Long?,
    private var custom: Boolean
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var getDateString: String? = null
    private var isCustom: Boolean = false
    private var isDateShow : Boolean = false

    fun getSelectedPosition() : Int = selectedPosition

    override fun getItemViewType(position: Int): Int {
        if (!stringList[position].contains("Custom")){
            return 0
        }
        return 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        if (viewType == 0){
            return ViewHolderOne(ItemRadioButtonBinding.inflate(inflater, parent, false))
        }
        return ViewHolderTwo(ItemRadioDatepickerBinding.inflate(inflater, parent, false))
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (!stringList[position].contains("Custom")){
            val holderOne: ViewHolderOne = holder as ViewHolderOne
            holderOne.binding.apply {
                materialRadioButton.text = getItem(holder.absoluteAdapterPosition)

                materialRadioButton.isChecked = selectedPosition == holder.absoluteAdapterPosition

                materialRadioButton.setOnClickListener {
                    selectedPosition = holder.absoluteAdapterPosition
                    notifyDataSetChanged()
                }
            }
        } else {
            val holderTwo: ViewHolderTwo = holder as ViewHolderTwo
            holderTwo.binding.apply {
                materialRadioButton.text = getItem(holder.absoluteAdapterPosition)
                materialRadioButton.isChecked = selectedPosition == holder.absoluteAdapterPosition

                materialRadioButton.setOnClickListener {
                    selectedPosition = holder.absoluteAdapterPosition
                    notifyDataSetChanged()
                }

                if (materialRadioButton.isChecked){
                    etPilihTgl.visibility = View.VISIBLE
                    if (custom){
                        etPilihTgl.setText("${mStartDate?.let { DateFormatUtils.convertLongToTime(BPMConstants.NEW_DATE_FORMAT, it) }} - " + "${mEndDate?.let { DateFormatUtils.convertLongToTime(BPMConstants.NEW_DATE_FORMAT, it) }}")
                    }
                }else{
                    etPilihTgl.visibility = View.GONE
                }

                etPilihTgl.setOnTouchListener { _, _ ->
                    if(!isDateShow) {
                        isDateShow = true
                        val today = MaterialDatePicker.todayInUtcMilliseconds()
                        val calendar = Calendar.getInstance()

                        calendar.timeInMillis = today
                        calendar[Calendar.YEAR] = 2020
                        val janThisYear = calendar.timeInMillis

                        calendar.timeInMillis = today
                        val decThisYear = calendar.timeInMillis

                        val constraintsBuilder =
                            CalendarConstraints.Builder()
                                .setStart(janThisYear)
                                .setEnd(decThisYear)

                        val datePicker = MaterialDatePicker.Builder
                            .dateRangePicker().setCalendarConstraints(constraintsBuilder.build())
                            .build()

                        datePicker.show(childFragmentManager, "")
                        datePicker.addOnPositiveButtonClickListener { dateSelected ->
                            val startDate = dateSelected.first
                            val endDate = dateSelected.second

                            etPilihTgl.setText(
                                "${
                                    DateFormatUtils.convertLongToTime(
                                        BPMConstants.NEW_DATE_FORMAT,
                                        startDate
                                    )
                                } - " +
                                        DateFormatUtils.convertLongToTime(
                                            BPMConstants.NEW_DATE_FORMAT,
                                            endDate
                                        )
                            )
                            setTextDate(holderTwo.binding.etPilihTgl.text.toString())
                            setIscustom(true)
                        }
                        datePicker.addOnDismissListener {
                            isDateShow = false
                        }
                    }
                    true
                }

            }
        }
    }

    override fun getItemCount(): Int {
        return stringList.size
    }


    fun getItem(i : Int) = stringList[i]

    class ViewHolderOne(val binding : ItemRadioButtonBinding) : RecyclerView.ViewHolder(binding.root)

    class ViewHolderTwo(val binding : ItemRadioDatepickerBinding) : RecyclerView.ViewHolder(binding.root)

    fun setTextDate(toString: String){
        this.getDateString = toString
    }

    fun getTextDate(): String{
        return getDateString ?: ""
    }

    fun setIscustom(custom: Boolean){
        this.isCustom = custom
    }

    fun getIscustom(): Boolean{
        return isCustom
    }




}