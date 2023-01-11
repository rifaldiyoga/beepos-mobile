package com.bits.bee.bpmc.presentation.ui.analisis_sesi

import android.graphics.Color
import android.graphics.DashPathEffect
import android.view.*
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
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
import com.bits.bee.bpmc.utils.extension.replaceNumberWithStars
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.github.mikephil.charting.utils.Utils
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.first
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

    private lateinit var itemRankAdapter: ItemRankAdapter


    override fun initComponents() {
        setHasOptionsMenu(true)
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
        viewModel.getActivePosses()
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
                                if (it.posses != null){
                                    viewModel.getActivePosses()
                                    lLAnalisaEmpty.visibility = View.GONE
                                    sVKasirAktif.visibility = View.VISIBLE
                                }else{
                                    lLAnalisaEmpty.visibility = View.VISIBLE
                                    sVKasirAktif.visibility = View.GONE
                                }

                            }
                            it.posses?.let { data->
                                val startTime = Date(data.startTime.time)
                                tvMulaiOperasional.text = DateFormatUtils.formatDateToString(
                                    BPMConstants.DEFAULT_DATE_FORMAT, startTime)
                                if (data.endTime != null){
                                    val endTime = Date(data.endTime!!.time)
                                    tvSelesaiOperasional.text = DateFormatUtils.formatDateToString(BPMConstants.DEFAULT_DATE_FORMAT, endTime)
                                }else{
                                    tvSelesaiOperasional.text = ""
                                }

                                constraintLayout10.isVisible = data.totalActualCash > BigDecimal.ZERO
                                view32.isVisible = data.totalActualCash > BigDecimal.ZERO

                                var modal = CurrencyUtils.formatCurrency(data.startBal)
                                var totalPendapatan =  CurrencyUtils.formatCurrency(data.total.add(data.startBal))
                                var pemasukan =  CurrencyUtils.formatCurrency(data.totIn ?: bigDecimalZero)
                                var pengeluaran =  CurrencyUtils.formatCurrency(data.totOut ?: bigDecimalZero)
                                var totalTunai =  CurrencyUtils.formatCurrency(it.totalTunai)
                                var totalDebit =  CurrencyUtils.formatCurrency(it.totalDebit)
                                var totalKredit =  CurrencyUtils.formatCurrency(it.totalKredit)
                                var totalGopay =  CurrencyUtils.formatCurrency(it.totalGopay)
                                var totalNonTunai =  CurrencyUtils.formatCurrency(viewModel.getTotalNonTunai())
                                val totalAct = CurrencyUtils.formatCurrency(data.totalActualCash)
                                val program = CurrencyUtils.formatCurrency(data.total.add(data.startBal))
                                val diffCash = CurrencyUtils.formatCurrency(data.totalDiffCash)

                                if(viewModel.reg.first()?.value == "1"){
                                    modal = modal.replaceNumberWithStars()
                                    totalPendapatan = totalPendapatan.replaceNumberWithStars()
                                    pemasukan = pemasukan.replaceNumberWithStars()
                                    pengeluaran = pengeluaran.replaceNumberWithStars()
                                    totalTunai = totalTunai.replaceNumberWithStars()
                                    totalDebit = totalDebit.replaceNumberWithStars()
                                    totalKredit = totalKredit.replaceNumberWithStars()
                                    totalGopay = totalGopay.replaceNumberWithStars()
                                    totalNonTunai = totalNonTunai.replaceNumberWithStars()
                                }

                                tvSesi.text = "#${data.shift}"
                                tvModal.text = getString(R.string.mata_uang_nominal,
                                    "Rp", modal)
                                tvTotalPendapatan.text = getString(R.string.mata_uang_nominal,
                                    "Rp", totalPendapatan)
                                tvPemasukan.text = getString(R.string.mata_uang_nominal,
                                    "Rp", pemasukan)
                                tvPengeluaran.text = getString(R.string.mata_uang_nominal,
                                    "Rp", pengeluaran)
                                viewModel.getValueDetail()
                                it.saleList.let {
                                    tvAvgOrder.text = getString(R.string.mata_uang_nominal,
                                        "Rp", CurrencyUtils.formatCurrency(viewModel.totalAvg(it)))
                                    tvJmlOrder.text = it.size.toString()
                                    tvTotalQty.text = CurrencyUtils.formatCurrency(viewModel.totalQty(it))
                                }
                                tvNewMember.text = it.bpDateList.size.toString()

                                tvTransSukses.text = CurrencyUtils.formatCurrency(it.notaSucces)

                                tvTransVoid.text = CurrencyUtils.formatCurrency(it.notaVoid)
                                tvTotalTunai.text = getString(R.string.mata_uang_nominal, "Rp", totalTunai)
                                tvTotalDebit.text = getString(R.string.mata_uang_nominal, "Rp", totalDebit)
                                tvTotalKredit.text = getString(R.string.mata_uang_nominal, "Rp", totalKredit)
                                tvTotalGopay.text = getString(R.string.mata_uang_nominal, "Rp", totalGopay)
                                tvTotalNonTunai.text = getString(R.string.mata_uang_nominal, "Rp", totalNonTunai)
                                tvProgram.text = getString(R.string.mata_uang_nominal, "Rp", program)
                                tvAktual.text = getString(R.string.mata_uang_nominal, "Rp", totalAct)
                                tvSelisih.text = getString(R.string.mata_uang_nominal, "Rp", diffCash)

//                                clEmptyRanking.visibility = View.GONE
//                                clRanking.visibility = View.VISIBLE
//                                itemRankAdapter.submitList(it)
                                if (it.rankItem.isNotEmpty()){
                                    clEmptyRanking.visibility = View.GONE
                                    clRanking.visibility = View.VISIBLE
                                    itemRankAdapter.submitList(it.rankItem)
                                }else{
                                    clEmptyRanking.visibility = View.VISIBLE
                                    clRanking.visibility = View.GONE
                                }

                            }
                            it.user?.let {
                                tvUserKasir.text = it.name
                            }
                        }
                    }
                }
            }
        }
    }

    private fun loadViewChart(){
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
            chart1.setNoDataTextColor(ContextCompat.getColor(requireActivity(), R.color.red))

            val xAxis = chart1.xAxis

            xAxis.position = XAxis.XAxisPosition.BOTTOM
            xAxis.enableGridDashedLine(10f, 10f, 0f)
            xAxis.granularity = 1f

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
                        setListEntry(it.listEntry)
                    }
                }
            }
        }
    }

    private fun setListEntry(entries: List<Entry>) {
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
                set1.color = ContextCompat.getColor(requireActivity(), R.color.red)
                set1.setCircleColor(ContextCompat.getColor(requireActivity(), R.color.red))
                set1.lineWidth = 1f
                set1.circleRadius = 3f
                set1.setDrawCircleHole(true)
                set1.formLineWidth = 1f
                set1.formLineDashEffect = DashPathEffect(floatArrayOf(10f, 5f), 0f)
                set1.formSize = 15f
                set1.valueTextSize = 9f
                set1.enableDashedHighlightLine(10f, 5f, 0f)
                set1.setDrawFilled(true)
                set1.setFillFormatter { _, _ -> chart1.axisLeft.axisMinimum }
                if (Utils.getSDKInt() >= 18){
                    val drawable = ContextCompat.getDrawable(requireContext(), R.color.gray_lite)
                    set1.fillDrawable = drawable
                } else {
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