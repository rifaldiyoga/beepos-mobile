package com.bits.bee.bpmc.presentation.ui.setting_printer.list_printer_search

import android.Manifest
import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.content.*
import android.os.Build
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.bits.bee.bpmc.databinding.FragmentSettingListPrinterBinding
import com.bits.bee.bpmc.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListPrinterFragment(
    override val bindingInflater: (LayoutInflater, ViewGroup?, Boolean) -> FragmentSettingListPrinterBinding = FragmentSettingListPrinterBinding::inflate
): BaseFragment<FragmentSettingListPrinterBinding>() {

    private val viewModel: FindPrinterViewModel by viewModels()

    private lateinit var mBluetoothAdapter: BluetoothAdapter
    private lateinit var bluetoothManager: BluetoothManager
    var deviceName = "My_Device_Name"
    private var mFindPrinterState: MutableList<FindPrinterState> = mutableListOf()
    lateinit var findPrinterAdapter: FindPrinterAdapter
    private lateinit var mPairedDevices: Set<BluetoothDevice>

    private val requestBluetooth = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if(result.resultCode == Activity.RESULT_OK){
            startDiscoverable()
        }
    }

    private val requestPermissionBt = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){ permission ->
        val isGranted = true

        if(!isGranted){
            Toast.makeText(requireActivity(), "Beberapa permission belum aktif!", Toast.LENGTH_LONG).show()
        }
    }

    override fun initComponents() {
        bluetoothManager = requireContext().getSystemService(Context.BLUETOOTH_SERVICE) as BluetoothManager
        mBluetoothAdapter = bluetoothManager.adapter
        requestBluetoothEnable()
        binding.apply {
            findPrinterAdapter = FindPrinterAdapter(mListener = object: FindPrinterAdapter.PilihBluetoothPrinterI{
                override fun OnItemClick(element: PrinterDevice) {
                    findNavController().previousBackStackEntry?.savedStateHandle?.set("printer", element)
                    findNavController().popBackStack()
                }
            })
            rvListPrinter.layoutManager = LinearLayoutManager(requireContext())
            rvListPrinter.adapter = findPrinterAdapter
        }
    }

    fun stopDiscovery(){
        checkBTPermission()
        if (mBluetoothAdapter.isDiscovering){
            mBluetoothAdapter.cancelDiscovery()
        }
        requireContext().unregisterReceiver(receiver)
    }

    override fun subscribeListeners() {

    }

    override fun subscribeObservers() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.viewStates().collect {
                    it?.let {
                        binding.rvListPrinter.isVisible = it.deviceList.isNotEmpty()
                        binding.tvJmlPrinter.text = "${it.deviceList.size} perangkat ditemukan"
                        findPrinterAdapter.submitList(it.deviceList)

                    }
                }
            }
        }
    }

    private fun requestBluetoothEnable() {
        if (!mBluetoothAdapter.isEnabled) {
            val enableBluetoothIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            requestBluetooth.launch(enableBluetoothIntent)
        } else {
            startDiscoverable()
        }
    }

    private fun startDiscoverable(){
        val intentFilter = IntentFilter(BluetoothAdapter.ACTION_SCAN_MODE_CHANGED)
        requireContext().registerReceiver(receiver2, intentFilter)
        checkBTPermission()
        if (mBluetoothAdapter.isDiscovering) {
            mBluetoothAdapter.cancelDiscovery()
            Log.d(ContentValues.TAG, "Discovery: cancelling discover.")
        }
        mBluetoothAdapter.startDiscovery()
        val filter = IntentFilter(BluetoothDevice.ACTION_FOUND)
        requireContext().registerReceiver(receiver, filter)

        mPairedDevices = mBluetoothAdapter.bondedDevices
        if (mPairedDevices.isNotEmpty()) {
            val pairedList = mPairedDevices.map {
                PrinterDevice(it.name, it.address)
            }
            viewModel.updateState(
                viewModel.state.copy(
                    deviceList = pairedList
                )
            )
        }
    }

    private fun checkBTPermission(){
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            requestPermissionBt.launch(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.BLUETOOTH_SCAN, Manifest.permission.BLUETOOTH_CONNECT))
        } else {
            Log.d(ContentValues.TAG, "checkBTPermissions: No need to check permissions. SDK version < LOLLIPOP.")
        }
    }

    private val receiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val action = intent.action
            Log.d(ContentValues.TAG, "onReceive: ACTION FOUND.")
            if (BluetoothDevice.ACTION_FOUND == action) {
                val device: BluetoothDevice? = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE)
                checkBTPermission()
                if (device != null && device.bondState != BluetoothDevice.BOND_BONDED){
                    if (device.address != null) {
                        if(viewModel.state.deviceList.firstOrNull { it.address == device.address } == null) {
                            Toast.makeText(requireActivity(), "Found printer ${device.name} ${device.address}", Toast.LENGTH_LONG).show()
                        }
                        viewModel.addDiscoverPrint(device.name, device.address)
                    }
                    Log.d(ContentValues.TAG,"onReceive device: " + device.name + ": " + device.address+" "+device+"List find: "+mFindPrinterState)
                }
            } else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED == action){
                Log.d(ContentValues.TAG,"onReceive device: discovery is finish")
                stopDiscovery()
            }
        }
    }

    private val receiver2 = object: BroadcastReceiver() {
        override fun onReceive(ctx: Context, intent: Intent) {
            val action = intent.action
            if (action.equals(BluetoothAdapter.ACTION_SCAN_MODE_CHANGED)){
                val mode = intent.getIntExtra(BluetoothAdapter.EXTRA_SCAN_MODE, BluetoothAdapter.ERROR)
                when(mode){
                    BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE ->{
                        Log.d(ContentValues.TAG, "receiver2: Discoverability Enabled.")
                    }
                    BluetoothAdapter.SCAN_MODE_CONNECTABLE ->{
                        Log.d(ContentValues.TAG, "receiver2: Able to receive connections.")
                    }
                    BluetoothAdapter.SCAN_MODE_NONE ->{
                        Log.d(ContentValues.TAG, "receiver2: Not able to receive connections")
                    }
                    BluetoothAdapter.STATE_CONNECTING ->{
                        Log.d(ContentValues.TAG, "receiver2: Connecting")
                    }
                    BluetoothAdapter.STATE_CONNECTED ->{
                        Log.d(ContentValues.TAG, "receiver2: Connecting")
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        requireContext().unregisterReceiver(receiver)
        requireContext().unregisterReceiver(receiver2)
    }
}