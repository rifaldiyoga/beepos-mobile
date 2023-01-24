package com.bits.bee.bpmc.presentation.ui.sign_up.tambah_produk

import android.Manifest
import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import android.provider.Settings
import android.view.*
import android.widget.AdapterView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.FileProvider
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentTambahPrdBinding
import com.bits.bee.bpmc.domain.model.ItemDummy
import com.bits.bee.bpmc.domain.model.UnitDummy
import com.bits.bee.bpmc.presentation.base.BaseFragment
import com.bits.bee.bpmc.presentation.dialog.CustomDialogBuilder
import com.bits.bee.bpmc.presentation.dialog.DialogBuilderHelper
import com.bits.bee.bpmc.presentation.dialog.pilih_kategori.PilihKategoriDialog
import com.bits.bee.bpmc.presentation.dialog.pilih_merk.PilihMerekDialog
import com.bits.bee.bpmc.presentation.ui.pos.MainActivity
import com.bits.bee.bpmc.presentation.ui.pos.PosModeState
import com.bits.bee.bpmc.presentation.ui.setting_sistem.TAG
import com.bits.bee.bpmc.utils.*
import com.bits.bee.bpmc.utils.extension.addNumberFormatChange
import com.bits.bee.bpmc.utils.extension.gone
import com.bits.bee.bpmc.utils.extension.removeSymbol
import com.bits.bee.bpmc.utils.extension.visible
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.io.File
import java.math.BigDecimal
import java.util.*


/**
 * Created by aldi on 07/06/22.
 */
@AndroidEntryPoint
class TambahProdukFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentTambahPrdBinding = FragmentTambahPrdBinding::inflate
) : BaseFragment<FragmentTambahPrdBinding>() {

    private val viewModel : TambahProdukViewModel by viewModels()

    private lateinit var unitAdapter : SatuanAdapter
    private lateinit var tipeProdList : Array<String>
    private var tipeList = listOf("Pilih Tipe Produk", "Barang Jadi (di stok)", "Jasa (tidak distok)")
    private var gson = Gson()
    private var tempUri: Uri? = null
    private var tempFilePath =""
    private var defaultKategori = false
    private var defaultMerk = false
    private var itemPict: Bitmap? = null

    private val requestPermissionCamera = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){ data ->
        data.forEach {
            if(!it.value){
                Toast.makeText(requireActivity(), "Beberapa permission belum aktif!", Toast.LENGTH_LONG).show()
                try {
                    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                    val uri = Uri.fromParts("package", "com.bits.bee.bpmc", null)
                    intent.data = uri
                    startActivity(intent)
                }catch (e : ActivityNotFoundException){
                    e.printStackTrace()
                }
            }
        }
    }

    override fun initComponents() {
        setHasOptionsMenu(true)
        FileHandlerUtils.createFolder(BPMConstants.getDatapath() + BPMConstants.BPM_PARENTPATH)
        FileHandlerUtils.createFolder(BPMConstants.getDatapath() + BPMConstants.BPM_PRODUKPATH)

        tipeProdList = resources.getStringArray(R.array.list_tipe_produk)
        binding.apply {
            val tipeAdapter = SpinnerAdapter(requireContext(), tipeList)
            spTipePrd.setAdapter(tipeAdapter)

            arguments?.let {
                val item = it.getParcelable<ItemDummy>("itemDummy")
                item?.let {
                    viewModel.updateState(
                        viewModel.state.copy(
                            itemDummy = item,
                            nama = item.name,
                            harga = item.price,
                            isEdit = true,
                            itemId = item.id ?: -1,
                            pid = item.pid,
                            isActivePid = BeePreferenceManager.getDataFromPreferences(requireActivity(), getString(R.string.pref_active_pid), false) as Boolean,
                            tipeProduk = item.itemTypeCode,
                            picPath = item.picPath,
                            bitmap = item.picPath.let { FileHandlerUtils.checkDirPath(item.picPath) }
                        )
                    )
                    viewModel.loadEditPrd(it.itemGroupId, it.brandId, it.id!!)
                    setToolbarTitle(getString(R.string.title_ubah_produk))
                }
            } ?: run {
                viewModel.updateState(
                    viewModel.state.copy(
                        unitList = mutableListOf(UnitDummy(idx = -1, unit= "", conv = BigDecimal.ONE,)),
                        isActivePid  = BeePreferenceManager.getDataFromPreferences(requireActivity(), getString(R.string.pref_active_pid), false) as Boolean,
                    )
                )
                defaultKategori = BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_default_kategori), false) as Boolean
                defaultMerk = BeePreferenceManager.getDataFromPreferences(requireContext(), getString(R.string.pref_default_merk), false) as Boolean
            }

            unitAdapter = SatuanAdapter(
                onSatuanChange = { pos, value ->
                    viewModel.onSatuanChange(pos, value)
                    viewModel.validateSatuan(pos, value)
                },
                onQtyChange = {pos, value ->
                    viewModel.onQtyChange(pos, value)
                },
                onDelete = { pos ->
//                    val dialog = DialogBuilderHelper.showDialogChoice(requireActivity(), getString(R.string.informasi),
//                        "Apakah anda yakin ingin menghapus satuan ${pos + 1}? Satuan ${pos + 1} yang dihapus tidak dapat dikembalikan lagi",
//                        getString(R.string.batal),
//                        {
//                            it.dismiss()
//                        },
//                        getString(R.string.hapus),{
//                            it.dismiss()
//
//                        })
//                    dialog.show(parentFragmentManager, "")
                    viewModel.onDelete(pos)
                },
                onUpdateSatuan = { value ->
                    viewModel.onUpdateSatuan(value)
                },
                viewModel.state.msgQty
            )
            recyclerView2.apply {
                layoutManager = LinearLayoutManager(requireActivity())
                adapter = unitAdapter
            }
            etHarga.addNumberFormatChange()
        }
    }

    override fun subscribeListeners() {
        binding.apply {
            etNamaPrd.addTextChangedListener {
                viewModel.state.nama = etNamaPrd.text.toString().trim()
                BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_add_nama_prd), viewModel.state.nama)
            }
            etHarga.addTextChangedListener {
                viewModel.state.harga = etHarga.text.toString().trim().removeSymbol()
                BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_add_harga_prd), viewModel.state.harga)
            }
            etNamaPid.addTextChangedListener {
                viewModel.state.pid = etNamaPid.text.toString().trim()
                BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_add_pid), viewModel.state.pid)
            }
            etKategoriProduk.setOnClickListener {
                viewModel.onShowDialog()
            }
            etBrandPrd.setOnClickListener {
                viewModel.onShowDialogMerk()
            }
            spTipePrd.onItemClickListener = AdapterView.OnItemClickListener { _, _, p2, _ ->
                viewModel.state.tipeProduk = tipeProdList[p2]
            }
            btnLanjut.setOnClickListener {
                if (viewModel.state.bitmap != null) {
                    val tglTrx = DateFormatUtils.formatDateToString("yyMMddHHmm", Date())
                    val valpicpath = FileHandlerUtils.saveBitmap(requireContext(), viewModel.state.bitmap!!, BPMConstants.BPM_PRODUKPATH, etNamaPrd.text.toString().trim()+tglTrx)
                    viewModel.updateState(
                        viewModel.state.copy(
                            picPath = valpicpath
                        )
                    )
                }
                viewModel.validateNama()
                viewModel.validateHarga()
                viewModel.validateTipe()
                viewModel.validateQty()
                when(viewModel.state.posModeState){
                    PosModeState.RetailState ->{
                        if (etNamaPrd.text.toString().isNotEmpty() && etHarga.text.toString().isNotEmpty() &&
                            viewModel.state.unitList[0].unit.isNotEmpty() && viewModel.state.itemGrp != null && viewModel.state.brand != null){
                            viewModel.onSubmit(etNamaPrd.text.toString().trim(), etHarga.text.toString().trim(), etNamaPid.text.toString().trim())
                        }else{
                            Toast.makeText(requireContext(), "Harap lengkapi terlebih dahulu", Toast.LENGTH_SHORT).show()
                        }
                    }
                    PosModeState.FnBState ->{
                        if (etNamaPrd.text.toString().isNotEmpty() && etHarga.text.toString().isNotEmpty()){
                            viewModel.onSubmit(etNamaPrd.text.toString().trim(), etHarga.text.toString().trim(), etNamaPid.text.toString().trim())
                        }else{
                            Toast.makeText(requireContext(), "Harap lengkapi terlebih dahulu", Toast.LENGTH_SHORT).show()
                        }
                    }
                    else -> {
                        val tes = ""
                    }
                }
            }
            btnTambahSatuan.setOnClickListener {
                viewModel.onClickTambahSatuan()
            }
            btnAddFoto.setOnClickListener {
//                ImagePicker.Companion.with(requireActivity())
////                    .crop()	    			//Crop image(Optional), Check Customization for more option
////                    .compress(1024)			//Final image size will be less than 1 MB(Optional)
////                    .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
//                    .start()
//                val ss= ""
//                val intent = Intent(activity, MainActivity)
//                resultIntent.launch(Intent())
//                openCamera()
                viewModel.showDialogOpsi()
            }
            llImage.setOnClickListener {
                viewModel.onClickHapusImage()
            }
            cvPid.setOnClickListener {
                viewModel.OnrequestInsight()
            }
        }
    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.getlastItemgrp.collect{
                it?.let {
                    viewModel.updateState(
                        viewModel.state.copy(
                            itemGrp = if (!defaultKategori) it else null
                        )
                    )
                }
            }
            viewModel.getlastBrand.collect{
                it?.let {
                    viewModel.updateState(
                        viewModel.state.copy(
                            brand = if (!defaultMerk) it else null
                        )
                    )
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.msg.collect {
                showSnackbar(it)
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.modePreferences.collect {
                    viewModel.updateState(
                        viewModel.state.copy(
                            posModeState = it
                        )
                    )
                    binding.apply {
                        when(it){
                            PosModeState.FnBState -> {
                                cvPid.gone()
                                groupSatuan.visible()
                                lLMerk.visibility = View.GONE
                                etNamaPrd.hint = "Cth. Air Mineral"
                                unitAdapter.setTxtView(getString(R.string.satuan_prd), true)
                            }
                            PosModeState.RetailState -> {
                                cvPid.visible()
                                groupSatuan.visible()
                            }
                        }
                    }
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    it?.let { state ->
                        unitAdapter.submitList(state.unitList)
                        binding.apply {
                            etNamaPrd.setText(state.nama)
                            etHarga.setText(state.harga)
                            if(state.tipeProduk.isNotEmpty())
                                spTipePrd.setText(tipeList[tipeProdList.indexOf(state.tipeProduk)], false)
                            etNamaPid.setText(state.pid)
                            btnAddFoto.isVisible = state.bitmap == null
                            ivImage.isVisible = state.bitmap != null
                            tvHapusFotoProduk.isVisible = state.bitmap != null
                            state.bitmap?.let {
                                ivImage.setImageBitmap(it)
                            }
//                            state.picPath?.let {
//                                ivImage.setImageBitmap(FileHandlerUtils.checkDirPath(it))
//                            }

                            state.itemGrp?.let {
                                etKategoriProduk.setText(it.name)
                            }
                            state.brand?.let {
                                etBrandPrd.setText(it.brandName)
                            }
                            state.msgQty?.let {
                                unitAdapter.setError(it)
                                Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
                            }
                            tilNama.error = it.msgNama
                            tilHarga.error = it.msgHarga
                            tilTipe.error = it.msgTipe
                            when(viewModel.state.posModeState){
                                PosModeState.RetailState ->{
                                    lLPid.isVisible = state.isActivePid
                                    cvPid.isVisible = !state.isActivePid
                                    if (state.unitList.size == 3){
                                        btnTambahSatuan.gone()
                                    }else{
                                        btnTambahSatuan.visible()
                                    }
                                }
                                PosModeState.FnBState ->{
                                    btnTambahSatuan.gone()
                                }
                                else -> {

                                }
                            }
                        }
                    }
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.event.collect {
                    when(it){
                        TambahProdukViewModel.UIEvent.FinsihSubmit -> {
//                            val action = TambahProdukFragmentDirections.actionTambahProdukFragmentToAturProdukFragment()
//                            findNavController().navigate(action)
                            findNavController().popBackStack()
                        }
                        TambahProdukViewModel.UIEvent.RequestDialogKategori ->{
                            val dialog = PilihKategoriDialog(
                                getString(R.string.pilih_kategori),
                                viewModel.state.itemGrp,
                                { dialog, data ->
                                    dialog.dismiss()
                                    Toast.makeText(requireContext(), data.name, Toast.LENGTH_LONG).show()
                                    viewModel.updateState(
                                        viewModel.state.copy(
                                            itemGrp = data
                                        )
                                    )
                                },
                                { dialog, data ->
                                    dialog.dismiss()
                                    val action = TambahProdukFragmentDirections.actionTambahProdukFragmentToTambahKategoriFragment()
                                    findNavController().navigate(action)
                                },
                                { dialog, data ->
                                    dialog.dismiss()
                                    val action = TambahProdukFragmentDirections.actionTambahProdukFragmentToTambahKategoriFragment(data)
                                    findNavController().navigate(action)
                                }
                            )
                            // save
                            val listPref = gson.toJson(viewModel.state.unitList)
                            BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_add_list_unit), listPref)
                            BeePreferenceManager.saveToPreferences(requireContext(), getString(R.string.pref_add_tipe_prd), viewModel.state.tipeProduk)
                            dialog.show(parentFragmentManager, TAG)
                        }
                        TambahProdukViewModel.UIEvent.RequestDialogMerk ->{
                            val dialog = PilihMerekDialog(
                                getString(R.string.pilih_merk),
                                viewModel.state.brand,
                                { data ->
                                    viewModel.updateState(
                                        viewModel.state.copy(
                                            brand = data
                                        )
                                    )
                                },
                                { onAdd ->
                                    if (onAdd.equals(getString(R.string.pilih_merk))){
                                        val action = TambahProdukFragmentDirections.actionTambahProdukFragmentToTambahMerekFragment(null)
                                        findNavController().navigate(action)
                                        return@PilihMerekDialog
                                    }else{
                                        return@PilihMerekDialog
                                    }
                                },
                                { edit ->
                                    val action = TambahProdukFragmentDirections.actionTambahProdukFragmentToTambahMerekFragment(edit.toString())
                                    findNavController().navigate(action)
                                    return@PilihMerekDialog
                                }
                            )
                            dialog.show(parentFragmentManager, TAG)

                        }
                        TambahProdukViewModel.UIEvent.RequestInisghtPId ->{
                            val action = TambahProdukFragmentDirections.actionTambahProdukFragmentToInsightPidFragment()
                            findNavController().navigate(action)
                        }
                        TambahProdukViewModel.UIEvent.RequestDialogDelete ->{
                            val dialog = CustomDialogBuilder.Builder(requireContext())
                                .setTitle(getString(R.string.hapus_produk))
                                .setMessage(getString(R.string.msg_hapus_produk))
                                .setPositiveText(getString(R.string.batal))
                                .setNegativeText(getString(R.string.hapus))
                                .setPositiveCallback {
                                    it.dismiss()
                                }
                                .setNegativeCallback {
                                    requireActivity().actionBar?.displayOptions
                                    viewModel.onDeleteProduk()
                                }.build()
                            dialog.show(parentFragmentManager,
                                com.bits.bee.bpmc.presentation.ui.nama_device.TAG
                            )
                        }
                        TambahProdukViewModel.UIEvent.RequestDialogOpsi ->{
                            val dialog = CustomDialogBuilder.Builder(requireContext())
                                .setTitle(getString(R.string.pilih))
                                .setMessage("")
                                .setPositiveText(getString(R.string.kamera))
                                .setNegativeText(getString(R.string.galeri))
                                .setPositiveCallback {
                                    openCamera(true)
                                    it.dismiss()
                                }
                                .setNegativeCallback {
                                    openCamera(false)
                                    it.dismiss()
                                }.build()
                            dialog.show(parentFragmentManager,
                                com.bits.bee.bpmc.presentation.ui.nama_device.TAG
                            )
                        }
                        else -> {}
                    }
                }
            }
        }

    }

    private fun openCamera(isCamera: Boolean) {
//        if(PermissionUtils.checkPermissionIsGranted(requireActivity(), Manifest.permission.CAMERA)
//            && PermissionUtils.checkPermissionIsGranted(requireActivity(), Manifest.permission.READ_EXTERNAL_STORAGE)
//            && PermissionUtils.checkPermissionIsGranted(requireActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
//            tempUri = FileProvider.getUriForFile(requireContext(), "com.bits.bee.bpmc.provider", createImg().also {
//                tempFilePath = it.absolutePath
//            })
//            resultLauncherContract.launch(tempUri)
//        } else {
//            requestPermissionCamera.launch(arrayOf(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE))
//        }
        if(PermissionUtils.checkPermissionIsGranted(requireActivity(), Manifest.permission.CAMERA)
            && PermissionUtils.checkPermissionIsGranted(requireActivity(), Manifest.permission.READ_EXTERNAL_STORAGE)
            && PermissionUtils.checkPermissionIsGranted(requireActivity(), Manifest.permission.WRITE_EXTERNAL_STORAGE)){
            if (isCamera){
                tempUri = FileProvider.getUriForFile(requireContext(), "com.bits.bee.bpmc.provider", createImg().also {
                    tempFilePath = it.absolutePath
                })
                resultLauncherContract.launch(tempUri)
            }else{
                tempUri = FileProvider.getUriForFile(requireContext(), "com.bits.bee.bpmc.provider", createImg().also {
                    tempFilePath = it.absolutePath
                })
                getImage.launch("image/*")
            }
        }else{
            requestPermissionCamera.launch(arrayOf(Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE))
        }
    }

    private fun createImg(): File {
        val dir = requireActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile("temp_image", ".jpg", dir)
    }

    private val resultLauncherContract = registerForActivityResult(ActivityResultContracts.TakePicture()){ sukses  ->
        if (sukses){
            val bitmap: Bitmap = MediaStore.Images.Media.getBitmap(requireActivity().contentResolver, Uri.parse(
                tempUri.toString()
            ))
//            itemPict = FileHandlerUtils.bitMapScale(bitmap, 307200)
            viewModel.getDataFromIntent(bitmap, requireActivity(), tempUri, tempFilePath)
        }
    }

    private val getImage = registerForActivityResult(ActivityResultContracts.GetContent()) {
        val bitmap: Bitmap = MediaStore.Images.Media.getBitmap(requireActivity().contentResolver, Uri.parse(
            it.toString()
        ))
//        itemPict = FileHandlerUtils.bitMapScale(bitmap, 307200)
        viewModel.getDataFromIntent(bitmap, requireActivity(), tempUri, tempFilePath)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        if (viewModel.state.isEdit){
            inflater.inflate(R.menu.menu_void, menu)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_void -> viewModel.onShowDelete()
        }
        return super.onOptionsItemSelected(item)
    }

}