package com.bits.bee.bpmc.presentation.dialog.tambah_kas

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.DialogTambahKasBinding
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import com.bits.bee.bpmc.presentation.ui.rekap_kas.KasKeluarMasukSharedViewModel
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.DateFormatUtils
import com.bits.bee.bpmc.utils.addNumberFormatChange
import com.bits.bee.bpmc.utils.removeSymbol
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.util.*

@AndroidEntryPoint
class TambahKasDialog(
    private val builder : Builder,
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogTambahKasBinding = DialogTambahKasBinding::inflate
): BaseBottomSheetDialogFragment<DialogTambahKasBinding>() {

//    private val sharedViewModel: TambahKasSharedViewModel by activityViewModels()
    private val sharedViewModel: KasKeluarMasukSharedViewModel by activityViewModels()
    private val viewModel : TambahKasSharedViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getValue()
//        iskasMasuk = BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_tablayout), false) as Boolean
    }

    override fun initComponents() {
        binding.apply {
            tvTitle.text = builder.title
            textView56.text = builder.nominal
            etDeskripsi.setText(builder.deskripsi)
            etNominal.addNumberFormatChange()
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            etNominal.addTextChangedListener {
                viewModel.updateState(
                    viewModel.state.copy(
                        nominal = etNominal.text.toString().trim().removeSymbol()
                    )
                )
            }

            etDeskripsi.addTextChangedListener {
                viewModel.updateState(
                    viewModel.state.copy(
                        deskripsi = etDeskripsi.text.toString().trim()
                    )
                )
                viewModel.validateInput()
//                viewModel.state.deskripsi =
            }

            btnSimpan.setOnClickListener {
                sharedViewModel.onSaveKasMasuk(builder.isStatus,
                    viewModel.state.nominal,
                    viewModel.state.deskripsi ?: "",
                    viewModel.state.posses,
                    viewModel.state.cash
                )
                if (!sharedViewModel.state.blockCashOut)
                    dismiss()
                else
                    showError()
                //                if (iskasMasuk){
//
//                }else{
//                    sharedViewModel.onSaveKasKeluar(viewModel.state.nominal!!, viewModel.state.deskripsi!!, viewModel.state.posses, viewModel.state.cash)
//                }
//                builder.positiveCallback?.let { it(dialog!!) }
            }

            imgViewClose.setOnClickListener {
                dismiss()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.viewStates().collect {
                    binding.apply {
                        it?.let {
                            it.user?.let {
                                etUser.setText(it)
                                BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_user_kasir), it)
                                etUser.isEnabled = false
//                                etNominal.setText("")
                                etNominal.isFocusable = true
                                viewModel.posses()
                            }
                            etTanggal.setText(DateFormatUtils.formatDateToString(
                                BPMConstants.NEW_DATE_FORMAT, Date()))
                            it.posses?.let {
                                viewModel.initCash(it.possesId!!)
                                etTanggal.setText(DateFormatUtils.formatDateToString(
                                        BPMConstants.NEW_DATE_FORMAT, it.trxDate))
                                etTanggal.isEnabled = false
                            }
                            btnSimpan.apply {
                                background = ContextCompat.getDrawable(requireContext(), when(it.isValid){
                                    true -> R.drawable.btn_rect_primary
                                    false -> R.drawable.btn_rect_disable
                                })
                                isEnabled = it.isValid
                            }
                        }
                    }
                }
            }
        }

    }

    fun showError(){
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                sharedViewModel.viewStates().collect{
                    it?.let {
                        binding.apply {
                            it.msgKasKeluar?.let {
                                tilNominal.error = it
                            }
                        }
                    }
                }
            }
        }
    }

    data class Builder(
        @ApplicationContext val context: Context,
        var positiveCallback: ((Dialog) -> Unit)? = null,
        var title: String? = null,
        var nominal: String? = null,
        var deskripsi: String? = null,
        var isStatus: Boolean = false
    ){

        fun setPositiveCallback(positiveCallback: (Dialog) -> Unit): Builder {
            this.positiveCallback = positiveCallback
            return this
        }

        fun setTitle(title: String?): Builder {
            this.title = title
            return this
        }

        fun setNominal(nominal: String?): Builder{
            this.nominal = nominal
            return this
        }

        fun setDeskripsi(deskripsi: String?): Builder{
            this.deskripsi = deskripsi
            return this
        }

        fun setStatus(isKasmasuk: Boolean): Builder{
            this.isStatus = isKasmasuk
            return this
        }

        fun build(): TambahKasDialog {
            return TambahKasDialog(this)
        }
    }

}