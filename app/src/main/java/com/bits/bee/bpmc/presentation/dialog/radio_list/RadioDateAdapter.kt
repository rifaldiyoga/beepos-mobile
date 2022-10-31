package com.bits.bee.bpmc.presentation.dialog.radio_list

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
import com.google.android.material.datepicker.MaterialDatePicker

class RadioDateAdapter(
    private val childFragmentManager: FragmentManager,
    private val ctx: Context,
    stringList: List<String>,
    selected: Int
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var stringList : List<String> = mutableListOf()
    private var selectedPosition : Int = 0
    private var getDateString: String? = null

    init {
        this.stringList = stringList
        this.selectedPosition = selected
    }

    fun getSelectedPosition() : Int = selectedPosition

    override fun getItemViewType(position: Int): Int {
        if (!stringList.get(position).contains("Custom")){
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

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (!stringList.get(position).contains("Custom")){
            val holderOne: ViewHolderOne = holder as ViewHolderOne
            holderOne.binding.apply {
                materialRadioButton.text = getItem(holder.absoluteAdapterPosition)

                materialRadioButton.isChecked = selectedPosition == holder.absoluteAdapterPosition

                materialRadioButton.setOnClickListener {
                    selectedPosition = holder.absoluteAdapterPosition
                    notifyDataSetChanged()
                }
            }
        }else{
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
                }else{
                    etPilihTgl.visibility = View.GONE
                }

                etPilihTgl.setOnClickListener {
                    val datePicker = MaterialDatePicker.Builder.dateRangePicker().build()
                    datePicker.show(childFragmentManager, "")

                    datePicker.addOnPositiveButtonClickListener { dateSelected ->
                        val startDate = dateSelected.first
                        val endDate = dateSelected.second

                        etPilihTgl.setText("${DateFormatUtils.convertLongToTime(BPMConstants.NEW_DATE_FORMAT, startDate)} - " +
                                "${DateFormatUtils.convertLongToTime(BPMConstants.NEW_DATE_FORMAT, endDate)}")
                        setTextDate(holderTwo.binding.etPilihTgl.text.toString())
                    }

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



}