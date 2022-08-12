package com.bits.bee.bpmc.presentation.ui.setting_nota

import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.net.Uri
import android.provider.CalendarContract.Instances.query
import android.provider.CalendarContract.Reminders.query
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContentResolverCompat.query
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentSettingNotaBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.AturDialogBuilder
import com.bits.bee.bpmc.utils.BPMConstants
import com.bits.bee.bpmc.utils.BeePreferenceManager
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
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
        val string=""
        mPilihLogo = BeePreferenceManager.getDataFromPreferences(requireContext(), getString(
            R.string.pref_logo_galeri), false) as Boolean
        if (mPilihLogo){
            binding.swcLogoGaleri.isChecked = true
        }else{
            binding.swcLogoGaleri.isChecked = false
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            clAturHeader.setOnClickListener {
                viewModel.onClickAturHeader()
            }
            clAturFooter.setOnClickListener {
                viewModel.onClickAturFooter()
            }
            swcLogo.setOnCheckedChangeListener { compoundButton, b ->
                if (b){
                    BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_logo), true)
                }else{
                    BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_logo), false)
                }
            }
            swcLogoGaleri.setOnCheckedChangeListener { compoundButton, b ->
                if (compoundButton == swcLogoGaleri){
                    if (b){
                        BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_logo_galeri), true)
                        onShowGaleri()
                    }else{
                        BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_logo_galeri), false)
                        BeePreferenceManager.saveToPreferences(requireContext(), BPMConstants.NOTASETTING_LOGOPATH, BPMConstants.INIT_DEFAULT_LOGO)
                        viewModel.updateState(
                            viewModel.state.copy(
                                useLogoGalery = false,
                                filePath = BeePreferenceManager.getDataFromPreferences(requireContext(), BPMConstants.NOTASETTING_LOGOPATH, "") as String
                            )
                        )
                    }
                }
            }
            swcHeader.setOnCheckedChangeListener { compoundButton, b ->
                if (b){
                    clAturHeader.visible()
                    BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_header), true)
                }else{
                    clAturHeader.gone()
                    BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_header), false)
                }
            }
            swcFooter.setOnCheckedChangeListener { compoundButton, b ->
                if (b){
                    clAturFooter.visible()
                    BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_footer), true)
                }else{
                    clAturFooter.gone()
                    BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_footer), false)
                }
            }
            swcRkpCustomer.setOnCheckedChangeListener { compoundButton, b ->
                if (b){
                    BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_rkp_customer), true)
                }else{
                    BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_rkp_customer), false)
                }
            }
            swcRkpProdukChannel.setOnCheckedChangeListener { compoundButton, b ->
                if (b){
                    BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_rkp_produk_channel), true)
                }else{
                    BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_rkp_produk_channel), false)
                }
            }
            swcRkpFaktur.setOnCheckedChangeListener { compoundButton, b ->
                if (b){
                    BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_rkp_faktur), true)
                }else{
                    BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_rkp_faktur), false)
                }
            }
            swcRkpChannel.setOnCheckedChangeListener { compoundButton, b ->
                if (b){
                    BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_rkp_channel), true)
                }else{
                    BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_rkp_channel), false)
                }
            }
        }
    }

    fun onShowGaleri(){
        BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pilih_logo), true)
        Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI).apply {
            type = "image/*"
            startActivityForResult(this, IMG_RESULT)
        }
    }

    override fun subscribeObservers() {
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
                                    )
                                        .show()
                                    BeePreferenceManager.saveToPreferences(
                                        requireActivity(), getString(
                                            R.string.pref_isi_header
                                        ), data.toString()
                                    )
                                },
                                BeePreferenceManager.getDataFromPreferences(requireContext(), getString(
                                    R.string.pref_isi_header), "") as String
                                )
                            dialog.show(
                                parentFragmentManager, TAG
                            )
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
                                    BeePreferenceManager.saveToPreferences(
                                        requireActivity(), getString(
                                            R.string.pref_isi_footer
                                        ), data.toString()
                                    )
                                },
                                BeePreferenceManager.getDataFromPreferences(requireContext(), getString(
                                    R.string.pref_isi_footer), "") as String
                                )
                            dialog.show(
                                parentFragmentManager, TAG
                            )
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.viewStates().collect {
                    binding.apply {
                        swcLogo.isChecked = BeePreferenceManager.getDataFromPreferences(requireContext(), getString(
                            R.string.pref_logo), false) as Boolean
                        swcLogoGaleri.isChecked = BeePreferenceManager.getDataFromPreferences(requireContext(), getString(
                            R.string.pref_logo_galeri), false) as Boolean
                        swcHeader.isChecked = BeePreferenceManager.getDataFromPreferences(requireContext(), getString(
                            R.string.pref_header), false) as Boolean
                        swcFooter.isChecked = BeePreferenceManager.getDataFromPreferences(requireContext(), getString(
                            R.string.pref_footer), false) as Boolean
                        tVPath.text = BeePreferenceManager.getDataFromPreferences(requireContext(), BPMConstants.NOTASETTING_LOGOPATH, "") as String
                        swcRkpCustomer.isChecked = false
                        swcRkpProdukChannel.isChecked = false
                        swcRkpFaktur.isChecked = false
                        swcRkpChannel.isChecked = false
                    }
                }
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMG_RESULT){
            if (data != null && data.data != null){
                val uri: Uri = data.data!!
                val file = arrayOf(MediaStore.Images.Media.DATA)
                getContentImg(uri, file, requireContext())
                BeePreferenceManager.saveToPreferences(requireContext(), BPMConstants.NOTASETTING_LOGOPATH, mImagePath)
                viewModel.updateState(
                    viewModel.state.copy(
                        filePath = mImagePath
                    )
                )
            }
        }else{
            BeePreferenceManager.saveToPreferences(requireContext(), BPMConstants.NOTASETTING_LOGOPATH, BPMConstants.INIT_DEFAULT_LOGO)
            BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_logo_galeri), false)
            binding.swcLogoGaleri.isChecked = false
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