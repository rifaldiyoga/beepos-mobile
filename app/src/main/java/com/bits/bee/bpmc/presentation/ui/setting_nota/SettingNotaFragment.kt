package com.bits.bee.bpmc.presentation.ui.setting_nota

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentSettingNotaBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.AturDialogBuilder
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.PermissionUtils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

private const val TAG = "SettingNotaFragment"

@AndroidEntryPoint
class SettingNotaFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSettingNotaBinding =  FragmentSettingNotaBinding::inflate
) : BaseFragment<FragmentSettingNotaBinding>() {

    private val viewModel: SettingNotaViewModel by viewModels()

    private val imagePickerActivityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){

        if (it.resultCode == Activity.RESULT_OK){
            if (it.data != null){
                val uri = it.data!!.data
                val file = arrayOf(MediaStore.Images.Media.DATA)

                viewModel.onUpdateLogoGaleri(getContentImg(uri, file, requireContext()))
            }
        }else{
            viewModel.onUpdateLogoGaleri(BPMConstants.BPM_INIT_DEFAULT_LOGO)
            binding.swcLogoGaleri.isChecked = false
        }

    }

    private val requestPermissionStorage = registerForActivityResult(ActivityResultContracts.RequestPermission()){ isGranted ->
        if(!isGranted){
            Toast.makeText(requireActivity(), "Beberapa permission belum aktif!", Toast.LENGTH_LONG).show()
        }
    }

    override fun initComponents() {
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

            clLogoGaleri.setOnClickListener {
                swcLogoGaleri.isChecked = !swcLogoGaleri.isChecked
            }
            swcLogoGaleri.setOnCheckedChangeListener { _, b ->
                if (b){
                    onShowGaleri()
                } else {
                    viewModel.onUpdateLogoGaleri(BPMConstants.BPM_INIT_DEFAULT_LOGO)
                }
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
        if(PermissionUtils.checkPermissionIsGranted(requireActivity(), Manifest.permission.READ_EXTERNAL_STORAGE)) {
            Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI).apply {
                type = "image/*"
                imagePickerActivityResult.launch(this)
            }
        } else {
            requestPermissionStorage.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
        }
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

    fun getContentImg(uri: Uri?, file: Array<String>, context: Context) : String{

        if(uri == null)
            return ""

        val cursor = context.contentResolver.query(uri, file, null, null, null)
        if (cursor != null) {
            cursor.moveToFirst()
        }else{
            return ""
        }

        val intColumnIndex: Int = cursor.getColumnIndex(file[0])
        val mImagePath = cursor.getString(intColumnIndex)
        cursor.close()
        return mImagePath
    }
}