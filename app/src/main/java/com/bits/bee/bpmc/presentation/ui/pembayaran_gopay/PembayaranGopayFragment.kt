package com.bits.bee.bpmc.presentation.ui.pembayaran_gopay

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentPembayaranGopayBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.ui.pembayaran_non_tunai.PembayaranNonTunaiFragment
import com.bits.bee.bpmc.presentation.ui.pembayaran_non_tunai.PembayaranNonTunaiFragmentDirections
import com.bits.bee.bpmc.presentation.ui.pembayaran_non_tunai.PembayaranNonTunaiViewModel
import com.bits.bee.bpmc.presentation.ui.pos.MainViewModel
import com.bits.bee.bpmc.utils.CurrencyUtils
import com.bits.bee.bpmc.utils.Resource
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.math.BigDecimal
import java.util.concurrent.Executors

/**
 * Created by aldi on 31/05/22.
 */
@AndroidEntryPoint
class PembayaranGopayFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentPembayaranGopayBinding = FragmentPembayaranGopayBinding::inflate
) : BaseFragment<FragmentPembayaranGopayBinding>() {

    private val viewModel : PembayaranGopayViewModel by viewModels()

    private val parentViewModel : PembayaranNonTunaiViewModel by viewModels({requireParentFragment()})

    private val mainViewModel : MainViewModel by activityViewModels()

    val mHandler : Handler = Handler(Looper.getMainLooper())

    override fun initComponents() {
        binding.apply {
            val trxNo = mainViewModel.getTrxNo(requireActivity())
            viewModel.updateState(
                viewModel.state.copy(
                    sale = mainViewModel.saleTrans.getMaster().copy(
                        trxNo = trxNo
                    ),
                    saledList = mainViewModel.saleTrans.getListDetail(),
                    bp = mainViewModel.activeBp.value
                )
            )
            viewModel.state.sale?.let { sale ->
                if(sale.gopayUrl.isNotEmpty()){
                    when(sale.gopayPaymentStatus){
                        CANCEL -> {

                        }
                        PENDING -> {
                            viewModel.checkStatusPayment()
                            setProgressPayment()
                            loadQrCode(sale.gopayUrl)
                        }
                        SETTLEMENT -> {

                        }
                    }
                } else {
                    viewModel.requestQRCode()
                }

            }
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            btnCheckStatus.setOnClickListener {
                viewModel.cancelPayment()
            }
        }
    }

    override fun subscribeObservers() {
        viewModel.observeGopayResponse().removeObservers(viewLifecycleOwner)
        viewModel.observeGopayResponse().observe(viewLifecycleOwner){
            when(it.status){
                Resource.Status.LOADING -> {
                    binding.progressBar.visible()
                    setProgressPayment()
                }
                Resource.Status.SUCCESS -> {
                    it.data?.let { data ->
                        binding.progressBar.gone()
                        data.data.url_qrcode?.let {
                            mainViewModel.saleTrans.getMaster().gopayUrl = it
                            mainViewModel.saleTrans.getMaster().gopayTransactionId = data.data.transaction_id!!
                            viewModel.state.sale!!.gopayUrl = it
                            viewModel.state.sale!!.gopayTransactionId = data.data.transaction_id!!
                            if(it.isNotEmpty()){
                                loadQrCode(it)
                                viewModel.checkStatusPayment()
                            }
                        }
                    }
                }
                Resource.Status.ERROR -> {
                    binding.progressBar.gone()
                }
                Resource.Status.NOINTERNET -> TODO()
            }
        }
        viewModel.observeGopayStatusResponse().removeObservers(viewLifecycleOwner)
        viewModel.observeGopayStatusResponse().observe(viewLifecycleOwner){
            when(it.status){
                Resource.Status.LOADING -> {
                }
                Resource.Status.SUCCESS -> {
                    it.data?.let { data ->
                        mainViewModel.saleTrans.getMaster().gopayPaymentStatus = data.data.transaction_status
                        when(data.data.transaction_status){
                            CANCEL -> {
                                binding.circularProgressIndicator.gone()
                                Toast.makeText(requireActivity(), "Cancel", Toast.LENGTH_LONG).show()
                            }
                            PENDING -> {
                                mHandler.postDelayed({
                                    viewModel.checkStatusPayment()
                                }, 3000)
                            }
                            SETTLEMENT -> {
                                viewLifecycleOwner.lifecycleScope.launchWhenStarted {
                                    binding.circularProgressIndicator.gone()
                                    binding.ivQrCode.gone()
                                    val state = viewModel.state
                                    mainViewModel.submitSale(
                                        context = requireContext(),
                                        termType = state.pmtd?.edcSurcType ?: "",
                                        paymentAmt = state.sale!!.total,
                                        pmtd = state.pmtd,
                                    )
                                    Toast.makeText(requireActivity(), "Berhasil melakukan pembayaran!", Toast.LENGTH_LONG).show()
                                    val action = PembayaranNonTunaiFragmentDirections.actionPembayaranNonTunaiFragmentToTransaksiBerhasilFragment()
                                    findNavController().navigate(action)
                                }
                            }
                            EXPIRED -> {
                                binding.circularProgressIndicator.gone()
                                binding.ivQrCode.gone()
                                Toast.makeText(requireActivity(), "Cancel", Toast.LENGTH_LONG).show()
                            }
                        }
                        Toast.makeText(requireActivity(), data.data.transaction_status, Toast.LENGTH_LONG).show()
                    }
                }
                Resource.Status.ERROR -> {
                }
                Resource.Status.NOINTERNET -> TODO()
            }
        }
        viewModel.observeCancelGopayResponse().removeObservers(viewLifecycleOwner)
        viewModel.observeCancelGopayResponse().observe(viewLifecycleOwner){
            when(it.status){
                Resource.Status.LOADING -> {
                }
                Resource.Status.SUCCESS -> {
                    it.data?.let { data ->
                        mainViewModel.saleTrans.getMaster().gopayUrl = ""
                        mainViewModel.saleTrans.getMaster().gopayTransactionId = ""
                        binding.progressBar.visible()
                        (parentFragment as PembayaranNonTunaiFragment).closePane()
                    }
                }
                Resource.Status.ERROR -> {
                }
                Resource.Status.NOINTERNET -> TODO()
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    it?.let { state ->
                        binding.apply {
                            tvTotalBayar.text = getString(R.string.mata_uang_nominal, mainViewModel.state.crc?.symbol ?: "", CurrencyUtils.formatCurrency(state.sale?.total ?: BigDecimal.ZERO))
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                parentViewModel.activePmtd.collect {
                    viewModel.updateState(
                        viewModel.state.copy(
                            pmtd = it
                        )
                    )
                }
            }
        }
    }

    private fun setProgressPayment() {
        binding.circularProgressIndicator.visible()
        binding.button2.text = "Batalkan Pembayaran"
    }

    private fun loadQrCode(url : String) {
        val executor = Executors.newSingleThreadExecutor()
        var image : Bitmap?
        executor.execute {
            try {
                val a = java.net.URL(url).openStream()
                image = BitmapFactory.decodeStream(a)

                mHandler.post {
                    binding.ivQrCode.setImageBitmap(image)
                    binding.progressBar.gone()
                }
            } catch (e : Exception) {
                e.printStackTrace()
                binding.progressBar.gone()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    companion object {
        const val PENDING = "pending"
        const val SETTLEMENT = "settlement"
        const val CANCEL = "cancel"
        const val EXPIRED = "expired"
    }
}