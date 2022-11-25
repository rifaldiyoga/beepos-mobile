package com.bits.bee.bpmc.presentation.ui.pos.scan

import android.content.pm.PackageManager
import android.os.Build
import android.util.Size
import android.view.*
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.camera.core.*
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.bits.bee.bpmc.R
import com.bits.bee.bpmc.databinding.FragmentScannerBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import com.bits.bee.bpmc.utils.MLKitBarcodeAnalyzer
import com.bits.bee.bpmc.utils.ZxingBarcodeAnalyzer
import com.google.common.util.concurrent.ListenableFuture


/**
 * Created by aldi on 22/07/22.
 */
@AndroidEntryPoint
class ScannerFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentScannerBinding = FragmentScannerBinding::inflate
) : BaseFragment<FragmentScannerBinding>(){

    private var flashOn = false
    private var mMenu: Menu? = null

    // lib new try
    private lateinit var cameraProviderFuture: ListenableFuture<ProcessCameraProvider>
    private lateinit var cameraExecutor: ExecutorService
    private var flashEnabled = false
    private var scannerSDK: ScannerSDK = ScannerSDK.MLKIT //default is MLKit

    override fun initComponents() {
//        setHasOptionsMenu(true)
//        scannerSDK = st?.getSerializableExtra(ARG_SCANNING_SDK) as ScannerSDK
//
//        when (scannerSDK) {
//            ScannerSDK.MLKIT -> binding.ivScannerLogo.setImageResource(R.drawable.mlkit_icon)
//            ScannerSDK.ZXING -> binding.ivScannerLogo.setImageResource(R.drawable.zxing)
//        }

        cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext())
        // Initialize our background executor
        cameraExecutor = Executors.newSingleThreadExecutor()

        cameraProviderFuture.addListener({
            val cameraProvider = cameraProviderFuture.get()
            bindPreview(cameraProvider)
        }, ContextCompat.getMainExecutor(requireContext()))

        binding.overlay.post {
            binding.overlay.setupViewFinder()
        }
    }

    override fun subscribeListeners() {
        // Callbacks
//        codeScanner.decodeCallback = DecodeCallback {
//            requireActivity().runOnUiThread {
//                findNavController().previousBackStackEntry?.savedStateHandle?.set("scan", it.text)
//                Toast.makeText(requireContext(), "Scan result: ${it.text}", Toast.LENGTH_LONG).show()
//                findNavController().popBackStack()
//            }
//        }
//        codeScanner.errorCallback = ErrorCallback { // or ErrorCallback.SUPPRESS
//            requireActivity().runOnUiThread {
//                Toast.makeText(
//                    requireActivity(),
//                    "Camera initialization error: ${it.message}",
//                    Toast.LENGTH_LONG
//                ).show()
//            }
//        }
    }

    override fun subscribeObservers() {
    }

//    override fun handleResult(rawResult: Result?) {
//        val resultCode = rawResult!!.text
//        mScannerView.resumeCameraPreview(this@ScannerFragment)
//
//        requireActivity().runOnUiThread {
//            findNavController().previousBackStackEntry?.savedStateHandle?.set("scan", intentss.data.toString())
//            Toast.makeText(requireContext(), "Scan result: ${resultCode}", Toast.LENGTH_LONG).show()
//            findNavController().popBackStack()
//        }
//    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_flash, menu)
        if (!flashOn){
            menu.getItem(0).icon = ContextCompat.getDrawable(requireContext(), R.drawable.eva_flash_off_outline)
            flashOn = false
        }
        this.mMenu = menu
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.flash_on ->{
                if (requireContext().packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH)){
                    if (flashOn){
                        mMenu!!.getItem(0).icon =
                            ContextCompat.getDrawable(requireContext(), R.drawable.eva_flash_off_outline)
                        flashOn = false
                        Toast.makeText(requireContext(), "Off", Toast.LENGTH_SHORT).show()
                    }else{
                        mMenu!!.getItem(0).icon =
                            ContextCompat.getDrawable(requireContext(), R.drawable.eva_flash_outline)
                        flashOn = true
                        Toast.makeText(requireContext(), "On", Toast.LENGTH_SHORT).show()
                    }
                }else{
                    Toast.makeText(requireContext(), "tidak punya fitur flash camera", Toast.LENGTH_SHORT).show()
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun bindPreview(cameraProvider: ProcessCameraProvider?) {

        cameraProvider?.unbindAll()

        val preview: Preview = Preview.Builder()
            .build()

        val cameraSelector: CameraSelector = CameraSelector.Builder()
            .requireLensFacing(CameraSelector.LENS_FACING_BACK)
            .build()

        val imageAnalysis = ImageAnalysis.Builder()
            .setTargetResolution(Size(binding.cameraPreview.width, binding.cameraPreview.height))
            .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
            .build()

        val orientationEventListener = object : OrientationEventListener(requireContext()) {
            override fun onOrientationChanged(orientation : Int) {
                // Monitors orientation values to determine the target rotation value
                val rotation : Int = when (orientation) {
                    in 45..134 -> Surface.ROTATION_270
                    in 135..224 -> Surface.ROTATION_180
                    in 225..314 -> Surface.ROTATION_90
                    else -> Surface.ROTATION_0
                }

                imageAnalysis.targetRotation = rotation
            }
        }
        orientationEventListener.enable()

        //switch the analyzers here, i.e. MLKitBarcodeAnalyzer, ZXingBarcodeAnalyzer
        class ScanningListener : ScanningResultListener {
            override fun onScanned(result: String) {
                requireActivity().runOnUiThread {
                    imageAnalysis.clearAnalyzer()
                    cameraProvider?.unbindAll()

                    findNavController().previousBackStackEntry?.savedStateHandle?.set("scan", result)
                    Toast.makeText(requireContext(), "Scan result: $result", Toast.LENGTH_LONG).show()
                    findNavController().popBackStack()
                }
            }
        }

        var analyzer: ImageAnalysis.Analyzer = MLKitBarcodeAnalyzer(ScanningListener())

        if (scannerSDK == ScannerSDK.ZXING) {
            analyzer = ZxingBarcodeAnalyzer(ScanningListener())
        }

        imageAnalysis.setAnalyzer(cameraExecutor, analyzer)

        preview.setSurfaceProvider(binding.cameraPreview.surfaceProvider)

        val camera =
            cameraProvider?.bindToLifecycle(this, cameraSelector, imageAnalysis, preview)

        if (camera?.cameraInfo?.hasFlashUnit() == true) {
            binding.ivFlashControl.visibility = View.VISIBLE

            binding.ivFlashControl.setOnClickListener {
                camera.cameraControl.enableTorch(!flashEnabled)
            }

            camera.cameraInfo.torchState.observe(this) {
                it?.let { torchState ->
                    if (torchState == TorchState.ON) {
                        flashEnabled = true
                        binding.ivFlashControl.setImageResource(R.drawable.eva_flash_outline)
                    } else {
                        flashEnabled = false
                        binding.ivFlashControl.setImageResource(R.drawable.eva_flash_off_outline)
                    }
                }
            }
        }


    }

    interface ScanningResultListener {
        fun onScanned(result: String)
    }

    enum class ScannerSDK {
        MLKIT,
        ZXING
    }

}