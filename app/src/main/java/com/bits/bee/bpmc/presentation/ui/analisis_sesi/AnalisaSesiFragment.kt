package com.bits.bee.bpmc.presentation.ui.analisis_sesi

import android.graphics.Color
import android.graphics.DashPathEffect
import android.os.Bundle
import android.view.*
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentAnalisaSesiBinding
import com.bits.bee.bpmc.domain.model.Posses
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.CurrencyUtils
import com.bits.bee.bpmc.utils.DateFormatUtils
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IFillFormatter
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.github.mikephil.charting.utils.Utils
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.math.BigDecimal
import java.sql.Date

/**
 * Created by aldi on 13/04/22.
 */
@AndroidEntryPoint
class AnalisaSesiFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentAnalisaSesiBinding = FragmentAnalisaSesiBinding::inflate
) : BaseFragment<FragmentAnalisaSesiBinding>() {

    private val viewModel : AnalisaSesiViewModel by viewModels()
    private var mPosses: Posses? = null
    private var isRiwayat: Boolean = false
    private var bigDecimalZero: BigDecimal = BigDecimal("0")
//    private lateinit var chart: LineChart

    private lateinit var itemRankAdapter: ItemRankAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            isRiwayat = it.getBoolean("isRiwayat")
            if (isRiwayat){
                if (!it.getString("posses").equals("null") && it.getString("posses")?.isNotEmpty() == true){
                    mPosses = Gson().fromJson(it.getString("posses"), Posses::class.java)
                    viewModel.updateState(
                        viewModel.state.copy(
                            posses = mPosses
                        )
                    )
                }
            }
        }
    }

    override fun initComponents() {
        setHasOptionsMenu(true)
        binding.apply {
            itemRankAdapter = ItemRankAdapter()
            rvRankItem.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = itemRankAdapter
            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            btnBukaKasir.setOnClickListener {
                viewModel.onClickBukaKasir()
            }
            btnLihatRiwayat.setOnClickListener {
                viewModel.onClickMenu()
            }
        }
    }

    override fun subscribeObservers() {
        loadViewChart()
//        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
//            viewModel.getActivePosses()
//            viewModel.checkPosses()
//        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect { event ->
                    when(event){
                        AnalisaSesiViewModel.UIEvent.RequstDetailBukaKasir ->{
                            val action = AnalisaSesiFragmentDirections.actionAnalasisiSesiFragmentToDetailBukaKasirFragment()
                            findNavController().navigate(action)
                        }
                        AnalisaSesiViewModel.UIEvent.RequestRiwayatSesi ->{
                            val action = AnalisaSesiFragmentDirections.actionAnalasisiSesiFragmentToRiwayatSesiFragment()
                            findNavController().navigate(action)
                        }
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    it?.let {
                        binding.apply {
                            if (isRiwayat){
                                lLAnalisaEmpty.visibility = View.GONE
                                sVKasirAktif.visibility = View.VISIBLE
                            }else{
                                it.possesList?.let {
                                    if (it.isNotEmpty()){
                                        viewModel.getActivePosses()
                                        lLAnalisaEmpty.visibility = View.GONE
                                        sVKasirAktif.visibility = View.VISIBLE

                                    }else if(it.isEmpty()){
                                        lLAnalisaEmpty.visibility = View.VISIBLE
                                        sVKasirAktif.visibility = View.GONE
                                    }
                                }
                            }
                            it.posses?.let { data->
                                val startTime = Date(data.startTime.time)
                                tvMulaiOperasional.text = DateFormatUtils.formatDateToString(
                                    BPMConstants.DEFAULT_DATE_FORMAT, startTime)
                                if (data.endTime != null){
                                    val endTime = Date(data.endTime!!.time)
                                    tvSelesaiOperasional.text = DateFormatUtils.formatDateToString(
                                        BPMConstants.DEFAULT_DATE_FORMAT, endTime)
                                }else{
                                    tvSelesaiOperasional.text = ""
                                }
                                tvSesi.text = "#${data.shift}"
                                tvModal.text = getString(R.string.mata_uang_nominal,
                                    "Rp", CurrencyUtils.formatCurrency(data.startBal))
                                tvTotalPendapatan.text = getString(R.string.mata_uang_nominal,
                                    "Rp", CurrencyUtils.formatCurrency(data.total.add(data.startBal)))
                                tvPemasukan.text = getString(R.string.mata_uang_nominal,
                                    "Rp", CurrencyUtils.formatCurrency(data.totIn ?: bigDecimalZero))
                                tvPengeluaran.text = getString(R.string.mata_uang_nominal,
                                    "Rp", CurrencyUtils.formatCurrency(data.totOut ?: bigDecimalZero))
                                viewModel.getValueDetail()
                            }
                            it.user?.let {
                                tvUserKasir.text = it.name
                            }
                            it.saleList?.let {
                                tvAvgOrder.text = getString(R.string.mata_uang_nominal,
                                    "Rp", CurrencyUtils.formatCurrency(viewModel.totalAvg(it)))
                                tvJmlOrder.text = it.size.toString()
                                tvTotalQty.text = CurrencyUtils.formatCurrency(viewModel.totalQty(it))
                            }
                            it.bpDateList?.let {
                                tvNewMember.text = it.size.toString()
                            }
                            it.notaSucces?.let {
                                tvTransSukses.text = it.toString()
                            }
                            it.notaVoid?.let {
                                tvTransVoid.text = it.toString()
                            }
                            it.totalTunai?.let {
                                tvTotalTunai.text = getString(R.string.mata_uang_nominal,
                                    "Rp", CurrencyUtils.formatCurrency(it ?: bigDecimalZero))
                            }
                            it.totalDebit?.let {
                                tvTotalDebit.text = getString(R.string.mata_uang_nominal,
                                    "Rp", CurrencyUtils.formatCurrency(it ?: bigDecimalZero))
                            }
                            it.totalGopay?.let {
                                tvTotalGopay.text = getString(R.string.mata_uang_nominal,
                                    "Rp", CurrencyUtils.formatCurrency(it ?: bigDecimalZero))
                                tvTotalNonTunai.text = getString(R.string.mata_uang_nominal,
                                    "Rp", CurrencyUtils.formatCurrency(viewModel.getTotalNonTunai() ?: bigDecimalZero))
                            }
                            it.rankItem?.let {
//                                clEmptyRanking.visibility = View.GONE
//                                clRanking.visibility = View.VISIBLE
//                                itemRankAdapter.submitList(it)
                                if (it.size > 0){
                                    clEmptyRanking.visibility = View.GONE
                                    clRanking.visibility = View.VISIBLE
                                    itemRankAdapter.submitList(it)
                                }else{
                                    clEmptyRanking.visibility = View.VISIBLE
                                    clRanking.visibility = View.GONE
                                }
                            }
//                            it.reg?.let { datareg->
//                                loadViewChart()
//                            }
//                            it.listEntry?.let {
//                                setListEntry(it)
//                            }
                        }
                    }
                }
            }
        }
    }

    fun loadViewChart(){
        binding.apply {
            chart1.setBackgroundColor(Color.WHITE)
            chart1.description.isEnabled = false
            chart1.setTouchEnabled(true)
            chart1.setDrawGridBackground(false)
            chart1.isDragEnabled = true
            chart1.setScaleEnabled(true)
            chart1.setPinchZoom(true)
            chart1.legend.isEnabled = false
            chart1.setNoDataText("Tidak ada data untuk sesi ini")
            chart1.setNoDataTextColor(resources.getColor(R.color.red))

            // // X-Axis Style // //
            // // X-Axis Style // //
            val xAxis = chart1.xAxis

            xAxis.position = XAxis.XAxisPosition.BOTTOM
            xAxis.enableGridDashedLine(10f, 10f, 0f)
            xAxis.granularity = 1f
//            xAxis.valueFormatter = object : ValueFormatter() {
//                override fun getFormattedValue(value: Float): String {
//                    return if (!viewModel.state.reg!!.value.equals("1")) String.format(
//                        "%02d",
//                        value.toInt()
//                    ) else getString(R.string.star)
//                }
//            }

            val yAxis = chart1.axisLeft
            chart1.axisRight.isEnabled = false
            yAxis.enableGridDashedLine(10f, 10f, 0f)
            yAxis.axisMinimum = 0f
            chart1.animateX(1500)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.viewStates().collect {
                    it?.let {
                        it.listEntry?.let {
                            setListEntry(it)
                        }
                    }
                }
            }
        }

//        val dataGr: MutableList<Entry> = mutableListOf()
//        var set1: LineDataSet
//
//        dataGr.add(Entry(0f, 0f))
//        dataGr.add(Entry(1f, 0f))
//        dataGr.add(Entry(2f, 0f))
//        dataGr.add(Entry(3f, 300f))
//        dataGr.add(Entry(4f, 0f))
//        dataGr.add(Entry(5f, 0f))
//        dataGr.add(Entry(6f, 15500f))
//        dataGr.add(Entry(7f, 0f))
//        dataGr.add(Entry(8f, 0f))
//        dataGr.add(Entry(9f, 12000f))
//        dataGr.add(Entry(10f, 0f))
//
//
//        val kasusLineDataSet = LineDataSet(dataGr, "Produk")
//        kasusLineDataSet.mode = LineDataSet.Mode.CUBIC_BEZIER
//        kasusLineDataSet.color = Color.BLUE
//        kasusLineDataSet.circleRadius = 5f
//        kasusLineDataSet.setCircleColor(Color.BLUE)
//
//        //Setup Legend
//        binding.apply {
//            val legend = chart1.legend
//            legend.isEnabled = true
//            legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP)
//            legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER)
//            legend.setOrientation(Legend.LegendOrientation.HORIZONTAL)
//            legend.setDrawInside(false)
//
//            chart1.description.isEnabled = false
//            chart1.xAxis.position = XAxis.XAxisPosition.BOTTOM
//            chart1.data = LineData(kasusLineDataSet)
//            chart1.animateXY(100, 500)
//        }
    }

    fun setListEntry(entries: List<Entry>) {
        var set1: LineDataSet

        binding.apply {
            if (chart1.data != null && chart1.data.dataSetCount > 0){
                set1 = chart1.data.getDataSetByIndex(0) as LineDataSet
                set1.values = entries
                set1.notifyDataSetChanged()
                chart1.data.notifyDataChanged()
                chart1.notifyDataSetChanged()
            }else{
                set1 = LineDataSet(entries, "DataSet 1")
                set1.setDrawIcons(false)
                set1.color = resources.getColor(R.color.red)
                set1.setCircleColor(resources.getColor(R.color.red))
                set1.lineWidth = 1f
                set1.circleRadius = 3f
                set1.setDrawCircleHole(true)
                set1.formLineWidth = 1f
                set1.formLineDashEffect = DashPathEffect(floatArrayOf(10f, 5f), 0f)
                set1.formSize = 15f
                set1.valueTextSize = 9f
                set1.enableDashedHighlightLine(10f, 5f, 0f)
                set1.setDrawFilled(true)
                set1.setFillFormatter(object : IFillFormatter{
                    override fun getFillLinePosition(
                        dataSet: ILineDataSet?,
                        dataProvider: LineDataProvider?
                    ): Float {
                        return chart1.axisLeft.axisMinimum
                    }

                })
                if (Utils.getSDKInt() >= 18){
                    val drawable = ContextCompat.getDrawable(requireContext(), R.color.gray_lite)
                    set1.fillDrawable = drawable
                }else{
                    set1.fillColor = resources.getColor(R.color.gray_lite)
                }

                val dataSets = ArrayList<ILineDataSet>()
                dataSets.add(set1)

                val data = LineData(dataSets)
                data.setValueFormatter(object : ValueFormatter() {
                    override fun getFormattedValue(value: Float): String {
                        return String.format("%d", value.toInt())
                    }
                })
                chart1.data = data
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_analisa_sesi, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_list -> viewModel.onClickMenu()
        }
        return super.onOptionsItemSelected(item)
    }


}