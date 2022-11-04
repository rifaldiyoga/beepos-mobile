package com.bits.bee.bpmc.presentation.ui.setting_nota

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentSettingNotaBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.AturDialogBuilder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

private const val TAG = "SettingNotaFragment"

@AndroidEntryPoint
class SettingNotaFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSettingNotaBinding =  FragmentSettingNotaBinding::inflate
) : BaseFragment<FragmentSettingNotaBinding>() {
    private val viewModel: SettingNotaViewModel by viewModels()
    private val IMG_RESULT = 1
    private lateinit var mImagePath: String
    private var mPilihLogo: Boolean = false

    override fun initComponents() {
        binding.swcLogoGaleri.isChecked = mPilihLogo
    }

    override fun subscribeListeners() {
        binding.apply {
            clAturHeader.setOnClickListener {
                viewModel.onClickAturHeader()
            }
            clAturFooter.setOnClickListener {
                viewModel.onClickAturFooter()
            }

            clLogo.setOnClickListener {
                swcLogo.isChecked = !swcLogo.isChecked
            }
            swcLogo.setOnCheckedChangeListener { _, b ->
                viewModel.onClickLogo(b)
            }

            swcLogoGaleri.setOnCheckedChangeListener { _, b ->
//                if (compoundButton == swcLogoGaleri){
//                    if (b){
//                        BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_logo_galeri), true)
//                        onShowGaleri()
//                    }else{
//                        BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_logo_galeri), false)
//                        BeePreferenceManager.saveToPreferences(requireContext(), BPMConstants.NOTASETTING_LOGOPATH, BPMConstants.INIT_DEFAULT_LOGO)
//                        viewModel.updateState(
//                            viewModel.state.copy(
//                                isLogo = false,
//                                filePath = BeePreferenceManager.getDataFromPreferences(requireContext(), BPMConstants.NOTASETTING_LOGOPATH, "") as String
//                            )
//                        )
//                    }
//                }
            }

            clHeader.setOnClickListener {
                swcHeader.isChecked = !swcHeader.isChecked
            }
            swcHeader.setOnCheckedChangeListener { _, b ->
                viewModel.onClickHeader(b)
            }

            clFooter.setOnClickListener {
                swcFooter.isChecked = !swcFooter.isChecked
            }
            swcFooter.setOnCheckedChangeListener { _, b ->
                viewModel.onClickFooter(b)
            }

            clRekapCustomer.setOnClickListener {
                swcRkpCustomer.isChecked = !swcRkpCustomer.isChecked
            }
            swcRkpCustomer.setOnCheckedChangeListener { _, b ->
                viewModel.onClickRekapCust(b)
            }

            clRekapItem.setOnClickListener {
                swcRkpItem.isChecked = !swcRkpItem.isChecked
            }
            swcRkpItem.setOnCheckedChangeListener { _, b ->
                viewModel.onClickRekapItem(b)
            }


            clRekapProdukChannel.setOnClickListener {
                swcRkpProdukChannel.isChecked = !swcRkpProdukChannel.isChecked
            }
            swcRkpProdukChannel.setOnCheckedChangeListener { _, b ->
                viewModel.onClickRekapItemChannel(b)
            }

            clRekapFaktur.setOnClickListener {
                swcRkpFaktur.isChecked = !swcRkpFaktur.isChecked
            }
            swcRkpFaktur.setOnCheckedChangeListener { _, b ->
                viewModel.onClickRekapFaktur(b)
            }

            clRekapChannel.setOnClickListener {
                swcRkpChannel.isChecked = !swcRkpChannel.isChecked
            }
            swcRkpChannel.setOnCheckedChangeListener { _, b ->
                viewModel.onClickRekapChannel(b)
            }
        }
    }

    fun onShowGaleri(){
//        BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pilih_logo), true)
//        Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI).apply {
//            type = "image/*"
////            startActivityForResult(this, IMG_RESULT)
//        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.notaPreferences.collect {
                    viewModel.updateState(
                        viewModel.state.copy(
                            isLogo = it.isLoadLogo,
                            isHeader = it.isHeader,
                            isFooter = it.isFooter,
                            isRekapCust = it.isRekapCust,
                            isRekapChannel = it.isRekapChannel,
                            isRekapFaktur = it.isRekapFaktur,
                            isRekapItem = it.isRekapItem,
                            isRekapItemChannel = it.isRekapItemChannel,
                            filePath = it.logoPath,
                            header = it.header,
                            footer = it.footer,
                        )
                    )
                    binding.apply {
                        swcLogo.isChecked = it.isLoadLogo
                        swcHeader.isChecked = it.isHeader
                        swcFooter.isChecked = it.isFooter
                        swcRkpCustomer.isChecked = it.isRekapCust
                        swcRkpChannel.isChecked = it.isRekapChannel
                        swcRkpProdukChannel.isChecked = it.isRekapItemChannel
                        swcRkpFaktur.isChecked = it.isRekapFaktur
                        swcRkpItem.isChecked = it.isRekapItem

                        tVPath.text = it.logoPath
                        tvFooter.text = it.footer
                        tvHeader.text = it.header

                        clAturFooter.isVisible = it.isFooter
                        clAturHeader.isVisible = it.isHeader
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.event.collect { event ->
                    when (event) {
                        SettingNotaViewModel.UIEvent.RequestAturHeader -> {
                            val dialog = AturDialogBuilder(
                                getString(R.string.atur_heder),
                                getString(R.string.isi_header),
                                { data ->
                                    Toast.makeText(
                                        requireContext(),
                                        data.toString(),
                                        Toast.LENGTH_LONG
                                    ).show()
                                    viewModel.onSuccessHeader(data.toString())
                                },
                                viewModel.state.header
                            )
                            dialog.show(parentFragmentManager, TAG)
                        }
                        SettingNotaViewModel.UIEvent.RequestAturFooter -> {
                            val dialog = AturDialogBuilder(
                                getString(R.string.atur_footer),
                                getString(R.string.isi_footer),
                                { data ->
                                    Toast.makeText(
                                        requireContext(),
                                        data.toString(),
                                        Toast.LENGTH_LONG
                                    )
                                        .show()
                                    viewModel.onSuccessFooter(data.toString())
                                },
                                viewModel.state.footer
                            )
                            dialog.show(parentFragmentManager, TAG)
                        }
                    }
                }
            }
        }
    }

    fun getContentImg(uri: Uri, file: Array<String>, context: Context){
        val cursor = context.contentResolver.query(uri, file, null, null, null)
        if (cursor != null) {
            cursor.moveToFirst()
        }else{
            return
        }

        val intColumnIndex: Int = cursor.getColumnIndex(file[0])
        mImagePath = cursor.getString(intColumnIndex)
        cursor.close()
    }
}