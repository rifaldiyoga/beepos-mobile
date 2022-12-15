package com.bits.bee.bpmc.presentation.dialog.tambah_kas

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.DialogTambahKasKeluarBinding
import com.bits.bee.bpmc.presentation.base.BaseBottomSheetDialogFragment
import com.bits.bee.bpmc.presentation.ui.rekap_kas.KasKeluarMasukSharedViewModel
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.DateFormatUtils
import com.bits.bee.bpmc.utils.extension.removeSymbol
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*

@AndroidEntryPoint
class TambahKasKeluarDialog(
    private val builder : Builder,
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> DialogTambahKasKeluarBinding = DialogTambahKasKeluarBinding::inflate
): BaseBottomSheetDialogFragment<DialogTambahKasKeluarBinding>() {

    private val sharedViewModel: KasKeluarMasukSharedViewModel by activityViewModels()
    private val viewModel : TambahKasSharedViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getValue()
    }

    override fun initComponents() {
        binding.apply {
            tvTitle.text = builder.title
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            etNominal.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

                }

                override fun afterTextChanged(p0: Editable?) {
                    etNominal.removeTextChangedListener(this)

                    try {
                        var originalString: String = p0.toString()
                        val longval: Long
                        if (originalString.contains(",")) {
                            originalString = originalString.replace(",".toRegex(), "")
                        }
                        longval = originalString.toLong()
                        val formatter = NumberFormat.getInstance(Locale.US) as DecimalFormat
                        formatter.applyPattern("#,###,###,###")
                        val formattedString = formatter.format(longval)

                        //setting text after format to EditText
                        etNominal.setText(formattedString)
                        etNominal.setSelection(etNominal.getText().length)
                    } catch (nfe: NumberFormatException) {
                        nfe.printStackTrace()
                    }
                    etNominal.addTextChangedListener(this)
                    if (p0.toString().length > 0) {
                        try {
                            val nominalUang: String
                            nominalUang = p0.toString().replace("[^\\d]".toRegex(), "").removeSymbol()
                            viewModel.updateState(
                                viewModel.state.copy(
                                    nominal = nominalUang
                                )
                            )
                        } catch (e: Exception) {
                            e.stackTrace
                        }
                    }
                    viewModel.validateInput()
                }

            })

            etDeskripsi.addTextChangedListener {
                viewModel.updateState(
                    viewModel.state.copy(
                        deskripsi = etDeskripsi.text.toString().trim()
                    )
                )
                viewModel.validateInput()
            }

            btnSimpan.setOnClickListener {
                if (viewModel.state.nominal != null && viewModel.state.deskripsi != null){
//                    sharedViewModel.onSaveKasKeluar(viewModel.state.nominal!!, viewModel.state.deskripsi!!, viewModel.state.posses, viewModel.state.cash)
                    dismiss()
                }else{
                    Toast.makeText(builder.context, "Nominal atau deskripsi tidak boleh kosong", Toast.LENGTH_SHORT).show()
                }

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
                            etTanggal.setText(
                                DateFormatUtils.formatDateToString(
                                BPMConstants.NEW_DATE_FORMAT, Date()
                                ))
                            it.posses?.let {
                                viewModel.initCash(it.possesId!!)
                                etTanggal.setText(
                                    DateFormatUtils.formatDateToString(
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

    data class Builder(
        @ApplicationContext val context: Context,
        var positiveCallback: ((Dialog) -> Unit)? = null,
        var title: String? = null,
        var nominal: String? = null,
        var deskripsi: String? = null
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

        fun build(): TambahKasKeluarDialog {
            return TambahKasKeluarDialog(this)
        }
    }
}